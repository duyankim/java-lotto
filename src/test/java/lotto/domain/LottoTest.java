package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    @DisplayName("당첨번호와 일치 갯수를 판별할 수 있다")
    void matched_test() {
        Lotto winningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Set<Integer> lotto1 = Set.of(1, 2, 3, 10, 20, 30);
        Set<Integer> lotto2 = Set.of(1, 2, 3, 4, 20, 30);
        Set<Integer> lotto3 = Set.of(10, 20, 30, 40, 12, 13);

        assertThat(new Lotto(lotto1).getMatchingCount(winningLotto)).isEqualTo(3);
        assertThat(new Lotto(lotto2).getMatchingCount(winningLotto)).isEqualTo(4);
        assertThat(new Lotto(lotto3).getMatchingCount(winningLotto)).isZero();
    }

    @DisplayName("로또 번호의 갯수가 6개가 아니면 예외가 발생한다")
    @Test
    void size_exception_test() {
        Set<Integer> lottoNumbers = new HashSet<>(List.of(1, 2, 3, 10, 20, 30, 40));
        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

}
