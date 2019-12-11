package br.com.fluxodecaixa.domain.service.categoria;

import br.com.fluxodecaixa.domain.exception.CategoriaNaoEncontradaException;
import br.com.fluxodecaixa.domain.exception.CodigoCategoriaJaExisteException;
import br.com.fluxodecaixa.domain.model.Categoria;
import br.com.fluxodecaixa.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarCategoria {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public AtualizarCategoria(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria executar(UUID id, Categoria values) {
        this.efetuarValidacoes(id, values);

        Categoria categoria = categoriaRepository.getOne(id);
        categoria.setCodigo(values.getCodigo());
        categoria.setDescricao(values.getDescricao());
        return categoriaRepository.save(categoria);
    }

    private void efetuarValidacoes(UUID id, Categoria values) {
        if (categoriaRepository.findById(id).isEmpty()) {
            throw new CategoriaNaoEncontradaException(id);
        }

        Optional<Categoria> categoriaDoMesmoCodigo = categoriaRepository.findByCodigo(values.getCodigo());
        if (categoriaDoMesmoCodigo.isPresent() && categoriaDoMesmoCodigo.get().getId().compareTo(id) != 0) {
            throw new CodigoCategoriaJaExisteException(values.getCodigo());
        }
    }
}
