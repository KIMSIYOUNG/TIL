package movie;

import static org.assertj.core.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import movie.domain.AmountDiscountPolicy;
import movie.domain.PercentDiscountPolicy;

class MovieTest {
	@Test
	void movieTest() {
		Movie avatar = new Movie("아바타",
			Duration.ofMinutes(120),
			Money.wons(10000),
			new AmountDiscountPolicy(Money.wons(800),
				new SequenceCondition(1),
				new SequenceCondition(10),
				new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
				new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))));

		Money money = avatar.calculateMovieFee(new Screening(avatar, 1,
			LocalDateTime.of(2019, 10, 20, 10, 25, 30)));
		assertThat(money.isGreaterThanOrEqual(Money.wons(9200))).isTrue();
		System.out.println(money);
	}

	@Test
	void movieTest2() {
		Movie titanic = new Movie("타이타닉",
			Duration.ofMinutes(180),
			Money.wons(10000),
			new PercentDiscountPolicy(0.1,
				new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
				new SequenceCondition(2),
				new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))));

		Money money = titanic.calculateMovieFee(new Screening(titanic, 2,
			LocalDateTime.of(2019, 10, 20, 14, 25, 30)));
		assertThat(money.isGreaterThanOrEqual(Money.wons(9000))).isTrue();
	}
}