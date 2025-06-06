package Global_Java.controller;



import Global_Java.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("ocorrencias", ocorrenciaService.listarTodas());
        return "login";
    }
}
