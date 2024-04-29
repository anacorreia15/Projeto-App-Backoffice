package com.projeto.Backendmicroservice;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioRefeicoes extends JpaRepository<Refeicao, Integer> {

    @Query(value = "SELECT * FROM refeicao r WHERE MONTH(r.data) = :mesAtual AND r.tigela = true ORDER BY r.data ASC", nativeQuery = true)
    List<Refeicao> findRefeicoesByMesAndTigela(@Param("mesAtual") int mesAtual);

    @Query(value = "SELECT * FROM refeicao r WHERE r.data = :data AND r.tigela = true", nativeQuery = true)
    List<Refeicao> findRefeicoesByDataAndTigela(@Param("data") LocalDate data);

    @Query(value = "SELECT MONTH(r.data) AS mes, COUNT(*) AS totalSopa FROM refeicao r WHERE r.tigela = true  AND MONTH(r.data) = :mesAtual GROUP BY MONTH(r.data) ORDER BY mes", nativeQuery = true)
    Optional<Integer> findTotalSopaPorMes(@Param("mesAtual") int mesAtual);

    @Query(value = "SELECT COUNT(*) AS totalSopa FROM refeicao r WHERE r.tigela = true", nativeQuery = true)
    Optional<Integer> findTotalSopa();



}