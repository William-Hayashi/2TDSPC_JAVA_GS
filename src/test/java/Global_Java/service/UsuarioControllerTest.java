package Global_Java.service;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCadastrarUsuarioComSucesso() throws Exception {
        mockMvc.perform(post("/cadastro")
                        .param("email", "novo@email.com")
                        .param("senha", "123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?cadastro=sucesso"));
    }
}
