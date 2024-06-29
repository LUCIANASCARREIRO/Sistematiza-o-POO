package mgs;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;


    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

   
    @Override
    public String toString() {
        return "Funcionario \n" +
                "ID = "       + id + '\n' +
                "Nome = "     + nome + '\n';
    }
}
