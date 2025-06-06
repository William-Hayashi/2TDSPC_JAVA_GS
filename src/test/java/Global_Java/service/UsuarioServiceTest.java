package Global_Java.service;

import Global_Java.model.Usuario;
import Global_Java.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Test
    void deveAutenticarComSucesso() {
        // Arrange
        UsuarioRepository repository = mock(UsuarioRepository.class);
        UsuarioService service = new UsuarioService();
        service.setRepository(repository); // ou use injeção via construtor

        Usuario usuario = new Usuario();
        usuario.setEmail("email@email.com");
        usuario.setSenha("123");

        when(repository.findByEmail("email@email.com"))
                .thenReturn(Optional.of(usuario));

        // Act
        boolean autenticado = service.autenticar("email@email.com", "123");

        // Assert
        assertTrue(autenticado);
    }

    @Test
    void naoDeveAutenticarComSenhaErrada() {
        UsuarioRepository repository = mock(UsuarioRepository.class);
        UsuarioService service = new UsuarioService();
        service.setRepository(repository);

        Usuario usuario = new Usuario();
        usuario.setEmail("email@email.com");
        usuario.setSenha("123");

        when(repository.findByEmail("email@email.com"))
                .thenReturn(Optional.of(usuario));

        boolean autenticado = service.autenticar("email@email.com", "errado");

        assertFalse(autenticado);
    }
}
