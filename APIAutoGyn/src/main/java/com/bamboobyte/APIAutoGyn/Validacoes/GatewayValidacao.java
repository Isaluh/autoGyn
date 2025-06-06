package com.bamboobyte.APIAutoGyn.Validacoes;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.bamboobyte.APIAutoGyn.Entities.Peca;
import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
import com.bamboobyte.APIAutoGyn.DTO.*;
import com.bamboobyte.APIAutoGyn.Entities.Colaborador;
import com.bamboobyte.APIAutoGyn.Entities.Servico;

public class GatewayValidacao {
    private Validador validador;
    private List<Veiculo> veiculos;
    private List<Colaborador> colaboradores; 
    private List<Servico> servicos;
    private List<Peca> pecas;

    public GatewayValidacao(List<Veiculo> veiculos, List<Colaborador> colaboradores, List<Servico> servicos, List<Peca> pecas) {
        this.validador = new Validador();
        this.veiculos = veiculos;
        this.colaboradores = colaboradores;
        this.servicos = servicos;
        this.pecas = pecas;
    }

     public List<StatusValidacao> validar(CadastrarClienteDTO novoCliente) {
        List<StatusValidacao> erros = new LinkedList<>();

        if (novoCliente.isPJ()) {
            erros.add(this.validador.validaCNPJ(novoCliente.cnpj()));
            erros.add(this.validador.validaInscricaoEstadual(novoCliente.inscricaoEstadual()));
        } else {
            erros.add(this.validador.validaCPF(novoCliente.cpf()));
        }

        erros.add(this.validador.validaEmail(novoCliente.email()));
        erros.add(this.validador.validaCEP(novoCliente.cep()));
        erros.add(this.validador.validaUF(novoCliente.uf()));
        erros.add(this.validador.validaTelefone(novoCliente.telefone()));
        erros.add(this.validador.validaDDD(novoCliente.ddd()));

        if (novoCliente.ddd2() != null) {
            erros.add(this.validador.validaDDD(novoCliente.ddd2()));
            erros.add(this.validador.validaTelefone(novoCliente.telefone2()));
        }

        removerNulos(erros);
        return erros;
    }

    public List<StatusValidacao> validar(CadastrarAcessorioDTO novoAcessorio) {
        return new LinkedList<>(); 
    }

    public List<StatusValidacao> validar(CadastrarOSDTO novaOS) {
        List<StatusValidacao> erros = new LinkedList<>();
        
        Veiculo veiculo = findVeiculoByPlaca(novaOS.getPlaca());
        if (veiculo == null) {
            erros.add(StatusValidacao.VEICULO_NAO_ENCONTRADO);
        }

        for (ColaboradorServicoDTO colaboradorServico : novaOS.getServicos()) {
            if (colaboradorServico.getQuantidade() == null) {
                erros.add(StatusValidacao.QUANTIDADE_SERVICO_NULA);
            } else if (colaboradorServico.getQuantidade() <= 0) {
                erros.add(StatusValidacao.QUANTIDADE_SERVICO_NEGATIVA);
            }

            if (colaboradorServico.getCpf_colaborador() == null) {
                erros.add(StatusValidacao.SEM_CPF_COLABORADOR);
            } else {
                Colaborador colaborador = findColaboradorByCpf(colaboradorServico.getCpf_colaborador());
                if (colaborador == null) {
                    erros.add(StatusValidacao.COLABORADOR_NAO_ENCONTRADO);
                }
            }

            if (colaboradorServico.getId_servico() == null) {
                erros.add(StatusValidacao.SEM_ID_SERVICO);
            } else {
                Servico servico = findServicoById(colaboradorServico.getId_servico());
                if (servico == null) {
                    erros.add(StatusValidacao.SERVICO_NAO_ENCONTRADO);
                }
            }
        }

        for (PecaQuantidadeDTO pecaQuantidade : novaOS.getPecas()) {
            if (pecaQuantidade.getQuantidade() == null) {
                erros.add(StatusValidacao.QUANTIDADE_PECAS_NULA);
            } else if (pecaQuantidade.getQuantidade() <= 0) {
                erros.add(StatusValidacao.QUANTIDADE_PECAS_NEGATIVA);
            }

            if (pecaQuantidade.getId_peca() == null) {
                erros.add(StatusValidacao.SEM_ID_PECA);
            } else {
                Peca peca = findPecaById(pecaQuantidade.getId_peca());
                if (peca == null) {
                    erros.add(StatusValidacao.PECA_NAO_ENCONTRADA);
                } else if (peca.getQuantidadeEstoque() < pecaQuantidade.getQuantidade()) {
                    erros.add(StatusValidacao.SEM_ESTOQUE);
                }
            }
        }

        removerNulos(erros);
        return erros;
    }

    private Veiculo findVeiculoByPlaca(String placa) {
        return veiculos.stream().filter(v -> v.getPlaca().equals(placa)).findFirst().orElse(null);
    }

    private Colaborador findColaboradorByCpf(String cpf) {
        return colaboradores.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    private Servico findServicoById(Long id) {
        return servicos.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    private Peca findPecaById(Long id) {
        return pecas.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    private static void removerNulos(List<StatusValidacao> lista) {
        lista.removeIf(Objects::isNull);
    }

    public List<StatusValidacao> validar(CadastrarColaboradorDTO novoColaboradorDTO) {
        List<StatusValidacao> erros = new LinkedList<>();
        erros.add(this.validador.validaCPF(novoColaboradorDTO.getCpf()));
        removerNulos(erros);
        return erros;
    }
}
