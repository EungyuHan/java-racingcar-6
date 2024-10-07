package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarInputValidatorTest {

    @Test
    void 배열_중복_이름_확인() {
        String[] testCarNames = {"car1", "car2", "car1"};
        assertThatThrownBy(() -> CarInputValidator.validateCarInput(testCarNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarInputValidator.DUPLICATE_CAR_NAME_MESSAGE);
    }

    @Test
    void 허용_길이_초과_확인() {
        String[] testCarNames = {"car1", "car22", "car333"};
        assertThatThrownBy(() -> CarInputValidator.validateCarInput(testCarNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarInputValidator.LENGTH_EXCEED_MESSAGE);
    }

    @Test
    void 이름_비어있는지_확인() {
        String[] testCarNames = {"", "car1", "car2"};
        assertThatThrownBy(() -> CarInputValidator.validateCarInput(testCarNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarInputValidator.EMPTY_NAME_MESSAGE);
    }

    @Test
    void 이름_공백인지_확인() {
        String[] testCarNames = {" ", "car1", "car2"};
        assertThatThrownBy(() -> CarInputValidator.validateCarInput(testCarNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarInputValidator.EMPTY_NAME_MESSAGE);
    }
}