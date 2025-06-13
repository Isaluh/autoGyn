package com.bamboobyte.APIAutoGyn.DTO;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Entities.OS;

public class ListaOSDTO {

    private Long id;
    private String veiculo;
    private String data;
    private String valor;
    private String status;
    private String cliente;

    public ListaOSDTO(OS os) {
        this.id = os.getId();

        this.veiculo = String.format(
                "%s (%s)",
                os.getVeiculo().getModelo().getNome(),
                os.getVeiculo().getModelo().getMarca().getNome()
        );

        Date data = os.getData();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        this.data = String.format("%02d/%02d/%d",
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.YEAR));

        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        this.valor = formatador.format(os.getValorTotal());

        this.status = os.getEtapa() != null ? os.getEtapa().getDescricao() : "[Etapa indefinida]";

        if (os.getVeiculo() != null && os.getVeiculo().getCliente() != null) {
            Cliente cliente = os.getVeiculo().getCliente();

            if (cliente.getPessoaFisica() != null) {
                var pf = cliente.getPessoaFisica();
                this.cliente = String.format("[%s] %s", pf.getCpf(), cliente.getNome());

            } else if (cliente.getPessoaJuridica() != null) {
                var pj = cliente.getPessoaJuridica();
                this.cliente = String.format("[%s] %s", pj.getCnpj(), cliente.getNome());

            } else {
                this.cliente = cliente.getNome();
            }
        } else {
            this.cliente = "[Cliente não vinculado ao veículo]";
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
