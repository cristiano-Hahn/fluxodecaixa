package br.com.fluxodecaixa.interfaces.rest;

import br.com.fluxodecaixa.application.ProdutoService;
import br.com.fluxodecaixa.interfaces.transfer.produto.ProdutoDto;
import br.com.fluxodecaixa.interfaces.transfer.util.IdDto;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class ProdutoController {

    private final ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping("/produtos")
    public ResponseEntity<IdDto> criarProduto(@RequestBody @Valid ProdutoDto produto) {
        return ResponseEntity.ok(service.criarProduto(produto));
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable("id") UUID id, @RequestBody @Valid ProdutoDto produto) {
        service.atualizarProduto(id, produto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable("id") UUID id) {
        service.excluirProduto(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoDto> buscarProduto(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.buscarProduto(id));
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDto>> buscarTodosProdutos(@RequestParam(required = false) String filtro) {
        return ResponseEntity.ok(service.buscarTodosProdutos(filtro));
    }
}
