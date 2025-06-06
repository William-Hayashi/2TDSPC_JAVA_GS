package Global_Java.service;

import Global_Java.model.Usuario;
import Global_Java.repository.UsuarioRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Service
public class UsuarioService {

    // ✅ Adicione este método para poder usar mock no teste
    @Autowired
    private UsuarioRepository repository;

    public void salvar(Usuario usuario) {
        repository.save(usuario);
    }

    // ✅ Adicione este método para o teste funcionar
    public boolean autenticar(String email, String senha) {
        return repository.findByEmail(email)
                .map(u -> u.getSenha().equals(senha))
                .orElse(false);
    }

}
