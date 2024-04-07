## 3단계 기능요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

```
지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

#### 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 8: 일급 콜렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

##### 힌트
- 일급 콜렉션을 쓴다.
- 6개의 숫자 값을 가지는 java collection을 감싸는 객체를 추가해 구현해 본다.
- 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. 자바의 enum을 활용해 상수 값을 제거한다. 즉, enum을 활용해 일치하는 수를 로또 등수로 변경해 본다.

```java
public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
		
    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        return null;
    }
}
```

### 1차 TODO LIST
- InputView
    - [x] 보너스 볼 입력
        - [x] 보너스 볼의 범위 검증 (1~45 범위)
- 당첨 로직 수정
    - [x] 1등 : 6개 일치
    - [x] 2등 : 5개 일치 + 보너스 볼 일치
    - [x] 3등 : 5개 일치
    - [x] 4등 : 4개 일치
    - [x] 5등 : 3개 일치
- Rank enum 사용
    - [x] 일치하는 수를 로또 등수로 변경하는 로직 구현
    - [x] Rank enum 테스트


### 2차 TODO LIST
- [x] `LottoNumber` 로또 번호 객체 생성
- [x] Set<Integer> -> Set<LottoNumber>로 수정
- [x] Lotto 주 생성자를 호출하도록 수정
- [x] Rank 반복문 indent 줄이기
- [x] Results에서 enum클래스 values 메소드 사용하여 Map 생성부 수정 
- [x] WinningLotto 6개의 숫자와 보너스볼을 상태로 가지는 객체를 도출하도록
- [x] RankTest DisplayName을 도메인 용어로 수정
