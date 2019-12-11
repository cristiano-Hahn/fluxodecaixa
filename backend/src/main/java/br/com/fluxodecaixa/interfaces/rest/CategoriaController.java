package br.com.fluxodecaixa.interfaces.rest;

import br.com.fluxodecaixa.domain.model.Categoria;
import br.com.fluxodecaixa.domain.repository.CategoriaRepository;
import br.com.fluxodecaixa.domain.service.categoria.AtualizarCategoria;
import br.com.fluxodecaixa.domain.service.categoria.BuscarCategoria;
import br.com.fluxodecaixa.domain.service.categoria.CriarCategoria;
import br.com.fluxodecaixa.domain.service.categoria.ExcluirCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final CriarCategoria criarCategoria;
    private final AtualizarCategoria atualizarCategoria;
    private final BuscarCategoria buscarCategoria;
    private final ExcluirCategoria excluirCategoria;

    @Autowired
    public CategoriaController(CategoriaRepository categoriaRepository,
                               CriarCategoria criarCategoria,
                               AtualizarCategoria atualizarCategoria,
                               BuscarCategoria buscarCategoria,
                               ExcluirCategoria excluirCategoria) {
        this.categoriaRepository = categoriaRepository;
        this.criarCategoria = criarCategoria;
        this.atualizarCategoria = atualizarCategoria;
        this.buscarCategoria = buscarCategoria;
        this.excluirCategoria = excluirCategoria;
    }

    @GetMapping("/categorias")
    public List<Categoria> findAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable).getContent();
    }

    @PostMapping("/categorias")
    public Categoria insert(@Valid @RequestBody Categoria categoria) {
        return criarCategoria.executar(categoria);
    }

    @PutMapping("/categorias/{id}")
    public Categoria update(@PathVariable("id") UUID id, @Valid @RequestBody Categoria values) {
        return atualizarCategoria.executar(id, values);
    }

    @GetMapping("/categorias/{id}")
    public Categoria findById(@PathVariable("id") UUID id) {
        return buscarCategoria.executar(id);
    }

    @DeleteMapping("/categorias/{id}")
    public void delete(@PathVariable("id") UUID id) {
        excluirCategoria.executar(id);
    }

}
