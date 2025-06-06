package Global_Java.service;


import Global_Java.model.Ocorrencia;
import Global_Java.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    public List<Ocorrencia> listarTodas() {
        return repository.findAll();
    }
}
