package personalOrganiser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Collects together and runs all test cases for the personal organiser
 * @author Alexander
 * @version 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({AppointmentTest.class, ContactTest.class, TodoTest.class})
public class PersonalOrganiserTestSuite {
	
}