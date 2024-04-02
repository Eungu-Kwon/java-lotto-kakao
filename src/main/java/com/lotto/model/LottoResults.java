package com.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
	private List<LottoResult> lottoResults;

	public LottoResults() {
		lottoResults = Arrays.stream(LottoRank.values())
			.map(LottoResult::new)
			.collect(Collectors.toList());
	}

	public void addLottoCount(LottoRank lottoRank) {
		lottoResults.stream()
			.filter(result -> result.checkLottoRank(lottoRank))
			.findFirst()
			.ifPresent(LottoResult::addCount);
	}

	public int calculateTotalPrize() {
		return lottoResults.stream()
			.mapToInt(LottoResult::getPrize)
			.sum();
	}

	public List<LottoResult> getLottoResults() {
		return lottoResults;
	}
}
