package br.com.fluxodecaixa.domain.model;

import br.com.fluxodecaixa.domain.model.enums.MeioPagamento;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "vnd_id", nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "vnd_data")
    private Date data;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "vnd_meio_pagamento")
    private MeioPagamento meioPagamento;

    @Column(name = "vnd_descricao")
    private String descricao;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "vni_vnd_id")
    private List<VendaItem> itens;

    public List<VendaItem> getItens() {
        if(itens == null){
            itens = new ArrayList<>();
        }
        return itens;
    }
}
