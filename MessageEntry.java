import java.io.Serializable;

public class MessageEntry implements Serializable {
    private String userName;
    private String message;

    public MessageEntry(String userName, String message)  {
        this.userName= userName;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
