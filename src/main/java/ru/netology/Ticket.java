package ru.netology;

public class Ticket implements Comparable<Ticket> {

    private final int id;
    private final int price;
    private final String from;
    private final String where;
    private final int travelTime;

    public Ticket(int id, int price, String from, String where, int travelTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.where = where;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (price < o.getPrice()) {
            return -1;
        }
        if (price > o.getPrice()) {
            return 1;
        }
        return 0;
    }
}