package org.xmlConfig;

public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public String printMessage(){
        return repository.getMessage();
    }
}
