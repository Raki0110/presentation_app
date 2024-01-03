package fresher_presentation_app_springboot.exceptions;

public class UnAuthorizedReviewException extends RuntimeException {

     String message="Student cannot review himself";
	
	
	public UnAuthorizedReviewException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
}
