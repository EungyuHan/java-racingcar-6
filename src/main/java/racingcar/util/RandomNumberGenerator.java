package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.GameConstant;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {

    }

    public static int randomNumberGenerate() {
        return Randoms.pickNumberInRange(GameConstant.RANDOM_NUMBER_LOWER_BOUND, GameConstant.RANDOM_NUMBER_UPPER_BOUND);
    }
}
