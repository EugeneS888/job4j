package ru.job4j.calculate;

/**
 * Класс описывает авто
 */
public class Car {
    /**
     * @param volume Сколько бензина в баке
     */
    private double volume;

    /**
     * Сколько осталось в баке после поездки.
     *
     * @param km сколько проехали
     */
    public void drive(int km) {
        this.volume = this.volume - km;
    }

    /**
     * Завправка бензином, сколько в баке после заправки.
     *
     * @param gas
     */
    public void fill(int gas) {
        this.volume = this.volume + 10 * gas;
    }

    /**
     * Можем ли ехать, есть ли бензин?
     *
     * @return boolean Можем ли ехать?
     */
    public boolean canDrive() {
        boolean result = this.volume > 0;
        return result;
    }

    /**
     * Сколько км сможем проехать?
     * вывод на экран
     */
    public void gasInfo() {
        System.out.println("I can drive " + this.volume + " km");
    }
}
