package lotto.view;

import lotto.enums.RewardEnum;

import java.util.Map;

public class ResultView {

    public void printResult(Map<Integer, Integer> countMap, double profit) {
        for (RewardEnum rewardEnum : RewardEnum.values()) {
            printReward(rewardEnum, countMap);
        }
        printProfit(profit);
    }

    private void printReward(RewardEnum rewardEnum, Map<Integer, Integer> countMap) {
        System.out.printf("%s개 일치 (%s원)- %s개\n",
                rewardEnum.getMatchingCount(),
                rewardEnum.getReward(),
                countMap.get(rewardEnum.getMatchingCount()));
    }

    private void printProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profit);
    }
}
