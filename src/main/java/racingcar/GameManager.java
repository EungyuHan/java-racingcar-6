package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.validator.AttemptInputValidator;
import racingcar.validator.CarInputValidator;

public class GameManager {
    public static final String CAR_NAME_SPLIT_STANDARD = ",";

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
}
