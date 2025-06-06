package Global_Java.Rabbit;

import Global_Java.config.RabbitConfig;
import Global_Java.model.Ocorrencia;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OcorrenciaPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarNovaOcorrencia(Ocorrencia ocorrencia) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "ocorrencia.nova", ocorrencia);
    }
}
