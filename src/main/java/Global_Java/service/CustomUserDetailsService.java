package Global_Java.service;

import Global_Java.model.Usuario;
import Global_Java.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        System.out.println("Usuário encontrado: " + usuario.getEmail() + " | Senha: " + usuario.getSenha());

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha()) // ❗ não criptografada
                .roles("USER")
                .build();

    }
}
