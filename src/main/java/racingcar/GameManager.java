package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameManager {
    public static final String DUPLICATE_CAR_NAME_MESSAGE = "같은 이름을 가진 자동차가 있습니다.";
    public static final String CAR_NAME_SPLIT_STANDARD = ",";

    public List<Car> setParticipateCars() {
        String participateCarString = readLine();
        String[] participateCarNameList = participateCarString.split(CAR_NAME_SPLIT_STANDARD);
        checkDuplicateCarName(participateCarNameList);
        List<Car> carList = new ArrayList<>();
        for (String s : participateCarNameList) {
            carList.add(new Car(s));
        }
        return carList;
    }

    private void checkDuplicateCarName(String[] participateCarNameList) {
        Set<String> carNameSet = new HashSet<>();
        for (String carName : participateCarNameList) {
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
            }
            carNameSet.add(carName);
        }
    }
}
