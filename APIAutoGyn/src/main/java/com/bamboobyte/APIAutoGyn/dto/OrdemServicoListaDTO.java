package com.bamboobyte.APIAutoGyn.DTO;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.bamboobyte.APIAutoGyn.Entities.OS;

public class OrdemServicoListaDTO {

    private Long id;
    private String veiculo;
    private String data;
    private String valor;
    private String status;
    private String cliente;

    public OrdemServicoListaDTO(OS os) {
        this.id = os.getId();
        
        this.veiculo = String.format(
                "%s (%s) %d", 
                os.getVeiculo().getModelo().getNome(), 
                os.getVeiculo().getModelo().getMarca().getNome(),
                os.getVeiculo().getAnoModelo());
        
        Date data = os.getData();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        this.data = String.format("%02d/%02d/%d", 
                cal.get(Calendar.DAY_OF_MONTH), 
                cal.get(Calendar.MONTH) + 1, 
                cal.get(Calendar.YEAR));
        
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        this.valor = formatador.format(os.getValorTotal());
        
        this.status = os.getEtapa().getDescricao();

        if (os.getCliente().getPessoaFisica() != null) {
            this.cliente = String.format(
                    "[%s] %s", 
                    os.getCliente().getPessoaFisica().getCpf(), 
                    os.getCliente().getNome());
        } else if (os.getCliente().getPessoaJuridica() != null) {
            this.cliente = String.format(
                    "[%s] %s", 
                    os.getCliente().getPessoaJuridica().getCnpj(), 
                    os.getCliente().getNome());
        } else if (os.getCliente() != null) {
            this.cliente = os.getCliente().getNome();
        } else {
            this.cliente = "[Cliente não encontrado]";
        }
        
        this.cliente = String.format("(%d) %s", os.getId(), this.cliente);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
