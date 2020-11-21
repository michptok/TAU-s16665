package main.java;

public class Cage {


    private String id;
    private int currentCapacity;

    public Cage(String id, int currentCapacity) {
        this.id = id;
        this.currentCapacity = currentCapacity;
    }

    public boolean isCageEmpty() {
        return currentCapacity < 1;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            return;
        }
        this.id = id;
    }
}
