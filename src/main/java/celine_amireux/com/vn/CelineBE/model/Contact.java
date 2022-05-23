package celine_amireux.com.vn.CelineBE.model;

public class Contact {
    private int id;
    private String name;
    private String email;
    private String title;
    private String message;

    public Contact(int id, String name, String email, String title, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.title = title;
        this.message = message;
    }
    public Contact(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
