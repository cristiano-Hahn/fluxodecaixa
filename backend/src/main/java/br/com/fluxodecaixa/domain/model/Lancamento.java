package br.com.fluxodecaixa.domain.model;

import br.com.fluxodecaixa.domain.model.enums.MeioPagamento;
import br.com.fluxodecaixa.domain.model.enums.TipoLancamento;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "lan_id", nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "lan_data")
    private Date data;

    @Column(name = "lan_data_pagamento")
    private Date dataPagamento;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "lan_meio_pagamento")
    private MeioPagamento meioPagamento;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "lan_tipo")
    private TipoLancamento tipoLancamento;

    @Column(name = "lan_observacao")
    private String observacao;

    @NotNull
    @Column(name = "lan_valor", columnDefinition = "numeric(15,2)")
    private Double valor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lai_lan_id")
    private List<LancamentoItem> itens;

    public List<LancamentoItem> getItens() {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        return itens;
    }
}
