package ex01.operacoesbasicas.tarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
       List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t : listaTarefas){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
            }
        }
        listaTarefas.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas(){
        return listaTarefas.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(listaTarefas);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        System.out.printf("O número total de elementos na lista é %d.\n",listaTarefas.obterNumeroTotalTarefas());

        listaTarefas.adicionarTarefa("Tarefa 01");
        listaTarefas.adicionarTarefa("Tarefa 02");
        listaTarefas.adicionarTarefa("Tarefa 03");
        listaTarefas.adicionarTarefa("Tarefa 03");
        System.out.printf("O número total de elementos na lista é %d.\n",listaTarefas.obterNumeroTotalTarefas());
        listaTarefas.removerTarefa("Tarefa 03");
        System.out.printf("O número total de elementos na lista é %d.\n",listaTarefas.obterNumeroTotalTarefas());

        listaTarefas.obterDescricoesTarefas();
    }
}
