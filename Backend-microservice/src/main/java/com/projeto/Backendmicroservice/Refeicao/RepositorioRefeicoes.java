package com.projeto.Backendmicroservice.Refeicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepositorioRefeicoes extends JpaRepository<Refeicao, Long> {

    @Query(value = "SELECT * FROM refeicao r WHERE r.tigela = true ORDER BY r.data ASC", nativeQuery = true)
    List<Refeicao> findAllRefeicoes();

    @Query(value = "SELECT * FROM refeicao r WHERE MONTH(r.data) = :mes AND r.tigela = true ORDER BY r.data ASC", nativeQuery = true)
    List<Refeicao> findRefeicoesByMes(@Param("mes") int mes);

    //Query para retornal o total de sopa por dia quando é escolhido o dia especifico
    @Query(value = "SELECT SUM(volume_sopa_desperdicado) as volumeSopa FROM refeicao r WHERE r.data = :data AND r.tigela = true GROUP BY DAY(r.data)", nativeQuery = true)
    Double calculaTotalSopaByData(@Param("data") LocalDate data);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE r.data = :data", nativeQuery = true)
    Integer countTotalRefeicoesPorDia(@Param("data") LocalDate data);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE r.data = :data  AND r.tigela = true", nativeQuery = true)
    Integer countTotalRefeicoesPorDiaComTigela(@Param("data") LocalDate data);


    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE MONTH(r.data) = :mes", nativeQuery = true)
    Integer countTotalRefeicoesPorMes(@Param("mes") int mes);


    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE MONTH(r.data) = :mes  AND r.tigela = true", nativeQuery = true)
    Integer countTotalRefeicoesPorMesComTigela(@Param("mes") int mes);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE MONTH(r.data) = :mes  AND r.tigela = false", nativeQuery = true)
    Integer countTotalRefeicoesPorMesSemTigela(@Param("mes") int mes);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE r.data = :data  AND r.tigela = false", nativeQuery = true)
    Integer countTotalRefeicoesPorDiaSemTigela(@Param("data") LocalDate data);

    //esta
    @Query(value = "SELECT COUNT(*) AS total_litros FROM refeicao r WHERE MONTH(r.data) = :mes AND r.tigela = true", nativeQuery = true)
    Double countLitrosPorMes(@Param("mes") int mes);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE r.data between :dataInicio AND :dataFim AND r.tigela = true", nativeQuery = true)
    Integer countTotalRefeicoesPorSemanaComTigela(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE r.data between :dataInicio AND :dataFim AND r.tigela = false", nativeQuery = true)
    Integer countTotalRefeicoesPorSemanaSemTigela(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

    @Query(value = "SELECT SUM(volume_sopa_desperdicado) AS volumeTotalSopaDesp FROM refeicao r WHERE r.data between :dataInicio AND :dataFim AND r.tigela = true", nativeQuery = true)
    Double calculaLitrosDesperdicadosPorSemana(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

    @Query(value = "SELECT SUM(volume_sopa_desperdicado) AS volumeTotalSopaDesp FROM refeicao r WHERE MONTH(r.data) = :mes AND r.tigela = true", nativeQuery = true)
    Double calculaLitrosDesperdicadosPorMes(@Param("mes") int mes);

}