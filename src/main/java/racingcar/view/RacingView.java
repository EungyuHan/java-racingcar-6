package racingcar.view;

import racingcar.entity.Car;

public class RacingView {
    private RacingView() {
    }

    public static void printCarPosition(Car car) {
        StringBuilder carPosition = new StringBuilder(car.getCarName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            carPosition.append("-");
        }
        carPosition.append("\n");
        System.out.print(carPosition);
    }
}
