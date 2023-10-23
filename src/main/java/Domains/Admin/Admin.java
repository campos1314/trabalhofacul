package Domains.Admin;

import Domains.GrupoDeEstudos.GrupoDeEstudo;
import Domains.Pessoa.Pessoa;

import javax.persistence.*;
@Entity
@Table(name = "administradores")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @Column(unique = true)
    private String codigo;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private GrupoDeEstudo grupoDeEstudo;
    public Admin(){

    }
    public Admin(Pessoa pessoa, String codigo){
        this.pessoa = pessoa;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
