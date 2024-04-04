package com.lotto.view;

import java.util.Collections;
import java.util.List;

import com.lotto.model.LottoGame;
import com.lotto.model.LottoResult;
import com.lotto.model.LottoResults;
import com.lotto.model.LottoTickets;

public class LottoGameOutputView {

	public void printResult(LottoResults lottoResults) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		List<LottoResult> reversedLottoResults = getReversedLottoResults(lottoResults);
		reversedLottoResults
			.stream()
			.filter(result -> !result.isFailed())
			.forEach(System.out::println);
	}

	public void printLottoCount(int manualLottoCount, int autoLottoCount) {
		System.out.println();
		System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
	}

	public void printLottoList(LottoGame lottoGame) {
		LottoTickets lottoTickets = lottoGame.getLottoTickets();
		lottoTickets.getLottoTickets().forEach(lotto -> {
			System.out.println(lotto.toString());
		});
	}

	public void printProfitRate(LottoGame lottoGame) {
		System.out.println("총 수익률은 " + String.format("%.02f", lottoGame.calculateProfit()) + "입니다.");
	}

	private List<LottoResult> getReversedLottoResults(LottoResults lottoResults) {
		List<LottoResult> lottoResult = lottoResults.getLottoResults();
		Collections.reverse(lottoResult);
		return lottoResult;
	}

}
