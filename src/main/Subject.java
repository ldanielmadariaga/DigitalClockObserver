import java.util.ArrayList;

public abstract class Subject {

	private ArrayList<Observer> itsObservers = new ArrayList<Observer>();

	protected void notifyObservers() {
		for (Observer observer : itsObservers) {
			observer.update();
		}
	}

	public void registerObserver(Observer observer) {
		itsObservers.add(observer);
	}

}
