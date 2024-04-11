package com.lotto.controller;

import com.lotto.model.LottoGame;
import com.lotto.model.LottoResults;
import com.lotto.model.LottoTickets;
import com.lotto.model.TargetLotto;
import com.lotto.util.LottoNumberGenerator;
import com.lotto.view.LottoGameInputView;
import com.lotto.view.LottoGameOutputView;

public class LottoGameController {
	private final LottoGameInputView lottoGameInputView;
	private final LottoGameOutputView lottoGameOutputView;

	public LottoGameController(LottoGameInputView lottoGameInputView, LottoGameOutputView lottoGameOutputView) {
		this.lottoGameInputView = lottoGameInputView;
		this.lottoGameOutputView = lottoGameOutputView;
	}

	public void run() {
		int money = lottoGameInputView.inputMoney();
		int manualCount = lottoGameInputView.inputManualCount(money);
		LottoTickets lottoTickets = lottoGameInputView.inputManualLottoTickets(manualCount);

		int autoMoney = money - (manualCount * LottoGame.LOTTO_PRICE);
		LottoGame lottoGame = new LottoGame(autoMoney, new LottoNumberGenerator());
		lottoGame.addManualLottoTicket(lottoTickets);
		lottoGameOutputView.printLottoCount(manualCount, lottoGame.getLottoTickets().size() - manualCount);
		lottoGameOutputView.printLottoList(lottoGame);

		TargetLotto targetLotto = lottoGameInputView.inputTargetNumbers();
		LottoResults lottoResults = lottoGame.play(targetLotto);

		lottoGameOutputView.printResult(lottoResults);
		lottoGameOutputView.printProfitRate(lottoGame);
	}
}
