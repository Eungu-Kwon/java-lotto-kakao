package com.lotto.model;

import java.util.List;

public class LottoTicket {
	public static final int LOTTO_SIZE = 6;
	private final List<LottoNumber> lottoNumbers;

	public LottoTicket(List<Integer> lottoNumbers) {
		isLottoTicketValid(lottoNumbers);
		this.lottoNumbers = LottoNumber.of(lottoNumbers);
	}

	private void isLottoTicketValid(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
		}

		if (lottoNumbers.stream().distinct().count() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
		}
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
