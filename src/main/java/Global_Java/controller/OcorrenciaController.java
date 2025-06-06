package Global_Java.controller;

import Global_Java.Rabbit.OcorrenciaPublisher;
import Global_Java.model.Ocorrencia;
import Global_Java.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;
    @Autowired
    private OcorrenciaPublisher ocorrenciaPublisher;

    //@Autowired
    //private UrgenciaService urgenciaService;

    @GetMapping
    public String listarOcorrencias(Model model) {
        model.addAttribute("ocorrencias", ocorrenciaRepository.findAll());
        return "lista";
    }

    @GetMapping("/nova")
    public String mostrarFormularioNovaOcorrencia(Model model) {
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "form";
    }

    @PostMapping
    public String salvarOcorrencia(@ModelAttribute Ocorrencia ocorrencia) {
        if (ocorrencia.getId() == null || ocorrencia.getId().isBlank()) {
            ocorrencia.setId(null);
        }

        ocorrenciaRepository.save(ocorrencia);
        ocorrenciaPublisher.enviarNovaOcorrencia(ocorrencia);

        return "redirect:/ocorrencias";
    }

    @GetMapping("/editar/{id}")
    public String editarOcorrencia(@PathVariable String id, Model model) {
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(id).orElse(null);
        model.addAttribute("ocorrencia", ocorrencia);
        return "form";
    }

    @GetMapping("/deletar/{id}")
    public String deletarOcorrencia(@PathVariable String id) {
        ocorrenciaRepository.deleteById(id);
        return "redirect:/ocorrencias";
    }
}
