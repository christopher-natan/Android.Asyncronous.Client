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


#### Project Link:
[![EasyLoad Machine](https://agora-file-storage-prod.s3-us-west-1.amazonaws.com/profile/portfolio/attachment/3131600109047729501?response-content-disposition=inline%3B%20filename%3D%2240683749_418165865374976_3050876847018475520_n.jpg%22%3B%20filename%2A%3Dutf-8%27%2740683749_418165865374976_3050876847018475520_n.jpg&X-Amz-Security-Token=FQoGZXIvYXdzEBQaDNZ2RQ6esxykcSQrgCK3AwMvEcYj3NNnduj0ZGw7goTY6fCAN2LitD4L9Ty9uMKnlb9lsXqBODdKRvVxS6djGg3SZ%2B3S%2Bl9vbzGJO7jdV9yZtn2788WJnVOBcVgiN5a%2FUgeb2cyng%2F10uynZlpjoeV5ApipLEzaCXCxvfTwYi8fG2Xpos3GqG5DIilA6u7cUO7g8FSbcx1HxNYIgBTtn6ThtSMcTfw%2BVZxbLdErUr9doid3r%2BRe06jxDc5aet3sN2ij0V3S6GK0eP5BNrSnvOZzzJtKJlaWGm8x251Eu7A%2FcSS%2BurI%2FRTR3gOQm%2Bt3YNa4K2c7Fpyt47VQuiKZf90TUmNSUFIYEOG70WluGiry%2F5V%2FLbUJngIradabc0YR6mGhnUG687IkKBQ97ao0i7tlQYeIEqHYqjZ1F8jGDn2ryWQC%2FMZB%2B3mwS0vPa%2B29zbQ2kwylCn2L5dQ1c7pttrfrhLByF4oFk0g%2Bph7uvAFiAM8OUQ3jbDq6XGa9h2HFk36bJhW0yIMS0AYMipn5DiRb8QG9BjkQlVG8X2mh1vYoQxF%2FQw1b9W0jxYqBNL9aItO1wrFXomtKyNUeEZMw%2BokAt0N9Z7y1Yo6Nb%2B3gU%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20181105T025354Z&X-Amz-SignedHeaders=host&X-Amz-Expires=900&X-Amz-Credential=ASIA2YR6PYW5S7VWLK6A%2F20181105%2Fus-west-1%2Fs3%2Faws4_request&X-Amz-Signature=836e1f3312305a3e97d9efd0e2a94dd74ab5b9bce57fd0536b466a8a6f713657)](https://www.youtube.com/watch?v=MmLp7KN3-MI)