# Asyncronous Client
This class is used to communicate asynchronously between other machines using socket

#### How to:

   ```java
     public void connect() {
        Client client = new Client("192.168.1.1", 8080);
        client.execute(null, null, null);
        client.setListener(new Client.ClientListener() {
            @Override
            public void onIncomingData(String data) {}
            @Override
            public void onConnected() {}
            @Override
            public void onSendError(String errorMessage) { }
            @Override
            public void onConnectError(String errorMessage) {
                /* call the reconnnect method here i.e client.reconnect() */
            }
            @Override
            public void onReconnectError(String errorMessage) { }
            @Override
            public void onCloseError(String errorMessage) { }
            @Override
            public void onIncomingDataError(String errorMessage) { }
        });
    }