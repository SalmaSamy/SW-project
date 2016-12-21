public class Datee {
	private int day, month, year;

	public Datee(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}

	public Datee() {
		//
	}

	public String toString() {
		String date = day + "/" + month + "/" + year;
		return date;
	}

	public void setDay(int d) {
		day = d;
	}

	public void setMonth(int m) {
		month = m;
	}

	public void setYear(int y) {
		year = y;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
}
