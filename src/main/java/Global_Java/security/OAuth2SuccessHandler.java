package Global_Java.security;

import Global_Java.model.Usuario;
import Global_Java.repository.UsuarioRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UsuarioRepository usuarioRepository;

    public OAuth2SuccessHandler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        String nome = oAuth2User.getAttribute("name");

        // Verifica domínio
        if (!email.endsWith("@gmail.com")) { //@defesacivil.gov.br
            response.sendRedirect("/login?erro=nao_autorizado");
            return;
        }

        // Se o usuário ainda não existe, cria
        usuarioRepository.findByEmail(email).orElseGet(() -> {
            Usuario novo = new Usuario();
            novo.setEmail(email);
            novo.setNome(nome);
            novo.setSenha(""); // não usamos senha nesse caso
            return usuarioRepository.save(novo);
        });

        // Redireciona para a tela inicial
        response.sendRedirect("/ocorrencias");
    }
}
