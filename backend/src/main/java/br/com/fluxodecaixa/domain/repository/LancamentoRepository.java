package br.com.fluxodecaixa.domain.repository;

import br.com.fluxodecaixa.domain.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, UUID> {
    List<Lancamento> findByDataBetween(Date dataInicial, Date dataFinal);
}
