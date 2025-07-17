package observerPattern;

public interface StockObservable {

	void add(NotifyObserver o);
	void remove(NotifyObserver o);
	void notifyObserver();
	void setStock(int stock);
	void getStock();
	
}
