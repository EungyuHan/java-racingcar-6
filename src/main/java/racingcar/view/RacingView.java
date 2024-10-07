package racingcar.view;

import java.util.Iterator;
import java.util.List;
import racingcar.entity.Car;

public class RacingView {
    public static final String WINNER_NOTIFICATION_MESSAGE = "최종 우승자 : ";

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

    public static void printWinners(List<Car> winners) {
        Iterator<Car> iterator = winners.iterator();
        StringBuilder winnerString = new StringBuilder();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            winnerString.append(car.getCarName());

            if (iterator.hasNext()) {
                winnerString.append(", ");
            }
        }
        winnerString.append("\n");
        System.out.print(WINNER_NOTIFICATION_MESSAGE + winnerString);
    }
}
