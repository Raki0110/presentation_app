package fresher_presentation_app_springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;

@ControllerAdvice
public class PresentationExceptionController {
	
	
	@ExceptionHandler(PresentationIdNotFoundException.class)
	public ResponseEntity<ResponseStucture<String>> handlePresentationIdNotFoundException(PresentationIdNotFoundException  presentationIdNotFoundException)
	{
		ResponseStucture<String> structure=new ResponseStucture<>();
		structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("message: "+presentationIdNotFoundException.getMessage());
	    structure.setData("No Presentation id is found");
	    
	    return new ResponseEntity<ResponseStucture<String>>(structure,HttpStatus.NOT_FOUND);
	    
	}

}
