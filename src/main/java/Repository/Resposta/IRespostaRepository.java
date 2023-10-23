package Repository.Resposta;

import Domains.QAA.Resposta;

import java.util.List;

public interface IRespostaRepository {
    Resposta findById(int id);//retorna o ID da resposta
    List<Resposta> findByName(String nome);//todas as respostas que uma pessoa x qualquer deu
    List<Resposta> findAll();//retorna todas as respostas do BD
    boolean insert(Resposta resposta);
    boolean delete(Resposta resposta);
    boolean update(Resposta resposta);

}
