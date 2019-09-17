package model;

// for future use (replace string and prepare for restful)
public abstract class Message {

    private GameMessageType messageType;
    private String content;

    public Message(GameMessageType messageType) {
        this.messageType = messageType;
    }

    public GameMessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(GameMessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
