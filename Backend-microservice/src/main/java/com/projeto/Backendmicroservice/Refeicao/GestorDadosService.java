package com.projeto.Backendmicroservice.Refeicao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class GestorDadosService {

    private final RepositorioRefeicoes repositorioRefeicoes;

    public DadosRefeicao obterTotalSopa(LocalDate data) {
        double totalSopa = repositorioRefeicoes.calculaTotalSopaByData(data);
        return new DadosRefeicao(data, totalSopa);
    }

    public List<DadosRefeicao> obterTotalSopaMes(Integer mes) {
        List<Refeicao> refeicoes = repositorioRefeicoes.findRefeicoesByMes(mes);
        Map<LocalDate, Double> dadosAgrupados = new TreeMap<>();
        List<DadosRefeicao> dados = new ArrayList<>();

        for (Refeicao r: refeicoes) {
           LocalDate data = r.getData();
           double volume = r.getVolumeSopaDesperdicado();

           if (dadosAgrupados.containsKey(data)){
               double volumeExistente = dadosAgrupados.get(data);
               dadosAgrupados.put(data, volumeExistente + volume);
           } else {
               dadosAgrupados.put(data, volume);
           }
        }

        for (Map.Entry<LocalDate, Double> entry : dadosAgrupados.entrySet()) {
            dados.add(new DadosRefeicao(entry.getKey(), entry.getValue()));
        }
        // Ordenar a lista pela data
        dados.sort(Comparator.comparing(DadosRefeicao::getData));
        return dados;
    }


}
