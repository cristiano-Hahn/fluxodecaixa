package br.com.fluxodecaixa.domain.service.categoria;

import br.com.fluxodecaixa.domain.exception.CategoriaNaoEncontradaException;
import br.com.fluxodecaixa.domain.model.Categoria;
import br.com.fluxodecaixa.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarCategoria {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public BuscarCategoria(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria executar(UUID id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        this.efetuarValidacoes(id, categoria);

        return categoria.get();
    }

    private void efetuarValidacoes(UUID id, Optional<Categoria> categoria) {
        if (categoria.isEmpty()) {
            throw new CategoriaNaoEncontradaException(id);
        }
    }
}
