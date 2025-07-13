package ex02.pesquisa.tarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        for (Tarefa t : tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaRemover = t;
                break;
            }
        }

        if (tarefaParaRemover != null) {
            tarefaSet.remove(tarefaParaRemover);
        } else {
            throw new RuntimeException("Descrição inválida.");
        }
    }

    public void exibirTarefas(){
        System.out.println(tarefaSet);
    }

    public int contarTarefas(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : tarefaSet){
            if (t.isConcluida()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa t : tarefaSet){
            if (!t.isConcluida()){
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        Tarefa tarefaConcluida = null;
        for (Tarefa t : tarefaSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setConcluida(true);
                tarefaConcluida = t;
                break;
            }
        }
        if (tarefaConcluida == null){
            System.out.println("Tarefa não encontrada");
        } else {
            System.out.println("Tarefa atualizada para concluída");
        }

    }

    public void marcarTarefaPendente(String descricao){
        Tarefa tarefaPendente = null;
        for (Tarefa t : tarefaSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setConcluida(false);
                tarefaPendente = t;
                break;
            }
        }
        if (tarefaPendente == null){
            System.out.println("Tarefa não encontrada");
        } else {
            System.out.println("Tarefa atualizada para pendente");
        }

    }

    public void limparListaTarefas(){
        if (tarefaSet.isEmpty()){
            System.out.println("A lista já está vazia!");
        } else {
            tarefaSet.clear();
            System.out.println("Lista esvaziada.");
        }
    }
    public static void main(String[] args) {
        ListaTarefas tarefas = new ListaTarefas();

        tarefas.adicionarTarefa("Tarefa 1");
        tarefas.adicionarTarefa("Tarefa 2");
        tarefas.adicionarTarefa("Tarefa 3");
        tarefas.adicionarTarefa("Tarefa 4");

        tarefas.removerTarefa("tarefa 4");
        tarefas.exibirTarefas();
        System.out.println("Total de tarefas: "+tarefas.contarTarefas());
        tarefas.marcarTarefaConcluida("Tarefa 1");
        tarefas.marcarTarefaConcluida("tarefa 2");
        tarefas.marcarTarefaPendente("tarefa 2");
        System.out.println("Tarefas concluídas: " + tarefas.obterTarefasConcluidas());
        System.out.println("Tarefas pendentes: " +tarefas.obterTarefasPendentes());

        tarefas.limparListaTarefas();
    }
}
