package br.ufrpe.sigava.negocio;

import br.ufrpe.sigava.negocio.beans.Disciplina;
import br.ufrpe.sigava.negocio.beans.Tarefa;
import br.ufrpe.sigava.negocio.beans.pessoa.Aluno;
import br.ufrpe.sigava.negocio.beans.pessoa.Professor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class ServidorSigava implements IServidorSigava{
    private CadastroProfessor professores;
    private CadastroAlunos alunos;
    private CadastroTarefas tarefas;
    private CadastroDisciplinas disciplinas;

    private static ServidorSigava instance;

    private ServidorSigava(){
        this.professores = new CadastroProfessor();
        this.alunos = new CadastroAlunos();
        this.tarefas = new CadastroTarefas();
        this.disciplinas = new CadastroDisciplinas();
    }

    public static ServidorSigava getIstance(){
        if (instance == null){
            instance = new ServidorSigava();
        }
        return instance;
    }

    public ArrayList <Aluno> listarAlunos (){
        return alunos.listarAlunos();
    }

    public ArrayList <Professor> listarProfessores (){
        return professores.listarProfessores();
    }

    public ArrayList <Tarefa> listarTarefas (){
        return tarefas.listarTarefas();
    }

    public ArrayList <Disciplina> listarDisciplinas (){
        return disciplinas.listarDisciplinas();
    }

    public boolean cadastrarAluno(Aluno aluno){ //TODO excepcion
       return this.alunos.cadastrar(aluno);
    }

    public Aluno buscarAluno(String cpf){
        return this.alunos.procurar(cpf);
    }

    public boolean cadastrarAluno(String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        return this.alunos.cadastrar(nome, email, sexo, dataNascimento, senha, cpf);
    }

    public boolean adicionarMarcacao(String nomeDisciplina, String nomeCronograma, Aluno aluno, int codigoTarefa, LocalDate dataTermino){
        return this.alunos.adicionarMarcacao(nomeDisciplina, nomeCronograma, aluno, codigoTarefa, dataTermino);
    }

    public boolean descadastrarAluno(Aluno aluno){
        return this.alunos.descadastrar(aluno);
    }

    public boolean existeAluno(Aluno aluno){
        return this.alunos.existe(aluno);
    }

    public boolean cadastrarDisciplina(Disciplina disciplina){
        return this.disciplinas.cadastrar(disciplina);
    }

    public boolean cadastrarDisciplina(String nome, LocalDate dataInicio, DayOfWeek diaAula, int duracaoAula, int cargaHoraria){
        return this.disciplinas.cadastrar(nome, dataInicio, diaAula, duracaoAula, cargaHoraria);
    }

    public boolean descadastrarDisciplina(Disciplina disciplina){
        return this.disciplinas.descadastrar(disciplina);
    }

    public Disciplina buscarDisciplina(String nome){
        return this.disciplinas.procurar(nome);
    }

    public boolean existeDisciplina(Disciplina disciplina){
        return this.disciplinas.existe(disciplina);
    }

    public boolean cadastrarProfessorDisciplina(String nomeDisciplina, Professor professor){
        return this.disciplinas.cadastrarProfessor(nomeDisciplina, professor);
    }

    public boolean cadastrarAlunoDisciplina(String nomeDisciplina, Aluno aluno){
        return this.disciplinas.cadastrarAluno(nomeDisciplina, aluno);
    }

    public boolean cadastrarTarefaDisciplina(String nomeDisciplina, Tarefa tarefa){
        return this.disciplinas.cadastrarTarefa(nomeDisciplina, tarefa);
    }

    public boolean cadastrarProfessor(Professor professor){
        return this.professores.cadastrar(professor);
    }

    public boolean cadastrarProfessor(String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        return this.professores.cadastrar(nome, email, sexo, dataNascimento, senha, cpf);
    }

    public boolean descadastrarProfessor(Professor professor){
        return this.professores.descadastrar(professor);
    }

    public Professor buscarProfessor(String cpf){
        return this.professores.procurar(cpf);
    }

    public boolean existeProfessor(Professor professor){
        return this.professores.existe(professor);
    }

    public boolean cadastrarTarefa(Tarefa tarefa){
        return this.tarefas.cadastrar(tarefa);
    }

    public boolean cadastrarTarefa(String descricao, LocalDate dataInicio,
                                   LocalDate dataTermino, int codigoTarefa, Disciplina disciplina){
        return this.tarefas.cadastrar(descricao, dataInicio, dataTermino, codigoTarefa, disciplina);
    }

    public boolean descadastrarTarefa(Tarefa tarefa){
        return this.tarefas.descadastrar(tarefa);
    }

    public Tarefa buscarTarefa(int codigo){
        return this.tarefas.procurar(codigo);
    }

    public boolean existeTarefa(Tarefa tarefa){
        return this.tarefas.existe(tarefa);
    }




}
