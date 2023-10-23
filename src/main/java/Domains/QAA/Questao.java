package Domains.QAA;

import Domains.Pessoa.Pessoa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perguntas")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pergunta;
    private LocalDate dataPergunta;
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> resposta = new ArrayList<>();

    public Questao(){
    }

    public Questao(String pergunta, Pessoa pessoa) {
        this.pergunta = pergunta;
        this.dataPergunta = LocalDate.now();
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public LocalDate getDataPergunta() {
        return dataPergunta;
    }

    public void setDataPergunta(LocalDate dataPergunta) {
        this.dataPergunta = dataPergunta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Resposta> getResposta() {
        return resposta;
    }

    public void setResposta(List<Resposta> resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Questao{" +
                "id=" + id +
                ", pergunta='" + pergunta + '\'' +
                ", dataPergunta=" + dataPergunta +
                ", pessoa=" + pessoa +
                ", resposta=" + resposta +
                '}';
    }
}
