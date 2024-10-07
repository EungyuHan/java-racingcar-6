package racingcar.entity;

public class Car {
    private static final int MOVE_CRITERIA = 4;
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void attemptMove(int randomNumber) {
        if (randomNumber >= MOVE_CRITERIA) {
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
