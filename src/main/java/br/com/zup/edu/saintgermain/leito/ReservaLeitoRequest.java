package br.com.zup.edu.saintgermain.leito;

import javax.validation.constraints.NotBlank;

public class ReservaLeitoRequest {

    @NotBlank
    private String titulo;

    @Deprecated
    public ReservaLeitoRequest() {
    }

    public ReservaLeitoRequest(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Leito toModel() {
        return  new Leito(titulo);
    }
}
