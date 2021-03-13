package zombieLand;

public class User implements Cloneable {
    public User() {

    }
    private String id, pw, name;
    private int record = 0;
    private boolean logIn = false;

    public User(String id, String pw, String name, int record, boolean logIn) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.record = record;
        this.logIn = logIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    @Override
    public User clone() {
        User clone = null;
        try {
            clone = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }


}
