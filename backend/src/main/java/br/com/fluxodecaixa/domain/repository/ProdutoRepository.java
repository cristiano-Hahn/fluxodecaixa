package br.com.fluxodecaixa.domain.repository;

import br.com.fluxodecaixa.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    List<Produto> findByNomeContainingIgnoreCaseOrCodigo(String nome, Integer codigo);
}
