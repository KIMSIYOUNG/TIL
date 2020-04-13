package movie;

import java.math.BigDecimal;

public class Money {
	public static final Money ZERO = Money.wons(0);

	private final BigDecimal amount;

	private Money(BigDecimal amount) {
		this.amount = amount;
	}

	public static Money wons(long amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public static Money wons(double amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public Money plus(Money other) {
		return new Money(amount.add(other.amount));
	}

	public Money minus(Money other) {
		return new Money(amount.subtract(other.amount));
	}

	public Money times(double percent) {
		return new Money(amount.multiply(BigDecimal.valueOf(percent)));
	}

	public boolean isLessThan(Money other) {
		return amount.compareTo(other.amount) < 0;
	}

	public boolean isGreaterThanOrEqual(Money other) {
		return amount.compareTo(other.amount) >= 0;
	}
}
