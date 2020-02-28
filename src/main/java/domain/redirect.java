package domain;

public class redirect {
    String from;
    String to;

    public redirect(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "redirect{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
