package br.com.rabbit;

import br.com.model.Avaliacao;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Avaliacao avaliacao){
        rabbitTemplate.convertAndSend(this.queue.getName(), avaliacao);
    }
}
