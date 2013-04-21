package personalOrganiser;

import org.junit.*;

/**
 * Test cases for {@link Appointment}
 * @author Alexander
 * @version 1.0
 */
public class AppointmentTest {

	public Appointment a;
	
	@Before
	public void setup() {
		a = new Appointment();
	}
	
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setTitle("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowAppointmentTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setTitle("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctAppointmentTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setTitle("Software Engineering Meeting");
	}
	
	@Test
	public void test_emptyAppointmentLocation()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setLocation("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowAppointmentLocation()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setLocation("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctAppointmentLocation()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setLocation("East Building");
	}
	
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("", "");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_overflowAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_illegalAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("#~@", "{})(");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_overflowMinutesAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("07", "88");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_limitMinutesAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("07", "60");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_limitHoursAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("24", "00");
	}
	
	@Test
	public void test_correctAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("08", "30");
	}
	
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("", "");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_overflowAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_illegalAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("#~@", "{})(");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_overflowMinutesAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("07", "88");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_limitMinutesAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("07", "60");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_limitHoursAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("24", "00");
	}
	
	@Test(expected=PersonalOrganiserError.BeforeStartException.class)
	public void test_beforeStartAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setStartTime("08", "30");
		a.setEndTime("08", "00");
	}
	
	@Test
	public void test_correctAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setStartTime("08", "30");
		a.setEndTime("08", "30");
	}
	
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_illegalAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowMonthsAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowDaysAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		
	}
	
	@Test(expected=PersonalOrganiserError.PastDateException.class)
	public void test_pastDateAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		
	}
	
	@Test
	public void test_correctAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		
	}
	
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_illegalAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowMonthsAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowDaysAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		
	}
	
	@Test(expected=PersonalOrganiserError.PastDateException.class)
	public void test_pastDateAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		
	}
	
	@Test(expected=PersonalOrganiserError.BeforeStartException.class)
	public void test_beforeStartAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		
	}
	
	@Test
	public void test_correctAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		
	}
	
	@Test
	public void test_emptyAppointmentDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		a.setDescription("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowAppointmentDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		a.setDescription("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctAppointmentDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		a.setDescription("Meeting to discuss test plan");
	}
}
