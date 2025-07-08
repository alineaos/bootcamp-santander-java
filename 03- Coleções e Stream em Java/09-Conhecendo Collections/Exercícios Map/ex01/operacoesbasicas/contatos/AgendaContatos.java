package ex01.operacoesbasicas.contatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, int numero){
        agendaContatoMap.put(nome, numero);
    }

    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()){
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Contato 1", 12345);
        agenda.adicionarContato("Contato 2", 67890);
        agenda.adicionarContato("Contato 3", 98760);
        agenda.adicionarContato("Contato 4", 54321);
        agenda.adicionarContato("Contato 5", 54745);

        agenda.removerContato("Contato 5");
        agenda.exibirContatos();
        System.out.println(agenda.pesquisarPorNome("Contato 2"));
    }
}
