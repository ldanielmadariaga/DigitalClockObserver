public class MockTimeSource extends Subject implements TimeSource {

	private int itsHours;
	private int itsMinutes;
	private int itsSeconds;

	public int getHours() {
		return itsHours;
	}

	public int getMinutes() {
		return itsMinutes;
	}

	public int getSeconds() {
		return itsSeconds;
	}

	public void setTime(int hours, int minutes, int seconds) {
		itsHours = hours;
		itsMinutes = minutes;
		itsSeconds = seconds;
		notifyObservers();

	}

}
