package fresher_presentation_app_springboot.exceptions;

public class StudentNameNotFoundException extends RuntimeException{
	
String message="Student Name is not present";
	
	
	public StudentNameNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

}
