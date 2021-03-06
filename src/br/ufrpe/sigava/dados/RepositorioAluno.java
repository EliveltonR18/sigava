package br.ufrpe.sigava.dados;

import br.ufrpe.sigava.negocio.beans.Cronograma;
import br.ufrpe.sigava.negocio.beans.Disciplina;
import br.ufrpe.sigava.negocio.beans.Tarefa;
import br.ufrpe.sigava.negocio.beans.pessoa.Aluno;

import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioAluno implements IRepositorioAluno{
    private ArrayList<Aluno> repositorioAluno;
    private static RepositorioAluno instance;

    private RepositorioAluno(){
        this.repositorioAluno = new ArrayList<Aluno>();
    }

    public static RepositorioAluno getInstance(){
        if (instance == null){
            instance = new RepositorioAluno();
        }
        return instance;
    }

    public ArrayList<Aluno> listarAlunos(){
        return this.repositorioAluno;
    }

    @Override
    public boolean adicionar (Aluno aluno){
        return this.repositorioAluno.add(aluno);
    }

    @Override
    public boolean adicionar (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        Aluno aluno = new Aluno(nome,email,sexo,dataNascimento,senha,cpf);
        return adicionar(aluno);
    }

    @Override
    public boolean remover (Aluno aluno){
        return this.repositorioAluno.remove(aluno);
    }

    @Override
    public Aluno buscar (String cpf){
        Aluno aluno = null;
        for (int i = 0; i < this.repositorioAluno.size(); i++) {
            if (this.repositorioAluno.get(i).getCpf().equalsIgnoreCase(cpf)) {
                aluno = this.repositorioAluno.get(i);
            }
        }
        return aluno;
    }

    @Override
    public boolean existe (Aluno aluno) {
        return this.repositorioAluno.contains(aluno);
    }

    @Override
    public boolean adicionarMarcacao(String nome, Aluno aluno, int codigoTarefa, LocalDate dataTermino, Tarefa tarefa){
        Cronograma cronograma = aluno.buscarCronograma(nome);
        return cronograma.adicionar(codigoTarefa, dataTermino, tarefa);
    }

    @Override
    public boolean existeCronograma (Aluno aluno, String nomeCronograma) {
        boolean retorno = false;
        if (aluno != null && nomeCronograma != null) {
            for (int i = 0; i < aluno.getCronogramas().size(); i++) {
                if (aluno.getCronogramas().get(i).getNome().equalsIgnoreCase(nomeCronograma)) {
                    retorno = true;
                }
            }
        }
        return retorno;
    }

    public ArrayList<Disciplina> listarDisciplinas (Aluno aluno){
        return aluno.getDisciplinas();
    }

}
