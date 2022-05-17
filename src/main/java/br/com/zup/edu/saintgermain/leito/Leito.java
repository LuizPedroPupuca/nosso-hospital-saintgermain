package br.com.zup.edu.saintgermain.leito;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@OptimisticLocking(type = OptimisticLockType.ALL)
@DynamicUpdate
public class Leito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOcupacao status = StatusOcupacao.LIVRE;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    private LocalDateTime atualizadoEm;

    public Leito(String titulo) {
        this.titulo = titulo;
    }

    public void atualizaReservaParaLivre() {
        this.atualizadoEm = LocalDateTime.now();
        this.status = StatusOcupacao.LIVRE;
    }

    public void atualizaReservaParaOcupado() {
        this.atualizadoEm = LocalDateTime.now();
        this.status = StatusOcupacao.OCUPADO;
    }

    /**
     * @deprecated construtor de uso exclusivo para o Hibernate
     */
    @Deprecated
    public Leito() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public StatusOcupacao getStatus() {
        return status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }
}
