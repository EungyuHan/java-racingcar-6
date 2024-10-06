package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static final int ALLOWED_NAME_LENGTH = 5;
    public static final String DUPLICATE_CAR_NAME_MESSAGE = "같은 이름을 가진 자동차가 있습니다.";
    public static final String LENGTH_EXCEED_MESSAGE = "허용된 이름 길이를 초과했습니다.";

    private InputValidator() {
    }

    public static void userInputValidate(String[] participateCarNameList) {
        checkDuplicateCarName(participateCarNameList);
        checkAllowedLength(participateCarNameList);
    }

    private static void checkDuplicateCarName(String[] participateCarNameList) {
        Set<String> carNameSet = new HashSet<>();
        for (String carName : participateCarNameList) {
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
            }
            carNameSet.add(carName);
        }
    }

    private static void checkAllowedLength(String[] testCarNames) {
        for(String s : testCarNames) {
            if(s.length()>ALLOWED_NAME_LENGTH) {
                throw new IllegalArgumentException(LENGTH_EXCEED_MESSAGE);
            }
        }
    }

}