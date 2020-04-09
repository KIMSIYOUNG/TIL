package movie.domain;

import movie.DiscountCondition;
import movie.DiscountPolicy;
import movie.Money;
import movie.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
	private final double percent;

	public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.getFee().times(percent);
	}
}
