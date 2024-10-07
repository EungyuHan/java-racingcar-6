package racingcar.entity;

import racingcar.config.GameConstant;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= GameConstant.MOVING_LOWER_BOUND) {
            position++;
        }
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
