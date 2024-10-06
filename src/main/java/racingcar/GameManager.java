package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.validator.InputValidator;

public class GameManager {
    public static final String CAR_NAME_SPLIT_STANDARD = ",";

    public List<Car> setParticipateCars(String participateCarString) {
        String[] participateCarNameList = participateCarString.split(CAR_NAME_SPLIT_STANDARD);
        InputValidator.userInputValidate(participateCarNameList);

        List<Car> carList = new ArrayList<>();
        for (String s : participateCarNameList) {
            carList.add(new Car(s));
        }
        return carList;
    }
}
