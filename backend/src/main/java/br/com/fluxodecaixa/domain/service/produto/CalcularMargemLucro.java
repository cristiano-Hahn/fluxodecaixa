package br.com.fluxodecaixa.domain.service.produto;

import org.springframework.stereotype.Service;

@Service
public class CalcularMargemLucro {

    public Double executar(Double precoCusto, Double precoVenda) {
        Double lucro = precoVenda - precoCusto;
        return lucro / precoVenda * 100;
    }

}
