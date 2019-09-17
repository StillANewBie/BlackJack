package model;

public class Player extends GenericPlayer {

    private int order;
    private int name;

    public Player(int order, int name) {
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

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
