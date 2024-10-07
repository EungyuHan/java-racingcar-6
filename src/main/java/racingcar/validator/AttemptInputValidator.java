package racingcar.validator;

public class AttemptInputValidator {
    public static final String NEGATIVE_ATTEMPT_MESSAGE = "0이하의 정수는 입력할 수 없습니다.";
    public static final String NON_NUMERIC_MESSAGE = "숫자를 입력해주세요.";

    private AttemptInputValidator() {
    }

    public static void attemptInputValidate(String attemptString) {
        int attemptNumber = checkNonNumericAttempt(attemptString);
        checkNegativeAttempt(attemptNumber);
    }

    private static void checkNegativeAttempt(int attemptNumber) {
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ATTEMPT_MESSAGE);
        }
    }

    private static int checkNonNumericAttempt(String testString) {
        int attemptNumber;
        try {
            attemptNumber = Integer.parseInt(testString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
        }
        return attemptNumber;
    }
}
