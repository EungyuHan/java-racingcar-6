package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class AttemptInputValidatorTest {
    @Test
    void 음수_혹은_0_입력() {
        String testString = "-1";
        assertThatThrownBy(() -> AttemptInputValidator.attemptInputValidate(testString))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(AttemptInputValidator.NEGATIVE_ATTEMPT_MESSAGE);
    }
}