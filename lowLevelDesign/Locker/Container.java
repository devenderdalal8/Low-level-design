package Locker;

import java.util.Random;

public class Container {
    private String id;
    private Status status = Status.IS_AVAILABLE;
    private Size size;

    public Container(Size size) {
        this.size = size;
    }

    public Status getStatus() {
        return status;
    }

    public Size getSize() {
        return size;
    }

    public void open() {
        System.out.println("Opening container");
        status = Status.OCCUPIED;
    }

    public void close() {
        System.out.println("Closing container");
        status = Status.IS_AVAILABLE;
    }

    public void markOccupied() {
        status = Status.OCCUPIED;
    }

    public void markFree() {
        status = Status.IS_AVAILABLE;
    }


}

