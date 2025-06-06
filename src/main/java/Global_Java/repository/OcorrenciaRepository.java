package Global_Java.repository;

import Global_Java.model.Ocorrencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends MongoRepository<Ocorrencia, String> {
}
