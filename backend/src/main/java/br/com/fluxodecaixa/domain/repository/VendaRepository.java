package br.com.fluxodecaixa.domain.repository;

import br.com.fluxodecaixa.domain.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {
}
