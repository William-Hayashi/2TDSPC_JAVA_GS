package Global_Java.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "Ocorrencia")
public class Ocorrencia {

    @Id
    private String id;

    private String nome;
    private String localizacao;
    private String descricao;

    private Integer urgencia;

}
