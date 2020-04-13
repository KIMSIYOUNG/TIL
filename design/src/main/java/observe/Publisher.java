package observe;

public interface Publisher {
	void add(Observer observer);

	void delete(Observer observer);

	void notifyInfo();

	void notifySpecificObserver(Observer observer);
}
