package fresher_presentation_app_springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;


@ControllerAdvice
public class StudentExceptionController {

	@ExceptionHandler(StudentIdNotFoundException.class)
	public ResponseEntity<ResponseStucture<String>> handleStudentIdNotFoundException(StudentIdNotFoundException  studentIdNotFoundException)
	{
		ResponseStucture<String> structure=new ResponseStucture<>();
		structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("message: "+studentIdNotFoundException.getMessage());
	    structure.setData("No student id is found");
	    
	    return new ResponseEntity<ResponseStucture<String>>(structure,HttpStatus.NOT_FOUND);
	    
	}
	
	@ExceptionHandler(StudentNameNotFoundException.class)
	public ResponseEntity<ResponseStucture<String>> handleStudentNameNotFoundException(StudentNameNotFoundException  studentNameNotFoundException)
	{
		ResponseStucture<String> structure=new ResponseStucture<>();
		structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("message: "+studentNameNotFoundException.getMessage());
	    structure.setData("No student Name is found");
	    
	    return new ResponseEntity<ResponseStucture<String>>(structure,HttpStatus.NOT_FOUND);
	    
	}
	
}