package br.com.fluxodecaixa.domain.service.venda;

import br.com.fluxodecaixa.domain.model.Venda;
import br.com.fluxodecaixa.domain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarVenda {

    private VendaRepository vendaRepository;

    @Autowired
    public CriarVenda(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda executar(Venda values) {
        return vendaRepository.save(values);
    }

}
