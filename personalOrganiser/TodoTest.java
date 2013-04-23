package personalOrganiser;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Test cases for both {@link Task} and {@link TodoList}
 * @author Alexander
 * @version 1.1
 */
public class TodoTest {

	public TodoList tl;
	public Task t;
	
	@Before
	public void setup() {
		tl = new TodoList();
		try {
			t = new Task("Test");
		} catch (Exception e) {
			System.err.println("Could Not Create Test Task");
		}
	}
	
	//Test 10.4.2
	@Test
	public void test_addTaskToTodoList() {
		tl.addTask(t);
		assertTrue(tl.getTasks().contains(t));
	}
	
	//Test 10.4.2ai
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyTaskTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		t.setTitle(null);
	}
	
	//Test 10.4.2aii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowTaskTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		t.setTitle("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.4.2aiii
	@Test
	public void test_correctTaskTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		t.setTitle("Revise contract draft");
	}
	
	//Test 10.4.2bi
	@Test
	public void test_emptyTaskOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setDescription(null);
	}
	
	//Test 10.4.2bii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowTaskOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setDescription("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.4.2biii
	@Test
	public void test_correctTaskOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setDescription("To be submitted to Bob");
	}
	
	//Test 10.4.2ci
	@Test
	public void test_emptyTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("", "", "");
	}
	
	//Test 10.4.2cii
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.4.2ciii
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_illegalTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("#~", "@{}", ")(");
	}
	
	//Test 10.4.2civ
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowMonthsTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("04", "13", "2013");
	}
	
	//Test 10.4.2cv
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowDaysTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("40", "06", "2013");
	}
	
	//Test 10.4.2cvi
	@Test(expected=PersonalOrganiserError.PastDateException.class)
	public void test_pastDateTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("04", "06", "2010");
	}
	
	//Test 10.4.2cvii
	@Test
	public void test_correctTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("04", "06", "2013");
	}
	
	//Test 10.4.2di
	@Test
	public void test_emptyTaskOptionalCategory()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setCategory("");
	}
	
	//Test 10.4.2dii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowTaskOptionalCategory()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setCategory("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.4.2diii
	@Test
	public void test_correctTaskOptionalCategory()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setCategory("Work");
	}
	
	//Test 10.4.3
	@Test
	public void test_viewATask() {
		try {
			TodoList test = new TodoList(new Task("Test"));
			assertTrue(test.getTask(0).toString() != null);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	//Test 10.4.3.1
	@Test
	public void test_viewListOfTasks() {
		String test = tl.toString();
		assertTrue(test != null);
	}
	
	//Test 10.4.4i
	@Test
	public void test_editTask() {
		try {
			TodoList test = new TodoList(new Task("Test Before"));
			test.getTask(0).setTitle("Test After");
			assertTrue(test.getTask(0).getTitle().equals("Test After"));
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	//Test 10.4.4ii
	@Test
	public void test_removeTask() {
		try {
			TodoList test = new TodoList(new Task("Test"));
			test.removeTask(0);
			assertTrue(test.getTasks().isEmpty());
		} catch (Exception e) {
			assertTrue(false);
		}		
	}
	
	//Test 10.4.5
	@Test
	public void test_checkOffTask() {
		try {
			TodoList test = new TodoList(new Task("Test"));
			test.getTask(0).setComplete(true);
			assertTrue(test.getTask(0).getComplete());
		} catch (Exception e) {
			assertTrue(false);
		}	
	}
	
	//Test 10.4.6
	@Test
	public void test_fieldsCheckTask() {
		String fields = "";
		try {
			TodoList test = new TodoList(new Task("Test"));
			fields = test.getTask(0).toString();
		} catch (Exception e) {
			assertTrue(false);
		}
		assertTrue(fields.contains("Title") && fields.contains("Description") && fields.contains("Deadline") && fields.contains("Category"));
	}
	
	/*//Test 10.4.7
	@Test
	public void test_alertTask() {
		
	}*/
}