package com.projeto.Backendmicroservice.Refeicao;

import com.projeto.Backendmicroservice.Ementa.RepositorioEmentas;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
@AllArgsConstructor
public class GestorDadosService {

    private final RepositorioRefeicoes repositorioRefeicoes;
    private final RepositorioEmentas repositorioEmentas;

    public List<DadosRefeicao> obterTotalSopa(LocalDate data) {
        List<DadosRefeicao> dadosRefeicaoList = new ArrayList<>();

        double totalSopa = repositorioRefeicoes.calculaTotalSopaByData(data);
        DadosRefeicao dadosRefeicao = new DadosRefeicao(data, totalSopa);
        dadosRefeicaoList.add(dadosRefeicao);

        return dadosRefeicaoList;
    }

    public List<DadosRefeicao> obterTotalSopaMes(Integer mes) {
        List<Refeicao> refeicoes = repositorioRefeicoes.findRefeicoesByMes(mes);
        System.out.println(refeicoes);
        Map<LocalDate, Double> dadosAgrupados = new TreeMap<>();
        List<DadosRefeicao> dados = new ArrayList<>();

        for (Refeicao refeicao : refeicoes) {
            LocalDate data = refeicao.getData();
            double volume = refeicao.getVolumeSopaDesperdicado();
            //System.out.println(volume);
            if (dadosAgrupados.isEmpty()){
                dadosAgrupados.put(data, volume);

            } else if (dadosAgrupados.containsKey(data)){
                double volumeExistente = dadosAgrupados.get(data);
                //System.out.println(volumeExistente);
                dadosAgrupados.put(data, volumeExistente + volume);

            } else {
                dadosAgrupados.put(data, volume);
            }
        }
        System.out.println(dadosAgrupados);

        for (Map.Entry<LocalDate, Double> entry : dadosAgrupados.entrySet()) {
            dados.add(new DadosRefeicao(entry.getKey(), entry.getValue()));
        }
        // Ordenar a lista pela data
        dados.sort(Comparator.comparing(DadosRefeicao::getData));
        return dados;
    }

    public DadosRefeicao obterTotalSopaProd(LocalDate data) {
        double totalSopaProd = repositorioEmentas.findTotalSopaProdByData(data);
        return new DadosRefeicao(data, totalSopaProd);
    }

