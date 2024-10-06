package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameManagerTest {
    static GameManager gameManager = new GameManager();

    @Test
    void 자동차_이름_입력() {
        String testString = "car1,car2,car3";
        String[] resultString = {"car1", "car2", "car3"};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(inputStream);

        List<Car> cars = gameManager.setParticipateCars();

        assertThat(cars).hasSize(3);
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getCarName()).isEqualTo(resultString[i]);
        }
    }

    @Test
    void 중복된_이름_입력() {
        String testString = "car1,car2,car1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> gameManager.setParticipateCars())
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 이름을 가진 자동차가 있습니다.");
    }
}