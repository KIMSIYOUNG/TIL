package observe;

import java.util.ArrayList;
import java.util.List;

public class NewsMachine implements Publisher {
	private List<Observer> observers;
	private String title;
	private String news;

	public NewsMachine() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void delete(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyInfo() {
		for (Observer observer : observers) {
			observer.update(title, news);
		}
	}

	@Override
	public void notifySpecificObserver(Observer observer) {
		observer.update(title, news);
	}

	public void setNews(String title, String news) {
		this.title = title;
		this.news = news;
		notifyInfo();
	}
}