    public LocalDate[] calcularDatasSemana(String semana) {
        // Extrai o ano e o número da semana do valor recebido
        int semanaSelecionada = Integer.parseInt(semana.substring(6));
        int ano = Integer.parseInt(semana.substring(0, 4));

        // Calcula o primeiro dia da semana correspondente
        LocalDate dataInicio = LocalDate.of(ano, 1, 1) // Primeiro dia do ano
                .plusWeeks(semanaSelecionada - 1) // Adiciona o número de semanas
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)); // Volta para o primeiro dia da semana (segunda-feira)

        // Calcula o último dia da semana correspondente
        LocalDate dataFim = dataInicio.plusDays(6); // Adiciona seis dias para obter o último dia da semana

        // Retorna um array contendo as datas de início e fim da semana
        return new LocalDate[]{dataInicio, dataFim};
    }

    public Integer getDadosTotaisComSopa(String semana){
        LocalDate dataInicio = calcularDatasSemana(semana)[0];
        LocalDate dataFim = calcularDatasSemana(semana)[1];
        return repositorioRefeicoes.countTotalRefeicoesPorSemanaComTigela(dataInicio, dataFim);
    }

    public Integer getDadosTotaisSemSopa(String semana){
        LocalDate dataInicio = calcularDatasSemana(semana)[0];
        LocalDate dataFim = calcularDatasSemana(semana)[1];
        return repositorioRefeicoes.countTotalRefeicoesPorSemanaSemTigela(dataInicio, dataFim);
    }

    public static List<LocalDate[]> calcularSemanasDoMes(int mes) {
        List<LocalDate[]> semanas = new ArrayList<>();

        LocalDate primeiroDiaDoMes = LocalDate.now().withDayOfMonth(1).withMonth(mes);
        LocalDate ultimoDiaDoMes = primeiroDiaDoMes.withDayOfMonth(primeiroDiaDoMes.lengthOfMonth());

        LocalDate inicioSemana = primeiroDiaDoMes;
        LocalDate fimSemana = primeiroDiaDoMes.plusDays(6 - primeiroDiaDoMes.getDayOfWeek().getValue());

        while (fimSemana.isBefore(ultimoDiaDoMes) || fimSemana.isEqual(ultimoDiaDoMes)) {
            semanas.add(new LocalDate[]{inicioSemana, fimSemana});

            inicioSemana = fimSemana.plusDays(1);
            fimSemana = inicioSemana.plusDays(6);
        }

        // Se o último dia do mês não cair no último dia de uma semana completa, adicione a semana restante
        if (inicioSemana.isBefore(ultimoDiaDoMes) || inicioSemana.isEqual(ultimoDiaDoMes)) {
            semanas.add(new LocalDate[]{inicioSemana, ultimoDiaDoMes});
        }

        return semanas;
    }

    public List<Double> getTotalSopaDesperdicadaSemanas(Integer mes) {
        List<Double> totaisPorSemana = new ArrayList<>();
        List<LocalDate[]> semanasDoMes = calcularSemanasDoMes(mes); // Método para calcular as semanas do mês

        for (LocalDate[] semana : semanasDoMes) {
            LocalDate dataInicio = semana[0];
            LocalDate dataFim = semana[1];
            Double totalSemana = repositorioRefeicoes.calculaLitrosDesperdicadosPorSemana(dataInicio, dataFim);
            totaisPorSemana.add(totalSemana);
        }

        return totaisPorSemana;
    }

    public List<DadosRefeicao> obterTotalSopaSemana(String semana) {
        List<DadosRefeicao> dadosSemana = new ArrayList<>();

        LocalDate dataInicio = calcularDatasSemana(semana)[0];
        LocalDate dataFim = calcularDatasSemana(semana)[1];

        LocalDate dataAtual = dataInicio;
        while (!dataAtual.isAfter(dataFim)) {
            // Execute a consulta ao banco de dados para obter os dados da refeição desse dia
            List<DadosRefeicao> dadosDia = obterTotalSopa(dataAtual);

            // Adiciona os dados do dia à lista geral
            dadosSemana.addAll(dadosDia);

            // Avança para o próximo dia
            dataAtual = dataAtual.plusDays(1);
        }
        // Ordenar a lista pela data
        dadosSemana.sort(Comparator.comparing(DadosRefeicao::getData));
        return dadosSemana;
    }


    public List<Double> getTotalSopaDesperdicadaMes() {
        List<Integer> listaMeses = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> volumeVariosMeses = new ArrayList<>();

        for (Integer mes : listaMeses) {
            double volumeTotal = repositorioRefeicoes.calculaLitrosDesperdicadosPorMes(mes);
            volumeVariosMeses.add(volumeTotal);
        }

        return volumeVariosMeses;
    }

    public List<Integer> getNrRefeicoesMes(){
        List<Integer> listaMeses = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listaNrRefeicoes = new ArrayList<>();

        for (Integer mes : listaMeses) {
            int n_refeicoes = repositorioRefeicoes.countTotalRefeicoesPorMes(mes);
            listaNrRefeicoes.add(n_refeicoes);
        }
        return listaNrRefeicoes;
    }

    public List<Integer> getNrRefeicoesMesComTigela(){
        List<Integer> listaMeses = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listaNrRefeicoesComTigela = new ArrayList<>();

        for (Integer mes : listaMeses) {
            int n_refeicoes = repositorioRefeicoes.countTotalRefeicoesPorMesComTigela(mes);
            listaNrRefeicoesComTigela.add(n_refeicoes);
        }
        return listaNrRefeicoesComTigela;
    }


}
