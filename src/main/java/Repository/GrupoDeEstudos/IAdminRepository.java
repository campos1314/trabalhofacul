package Repository.GrupoDeEstudos;

import Domains.Admin.Admin;
import Domains.Endereco.Endereco;

import java.util.List;

public interface IAdminRepository {
    //o Admin vai poder adicionar membros, remover membros, apagar perguntas e respostas, colocar
    //perguntas e respostas, cada grupo contem apenas 1 admin que cria o grupo
    //nao podemos esquecer que essa classe ainda eh de Admin
    //vc pode deletar o grupo, mas nao o admin
    Admin findById(int id);
    Admin findByCodigo(String codigo);
    Admin findByPessoaNome(String nome);
    List<Admin> findAll();//retorna todas as pessoas que sao admin...
    boolean insert(Admin admin);
    boolean update(Admin admin);
    //boolean delete(Admin admin);//pensando se vou colocar o delete...

}
