package br.com.fluxodecaixa.interfaces.rest;

import br.com.fluxodecaixa.application.VendaService;
import br.com.fluxodecaixa.interfaces.transfer.util.IdDto;
import br.com.fluxodecaixa.interfaces.transfer.venda.VendaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class VendaController {

    private final VendaService service;

    @Autowired
    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping("/vendas")
    public ResponseEntity<IdDto> criarVenda(@RequestBody @Valid VendaDto vendaDto) {
        return ResponseEntity.ok(service.criarVenda(vendaDto
        ));
    }

    @GetMapping("/vendas/{id}")
    public ResponseEntity<VendaDto> buscarVenda(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.buscarVenda(id));
    }

    @DeleteMapping("/vendas/{id}")
    public ResponseEntity<?> excluirVenda(@PathVariable("id") UUID id) {
        service.excluirVenda(id);
        return ResponseEntity.ok().build();
    }
}
