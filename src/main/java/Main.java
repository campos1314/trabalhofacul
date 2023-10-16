import Domains.Endereco.Endereco;
import Domains.Endereco.REndereco;
import Domains.Pessoa.Pessoa;
import Repository.Endereco.EnderecoRepository;
import Repository.Pessoa.PessoaRepository;
import Utils.BuscandoApiCep;
import Utils.JPAUtil;
import com.google.gson.Gson;


import javax.persistence.*;
import java.io.IOException;

public class Main {
    public static void main(String[]args) throws IOException, InterruptedException {
        EntityManager em = JPAUtil.getEntityManager();
        var salvandoEndereco = new EnderecoRepository(em);
        var salvandoPessoa = new PessoaRepository(em);
        Gson gson = new Gson();
        em.getTransaction().begin();

        //BuscandoApiCep cep = new BuscandoApiCep("78142734");
        //var json = cep.getApiCep();
        //REndereco enderecoDTO = gson.fromJson(json, REndereco.class);
        //Endereco endereco = new Endereco(enderecoDTO);
        //salvandoEndereco.insert(endereco);
        //em.persist(endereco);

        var pessoa = salvandoPessoa.findById(2);
        System.out.println(pessoa.toString());
        //Pessoa pessoa = new Pessoa("Maria Goncalina", "2023-11-05", "65996451154", "000000000", endereco);
        //salvandoPessoa.insert(pessoa);
        em.getTransaction().commit();
        em.close();

    }
}
