package by.perevertkin;

import java.util.ConcurrentModificationException;
import java.util.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/service") 
public class WebSocketService {
    final static Queue<Session> queue=new ConcurrentLinkedQueue<>();
    public WebSocketService() {
        super();
    }
    
    @OnOpen
    public void open(Session session)
    {
            queue.add(session);
        }

    @OnClose
    public void closedConnection(Session session)
    {
            queue.remove(session);
        }

    @OnError
    public void error(Session session, Throwable t)
    {
            queue.remove(session);
            t.printStackTrace();
        }
    
    @OnError
    public void processMessage(Session session, String message)
    {
            queue.remove(session);
            t.printStackTrace();
        }
}
