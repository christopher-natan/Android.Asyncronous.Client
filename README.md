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


	
#### Project:
My latest project of year 2018. 
A machine that sends prepaid Top-up to any prepaid(Globe, Smart, Sun) mobile phone. And also serve  as Piso Wifi hotspot.

Programming languages that I've used are:
Android Java, CakePHP, MySQL, nGinx, Python3, NodeJs

Components are: 
Raspberry Pi 3,  Coin Acceptor, APEX 7000 Bill Acceptor, Relay, OptoCoupler,  Android Tablet 10 inch

With the Android Tablet 10 inch -  I made it as Kiosk Mode which displaying only the EasyLoad app

#### Demo Link:
[![EasyLoad Machine](http://img.youtube.com/vi/MmLp7KN3-MI/0.jpg?324)](http://www.youtube.com/watch?v=MmLp7KN3-MI)