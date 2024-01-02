package fresher_presentation_app_springboot.exceptions;

public class StudentIdNotFoundException extends RuntimeException{

	String message="Student Id is not present";
	
	
	public StudentIdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
}
