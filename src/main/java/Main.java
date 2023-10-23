import Repository.Endereco.EnderecoRepository;
import Repository.Pessoa.PessoaRepository;
import Repository.Questao.QuestaoRepository;
import Repository.Resposta.RespostaRepository;
import Utils.JPAUtil;
import com.google.gson.Gson;


import javax.persistence.*;
import java.io.IOException;

public class Main {
    public static void main(String[]args) throws IOException, InterruptedException {
        EntityManager em = JPAUtil.getEntityManager();
        var salvandoEndereco = new EnderecoRepository(em);
        var salvandoPessoa = new PessoaRepository(em);
        var salvandoQuestao = new QuestaoRepository(em);
        var salvandoResposta = new RespostaRepository(em);
        Gson gson = new Gson();
        em.getTransaction().begin();

        //BuscandoApiCep cep = new BuscandoApiCep("78110400");
        //var json = cep.getApiCep();
        //REndereco enderecoDTO = gson.fromJson(json, REndereco.class);
        //Endereco endereco = new Endereco(enderecoDTO);
        //salvandoEndereco.insert(endereco);
        //em.persist(endereco);


        //Pessoa pessoa = salvandoPessoa.findById(2);
        //var pergunta = new Questao("Pq o ceu eh azul? ", pessoa);
        //salvandoQuestao.insert(pergunta);

        var x = salvandoQuestao.findById(1);
        System.out.println(x.toString());


        //Questao x = salvandoQuestao.findById(2);
        //System.out.println(x);

        //var testando = new Resposta("bla bla bla.", pessoa, x);
        //salvandoResposta.insert(testando);

        //System.out.println(pessoa.toString());
        //Pessoa pessoa = new Pessoa("Anani", "2023-11-05", "65996451154", "000000000", endereco);
        //salvandoPessoa.insert(pessoa);


        em.getTransaction().commit();
        em.close();

    }
}
