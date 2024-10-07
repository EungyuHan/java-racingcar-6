package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.validator.AttemptInputValidator;
import racingcar.validator.CarInputValidator;
import racingcar.view.OutputView;

public class GameManager {
    private static final String CAR_NAME_SPLIT_STANDARD = ",";

    private GameManager() {
    }

    public static List<Car> setParticipateCars() {
        String participateCarString = readLine();
        String[] participateCarNameList = participateCarString.split(CAR_NAME_SPLIT_STANDARD);
        CarInputValidator.validateCarInput(participateCarNameList);

        List<Car> carList = new ArrayList<>();
        for (String s : participateCarNameList) {
            carList.add(new Car(s));
        }
        return carList;
    }

    public static int setAttemptNumber() {
        String attemptsNumberString = readLine();
        AttemptInputValidator.validateAttemptInput(attemptsNumberString);
        return Integer.parseInt(attemptsNumberString);
    }

    public static void attemptMoveCars(Car car) {
        int randomNumber = RandomNumberGenerator.randomNumberGenerate();
        car.attemptMove(randomNumber);
    }

    public static List<Car> judgeWinners(List<Car> cars) {
        int longest = 0;
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (longest < car.getPosition()) {
                longest = car.getPosition();
            }
        }
        for (Car car : cars) {
            if (longest == car.getPosition()) {
                winners.add(car);
            }
        }
        return winners;
    }

    public static void startGame() {
        OutputView.printCarNameRequestMessage();
        List<Car> cars = setParticipateCars();

        OutputView.printAttemptNumberRequestMessage();
        int attemptNumber = setAttemptNumber();

        OutputView.printLineBreak();

        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : cars) {
                attemptMoveCars(car);
                OutputView.printCarPosition(car);
            }
            OutputView.printLineBreak();
        }

        List<Car> winners = judgeWinners(cars);
        OutputView.printWinners(winners);
    }
}
