package personalOrganiser;

/**
 * Contains all custom exceptions required for the personal organiser
 * @author Alexander
 * @version 1.0
 */
public class PersonalOrganiserError {
	
	public class CharacterLimitException extends Exception {
		private static final long serialVersionUID = -4074894664721873966L;
	}
	
	public class EmptyStringException extends Exception {
		private static final long serialVersionUID = -1520170113780754462L;
	}
	
	public class IncorrectTimeException extends Exception {
		private static final long serialVersionUID = -1520170113780754462L;
	}
	
	public class PastDateException extends Exception {
		private static final long serialVersionUID = -1520170113780754462L;
	}
	
	public class BeforeStartException extends Exception {
		private static final long serialVersionUID = -1520170113780754462L;
	}
	
	public class IncorrectNameException extends Exception {
		private static final long serialVersionUID = -1520170113780754462L;
	}
	
	public class InvalidNumberException extends Exception {
		private static final long serialVersionUID = -1520170113780754462L;
	}
	
	public class InvalidEmailException extends Exception {
		private static final long serialVersionUID = -1520170113780754462L;
	}
	
	public class IncorrectDateException extends Exception {
		private static final long serialVersionUID = -1520170113780754462L;
	}
}