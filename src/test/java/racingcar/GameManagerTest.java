package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.config.GameTestConstant;
import racingcar.entity.Car;

class GameManagerTest {

    @Test
    void 우승자_판정_단일우승() {
        Car car1 = new Car("winner");
        car1.attemptMove(GameTestConstant.MOVABLE_NUMBER);

        Car car2 = new Car("loser");
        car2.attemptMove(GameTestConstant.IMMOAVBLE_NUMBER);

        List<Car> cars = List.of(car1, car2);

        List<Car> winners = GameManager.judgeWinners(cars);

        assertThat(winners).containsOnly(car1);
    }

    @Test
    void 우승자_판정_2명이상() {
        Car car1 = new Car("winner1");
        car1.attemptMove(GameTestConstant.MOVABLE_NUMBER);

        Car car2 = new Car("winner2");
        car2.attemptMove(GameTestConstant.MOVABLE_NUMBER);

        List<Car> cars = List.of(car1, car2);

        List<Car> winners = GameManager.judgeWinners(cars);

        assertThat(winners).containsOnly(car1, car2);
    }
}