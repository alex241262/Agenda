package com.devalexandre.agenda1.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devalexandre.agenda1.entities.Contato;
import com.devalexandre.agenda1.repositories.ContatoRepository;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {
	@Autowired
	private ContatoRepository contatoRepository;
	
	//trazer listas de todos os contatos
	public List<Contato> findAll(){
		List<Contato> result = contatoRepository.findAll();
		return result;
	}
	//trazer Somente 1 contato
	//comentario
	@GetMapping(value = "/{id}")
		public Contato findbyId(@PathVariable Long id){
			Contato result = contatoRepository.findById(id).get();
			return result;
		}
	//Inserir novo user
			@PostMapping
			public Contato insert(@RequestBody Contato contato) {
				Contato result = contatoRepository.save(contato);
				return result;
			}
			
			//Deletar user
			@DeleteMapping(value = "/{id}")
			public Contato delete(@PathVariable Long id) {			 
				contatoRepository.deleteById(id);
				return null;
			}
}
