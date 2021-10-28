package com.epam.brest.model;

import com.epam.brest.resource.ResourceHandler;

import java.util.List;

public class MessageProvider {

    private final List<String> messages;

    public MessageProvider(ResourceHandler resourceHandler, String fileMessages) {
        this.messages = resourceHandler.getMessages(fileMessages);
    }

    public String getMessage(int messageIdx) {
        return messages.get(messageIdx);
    }

}
