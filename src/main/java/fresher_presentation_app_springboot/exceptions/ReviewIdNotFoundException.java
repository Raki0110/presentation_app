package fresher_presentation_app_springboot.exceptions;

public class ReviewIdNotFoundException extends RuntimeException {
	
String message="Review Id is not present";
	
	
	public ReviewIdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}


}
