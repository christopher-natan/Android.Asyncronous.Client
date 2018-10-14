package easyload.natan.com.easyload.util;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Asynchronous Client
 * This class is used to communicate asynchronously between other machines using socket
 *
 * @author Christopher M. Natan
 * @version 2018.0.1
 */

public class Client extends AsyncTask<String, Void, String> {
    /**
     * use logging debug output to Logcat
     */
    private static final String LOG_TAG = "Client";
    /**
     * socket reconnect timeout length in milliseconds
     */
    private static final Integer RECONNECT_TIMEOUT = 1000;
    /**
     * A class setter and getter for incoming and outgoing data
     */
    private Data mData = new Data();
    /**
     * A class that listen incoming data coming from socket server.
     */
    private ListenIncomingData mListenIncomingData = new ListenIncomingData();
    /**
     * contains the IP of the socket server
     */
    private String mServerIp;
    /**
     * contains the port of the socket server
     */
    private Integer mServerPort;
    /**
     * it contains ClientListener object
     */
    private ClientListener mClientListener;
    /**
     * it contains Thread object
     */
    private Thread mReconnectThread;

    /**
     * The constructor
     *
     * @param serverIp   contains the ip of the server
     * @param serverPort contains the port of the server
     */
    public Client(String serverIp, int serverPort) {
        this.mServerIp = serverIp;
        this.mServerPort = serverPort;
    }

    /**
     * Perform background operations
     *
     * @param params contains null
     */
    @Override
    protected String doInBackground(String... params) {
        this.connect();
        return null;
    }

    /**
     * Establish new socket connection to a server
     */
    private void connect() {
        InetSocketAddress socketAddress = new InetSocketAddress(this.mServerIp, this.mServerPort);
        Socket socket = new Socket();
        try {
            socket.connect(socketAddress);
            mData.setOutgoing(socket.getOutputStream());
            mData.setIncoming(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            if (mClientListener != null) mClientListener.onConnected();
            this.listenIncomingData();

        } catch (IOException e) {
            if (mClientListener != null) mClientListener.onConnectError(e.getMessage());
        }
    }

    /**
     * Reconnect socket connection to server.
     * You can call this method onConnectError or onReconnectError
     */
    public void reconnect() {
        if (this.mReconnectThread != null) {
            if (this.mReconnectThread.isAlive()) mReconnectThread.interrupt();
        }
        this.mReconnectThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(RECONNECT_TIMEOUT);
                    Client.this.connect();
                } catch (InterruptedException e) {
                    if (mClientListener != null) mClientListener.onReconnectError(e.getMessage());
                }
            }
        };
        this.mReconnectThread.start();
    }

    /**
     * Perform sending data to socket server
     *
     * @param data contains any data string
     */
    public void send(String data) {
        if (data.trim().length() >= 1) {
            try {
                mData.getOutgoing().write(data.getBytes());
            } catch (IOException e) {
                if (mClientListener != null) mClientListener.onSendError(e.getMessage());
            }
        }
    }

    /**
     * Perform interrupting reconnect thread, destroying OutputStream and BufferedReader objects
     */
    public void close() {
        if (this.mReconnectThread != null) mReconnectThread.interrupt();
        if (mData.getOutgoing() != null) {
            try {
                mData.getOutgoing().close();
            } catch (IOException e) {
                if (mClientListener != null) mClientListener.onCloseError(e.getMessage());
            }
        }
        if (mData.getIncoming() != null) {
            try {
                mData.getIncoming().close();
            } catch (IOException e) {
                if (mClientListener != null) mClientListener.onCloseError(e.getMessage());
            }
        }
    }

    private void listenIncomingData() {
        mListenIncomingData.run();
    }

    /**
     * A class setter and getter for incoming and outgoing data
     */
    private class Data {
        private OutputStream mOutgoing;
        private BufferedReader mIncoming;

        private void setOutgoing(OutputStream outgoing) {
            this.mOutgoing = outgoing;
        }

        private void setIncoming(BufferedReader incoming) {
            this.mIncoming = incoming;
        }

        private OutputStream getOutgoing() {
            return this.mOutgoing;
        }

        private BufferedReader getIncoming() {
            return this.mIncoming;
        }
    }

    /**
     * A class that listen incoming data coming from socket server.
     */
    private class ListenIncomingData extends Thread implements Runnable {
        public void run() {
            String data;
            try {
                while ((data = mData.getIncoming().readLine()) != null) {
                    if (mClientListener != null)
                        mClientListener.onIncomingData(data.replaceAll("\n", ""));
                }
            } catch (IOException e) {
                if (mClientListener != null) mClientListener.onIncomingDataError(e.getMessage());
            }
        }
    }

    public void setListener(ClientListener listener) {
        mClientListener = listener;
    }

    /**
     * Client listener interface
     */
    public interface ClientListener {
        void onIncomingData(String data);
        void onConnected();
        void onSendError(String errorMessage);
        void onConnectError(String errorMessage);
        void onReconnectError(String errorMessage);
        void onCloseError(String errorMessage);
        void onIncomingDataError(String errorMessage);
    }

    public void destroy() {
        this.close();
    }
}