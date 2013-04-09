package personalOrganiser;

public class TestRun {
	
	public static void main(String[] args) {
		Database db = new Database();
		db.addContact("Douglas", "Adams");
		db.addContact("Ellen", "Page");
		db.addContact("Diablo", "Cody");
		db.addContact("Ian", "Sommerville");
		System.out.println(db.getAllContacts());
	}
}