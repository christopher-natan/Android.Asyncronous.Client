# Asyncronous Client
Java class to communicate asynchronously to a device using socket. One of the Android dependency class in  vending machine project

#### Vending Machine Project:
Latest project of the year 2018. 2 in 1 vending machine, send mobile top up-recharge prepaid phone and a wifi hotspot to provide internet access

#### Programming Languages:
Android Java, CakePHP, PHP, MySQL, nGinx, Python3, NodeJs, Shell script

#### Hardware Components are: 
Raspberry Pi 3, Coin Acceptor, APEX 7000 Bill Acceptor, Channel Relay, OptoCoupler, Android, Modem Router that supports flashing to OpenWRT firmware, Android Tablet 10 inch.

#### Kiosk Mode:
+ Android tablet is rooted
+ Allows running Vending Machine app only
+ Displays custom splash screen and animated logo on startup

#### Video:
https://www.youtube.com/watch?v=MmLp7KN3-MI

#### Project Link:
http://www.cmnworks.com/vending-machine.html

#### How to use:

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


