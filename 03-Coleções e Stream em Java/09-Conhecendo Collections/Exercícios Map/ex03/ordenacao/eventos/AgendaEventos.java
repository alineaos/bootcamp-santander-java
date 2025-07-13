package ex03.ordenacao.eventos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String nomeAtracao){
        eventoMap.put(data, new Evento(nomeEvento, nomeAtracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        if(!eventoMap.isEmpty()) {
            Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
            for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
                if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                    proximaData = entry.getKey();
                    proximoEvento = entry.getValue();
                    System.out.println("O próximo evento (" + proximoEvento + ") acontecerá na data " + proximaData);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agenda = new AgendaEventos();

        agenda.adicionarEvento(LocalDate.of(2025, Month.AUGUST, 24 ), "Evento 1", "Atração 1");
        agenda.adicionarEvento(LocalDate.of(2025, 8, 16 ), "Evento 2", "Atração 2");
        agenda.adicionarEvento(LocalDate.of(2026, 7, 07 ), "Evento 3", "Atração 3");

        agenda.exibirAgenda();
        agenda.obterProximoEvento();
    }
}
