package Repository.Questao;

import Domains.QAA.Questao;

import java.time.LocalDate;
import java.util.List;

public interface IQuestaoRepository {
    Questao findById(int id);
    List<Questao> findAll();
    List<Questao> findByDataDaPergunta(LocalDate data);
    List<Questao> findByPessoaDaQuestao(String nome);
    boolean insert(Questao questao);
    boolean delete(Questao questao);
    boolean update(Questao questao);
}
