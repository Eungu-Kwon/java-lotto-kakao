package com.lotto.model;

import java.util.ArrayList;
import java.util.List;

import com.lotto.util.LottoGenerateStrategy;

public class LottoTickets {
	private final List<LottoTicket> lottoTickets = new ArrayList<>();

	public LottoTickets(int amount, LottoGenerateStrategy lottoGenerateStrategy) {
		for (int i = 0; i < amount; i++) {
			List<Integer> numbers = lottoGenerateStrategy.generate();
			lottoTickets.add(new LottoTicket(numbers));
		}
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}

	public int size() {
		return lottoTickets.size();
	}

	public LottoResults playLotto(TargetLotto targetLotto) {
		LottoResults lottoResults = new LottoResults();
		getLottoTickets().forEach(lottoTicket -> {
			LottoRank lottoRank = targetLotto.match(lottoTicket);
			lottoResults.addLottoCount(lottoRank);
		});
		return lottoResults;
	}
}
