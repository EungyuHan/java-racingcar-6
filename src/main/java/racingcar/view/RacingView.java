package racingcar.view;

import java.util.Iterator;
import java.util.List;
import racingcar.entity.Car;

public class RacingView {
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_NUMBER_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String WINNER_NOTIFICATION_MESSAGE = "최종 우승자 : ";

    private RacingView() {
    }

    public static void printCarNameRequestMessage() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    public static void printAttemptNumberRequestMessage() {
        System.out.println(ATTEMPT_NUMBER_REQUEST_MESSAGE);
    }

    public static void printLineBreak() {
        System.out.println();
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
