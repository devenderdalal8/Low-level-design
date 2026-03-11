package Locker;

import java.util.ArrayList;
import java.util.List;

public class MainLocker {
    public static void main(String[] args) {
        Locker locker = new Locker(generateLockers());
        String code = locker.depositPackage(ContainerSize.SMALL);
        String mediumContainer = locker.depositPackage(ContainerSize.MEDIUM);
        System.out.println(locker.depositPackage(ContainerSize.SMALL));
        System.out.println(mediumContainer);
        System.out.println(locker.depositPackage(ContainerSize.LARGE));
        locker.openExpiredContainer();

        locker.pickUp(code);
        locker.pickUp(mediumContainer);
    }

    private static List<Container> generateLockers() {
        List<Container> containers = new ArrayList<>();
        containers.add(new Container(ContainerSize.SMALL));
        containers.add(new Container(ContainerSize.SMALL));
        containers.add(new Container(ContainerSize.MEDIUM));
        containers.add(new Container(ContainerSize.MEDIUM));
        containers.add(new Container(ContainerSize.LARGE));
        containers.add(new Container(ContainerSize.LARGE));
        containers.add(new Container(ContainerSize.MEDIUM));
        containers.add(new Container(ContainerSize.SMALL));
        containers.add(new Container(ContainerSize.LARGE));
        containers.add(new Container(ContainerSize.MEDIUM));
        return containers;
    }
}
