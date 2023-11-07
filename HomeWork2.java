import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HomeWork2 {
     // Проверяет, что экземпляр объекта Car также является экземпляром транспортного средства (Vehicle). 
    // Этот тест использует оператор instan
    @Test
    public void testCarIsInstanceOfVehicle() {
        Vehicle car = new Car("Toyota", "Camry", 2022);
        assertTrue(car instanceof Vehicle);
    }

    // Проверяет, что объект Car создается с 4 колесами. Этот тест создает объект Car 
    // и затем проверяет количество колес, вызывая метод getNumWheels() и сравнивая его 
    // с ожидаемым значением, которое равно 4.
    @Test
    public void testCarHasFourWheels() {
        Vehicle car = new Car("Toyota", "Camry", 2022);
        assertEquals(4, car.getNumWheels());
    }

    // Проверяет, что экземпляр объекта Motorcycle также является экземпляром транспортного средства (Vehicle). 
    // Этот тест также использует оператор instanceof для проверки, что объект типа Motorcycle также является 
    // объектом типа Vehicle.
    @Test
    public void testMotorcycleIsInstanceOfVehicle() {
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2022);
        assertTrue(motorcycle instanceof Vehicle);
    }

    // Проверяет, что объект Motorcycle создается с 2 колесами. Этот тест создает объект Motorcycle и 
    // затем проверяет количество колес, вызывая метод getNumWheels() и сравнивая его с ожидаемым значением, 
    // которое равно 2.
    @Test
    public void testMotorcycleHasTwoWheels() {
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2022);
        assertEquals(2, motorcycle.getNumWheels());
    }

    // Проверяет, что объект Car развивает скорость 60 в режиме тестового вождения (testDrive()). 
    // Этот тест создает объект Car, вызывает метод testDrive() и затем проверяет, что скорость 
    // (getSpeed()) стала равной 60.
    @Test
    public void testCarSpeedAfterTestDrive() {
        Car car = new Car("Toyota", "Camry", 2022);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    // Проверяет, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive()). 
    // Этот тест создает объект Motorcycle, вызывает метод testDrive() и затем проверяет, что скорость 
    // (getSpeed()) стала равной 75.
    @Test
    public void testMotorcycleSpeedAfterTestDrive() {
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2022);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    // Проверяет, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
    // машина останавливается (скорость равна 0). Этот тест создает объект Car, вызывает testDrive() 
    // и park(), затем проверяет, что скорость (getSpeed()) стала равной 0.
    @Test
    public void testCarSpeedAfterParking() {
        Car car = new Car("Toyota", "Camry", 2022);
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    // Проверяет, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) 
    // мотоцикл останавливается (скорость равна 0). Этот тест создает объект Motorcycle, вызывает testDrive() 
    // и park(), затем проверяет, что скорость (getSpeed()) стала равной 0.
    @Test
    public void testMotorcycleSpeedAfterParking() {
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2022);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
    
}
