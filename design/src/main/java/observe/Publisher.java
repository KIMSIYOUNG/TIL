package observe;

public interface Publisher {
	void add(Observer observer);

	void delete(Observer observer);

	void notifyInfo();

	void setNews(String title, String news);
}
