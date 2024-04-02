package com.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lotto.model.LottoTickets;

public class LottoTicketsTest {
	@Test
	void 구입_금액에_해당하는_로또를_구매할_수_있다() {
		LottoTickets lottoTickets = new LottoTickets(14, () -> {
			return List.of(1, 2, 3, 4, 5, 6);
		});

		assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(14);
		assertThat(lottoTickets.getLottoTickets().get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
	}

}
