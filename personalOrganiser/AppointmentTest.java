package personalOrganiser;

import org.junit.*;
//import static org.junit.Assert.*;

/**
 * Test cases for {@link Appointment}
 * @author Alexander
 * @version 1.1
 */
public class AppointmentTest {

	public Appointment a;
	
	@Before
	public void setup() {
		a = new Appointment();
	}
	
	//Test 10.1.1ai
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setTitle("");
	}
	
	//Test 10.1.1aii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowAppointmentTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setTitle("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.1.1aiii
	@Test
	public void test_correctAppointmentTitle()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setTitle("Software Engineering Meeting");
	}
	
	//Test 10.1.1bi
	@Test
	public void test_emptyAppointmentLocation()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setLocation("");
	}
	
	//Test 10.1.1bii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowAppointmentLocation()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setLocation("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.1.1biii
	@Test
	public void test_correctAppointmentLocation()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		a.setLocation("East Building");
	}
	
	//Test 10.1.1ci
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("", "");
	}
	
	//Test 10.1.1cii
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_overflowAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.1.1ciii
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_illegalAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("#~@", "{})(");
	}
	
	//Test 10.1.1civ
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_overflowMinutesAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("07", "88");
	}
	
	//Test 10.1.1cv
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_limitMinutesAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("07", "60");
	}
	
	//Test 10.1.1cvi
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_limitHoursAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("24", "00");
	}
	
	//Test 10.1.1cvii
	@Test
	public void test_correctAppointmentStartTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		a.setStartTime("08", "30");
	}
	
	//Test 10.1.1di
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		a.setStartDate("", "", "");
	}
	
	//Test 10.1.1dii
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		a.setStartDate("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.1.1diii
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_illegalAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		a.setStartDate("#~", "@{}", ")(");
	}
	
	//Test 10.1.1div
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowMonthsAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		a.setStartDate("04", "13", "2013");
	}
	
	//Test 10.1.1dv
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowDaysAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		a.setStartDate("40", "06", "2013");
	}
	
	//Test 10.1.1dvi
	@Test(expected=PersonalOrganiserError.PastDateException.class)
	public void test_pastDateAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		a.setStartDate("04", "06", "2010");
	}
	
	//Test 10.1.1dvii
	@Test
	public void test_correctAppointmentStartDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		a.setStartDate("04", "06", "2013");
	}
	
	//Test 10.1.1ei
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("", "");
	}
	
	//Test 10.1.1eii
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_overflowAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.1.1eiii
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_illegalAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("#~@", "{})(");
	}
	
	//Test 10.1.1eiv
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_overflowMinutesAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("07", "88");
	}
	
	//Test 10.1.1ev
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_limitMinutesAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("07", "60");
	}
	
	//Test 10.1.1evi
	@Test(expected=PersonalOrganiserError.IncorrectTimeException.class)
	public void test_limitHoursAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setEndTime("24", "00");
	}
	
	//Test 10.1.1evii
	@Test(expected=PersonalOrganiserError.BeforeStartException.class)
	public void test_beforeStartAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setStartTime("08", "30");
		a.setEndTime("08", "00");
	}
	
	//Test 10.1.1eviii
	@Test
	public void test_correctAppointmentEndTime()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		a.setStartTime("08", "30");
		a.setEndTime("08", "30");
	}
	
	//Test 10.1.1fi
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		a.setEndDate("", "", "");
	}
	
	//Test 10.1.1fii
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		a.setEndDate("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.1.1fiii
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_illegalAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		a.setEndDate("#~", "@{}", ")(");
	}
	
	//Test 10.1.1fiv
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowMonthsAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		a.setEndDate("05", "13", "2013");
	}
	
	//Test 10.1.1fv
	@Test(expected=PersonalOrganiserError.IncorrectDateException.class)
	public void test_overflowDaysAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		a.setEndDate("40", "06", "2013");
	}
	
	//Test 10.1.1fvi
	@Test(expected=PersonalOrganiserError.PastDateException.class)
	public void test_pastDateAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		a.setEndDate("05", "06", "2010");
	}
	
	//Test 10.1.1fvii
	@Test(expected=PersonalOrganiserError.BeforeStartException.class)
	public void test_beforeStartAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		a.setStartDate("04", "06", "2013");
		a.setEndDate("03", "06", "2013");
	}
	
	//Test 10.1.1fviii
	@Test
	public void test_correctAppointmentEndDate()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
		a.setEndDate("05", "06", "2013");
	}
	
	//Test 10.1.1gi
	@Test
	public void test_emptyAppointmentDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		a.setDescription("");
	}
	
	//Test 10.1.1gii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowAppointmentDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		a.setDescription("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.1.1giii
	@Test
	public void test_correctAppointmentDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		a.setDescription("Meeting to discuss test plan");
	}
}
