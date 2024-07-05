package br.com.nico.AppPessoaContatos.dto;

import br.com.nico.AppPessoaContatos.model.Pessoa;

public record PessoaDTO(Long id, String nome, String malaDireta) {
    public PessoaDTO(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), String.format("%s – CEP: %s – %s/%s",
                pessoa.getEndereco(), pessoa.getCep(), pessoa.getCidade(), pessoa.getUf()));
    }
}
