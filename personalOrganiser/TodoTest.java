package personalOrganiser;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test cases for both {@link Task} and {@link TodoList}
 * @author Alexander
 * @version 1.0
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
	
	@Test
	public void test_createTodoList() {
		TodoList todo = new TodoList();
		assertTrue(todo != null);
	}
	
	@Test
	public void test_addTaskToTodoList() {
		tl.addTask(t);
		assertTrue(tl.getTasks().contains(t));
	}
	
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyTaskTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		t.setTitle(null);
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowTaskTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		t.setTitle("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctTaskTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		t.setTitle("Revise contract draft");
	}
	
	@Test
	public void test_emptyTaskOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setDescription(null);
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowTaskOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setDescription("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctTaskOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setDescription("To be submitted to Bob");
	}
	
	@Test
	public void test_emptyTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("", "", "");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_illegalTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("#~", "@{}", ")(");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowMonthsTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("04", "13", "2013");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowDaysTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("40", "06", "2013");
	}
	
	@Test(expected=PersonalOrganiserError.PastDateException.class)
	public void test_pastDateTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("04", "06", "2010");
	}
	
	@Test
	public void test_correctTaskOptionalDeadLine()
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		t.setDeadlineDate("04", "06", "2013");
	}
	
	@Test
	public void test_emptyTaskOptionalCategory()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setCategory("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowTaskOptionalCategory()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setCategory("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctTaskOptionalCategory()
			throws PersonalOrganiserError.CharacterLimitException {
		t.setCategory("Work");
	}
}