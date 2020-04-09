package movie.domain;

import movie.DiscountCondition;
import movie.DiscountPolicy;
import movie.Money;
import movie.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
	private final Money discountAmount;

	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
