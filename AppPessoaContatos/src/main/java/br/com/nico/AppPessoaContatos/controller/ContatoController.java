package br.com.nico.AppPessoaContatos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nico.AppPessoaContatos.model.Contato;
import br.com.nico.AppPessoaContatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
	
	@Autowired
	ContatoService contatoService;
	
	@Operation(summary = "Grava o registro de um Contato")
	@PostMapping("/") // POST grava os dados de um Contato
	    public ResponseEntity<Contato> save(@RequestBody Contato contato){

		Contato newContato = contatoService.save(contato);
		if(newContato == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(newContato);
		}
	}

	@Operation(summary = "Retorna os dados de um Contato por ID")
    @GetMapping("/{id}") // GET retorna os dados de um Contato por ID
    public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.findContatoById(id);
		if(findContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
    }

	@Operation(summary = "Lista todos os Contatos de um ID de Pessoa ")
    @GetMapping("/pessoa/{id}") // GET lista todos os Contatos de uma Pessoa
    public ResponseEntity<List<Contato>> listContato(@PathVariable Long id) {
        List<Contato> contatos = contatoService.listContato(id);
        return ResponseEntity.ok(contatos);
    }

	@Operation(summary = "Atualiza um Contato existente por ID")
    @PutMapping("/{id}") // PUT atualiza um Contato existente
    public ResponseEntity<Contato> updContato(@PathVariable Long id, @RequestBody Contato contato) {
        Contato updContato = contatoService.updContato(id, contato);
        return ResponseEntity.ok(updContato);
    }

	@Operation(summary = "Remove um Contato por ID")
    @DeleteMapping("/{id}") // DELETE remove um Contato por ID
    public ResponseEntity<?> deleteContato(@PathVariable Long id) {
        contatoService.deleteContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}