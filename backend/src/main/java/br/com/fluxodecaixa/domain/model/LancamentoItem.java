package br.com.fluxodecaixa.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table(name = "lancamento_item")
public class LancamentoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "lai_id", nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "lai_quantidade", columnDefinition = "numeric (15,2)")
    private Double quantidade;

    @ManyToOne
    @JoinColumn(name = "lai_pro_id", referencedColumnName = "pro_id")
    private Produto produto;
}
