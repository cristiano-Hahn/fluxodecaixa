package br.com.fluxodecaixa.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "empresa", schema = "public")
public class Empresa {

    @Id
    @Column(columnDefinition = "uuid", name = "emp_id", nullable = false, updatable = false)
    private UUID id;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "emp_schema")
    private String schema;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "emp_razao_social")
    private String razaoSocial;

    @NotEmpty
    @Size(max = 14)
    @Column(name = "emp_inscricao")
    private String inscricao;

    @NotEmpty
    @Size(max = 256)
    @Column(name = "emp_email")
    private String email;

    @NotEmpty
    @Size(max = 256)
    @Column(name = "emp_endereco")
    private String endereco;

    @NotEmpty
    @Size(max = 256)
    @Column(name = "emp_telefone")
    private String telefone;

    @Column(name = "emp_ativa")
    private Boolean ativa;

    @JsonIgnore
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    @Column(name = "emp_created", nullable = false, updatable = false)
    private Date created;

    @JsonIgnore
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    @Column(name = "emp_updated", insertable = false)
    private Date updated;

    @JsonIgnore
    @Version
    @Setter(AccessLevel.NONE)
    @Column(name = "emp_version", nullable = false)
    private Long version;


}
