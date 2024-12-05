package org.xmlConfig;

public class MessageRepository {

    private String message;

    public MessageRepository(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageRepository{" +
                "message='" + message + '\'' +
                '}';
    }
}