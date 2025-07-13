package ex03.alunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        Aluno alunoParaRemover = null;
        for (Aluno a : alunoSet){
            if (a.getMatricula() == matricula){
                alunoParaRemover = a;
                break;
            }
        }

        if (alunoParaRemover != null) {
            alunoSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("Descrição inválida.");
        }
        alunoSet.remove(alunoParaRemover);
    }

    public Set<Aluno> exibirAlunoPorNome(){
        Set<Aluno> alunoPorNome = new TreeSet<>(alunoSet);
        return alunoPorNome;
    }

    public Set<Aluno> exibirAlunoPorNota(){
        Set<Aluno> alunoPorNota = new TreeSet<>(new ComparatorNota());
        alunoPorNota.addAll(alunoSet);
        return alunoPorNota;
    }

    public void exibirAlunos(){
        System.out.println(alunoSet);
    }
    public static void main(String[] args) {
        GerenciadorAlunos alunos = new GerenciadorAlunos();

        alunos.adicionarAluno("Aluno 4", 4l, 9.6);
        alunos.adicionarAluno("Aluno 3", 3l, 7.5);
        alunos.adicionarAluno("Aluno 1", 1l, 6.5);
        alunos.adicionarAluno("Aluno 2", 2l, 4.9);

        alunos.removerAluno(4l);
        System.out.println(alunos.exibirAlunoPorNome());
        System.out.println( alunos.exibirAlunoPorNota());
        alunos.exibirAlunos();
    }
}
