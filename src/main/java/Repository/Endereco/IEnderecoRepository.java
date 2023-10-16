package Repository.Endereco;

import Domains.Endereco.Endereco;

import java.util.List;

public interface IEnderecoRepository {
    Endereco findById(int id);
    List<Endereco> findByBairro(String bairro);
    List<Endereco> findByCidade(String cidade);
    List<Endereco> findByUf(String uf);
    List<Endereco> findAll();
    boolean insert(Endereco endereco);
    boolean update(Endereco endereco);
    boolean delete(Endereco endereco);
}
