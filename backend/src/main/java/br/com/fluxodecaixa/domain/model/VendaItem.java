package br.com.fluxodecaixa.domain.model;

import br.com.fluxodecaixa.domain.model.enums.MeioPagamento;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table(name = "venda_item")
public class VendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "vni_id", nullable = false, updatable = false)
    private UUID id;

 //   @ManyToOne
 //   @Setter(value = AccessLevel.NONE)
  // @JoinColumn(name = "vni_vnd_id", nullable = false)
  //  private Venda venda;

    @NotNull
    @Column(name = "vni_quantidade", columnDefinition = "numeric (15,2)")
    private Double quantidade;

    @ManyToOne
    @JoinColumn(name = "vni_pro_id", referencedColumnName = "pro_id")
    private Produto produto;
}
