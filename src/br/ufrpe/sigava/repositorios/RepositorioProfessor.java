package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.pessoa.Professor;

import java.time.LocalDate;
import java.util.ArrayList;


public class RepositorioProfessor implements IRepositorioProfessor {
    private ArrayList<Professor> repositorioProfessor = new ArrayList<Professor>();

    public RepositorioProfessor(){
    }

    @Override
    public boolean adicionar (Professor professor){
        return this.repositorioProfessor.add(professor);
    }

    @Override
    public boolean adicionar (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        Professor professor =  new Professor(nome, email, sexo,dataNascimento,senha,cpf);
        return adicionar(professor);
    }
    @Override
    public boolean remover (Professor professor){
        return this.repositorioProfessor.add(professor);
    }
    @Override
    public Professor buscar (String nome){
        Professor professor = null;

        for(int i = 0; i<this.repositorioProfessor.size(); i++){
            if(this.repositorioProfessor.get(i).getNome().equalsIgnoreCase(nome)){
                professor = this.repositorioProfessor.get(i);
            }
        }
        return professor;
    }
    @Override
    public boolean existe (Professor professor){
        return this.repositorioProfessor.contains(professor);
    }

}
