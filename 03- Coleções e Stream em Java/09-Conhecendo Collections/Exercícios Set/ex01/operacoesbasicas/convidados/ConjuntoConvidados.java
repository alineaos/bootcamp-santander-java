package ex01.operacoesbasicas.convidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidadoParaRemover = null;

        for (Convidado c : convidadoSet) {
            if (c.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = c;
                break;
            }
        }
            if (convidadoParaRemover != null) {
                convidadoSet.remove(convidadoParaRemover);
            } else {
                throw new IllegalArgumentException("Código do convite inválido.");
            }
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados convidados = new ConjuntoConvidados();

        convidados.adicionarConvidado("Maria", 001);
        convidados.adicionarConvidado("Joao", 002);
        convidados.adicionarConvidado("Felipe", 003);
        convidados.adicionarConvidado("Maria", 004);

        System.out.printf("Existem %d convidado(s).\n", convidados.contarConvidados());
        convidados.removerConvidadoPorCodigoConvite(004);
        convidados.exibirConvidados();

    }
}
