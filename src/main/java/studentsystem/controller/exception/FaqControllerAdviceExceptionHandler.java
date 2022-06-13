package studentsystem.controller.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

@ControllerAdvice
public class FaqControllerAdviceExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return ResponseEntity.badRequest().body(
                Map.ofEntries(
                        entry("timestamp", LocalDateTime.now()),
                        entry("status", status.value()),
                        entry("path", request.getDescription(false)),
                        entry("error_list", ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                .collect(Collectors.toList()))
                )
        );

//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("status", status.value());
//        body.put("path", request.getDescription(false).substring(4));
//        body.put("error_list", ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.toList()));
    }
}
