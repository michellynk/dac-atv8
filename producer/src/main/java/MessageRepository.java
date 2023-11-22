package main.java;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class MessageRepository {

    private List<Message> messages;

    public MachineRepository() {
        this.messages = new ArrayList<>();
    }

    public Machine save(Message messages) {
        messages.add(messages);
        return messages;
    }

}