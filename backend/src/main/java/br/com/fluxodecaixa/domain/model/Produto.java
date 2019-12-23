package br.com.fluxodecaixa.domain.model;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "pro_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "pro_codigo")
    @Generated(GenerationTime.INSERT)
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
    private Double precoVenda;

    @NotNull
    @Column(name = "pro_margem_lucro", columnDefinition = "numeric (15,4)")
    private Double margemLucro;

    @Size(max = 1000)
    @Column(name = "pro_observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "pro_und_id", referencedColumnName = "und_id")
    private UnidadeMedida unidadeMedida;

    @ManyToOne
    @JoinColumn(name = "pro_cat_id", referencedColumnName = "cat_id")
    private Categoria categoria;

}
