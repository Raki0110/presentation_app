package fresher_presentation_app_springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;

@ControllerAdvice
public class ReviewExceptionController {

	@ExceptionHandler(UnAuthorizedReviewException.class)
	public ResponseEntity<ResponseStucture<String>> handleUnAuthorizedReviewException(UnAuthorizedReviewException  unAuthorizedReviewException)
	{
		ResponseStucture<String> structure=new ResponseStucture<>();
		structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("message: "+unAuthorizedReviewException.getMessage());
	    structure.setData("Student Cannot Review Himself");
	    
	    return new ResponseEntity<ResponseStucture<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	    
}
