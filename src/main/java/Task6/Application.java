package Task6;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@Controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @GetMapping(value="/headers")
    public ResponseEntity<String> getHeaders(@RequestHeader Map<String, String> headers) {
        StringBuilder response = new StringBuilder();
        for (var h : headers.keySet())
            response.append("<pre><h2>")
                    .append(h).append(": ").append(headers.get(h))
                    .append("</h2></pre>");
        
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }
    
    @PostMapping(value="/id", consumes="application/json", produces="application/json")
    public ResponseEntity<String> addId(@RequestBody String body) {
        try {
            return new ResponseEntity<>(JSONManipulator.addId(body), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Error 422 - Unprocessable entity", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
