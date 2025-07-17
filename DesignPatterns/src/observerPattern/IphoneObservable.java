package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable{
	List<NotifyObserver> observerList = new ArrayList<NotifyObserver>();
	int stock = 0;

	@Override
	public void add(NotifyObserver o) {
		this.observerList.add(o);
	}

	@Override
	public void remove(NotifyObserver o) {
		this.observerList.remove(o);
	}

	@Override
	public void notifyObserver() {
		for(NotifyObserver o: observerList) {
			o.update();
		}
	}

	@Override
	public void setStock(int stock) {
		if(this.stock==0) {
			notifyObserver();
		}
		this.stock += stock;
	}

	@Override
	public void getStock() {
		System.out.println(this.stock);
	}
}
