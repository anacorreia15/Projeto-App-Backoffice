package com.projeto.Backendmicroservice.Ementa;

import com.projeto.Backendmicroservice.Refeicao.DadosRefeicao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;

@RestController
@AllArgsConstructor
public class EmentaController {

    private final RepositorioEmentas repositorioEmentas;

    @PostMapping("/ementas/inserir")
    public void insertEmenta(@RequestBody Ementa ementa){
        repositorioEmentas.save(ementa);
    }

    @GetMapping("/ementas/visualizar")
    public List<Ementa> getEmentas(@RequestParam("semana") String semana){

        // Extrai o ano e o número da semana do valor recebido
        int ano = Integer.parseInt(semana.substring(0, 4));
        int semanaSelecionada = Integer.parseInt(semana.substring(6));

        // Calcula o primeiro dia da semana correspondente
        LocalDate dataInicio = LocalDate.of(ano, 1, 1) // Primeiro dia do ano
                .plusWeeks(semanaSelecionada - 1) // Adiciona o número de semanas
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)); // Volta para o primeiro dia da semana (segunda-feira)

        // Calcula o último dia da semana correspondente
        LocalDate dataFim = dataInicio.plusDays(6); // Adiciona seis dias para obter o último dia da semana

        System.out.println(dataInicio);
        System.out.println(dataFim);

        List<Ementa> ementas = repositorioEmentas.findEmentasByData(dataInicio, dataFim);
        ementas.sort(Comparator.comparing(Ementa::getData));

        return ementas;
    }
}
