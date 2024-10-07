package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {


    private GameManager() {
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

    private static void raceStart(int attemptNumber, List<Car> cars) {
        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : cars) {
                int randomNumber = RandomNumberGenerator.randomNumberGenerate();
                car.moveCar(randomNumber);
                OutputView.printCarPosition(car);
            }
            OutputView.printLineBreak();
        }
    }

    public static void startGame() {
        OutputView.printCarNameRequestMessage();
        List<Car> cars = InputView.readCarNames();

        OutputView.printAttemptNumberRequestMessage();
        int attemptNumber = InputView.readAttemptNumber();

        OutputView.printLineBreak();

        raceStart(attemptNumber, cars);

        List<Car> winners = judgeWinners(cars);
        OutputView.printWinners(winners);
    }
}
