package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {

    }

    public static int randomNumberGenerate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
