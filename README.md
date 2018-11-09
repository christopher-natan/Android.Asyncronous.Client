# Asyncronous Client
This class is used to communicate asynchronously between other machines using socket.
This is one of my Android dependency source code on project called EasyLoad

#### EasyLoad Project:
This is my latest project of the year 2018. This machine send top-up to any prepaid mobile (Globe, Smart, Sun) networks. And also serve as Wi-Fi hotspot.

#### Programming Languages:
Android Java, CakePHP, PHP, MySQL, nGinx, Python3, NodeJs, Shell script

#### Hardware Components are: 
Raspberry Pi 3, Coin Acceptor, APEX 7000 Bill Acceptor, Channel Relay, OptoCoupler, Android, Modem Router that supports flashing to OpenWRT firmware, Android Tablet 10 inch.

#### Kiosk Mode:
+ Android tablet is rooted
+ It only allows EasyLoad App to run
+ Displays custom splash screen and animated logo on startup

#### Demo:
Youtube: https://www.youtube.com/watch?v=MmLp7KN3-MI
Facebook video: https://www.facebook.com/easyload.ph/videos/2101718383213214/

[![EasyLoad Machine](https://bit.ly/2Pdp1KH)](https://www.facebook.com/easyload.ph/videos/2101718383213214/)


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

