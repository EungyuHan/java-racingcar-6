package racingcar;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.validator.AttemptInputValidator;
import racingcar.validator.CarInputValidator;

class GameManagerTest {
    static GameManager gameManager = new GameManager();

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @AfterEach
    void tearDown() {
        close();
    }

    @Test
    void 자동차_이름_입력() {
        String testString = "car1,car2,car3";
        String[] resultString = {"car1", "car2", "car3"};
        System.setIn(generateUserInput(testString));

        List<Car> cars = gameManager.setParticipateCars();

        assertThat(cars).hasSize(resultString.length);
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getCarName()).isEqualTo(resultString[i]);
        }
    }

    @Test
    void 중복된_이름_입력() {
        String testString = "car1,car2,car1";
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(() -> gameManager.setParticipateCars())
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarInputValidator.DUPLICATE_CAR_NAME_MESSAGE);
    }

    @Test
    void 이름_허용_길이_초과() {
        String testString = "car1,car22,car333";
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(() -> gameManager.setParticipateCars())
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarInputValidator.LENGTH_EXCEED_MESSAGE);
    }

    @Test
    void 비어있는_이름_입력() {
        String testString = ",car1,car2";
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(() -> gameManager.setParticipateCars())
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarInputValidator.EMPTY_NAME_MESSAGE);
    }

    @Test
    void 이름_공백만_입력() {
        String testString = "car1,  ,car2";
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(() -> gameManager.setParticipateCars())
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarInputValidator.EMPTY_NAME_MESSAGE);
    }

    @Test
    void 시도횟수_입력() {
        String testString = "1";
        int expected = Integer.parseInt(testString);
        System.setIn(generateUserInput(testString));

        int attemptNumber = gameManager.setAttemptNumber();
        assertThat(attemptNumber).isEqualTo(expected);
    }

    @Test
    void 음수_시도횟수_입력() {
        String testString = "-1";
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(() -> gameManager.setAttemptNumber())
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(AttemptInputValidator.NEGATIVE_ATTEMPT_MESSAGE);
    }

    @Test
    void 숫자가_아닌_값_시도횟수_입력() {
        String testString = "a";
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(() -> gameManager.setAttemptNumber())
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(AttemptInputValidator.NON_NUMERIC_MESSAGE);
    }
}