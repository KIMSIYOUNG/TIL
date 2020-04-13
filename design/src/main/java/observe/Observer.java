package observe;

public interface Observer {
	void update(String title, String news);

	void withdraw();
}
