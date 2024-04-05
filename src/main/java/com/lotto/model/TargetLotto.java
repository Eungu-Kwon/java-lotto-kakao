package com.lotto.model;

import java.util.List;

public class TargetLotto {
	private final List<LottoNumber> numbers;
	private final LottoNumber bonusNumber;

	public TargetLotto(List<Integer> numbers, int bonusNumber) {
		isTargetLottoValid(numbers, bonusNumber);
		this.numbers = LottoNumber.of(numbers);
		this.bonusNumber = new LottoNumber(bonusNumber);
	}

	private void isTargetLottoValid(List<Integer> numbers, int bonusNumber) {
		if (numbers.size() != LottoTicket.LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
		}
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
		}
	}

	public List<LottoNumber> getNumbers() {
		return numbers;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

	public LottoRank match(LottoTicket lottoTicket) {
		int matchCount = (int)numbers.stream().filter(lottoTicket.getLottoNumbers()::contains).count();
		boolean isBonusMatch = lottoTicket.getLottoNumbers().contains(bonusNumber);
		return LottoRank.of(matchCount, isBonusMatch);
	}
}
