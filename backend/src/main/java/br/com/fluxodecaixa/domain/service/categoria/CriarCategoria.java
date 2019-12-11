package br.com.fluxodecaixa.domain.service.categoria;

import br.com.fluxodecaixa.domain.exception.CodigoCategoriaJaExisteException;
import br.com.fluxodecaixa.domain.model.Categoria;
import br.com.fluxodecaixa.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarCategoria {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CriarCategoria(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria executar(Categoria categoria) {
        this.efetuarValidacoes(categoria);
        return categoriaRepository.save(categoria);
    }

    private void efetuarValidacoes(Categoria categoria) {
        if (categoriaRepository.findByCodigo(categoria.getCodigo()).isPresent()) {
            throw new CodigoCategoriaJaExisteException(categoria.getCodigo());
        }
    }
}
