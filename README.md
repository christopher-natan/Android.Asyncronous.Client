# Asyncronous Client
This class is used to communicate asynchronously between other machines using socket.
This is one of my Android dependency source code on project called EasyLoad

#### EasyLoad Project:
This is my latest project of year 2018. 
A machine that sends prepaid Top-up to any prepaid(Globe, Smart, Sun) mobile phone. And also serve  as Piso Wifi hotspot.

#### Programming Languages:
Android Java, CakePHP, MySQL, nGinx, Python3, NodeJs

#### Hardware Components are: 
Raspberry Pi 3,  Coin Acceptor, APEX 7000 Bill Acceptor, Channel Relay, OptoCoupler,  Android Tablet 10' Android version 5.1

#### Kiosk Mode:
The Android should be rooted which I made it and customized most of the settings to make it as Kiosk Mode 
which displaying full screen with the EasyLoad app

#### Demo:
Youtube: https://www.youtube.com/watch?v=MmLp7KN3-MI

[![EasyLoad Machine](https://goo.gl/hnvpDJ)](http://www.youtube.com/watch?v=MmLp7KN3-MI)


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

