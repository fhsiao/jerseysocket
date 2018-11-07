package com.ztalk.jerseysocket.ws;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/ws/{username}", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class EndpointServer {
    private static final Logger logger = LogManager.getLogger(EndpointServer.class);

    private Session session;
    private static final Set<EndpointServer> sEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    /**
     * OnOpen (when a socket has been opened) allows us to intercept the creation of a new session.
     * The session class allows us to send data to the user.
     * In the method onOpen, we'll let the user know that the handshake was
     * successful.
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException{
        logger.debug(String.format("[Session %s] Session has been opened for the user:: %s.",session.getId(), username));

        this.session = session;
        sEndpoints.add(this);
        users.put(session.getId(), username);

        Message message = new Message();
        message.setFrom("Board Manager");
        message.setContent(String.format("Welcome %s!",username));
        broadcast(message);
    }

    /**
     * This method is invoked each time that the client receives a WebSocket message.
     *
     * @param message
     * @param session
     * @return
     */
    @OnMessage
    public void onMessage(Session session, Message message, @PathParam("username") String username) throws IOException, EncodeException {
        logger.debug(String.format("[Session %s] Sending message: %s to user:: %s",session.getId(), message, username));

        message.setFrom(users.get(session.getId()));
        broadcast(message);
    }

    /**
     * This method is invoked when the client closes a WebSocket connection.
     *
     * @param session
     * @return
     */
    @OnClose
    public void onClose(Session session, @PathParam("username") String username) throws IOException, EncodeException {
        logger.debug(String.format("[%s::Session %s] has been closed.", username,session.getId()));

        sEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent(String.format("Goodbye %s!",username));
        broadcast(message);
    }

    /**
     * This method is invoked when an error was detected on the connection.
     *
     * @param session
     * @param t
     * @return
     */
    @OnError
    public void onError(Session session, @PathParam("username") String username, Throwable t) {
        logger.debug(String.format("[%s::Session %s] An error has been detected: %s.", username,session.getId(), t.getMessage()));
    }

    private static void broadcast(Message message) throws IOException, EncodeException {
        sEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote()
                            .sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
