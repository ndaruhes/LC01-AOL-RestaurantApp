package Repository_Singleton;

import java.util.ArrayList;

import Models.Customer.*;

public class PeopleRepository {
	private static ArrayList<People> peopleList = null;

	public static ArrayList<People> getPeopleList() {
		synchronized (peopleList) {
			if (peopleList == null) {
				peopleList = new ArrayList<People>();
			}
		}
		return peopleList;
	}
}
