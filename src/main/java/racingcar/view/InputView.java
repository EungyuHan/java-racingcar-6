package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;
import racingcar.validator.AttemptInputValidator;
import racingcar.validator.CarInputValidator;

public class InputView {
    private static final String CAR_NAME_SPLIT_STANDARD = ",";

    private InputView() {
    }

    public static List<Car> readCarNames() {
        String carNamesInput = readLine();
        String[] carNameArray = carNamesInput.split(CAR_NAME_SPLIT_STANDARD);
        CarInputValidator.validateCarInput(carNameArray);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public static Integer readAttemptNumber() {
        String attemptNumberInput = readLine();
        AttemptInputValidator.validateAttemptInput(attemptNumberInput);

        return Integer.parseInt(attemptNumberInput);
    }
}
