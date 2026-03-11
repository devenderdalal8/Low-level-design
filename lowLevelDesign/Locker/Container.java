package Locker;

public class Container {
    private String id;
    private Status status = Status.IS_AVAILABLE;
    private final ContainerSize containerSize;

    public Container(ContainerSize containerSize) {
        this.containerSize = containerSize;
    }

    public Status getStatus() {
        return status;
    }

    public ContainerSize getSize() {
        return containerSize;
    }

    public void open() {
        System.out.println("Opening container");
    }

    public void close() {
        System.out.println("Closing container");
    }

    public void markOccupied() {
        status = Status.OCCUPIED;
    }

    public void markFree() {
        status = Status.IS_AVAILABLE;
    }

}

