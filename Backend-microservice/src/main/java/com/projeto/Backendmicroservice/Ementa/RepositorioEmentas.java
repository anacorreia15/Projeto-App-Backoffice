package com.projeto.Backendmicroservice.Ementa;

import com.projeto.Backendmicroservice.Refeicao.Refeicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepositorioEmentas extends JpaRepository<Ementa, Long> {


    @Query(value = "SELECT e FROM Ementa e WHERE e.data between :dataInicio AND :dataFim")
    List<Ementa> findEmentasByData(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

    @Query(value = "SELECT SUM(quantidade) as volumeSopaProduzido FROM ementa e WHERE e.data = :data GROUP BY DAY(e.data)", nativeQuery = true)
    Double findTotalSopaProdByData(@Param("data") LocalDate data);

    @Query(value = "SELECT SUM(quantidade) as volumeSopaProduzido FROM ementa e WHERE MONTH(e.data) = :mes", nativeQuery = true)
    Double findTotalSopaProdByMes(@Param("mes") Integer mes);

}

