package ex02.pesquisa.contatos;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> agenda;

    public AgendaContatos() {
        this.agenda = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        agenda.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(agenda);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : agenda){
            if (c.getNome().startsWith(nome)){
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for(Contato c : agenda){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Camila Oliveira", 12345);
        agenda.adicionarContato("Camila Cavalcante",54321);
        agenda.adicionarContato("Maria Silva",67890);
        agenda.adicionarContato("Pedro Henrique",98760);

        agenda.exibirContatos();
        System.out.println(agenda.pesquisarPorNome("Camila"));
        agenda.atualizarNumeroContato("Pedro Henrique", 34567);
        agenda.exibirContatos();

    }
}
