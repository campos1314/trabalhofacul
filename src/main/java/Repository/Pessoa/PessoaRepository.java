package Repository.Pessoa;

import Domains.Pessoa.Pessoa;
import javax.persistence.*;

import java.util.List;

public class PessoaRepository implements IPessoaRepository{
    private final EntityManager em;
    public PessoaRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public Pessoa findById(int id) {
        return em.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> findByName(String nome) {
        String jpql = "SELECT p FROM Pessoa AS p WHERE p.nome = ?1";
        return em.createQuery(jpql, Pessoa.class)
                .setParameter(1, nome)
                .getResultList();
    }

    @Override
    public Pessoa findByCpf(String cpf) {
        String jpql = "SELECT p FROM Pessoa AS p WHERE p.cpf = ?1";
        return em.createQuery(jpql, Pessoa.class)
                .setParameter(1, cpf)
                .getSingleResult();
    }

    @Override
    public Pessoa findByTelefone(String telefone) {
        String jpql = "SELECT p FROM Pessoa AS p WHERE p.telefone = ?1";
        return em.createQuery(jpql, Pessoa.class)
                .setParameter(1, telefone)
                .getSingleResult();
    }

    @Override
    public List<Pessoa> findByPessoaBairro(String bairro) {
        String jpql = "SELECT p FROM Pessoa AS p WHERE p.endereco.bairro = ?1";
        return em.createQuery(jpql, Pessoa.class)
                .setParameter(1, bairro)
                .getResultList();
    }

    @Override
    public List<Pessoa> findByPessoaCidade(String cidade) {
        String jpql = "SELECET p FROM Pessoa AS p WHERE p.endereco.cidade = ?1";
        return em.createQuery(jpql, Pessoa.class)
                .setParameter(1, cidade)
                .getResultList();
    }

    @Override
    public List<Pessoa> findByPessoaUf(String uf) {
        String jpql = "SELECET p FROM Pessoa AS p WHERE p.endereco.uf = ?1";
        return em.createQuery(jpql, Pessoa.class)
                .setParameter(1, uf)
                .getResultList();
    }

    @Override
    public void insert(Pessoa p) {
        this.em.persist(p);

    }

    @Override
    public boolean update(Pessoa p) {
        this.em.merge(p);
        return true;
    }

    @Override
    public boolean delete(Pessoa p) {
        p = em.merge(p);
        this.em.remove(p);
        return true;
    }
}