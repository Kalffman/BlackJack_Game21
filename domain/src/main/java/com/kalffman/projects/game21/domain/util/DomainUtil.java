package com.kalffman.projects.game21.domain.util;

public final class DomainUtil {

    public static Integer sumAceCardPoints(Integer partialSum, Integer aceCards) {
        if (aceCards == 0) return partialSum;

        boolean aceOnePoint = partialSum > 11;

        partialSum += (aceOnePoint ? 1 : 10);

        return sumAceCardPoints(partialSum, aceCards - 1);
    }
}
