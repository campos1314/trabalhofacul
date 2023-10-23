package Repository.Endereco;

import Domains.Endereco.Endereco;
import Repository.Endereco.IEnderecoRepository;
import javax.persistence.*;

import java.util.List;

public class EnderecoRepository implements IEnderecoRepository {
    private final EntityManager em;
    public EnderecoRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public Endereco findById(int id){
        return em.find(Endereco.class, id);
    }

    @Override
    public List<Endereco> findByBairro(String bairro) {
        String jpql = "SELECT p FROM Endereco AS p WHERE p.bairro = ?1";
        return em.createQuery(jpql, Endereco.class)
                .setParameter(1, bairro)
                .getResultList();
    }

    @Override
    public List<Endereco> findByCidade(String cidade) {
        String jpql = "SELECT p FROM Endereco AS p WHERE p.cidade = ?1";
        return em.createQuery(jpql, Endereco.class)
                .setParameter(1, cidade)
                .getResultList();
    }

    @Override
    public List<Endereco> findByUf(String uf) {
        String jpql = "SELECT p FROM Endereco AS p WHERE p.uf = ?1";
        return em.createQuery(jpql, Endereco.class)
                .setParameter(1, uf)
                .getResultList();
    }

    @Override
    public List<Endereco> findAll() {
        String jpql = "SELECT p FROM Endereco AS p";
        return em.createQuery(jpql, Endereco.class).getResultList();
    }

    @Override
    public boolean insert(Endereco endereco) {
        this.em.persist(endereco);
        return true;
    }

    @Override
    public boolean update(Endereco endereco) {
        this.em.merge(endereco);
        return true;
    }

    @Override
    public boolean delete(Endereco endereco) {
        endereco = em.merge(endereco);
        this.em.remove(endereco);
        return true;
    }
}
