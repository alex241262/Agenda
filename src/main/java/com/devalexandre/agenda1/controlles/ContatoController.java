package com.devalexandre.agenda1.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@GetMapping
	//public List<Contato> findAll(){
	//	List<Contato> result = contatoRepository.findAll();
	//	return result;
	//}
	
	public Page<Contato> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");
        return new PageImpl<Contato>(
        		contatoRepository.findAll(), 
                pageRequest, size);
    }
	
	@GetMapping(value = "/{id}")
		public Contato findbyId(@PathVariable Long id){
			Contato result = contatoRepository.findById(id).get();
			return result;
		}
	
			@PostMapping
			public Contato insert(@RequestBody Contato contato) {
				Contato result = contatoRepository.save(contato);
				return result;
			}
			
			
			@DeleteMapping(value = "/{id}")
			public Contato delete(@PathVariable Long id) {			 
				contatoRepository.deleteById(id);
				return null;
			}
			
			
}
