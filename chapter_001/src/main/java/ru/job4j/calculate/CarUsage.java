package ru.job4j.calculate;

/**
 * Описывает использование авто.
 *
 * @autor Не я
 */
public class CarUsage {
    /**
     * При запуске создает ссылку на новый объект Car.
     * Меняет значение его поля volume.
     *
     * @param args
     */
    public static void main(String[] args) {
        Car audi = new Car();
        boolean driving = audi.canDrive();
        System.out.println("Can you drive?: " + driving);
        System.out.println("Im going to gas station!");
        int gas = 25;
        audi.fill(gas);
        driving = audi.canDrive();
        System.out.println("Can you drive now?: " + driving);
        System.out.println("Now Im going to my granny");
        int distance = 10;
        System.out.println("It's " + distance + " km from here!");
        audi.drive(distance);
        audi.gasInfo();
    }
}
