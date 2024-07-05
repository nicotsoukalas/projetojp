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

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
	
	@Autowired
	ContatoService contatoService;
	
	  // POST /api/contatos/ (adiciona um novo Contato a uma Pessoa)
    @PostMapping("/{pessoaId}")
    public ResponseEntity<Contato> save(@PathVariable Long id,@RequestBody Contato contato){
		Contato newContato = contatoService.save(id, contato);
		if(newContato == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(newContato);
		}
		
	}
//    public ResponseEntity<Contato> save(@PathVariable Long pessoaId, @RequestBody Contato contato) {
//        Contato newContato = contatoService.save(pessoaId, contato);
//        return ResponseEntity.ok(newContato);
//    }

    // GET /api/contatos/{id} (retorna os dados de um Contato por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.findContatoById(id);
		if(findContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
    }

    // GET /api/contatos/pessoa/{pessoaId} (lista todos os Contatos de uma Pessoa)
    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<Contato>> listContato(@PathVariable Long pessoaId) {
        List<Contato> contatos = contatoService.listContato(pessoaId);
        return ResponseEntity.ok(contatos);
    }

    // PUT /api/contatos/{id} (atualiza um Contato existente)
    @PutMapping("/{id}")
    public ResponseEntity<Contato> updContato(@PathVariable Long id, @RequestBody Contato contato) {
        Contato updContato = contatoService.updContato(id, contato);
        return ResponseEntity.ok(updContato);
    }

    // DELETE /api/contatos/{id} (remove um Contato por ID)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContato(@PathVariable Long id) {
        contatoService.deleteContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
//	POST /api/contatos/ (adiciona um novo Contato a uma Pessoa)
//	GET /api/contatos/{id} (retorna os dados de um Contato por ID)
//	GET /api/contatos/pessoa/{idPessoa} (lista todos os Contatos de uma Pessoa)
//	PUT /api/contatos/{id} (atualiza um Contato existente)

	

