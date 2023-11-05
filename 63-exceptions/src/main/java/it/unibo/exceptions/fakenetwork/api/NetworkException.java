package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;
import java.util.Objects;

/**
 * Marks a network error.
 */
public class NetworkException extends IOException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor to be used when there is a failure when sending a message.
     *
     * @param messageBeingSent the message being sent
     */
    public NetworkException(final String messageBeingSent) {
        super("Network error while sending message " + messageBeingSent);
        Objects.requireNonNull(messageBeingSent);
    }

    /**
     * Constructor to be used when there is a failure receiving a message.
     */
    public NetworkException() {
        super("Network error: no response");
    }

}