/*package Global_Java.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.ChatPrompt;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrgenciaService {

    private final ChatClient chatClient;

    public UrgenciaService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Integer avaliarUrgencia(String descricao) {
        String prompt = String.format(
                "Avalie o nível de urgência de 0 (sem urgência) a 10 (urgência máxima) com base na seguinte ocorrência: \"%s\". " +
                        "Responda apenas com um número entre 0 e 10.", descricao
        );

        var userMessage = new UserMessage(prompt);
        var chatPrompt = new ChatPrompt(List.of(userMessage));
        var resposta = chatClient.call(chatPrompt).getResult().getOutput().getContent();

        try {
            return Integer.parseInt(resposta.replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            return 0; // padrão se a resposta for inesperada
        }
    }
}
*/