package Domains.QAA;

import Domains.Pessoa.Pessoa;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "respostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String conteudo;
    private LocalDate dataResposta;
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToOne
    private Questao questao;

    public Resposta() {
    }
    public Resposta(String resposta, Pessoa pessoa, Questao questao) {
        this.questao = questao;
        this.conteudo = resposta;
        this.dataResposta = LocalDate.now();
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDate dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Resposta [conteudo=" + conteudo + ", dataResposta=" + dataResposta + ", pessoa=" + pessoa + "]";
    }



}
