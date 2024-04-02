package com.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lotto.util.LottoNumberGenerator;

public class LottoNumberGeneratorTest {

	@Test
	void 각_로또_티켓은_1부터_45까지의_숫자를_가지고_있어야_한다_성공() {
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
		List<Integer> lottoNumbers = lottoNumberGenerator.generate();

		assertThat(lottoNumbers.size()).isEqualTo(6);
		assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
	}
}
