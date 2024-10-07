package racingcar.validator;

public class AttemptInputValidator {
    public static final String NEGATIVE_ATTEMPT_MESSAGE = "0이하의 정수는 입력할 수 없습니다.";
    public static final String NON_NUMERIC_MESSAGE = "숫자를 입력해주세요.";

    private AttemptInputValidator() {
    }

    public static void validateAttemptInput(String attemptString) {
        validateNumericinput(attemptString);
        validatePositiveInput(attemptString);
    }

    private static void validatePositiveInput(String attemptString) {
        int attemptNumber = Integer.parseInt(attemptString);
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ATTEMPT_MESSAGE);
        }
    }

    private static void validateNumericinput(String testString) {
        try {
            Integer.parseInt(testString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
        }
    }
}
