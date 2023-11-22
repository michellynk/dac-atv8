package main.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public Message save(Message message) {
        Message messageSaved = messageRepository.save(message);
        sendMachineToRabbit(messageSaved);
        return messageSaved;
    }

    public void sendMachineToRabbit(Message message) {
        try {
            String json = new ObjectMapper().writeValueAsString(message);
            rabbitTemplate.convertAndSend(MessageAMQPConfig.EXCHANGE_NAME, "", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
