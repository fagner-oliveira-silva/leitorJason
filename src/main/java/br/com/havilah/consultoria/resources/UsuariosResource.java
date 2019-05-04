package br.com.havilah.consultoria.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controledeacesso.model.usuario.Administrador;
import controledeacesso.model.usuario.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResource {
	
	@Autowired
	//private Usuario usuario;
	
	//@PostMapping
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuario;
	}

	//@GetMapping
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
