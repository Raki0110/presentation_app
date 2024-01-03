package fresher_presentation_app_springboot.exceptions;

public class PresentationIdNotFoundException extends RuntimeException {
	
String message="Presentation Id is not present";
	
	
	public PresentationIdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

}
