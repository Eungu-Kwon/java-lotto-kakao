package com.lotto.model;

import java.util.List;

public class TargetLotto {
	private final List<Integer> numbers;
	private final int bonusNumber;

	public TargetLotto(List<Integer> numbers, int bonusNumber) {
		isTargetLottoValid(numbers, bonusNumber);
		this.numbers = numbers;
		this.bonusNumber = bonusNumber;
	}

	private void isTargetLottoValid(List<Integer> numbers, int bonusNumber) {
		if (numbers.size() != LottoTicket.LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
		}
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public LottoRank match(LottoTicket lottoTicket) {
		int matchCount = (int)numbers.stream().filter(lottoTicket.getLottoNumbers()::contains).count();
		boolean isBonusMatch = lottoTicket.getLottoNumbers().contains(bonusNumber);
		return LottoRank.of(matchCount, isBonusMatch);
	}
}
