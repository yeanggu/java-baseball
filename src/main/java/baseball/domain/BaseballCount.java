package baseball.domain;

import java.util.List;

import static baseball.message.BaseballMessage.*;

public class BaseballCount {

    private final int NUMBER_LIST_SIZE = 3;
    private Computer computer;
    private List<Integer> userInputList;
    private User user;

    public BaseballCount() {
        this.computer = new Computer();
        this.user = new User();
        this.userInputList = user.getUserNumberList();
    }


    // 볼 값 반환 기능
    private int getBall() {
        int ballCount = 0;
        for (int i : userInputList) {
            if (computer.getComputerList().contains(i)) {
                ballCount += 1;
            }
        }
        return ballCount - getStrike();
    }

    // 스트라이크 값 반환 기능
    private int getStrike() {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LIST_SIZE; i++) {
            if (isSameDigit(i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    // 컴퓨터 난수와 유저 input값을 자릿수별 비교 기능
    private boolean isSameDigit(int index) {
        return userInputList.get(index) == computer.getComputerList().get(index);
    }
}
