package lotto.common;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    LottoRank(int matchCount, boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return NONE;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.matchBonus == matchBonus)
                .findFirst()
                .orElse(NONE);
    }
}