package model;

public class Player extends GenericPlayer {

    private int order;
    private String name;

    public Player(int order, String name) {
        super();
        this.order = order;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
