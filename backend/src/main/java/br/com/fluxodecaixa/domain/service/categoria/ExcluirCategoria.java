package br.com.fluxodecaixa.domain.service.categoria;

import br.com.fluxodecaixa.domain.exception.CategoriaNaoEncontradaException;
import br.com.fluxodecaixa.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExcluirCategoria {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public ExcluirCategoria(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void executar(UUID id) {
        this.efetuarValidacoes(id);
        categoriaRepository.deleteById(id);
    }

    private void efetuarValidacoes(UUID id) {
        if (categoriaRepository.findById(id).isEmpty()) {
            throw new CategoriaNaoEncontradaException(id);
        }
    }
}
