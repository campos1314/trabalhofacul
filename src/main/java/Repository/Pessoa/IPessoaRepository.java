package Repository.Pessoa;

import Domains.Endereco.Endereco;
import Domains.Pessoa.Pessoa;

import java.util.List;

public interface IPessoaRepository {
    Pessoa findById(int id);
    List<Pessoa> findByName(String nome);
    Pessoa findByCpf(String cpf);
    Pessoa findByTelefone(String telefone);
    List<Pessoa> findByPessoaBairro(String bairro);
    List<Pessoa> findByPessoaCidade(String cidade);
    List<Pessoa> findByPessoaUf(String uf);
    void insert(Pessoa p);
    boolean update(Pessoa p);
    boolean delete(Pessoa p);

}
