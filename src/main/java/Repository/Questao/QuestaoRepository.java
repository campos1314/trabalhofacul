package Repository.Questao;

import Domains.QAA.Questao;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class QuestaoRepository implements IQuestaoRepository{
    private final EntityManager em;
    public QuestaoRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Questao findById(int id) {
        return em.find(Questao.class, id);
    }

    @Override
    public List<Questao> findAll() {
        String jpql ="SELECT p FROM Questao AS p";
        return em.createQuery(jpql, Questao.class)
                .getResultList();
    }

    @Override
    public List<Questao> findByDataDaPergunta(LocalDate data) {
        String jpql = "SELECT p FROM Questao AS p WHERE p.dataPergunta = ?1";
        return em.createQuery(jpql, Questao.class)
                .setParameter(1, data)
                .getResultList();
    }

    @Override
    public List<Questao> findByPessoaDaQuestao(String nome) {
        String jpql = "SELECT p FROM Questao AS p WHERE p.pessoa.nome = ?1";
        return em.createQuery(jpql, Questao.class)
                .setParameter(1, nome)
                .getResultList();

    }

    @Override
    public boolean insert(Questao questao) {
        this.em.persist(questao);
        return true;
    }

    @Override
    public boolean delete(Questao questao) {
        questao = em.merge(questao);
        this.em.remove(questao);
        return true;
    }

    @Override
    public boolean update(Questao questao) {
        this.em.merge(questao);
        return true;
    }
}
