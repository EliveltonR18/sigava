package br.ufrpe.sigava.repositorios;
import br.ufrpe.sigava.classes.Tarefa;
import java.util.ArrayList;


public class RepositorioTarefa implements IRepositorioTarefa {

    private ArrayList <Tarefa> repositorioTarefas = new ArrayList<Tarefa>();

    @Override
    public boolean adicionar(Tarefa tarefa){
        return this.repositorioTarefas.add(tarefa);
    }
    @Override
    public boolean remover(Tarefa tarefa){
        return this.repositorioTarefas.remove(tarefa);
    }
    @Override
    public Tarefa buscar(int codigo){
        Tarefa tarefa = null;
        for (int i = 0; i < this.repositorioTarefas.size(); i++){
            if (this.repositorioTarefas.get(i).getCodigoTarefa() == codigo){
                tarefa = this.repositorioTarefas.get(i);
            }
        }
        return tarefa;
    }
    @Override
    public boolean existe(Tarefa tarefa){
        return this.repositorioTarefas.contains(tarefa);
    }

}

