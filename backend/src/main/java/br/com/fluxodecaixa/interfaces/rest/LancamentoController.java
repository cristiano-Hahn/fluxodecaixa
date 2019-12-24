package br.com.fluxodecaixa.interfaces.rest;

import br.com.fluxodecaixa.application.LancamentoService;
import br.com.fluxodecaixa.interfaces.transfer.lancamento.LancamentoDto;
import br.com.fluxodecaixa.interfaces.transfer.util.IdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class LancamentoController {

    private final LancamentoService service;

    @Autowired
    public LancamentoController(LancamentoService service) {
        this.service = service;
    }

    @PostMapping("/lancamentos")
    public ResponseEntity<IdDto> criarLancamento(@RequestBody @Valid LancamentoDto lancamentoDto) {
        return ResponseEntity.ok(service.criarLancamento(lancamentoDto));
    }

    @GetMapping("/lancamentos/{id}")
    public ResponseEntity<LancamentoDto> buscarLancamento(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.buscarLancamento(id));
    }

    @PutMapping("/lancamentos/{id}")
    public ResponseEntity<?> atualizarLancamento(@PathVariable("id") UUID id,
                                                 @RequestBody @Valid LancamentoDto lancamentoDto) {
        service.atualizarLancamento(id, lancamentoDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/lancamentos/{id}")
    public ResponseEntity<?> excluirLancamento(@PathVariable("id") UUID id) {
        service.excluirLancamento(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lancamentos")
    public ResponseEntity<List<LancamentoDto>> buscarTodosLancamentos(@RequestParam(value = "dataInicial", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicial,
                                                                      @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFinal) {
        return ResponseEntity.ok(service.buscarTodosLancamentos(dataInicial, dataFinal));
    }
}
