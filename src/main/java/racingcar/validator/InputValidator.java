package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static final String DUPLICATE_CAR_NAME_MESSAGE = "같은 이름을 가진 자동차가 있습니다.";

    private InputValidator(){
    }

    public static void checkDuplicateCarName(String[] participateCarNameList) {
        Set<String> carNameSet = new HashSet<>();
        for (String carName : participateCarNameList) {
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
            }
            carNameSet.add(carName);
        }
    }
}