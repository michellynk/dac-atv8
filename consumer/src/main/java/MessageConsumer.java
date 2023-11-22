package main.java;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = MachineAMQPConfig.QUEUE)
    public void consumer(Message message) {
        simpMessagingTemplate.convertAndSend(MessageWebSocketConfiguration.BROKER,
                new String(message.getBody()));
    }
}
