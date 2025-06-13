package com.bamboobyte.APIAutoGyn.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarOSDTO;
import com.bamboobyte.APIAutoGyn.DTO.ColaboradorServicoDTO;
import com.bamboobyte.APIAutoGyn.Repositories.ColaboradorRepository;
import com.bamboobyte.APIAutoGyn.Repositories.PecaRepository;
import com.bamboobyte.APIAutoGyn.Repositories.ServicoRepository;
import com.bamboobyte.APIAutoGyn.Repositories.VeiculoRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "os")
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_os")
    private Long id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "valor_total")
    private double valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "etapa")
    private Etapa etapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placa")
    private Veiculo veiculo;

    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPeca> itensPeca = new ArrayList<>();

    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemServico> itensServico = new ArrayList<>();

    public OS() {
    }

    public OS(CadastrarOSDTO dto,
            VeiculoRepository veiculoRepo,
            ServicoRepository servicoRepo,
            ColaboradorRepository colaboradorRepo,
            PecaRepository pecaRepo) {

        this.data = new Date();
        this.etapa = Etapa.ORCAMENTO;
        this.valorTotal = 0.0;

        this.veiculo = veiculoRepo.findById(dto.getVeiculo())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado: " + dto.getVeiculo()));

        for (ColaboradorServicoDTO sDto : dto.getServicosColaboradores()) {
            var servico = servicoRepo.findById(sDto.getServico())
                    .orElseThrow(() -> new RuntimeException("Serviço não encontrado: " + sDto.getServico()));

            var colaborador = colaboradorRepo.findByCpf(sDto.getColaborador())
                    .orElseThrow(() -> new RuntimeException("Colaborador não encontrado: " + sDto.getColaborador()));

            var item = new ItemServico();
            item.setOs(this);
            item.setServico(servico);
            item.setColaborador(colaborador);
            item.setQuantidade(1);
            item.setValorUnitario(servico.getValor());
            item.setValorTotal(servico.getValor());

            this.itensServico.add(item);
            this.valorTotal += item.getValorTotal();
        }

        for (Long idPeca : dto.getPeca()) {
            var peca = pecaRepo.findById(idPeca)
                    .orElseThrow(() -> new RuntimeException("Peça não encontrada ID: " + idPeca));

            if (peca.getQuantidadeEstoque() <= 0) {
                throw new RuntimeException("Estoque insuficiente para peça ID: " + idPeca);
            }

            var item = new ItemPeca();
            item.setOs(this);
            item.setPeca(peca);
            item.setQuantidade(1);
            item.setValorUnitario(peca.getValorUnitario());
            item.setValorTotal(peca.getValorUnitario());

            this.itensPeca.add(item);
            this.valorTotal += item.getValorTotal();
        }
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public List<ItemPeca> getItensPeca() {
        return itensPeca;
    }

    public List<ItemServico> getItensServico() {
        return itensServico;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setItensPeca(List<ItemPeca> itensPeca) {
        this.itensPeca = itensPeca;
    }

    public void setItensServico(List<ItemServico> itensServico) {
        this.itensServico = itensServico;
    }
}
