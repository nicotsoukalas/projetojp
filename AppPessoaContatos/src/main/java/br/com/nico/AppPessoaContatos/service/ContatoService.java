package br.com.nico.AppPessoaContatos.service;

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


	public Contato save(Long id, Contato contato) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        // Tratar erro se pessoa não estiver presente
        Pessoa findPessoa = pessoa.get();
        contato.setPessoa(findPessoa); // Associar o contato à pessoa
        return contatoRepository.save(contato);
    }
	
//	Adicionar um novo Contato a uma Pessoa
//	
//	Obter Contato por ID
//	
//	Listar todos os Contatos de uma Pessoa
//	
//	Atualizar Contato por ID
//	
//	Deletar Contato por ID
	}
}
