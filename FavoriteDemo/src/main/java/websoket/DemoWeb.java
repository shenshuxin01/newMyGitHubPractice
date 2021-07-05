package websoket;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class DemoWeb extends WebSocketServer {

    //配置服务端口号
    public DemoWeb(InetSocketAddress address) {
        super(address);
        System.out.println("配置服务端口号OK");
    }

    //客户端连接到服务器并且三次握手成功后执行
    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("客户端连接到服务器并且三次握手成功后执行");
    }

    //客户端连接关闭
    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("客户端连接关闭");
    }

    //接收客户端发来的消息
    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("接收客户端发来的消息");
        System.out.println(s);
        //服务端发出消息到客户端
        webSocket.send("服务端发出消息到客户端");
        System.out.println("服务端发出消息到客户端");

    }

    //抛异常处理
    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.out.println("onErroronError抛异常处理");
    }

    //本服务启动成功调用（整个生命周期进调用一次）
    @Override
    public void onStart() {
        System.out.println("本服务启动成功调用（整个生命周期进调用一次）");
    }

    public static void main(String[] args) {
        //开启服务 9090是端口号
        //在前端页面<script>里面写 var
        //          ws = new WebSocket("ws://localhost:9876");
        new DemoWeb(new InetSocketAddress(9876)).start();
    }
}

