package com.sliit.chatApplication.model;

public class RasaChatMessage {

    private String sender;
    private String recipient_id;
    private String message;
    private String text;

    public RasaChatMessage() {
    }

    public RasaChatMessage(String sender, String recipient_id, String message, String text) {
        this.sender = sender;
        this.recipient_id = recipient_id;
        this.message = message;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
