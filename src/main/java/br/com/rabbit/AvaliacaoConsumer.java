package br.com.rabbit;

import br.com.model.Avaliacao;
import br.com.service.AvaliacaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoConsumer {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @RabbitListener(queues = {"${queue.avaliacao.name}"})
    public void receive (@Payload Avaliacao avaliacao){
        System.out.println("Id: "+ avaliacao.get_id() + "\nDescrição: " + avaliacao.getDescricao()
                + "\nNota: " + avaliacao.getNota() + "\nNome do aluno: " + avaliacao.getNomeAluno());
        avaliacaoService.save(avaliacao);
    }
}
