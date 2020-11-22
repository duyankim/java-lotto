package study.lotto.dispenser;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class LottoDispenser {

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public static Lottos auto(int numberOfPurchases) {

        initLottoNumbers();

        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < numberOfPurchases; count++) {
            lottos.add(new Lotto(getLottoNumbers()));
        }
        return new Lottos(lottos);
    }

    private static void initLottoNumbers() {
        if (lottoNumbers.isEmpty()) {
            createLottoNumbers();
        }
    }

    private static void createLottoNumbers() {
        for (int lottoNumber = LottoNumber.MIN_LOTTO_NUMBER
                ; lottoNumber <= LottoNumber.MAX_LOTTO_NUMBER
                ; lottoNumber++) {
            lottoNumbers.add(LottoNumber.of(lottoNumber));
        }
    }

    private static Set<LottoNumber> getLottoNumbers() {
        // 섞기
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, Lotto.LOTTO_NUMBER_COUNT));
    }

    public static Lotto manual(List<String> parsedLottoNumbers) {
        return new Lotto(toLottoNumbers(parsedLottoNumbers));
    }

    public static Set<LottoNumber> toLottoNumbers(List<String> parsedLottoNumbers) {
        return parsedLottoNumbers.stream()
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

}
