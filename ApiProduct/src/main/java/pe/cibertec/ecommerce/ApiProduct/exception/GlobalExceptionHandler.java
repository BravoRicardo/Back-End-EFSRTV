package pe.cibertec.ecommerce.ApiProduct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.cibertec.ecommerce.ApiProduct.dto.ErrorResponseDto;


//Lo primero que tenemos que hacer con el globalexceptionHandler para que remplaze por encima del default
//Con el RestControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFound(EntityNotFoundException ex){
    
        var httpStatus = HttpStatus.NOT_FOUND;
        var errorResponse = new ErrorResponseDto(
                httpStatus,
                ex.getMessage(),
                ex.getStackTrace().toString());
        return new ResponseEntity<>(errorResponse,httpStatus);
    
    }
    
}
