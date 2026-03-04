package osain.main.company.exception;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestControllerAdvice
public class ExceptionHandling {

	  @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<String> handleException(RuntimeException ex) {
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body(ex.getMessage());
	    }

}
