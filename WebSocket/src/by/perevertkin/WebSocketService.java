package by.perevertkin;

import java.util.ConcurrentModificationException;
import java.util.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/message")
public class WebSocketService {
    final static Queue<Session> queue = new ConcurrentLinkedQueue<>();

    public WebSocketService() {
        super();
    }

    @OnOpen
    public void open(Session session) {
        System.out.println("open session --->");
        queue.add(session);
    }

    @OnClose
    public void closedConnection(Session session) {
        System.out.println("close connection---->");
        queue.remove(session);
    }

    @OnError
    public void error(Session session, Throwable t) {
        queue.remove(session);
        t.printStackTrace();
    }

    public void processMessage(Session session, String message) {
        System.out.println("message-->");
    }
}
