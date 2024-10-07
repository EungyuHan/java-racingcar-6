package racingcar.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.config.GameTestConstant;

class CarTest {
    Car car;
    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    void 자동차_전진_성공() {
        car.moveCar(GameTestConstant.MOVABLE_NUMBER);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_전진_실패() {
        car.moveCar(GameTestConstant.IMMOAVBLE_NUMBER);

        assertThat(car.getPosition()).isZero();
    }
}