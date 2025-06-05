package com.bamboobyte.APIAutoGyn.DTO;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.bamboobyte.APIAutoGyn.Entities.ItemServico;
import com.bamboobyte.APIAutoGyn.Entities.Servico;

public class ServicoOSDTO {
    private Long id;
    private String nome;
    private Boolean terminado;
    private String inicio;
    private String fim;
    private String responsavel;

    public ServicoOSDTO() {}

    public ServicoOSDTO(ItemServico itemServico) {
        Servico servico = itemServico.getServico();
        this.id = servico.getId();
        this.nome = servico.getDescricao();
        this.terminado = itemServico.getDataFim() != null;
        this.inicio = itemServico.getDataInicio() != null ? convertDateToLocalDate(itemServico.getDataInicio()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
        this.fim = itemServico.getDataFim() != null ? convertDateToLocalDate(itemServico.getDataFim()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
        this.responsavel = itemServico.getColaborador() != null ? itemServico.getColaborador().getNome() : "Responsável não informado";
    }

    private LocalDate convertDateToLocalDate(java.util.Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(Boolean terminado) {
        this.terminado = terminado;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "ServicoOSDTO [id=" + id + ", nome=" + nome + ", terminado=" + terminado + ", inicio=" + inicio
                + ", fim=" + fim + ", responsavel=" + responsavel + "]";
    }
}
