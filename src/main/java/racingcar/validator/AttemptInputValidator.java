package racingcar.validator;

public class AttemptInputValidator {
    public static final String NEGATIVE_ATTEMPT_MESSAGE = "0이하의 정수는 입력할 수 없습니다.";
    public static final String NON_NUMERIC_MESSAGE = "숫자를 입력해주세요.";

    private AttemptInputValidator() {
    }

    public static void attemptInputValidate(String attemptString) {
        checkNonNumericAttempt(attemptString);
        checkNegativeAttempt(attemptString);
    }

    private static void checkNegativeAttempt(String testString) {
        int attemptNumber = Integer.parseInt(testString);
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ATTEMPT_MESSAGE);
        }
    }

    private static void checkNonNumericAttempt(String testString) {
        for (int i = 0; i < testString.length(); i++) {
            char c = testString.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
            }
        }
    }
}
