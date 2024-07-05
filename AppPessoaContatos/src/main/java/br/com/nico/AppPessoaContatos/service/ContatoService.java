package br.com.nico.AppPessoaContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nico.AppPessoaContatos.model.Contato;
import br.com.nico.AppPessoaContatos.model.Pessoa;
import br.com.nico.AppPessoaContatos.repository.ContatoRepository;
import br.com.nico.AppPessoaContatos.repository.PessoaRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;


	public Contato save(Contato contato) {  // Adicionar um novo Contato a uma Pessoa
        if (contato.getPessoa() == null || contato.getPessoa().getId() == null) {
            throw new IllegalArgumentException("Pessoa ID is required");
        }
        Optional<Pessoa> pessoa = pessoaRepository.findById(contato.getPessoa().getId()); // busca pessoa pelo id
        if (!pessoa.isPresent()) {
            return null; // ou lançar uma exceção apropriada
        }
        contato.setPessoa(pessoa.get()); // Associar o contato à pessoa
        return contatoRepository.save(contato); // salva o contato associado à pessoa no BD
    }
	
	public Optional<Contato> findContatoById(Long id) {  //	Obtém contato por ID
		return contatoRepository.findById(id);
	}

	public List<Contato> listContato(Long id) {  //	Lista todos os contatos de uma Pessoa
		return contatoRepository.findByPessoaId(id);
	}

	public Contato updContato(Long id, Contato updContato) { //	Atualizar Contato por ID
		updContato.setId(id);
		return contatoRepository.save(updContato);
	}

	public void deleteContato(Long id) {  // Deleta contato por ID
		contatoRepository.deleteById(id);
	}

	
}
