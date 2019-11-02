package br.com.fluxodecaixa.domain.repository;

import br.com.fluxodecaixa.domain.model.Empresa;
import br.com.fluxodecaixa.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {

}
