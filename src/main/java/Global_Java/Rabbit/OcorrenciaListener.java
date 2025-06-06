package Global_Java.Rabbit;

import Global_Java.config.RabbitConfig;
import Global_Java.model.Ocorrencia;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaListener {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receberOcorrencia(Ocorrencia ocorrencia) {
        System.out.println("📥 Nova ocorrência recebida na fila: " + ocorrencia.getNome());

   }
}
