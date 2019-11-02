package br.com.fluxodecaixa.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Data
@Table(name = "produto")
public class Produto {

    @Id
    @Column(columnDefinition = "uuid", name = "pro_id", nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "pro_codigo")
    private Integer codigo;

    @Size(max = 100)
    @NotEmpty
    @Column(name = "pro_nome")
    private String nome;

    @NotNull
    @Column(name = "pro_preco_custo", columnDefinition = "numeric (15,2)")
    private Double precoCusto;

    @NotNull
    @Column(name = "pro_preco_venda", columnDefinition = "numeric (15,2)")
    private Double pro_preco_venda;

    @Size(max = 1000)
    @Column(name = "pro_descricao_completa")
    private String descricaoCompleta;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "pro_und_id", referencedColumnName = "und_id")
    private UnidadeMedida unidadeMedida;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "pro_cat_id", referencedColumnName = "cat_id")
    private Categoria categoria;

}
