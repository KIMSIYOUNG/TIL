package observe;

public class SpecialSubscriber implements Observer {
	private String news;
	private final Publisher publisher;

	public SpecialSubscriber(Publisher publisher) {
		this.publisher = publisher;
		publisher.add(this);
	}

	public void pullInfo() {
		publisher.notifySpecificObserver(this);
	}

	@Override
	public void update(String title, String news) {
		this.news = title + " : " + news;
	}

	@Override
	public void withdraw() {
		publisher.delete(this);
	}
}
