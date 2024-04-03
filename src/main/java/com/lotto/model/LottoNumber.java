package com.lotto.model;

public class LottoNumber {
	private int number;
	public LottoNumber(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException("로또 번호는 1부터 45까지 가능합니다.");
		}
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
