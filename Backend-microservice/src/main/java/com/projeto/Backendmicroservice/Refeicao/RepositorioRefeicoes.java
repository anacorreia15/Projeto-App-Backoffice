package com.projeto.Backendmicroservice.Refeicao;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepositorioRefeicoes extends JpaRepository<Refeicao, Long> {

    @Query(value = "SELECT * FROM refeicao r WHERE MONTH(r.data) = :mes AND r.tigela = true ORDER BY r.data ASC", nativeQuery = true)
    List<Refeicao> findRefeicoesByMes(@Param("mes") int mes);

    //Query para retornal o total de sopa por dia quando é escolhidodo mes
    /*@Query(value = "SELECT data, SUM(volume_sopa_desperdicado) as volumeSopaDesperdicado FROM refeicao r WHERE MONTH(r.data) = :mes  AND r.tigela = true GROUP BY r.data ORDER BY r.data ASC", nativeQuery = true)
    List<DadosRefeicao> calculaTotalSopaByMes(@Param("mes") Integer mes);*/

    //Query para retornal o total de sopa por dia quando é escolhido o dia especifico
    @Query(value = "SELECT SUM(volume_sopa_desperdicado) as volumeSopaDesperdicado FROM refeicao r WHERE r.data = :data AND r.tigela = true GROUP BY DAY(r.data)", nativeQuery = true)
    Double calculaTotalSopaByData(@Param("data") LocalDate data);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE r.data = :data", nativeQuery = true)
    Integer countTotalRefeicoesPorDia(@Param("data") LocalDate data);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE r.data = :data  AND r.tigela = true", nativeQuery = true)
    Integer countTotalRefeicoesPorDiaComTigela(@Param("data") LocalDate data);

    @Query(value = "SELECT COUNT(*) AS nr_refeicoes FROM refeicao r WHERE r.data = :data  AND r.tigela = false", nativeQuery = true)
    Integer countTotalRefeicoesPorDiaSemTigela(@Param("data") LocalDate data);

    @Query(value = "SELECT COUNT(*) AS total_litros FROM refeicao r WHERE MONTH(r.data) = :mes AND r.tigela = true", nativeQuery = true)
    Double countLitrosPorMes(@Param("mes") int mes);
}