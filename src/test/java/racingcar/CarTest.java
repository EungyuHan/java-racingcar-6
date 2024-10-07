package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;
    // Car static 멤버 접근을 위한 변수
    public static final String CAR_POSITION = "position";

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    void 자동차_전진_성공() {
        int number = 4;
        car.attemptMove(number);

        assertThat(car).extracting(CAR_POSITION).isEqualTo(1);
    }

    @Test
    void 자동차_전진_실패() {
        int number = 3;
        car.attemptMove(number);

        assertThat(car).extracting(CAR_POSITION).isEqualTo(0);
    }
}