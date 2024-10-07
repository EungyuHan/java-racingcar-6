package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.config.GameTestConstant;
import racingcar.entity.Car;

class RacingViewTest {
    static ByteArrayOutputStream outputStreamCaptor;
    Car car;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        car = new Car("car");
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 전진_성공_결과_출력() {
        car.attemptMove(GameTestConstant.MOVABLE_NUMBER);

        RacingView.printCarPosition(car);
        assertEquals("car : -\n", outputStreamCaptor.toString());
    }

    @Test
    void 전진_실패_결과_출력() {
        car.attemptMove(GameTestConstant.IMMOAVBLE_NUMBER);

        RacingView.printCarPosition(car);
        assertEquals("car : \n", outputStreamCaptor.toString());
    }

    @Test
    void 단일_우승자_출력() {
        Car winnerCar = new Car("winner");
        List<Car> winner = List.of(winnerCar);
        String expectedString = RacingView.WINNER_NOTIFICATION_MESSAGE
                + winnerCar.getCarName()
                + "\n";

        RacingView.printWinners(winner);

        assertEquals(expectedString, outputStreamCaptor.toString());
    }

    @Test
    void 공동_우승자_출력() {
        Car winnerCar1 = new Car("winner1");
        Car winnerCar2 = new Car("winner2");
        List<Car> winners = List.of(winnerCar1, winnerCar2);

        String expectedString = RacingView.WINNER_NOTIFICATION_MESSAGE
                + winnerCar1.getCarName()
                + ", "
                + winnerCar2.getCarName()
                + "\n";

        RacingView.printWinners(winners);

        assertEquals(expectedString, outputStreamCaptor.toString());
    }
}
