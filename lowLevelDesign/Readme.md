# Low Level Design Implementations

This repository contains various Low Level Design (LLD) implementations in Java. Each package represents a distinct system design problem, showcasing object-oriented principles, design patterns, and clean code practices.

## 1. Locker Management System (`Locker/`)
A system designed to manage a network of parcel lockers (e.g., Amazon Locker).
*   **Key Entities:** `Locker`, `Container`, `AccessToken`, `Status`, `ContainerSize`.
*   **Concepts:** Manages the allocation of locker containers of different sizes to users, handling access tokens for securing and retrieving packages.

## 2. Logger Library (`Logger/`)
A customized logging framework implementation.
*   **Key Entities:** `Logger` (Base), `Level`, `InfoLogger`, `DebugLogger`, `WarnLogger`, `ErrorLogger`.
*   **Concepts:** Implements the **Chain of Responsibility** design pattern to pass logging requests along a chain of handlers based on log severity levels.

## 3. Parking Lot System (`parkingLot/`)
A comprehensive parking lot management system.
*   **Key Entities:** `ParkingLot`, `ParkingFloor`, `ParkingSpot`, `ParkingTicket`, `Vehicle` (Car, Bike, Bus).
*   **Concepts:** 
    *   **Strategy Pattern:** Used for flexible parking assignment (`NearestParkingStratergy`, `BestParkingStratergy`, etc.) and fee calculation (`FlatRateStrategy`, `VehicleBasedFeeStrategy`).
    *   Supports different vehicle sizes and corresponding parking spot sizes.

## 4. Vending Machine (`VendingMachine/`)
A state-machine based vending machine implementation.
*   **Key Entities:** `VendingMachine`, `Inventory`, `Item`, `Coin`, `VendingMachineState`.
*   **Concepts:** Implements the **State** design pattern to handle complex transitions between different states such as `IdleDispenseState`, `HasMoneyState`, `ItemSelectedState`, and `DispenseState`.

## 5. Splitwise (`Splitwise/`)
*Currently a work-in-progress / planned module.*
Will contain the low-level design for an expense-sharing application like Splitwise, focusing on user balances, expense splitting strategies, and group management.

---

### How to run
Each module contains a `Main` or `Demo` class (e.g., `MainLocker.java`, `Logger/Main.java`, `ParkingLotDemo.java`, `VendingMachineDemo.java`) that can be executed to see the system in action.
