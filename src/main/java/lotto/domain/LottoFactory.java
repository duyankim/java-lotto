package lotto.domain;

import static lotto.LottoApplication.LOTTO_COST;

public class LottoFactory {

    private final Lottos lottos;

    private LottoFactory(int lottoAmount) {
        // 로또 장수만큼 6자리 숫자를 랜덤 뽑기한다.
        this.lottos = new Lottos(lottoAmount);
    }

    public static Lottos createLottos(int buyingAmount) {
        if (buyingAmount < LOTTO_COST) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }

        int lottoAmount = buyingAmount / LOTTO_COST;
        return new LottoFactory(lottoAmount).lottos;
    }

}
