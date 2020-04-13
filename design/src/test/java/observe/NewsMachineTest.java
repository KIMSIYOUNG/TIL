package observe;

import org.junit.jupiter.api.Test;

class NewsMachineTest {
	@Test
	void setNewsTest() {
		NewsMachine publisher = new NewsMachine();
		Observer annual = new AnnualSubscriber(publisher);
		Observer event = new EventSubscriber(publisher);
		publisher.setNews("봄이 왔네요.", "벚꽃이 만개했어요.");

		publisher.notifySpecificObserver(new SpecialSubscriber(publisher));
		annual.withdraw();
		publisher.setNews("겨울이 왔어요", "따듯하게 입어요");
	}
}