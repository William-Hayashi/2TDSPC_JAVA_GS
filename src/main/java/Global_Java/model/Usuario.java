package Global_Java.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "Usuario")
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;

}

