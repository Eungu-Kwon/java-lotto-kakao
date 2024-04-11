package com.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	public List<Integer> getLottoNumbersByInt() {
		return lottoNumbers.stream()
			.map(LottoNumber::getNumber)
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}

	public int size() {
		return lottoNumbers.size();
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
