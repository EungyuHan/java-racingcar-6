package racingcar.validator;

public class AttemptInputValidator {
    public static final String NEGATIVE_ATTEMPT_MESSAGE = "0이하의 정수는 입력할 수 없습니다.";

    private AttemptInputValidator() {
    }

    public static void attemptInputValidate(String attemptString) {
        checkNegativeAttempt(attemptString);
    }

    private static void checkNegativeAttempt(String testString) {
        int attemptNumber = Integer.parseInt(testString);
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ATTEMPT_MESSAGE);
        }
    }
}
