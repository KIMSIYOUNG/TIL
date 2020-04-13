package observe;

public class AnnualSubscriber implements Observer {
	private String news;
	private final Publisher publisher;

	public AnnualSubscriber(Publisher publisher) {
		this.publisher = publisher;
		publisher.add(this);
	}

	@Override
	public void update(String title, String news) {
		this.news = title + " : " + news;
		display();
	}

	@Override
	public void withdraw() {
		publisher.delete(this);
	}

	private void display() {
		System.out.println("Annual Subscriber ");
		System.out.println(news);
	}
}
