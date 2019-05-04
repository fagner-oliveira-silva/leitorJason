package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controledeacesso.model.usuario.Administrador;
import controledeacesso.model.usuario.Usuario;

@SpringBootApplication
@RestController
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
	@RequestMapping(value="/")
	public String demo() {
		return "Hello ...";
	}

	@RequestMapping(value="/listaMock")
	public List<Usuario> listar() {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		Usuario usuario;
		
		StringBuffer login = new StringBuffer("fagner.oliveira.silva");
		StringBuffer provedor = new StringBuffer("@oi.com.br");
		
		for (int i=1;i<5;i++) {

			login.append(i);
			
			usuario = new Administrador();
			usuario.setEmail(login.toString()+provedor.toString());
			usuario.setLogin(login.toString()+provedor.toString());
			usuario.setSenha("123");
			usuario.setPrimeiroNome(login.toString());
			
			lista.add(usuario);
			
		}
		
		return lista;
		
	}

}
