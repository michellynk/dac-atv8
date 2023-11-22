package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Machine> save(@RequestBody Message message) {
        Message messageSaved = messageService.save(message);
        System.out.println(String.format("Message saved: %s", messageSaved.toString()));
        return ResponseEntity.ok(messageSaved);
    }
}
