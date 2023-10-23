package Domains.GrupoDeEstudos;

import Domains.Admin.Admin;
import Domains.Pessoa.Pessoa;
import Domains.QAA.Questao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gruposestudos")
public class GrupoDeEstudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeGrupo;
    private String descricaoGrupo;
    private LocalDate dataCriacao;
    @OneToMany
    private List<Pessoa> membros = new ArrayList<>();
    @ManyToOne
    private Admin admin;
    @OneToMany
    private List<Questao> questao = new ArrayList<>();
    public GrupoDeEstudo(String nomeGrupo, String descricaoGrupo, Admin admin){
        this.admin = admin;
        this.nomeGrupo = nomeGrupo;
        this.descricaoGrupo = descricaoGrupo;
        this.dataCriacao = LocalDate.now();
    }
    public GrupoDeEstudo(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getDescricaoGrupo() {
        return descricaoGrupo;
    }

    public void setDescricaoGrupo(String descricaoGrupo) {
        this.descricaoGrupo = descricaoGrupo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Pessoa> getMembros() {
        return membros;
    }

    public void setMembros(List<Pessoa> membros) {
        this.membros = membros;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Questao> getQuestao() {
        return questao;
    }

    public void setQuestao(List<Questao> questao) {
        this.questao = questao;
    }

    @Override
    public String toString() {
        return "GrupoDeEstudo{" +
                "id=" + id +
                ", nomeGrupo='" + nomeGrupo + '\'' +
                ", descricaoGrupo='" + descricaoGrupo + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", membros=" + membros +
                ", admin=" + admin +
                ", questao=" + questao +
                '}';
    }
}
