package domain;

public class UserAndTime {
    String user;
    String TimeStamp;

    public UserAndTime(String user, String TimeStamp) {
        this.user = user;
        this.TimeStamp = TimeStamp;
    }

    @Override
    public String toString() {
        return "UserAndTime{" +
                "user='" + user + '\'' +
                ", TimeStamp='" + TimeStamp + '\'' +
                '}';
    }
}
