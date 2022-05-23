package Task6;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(HttpServerErrorException.BadGateway.class)
    public ResponseEntity<Object> handleBadGateway(RuntimeException  e, WebRequest request) {
        String body = "<pre><h1>502</h1></pre><pre><h2>Seems like something is broken!</h2></pre>";
        return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.BAD_GATEWAY, request);
    }
}
