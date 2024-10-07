package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;

class RacingViewTest {
    static ByteArrayOutputStream outputStreamCaptor;
    static final int MOVING_FORWARD = 5;
    static final int STOP = 3;
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
        car.attemptMove(MOVING_FORWARD);

        RacingView.printCarPosition(car);
        assertEquals("car : -\n", outputStreamCaptor.toString());
    }

    @Test
    void 전진_실패_결과_출력() {
        car.attemptMove(STOP);

        RacingView.printCarPosition(car);
        assertEquals("car : \n", outputStreamCaptor.toString());
    }
}
