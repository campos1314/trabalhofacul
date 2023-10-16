package Domains.Pessoa;

import Domains.Endereco.Endereco;
import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String telefone;
    private String cpf;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Pessoa(){

    }
    public Pessoa(int id, String nome, String dataNascimento, String telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Pessoa(String nome, String dataNascimento, String telefone, String cpf, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
