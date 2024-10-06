package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 배열_중복_이름_확인() {
        String[] testCarNames = {"car1", "car2", "car1"};
        assertThatThrownBy(() -> InputValidator.checkDuplicateCarName(testCarNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.DUPLICATE_CAR_NAME_MESSAGE);
    }
}