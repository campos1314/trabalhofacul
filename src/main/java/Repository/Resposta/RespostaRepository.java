package Repository.Resposta;

import Domains.QAA.Resposta;

import javax.persistence.EntityManager;
import java.util.List;

public class RespostaRepository implements IRespostaRepository{
    private final EntityManager em;
    public RespostaRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Resposta findById(int id) {
        return em.find(Resposta.class, id);
    }

    @Override
    public List<Resposta> findByName(String nome) {
        String jpql = "SELECT p FROM Resposta AS p WHERE p.pessoa.nome = ?1";
        return em.createQuery(jpql, Resposta.class)
                .setParameter(1, nome)
                .getResultList();
    }


    @Override
    public List<Resposta> findAll() {
        String jpql = "SELECT p FROM Resposta AS p";
        return em.createQuery(jpql, Resposta.class)
                .getResultList();
    }

    @Override
    public boolean insert(Resposta resposta) {
        this.em.persist(resposta);
        return true;
    }

    @Override
    public boolean delete(Resposta resposta) {
        resposta = em.merge(resposta);
        this.em.remove(resposta);
        return true;
    }

    @Override
    public boolean update(Resposta resposta) {
        this.em.merge(resposta);
        return true;
    }

}
