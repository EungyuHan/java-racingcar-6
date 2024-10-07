package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.validator.AttemptInputValidator;
import racingcar.validator.CarInputValidator;
import racingcar.view.RacingView;

public class GameManager {
    private static final String CAR_NAME_SPLIT_STANDARD = ",";

    public List<Car> setParticipateCars() {
        String participateCarString = readLine();
        String[] participateCarNameList = participateCarString.split(CAR_NAME_SPLIT_STANDARD);
        CarInputValidator.carInputValidate(participateCarNameList);

        List<Car> carList = new ArrayList<>();
        for (String s : participateCarNameList) {
            carList.add(new Car(s));
        }
        return carList;
    }

    public int setAttemptNumber() {
        String attemptsNumberString = readLine();
        AttemptInputValidator.attemptInputValidate(attemptsNumberString);
        return Integer.parseInt(attemptsNumberString);
    }

    public void attemptMoveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.randomNumberGenerate();
            car.attemptMove(randomNumber);
        }
        System.out.println();
    }

    public void getAttemptResult(List<Car> cars) {
        for (Car car : cars) {
            RacingView.printCarPosition(car);
        }
    }
}
