package Global_Java;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlobalJavaApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.directory(".") // raiz do projeto
				.ignoreIfMissing() // não quebra se o .env não existir (opcional)
				.load();

		// Carrega as variáveis manualmente no sistema
		System.setProperty("GOOGLE_CLIENT_ID", dotenv.get("GOOGLE_CLIENT_ID"));
		System.setProperty("GOOGLE_CLIENT_SECRET", dotenv.get("GOOGLE_CLIENT_SECRET"));
		System.setProperty("HUGGINGFACE_TOKEN", dotenv.get("HUGGINGFACE_TOKEN"));

		SpringApplication.run(GlobalJavaApplication.class, args);
	}
}
