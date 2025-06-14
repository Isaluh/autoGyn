package com.bamboobyte.APIAutoGyn.Services;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bamboobyte.APIAutoGyn.Entities.OS;
import com.bamboobyte.APIAutoGyn.Validacoes.FormatacoesComuns;
import com.bamboobyte.APIAutoGyn.Validacoes.FormatadorAdapter;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class RelatorioService {

    private static final SimpleDateFormat FORMATADOR_DATA = new SimpleDateFormat("dd/MM/yyyy");
    private static final FormatadorAdapter formatador = FormatacoesComuns.getInstancia();

    public byte[] gerarRelatorio(OS os) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, out);
            doc.open();

            Font tituloFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Font subtituloFont = new Font(Font.HELVETICA, 14, Font.BOLD);
            Font textoFont = new Font(Font.HELVETICA, 12);

            doc.add(new Paragraph("Ordem de Serviço #" + os.getId(), tituloFont));
            doc.add(new Paragraph("Status: " + (os.getEtapa() != null ? os.getEtapa().getDescricao() : "Indefinido"), textoFont));
            doc.add(new Paragraph(" "));

            if (os.getVeiculo() != null) {
                var veiculo = os.getVeiculo();
                doc.add(new Paragraph(String.format("Veículo: %s - Placa: %s",
                        veiculo.getModelo().getNome(), veiculo.getPlaca()), textoFont));

                if (veiculo.getCliente() != null) {
                    doc.add(new Paragraph("Cliente: " + veiculo.getCliente().getNome(), textoFont));
                } else {
                    doc.add(new Paragraph("Cliente: [Não vinculado ao veículo]", textoFont));
                }
            }

            doc.add(new Paragraph(" "));

            doc.add(new Paragraph("Serviços Realizados:", subtituloFont));
            if (os.getItensServico() != null && !os.getItensServico().isEmpty()) {
                for (var item : os.getItensServico()) {
                    String inicio = item.getDataInicio() != null ? FORMATADOR_DATA.format(item.getDataInicio()) : "Início não informado";
                    String fim = item.getDataFim() != null ? FORMATADOR_DATA.format(item.getDataFim()) : "Em andamento";
                    String responsavel = item.getColaborador() != null ? item.getColaborador().getNome() : "Sem responsável";

                    doc.add(new Paragraph(String.format("- %s | Resp.: %s | Início: %s | Fim: %s",
                            item.getServico().getDescricao(), responsavel, inicio, fim), textoFont));
                }
            } else {
                doc.add(new Paragraph("Nenhum serviço vinculado.", textoFont));
            }

            doc.add(new Paragraph(" "));

            doc.add(new Paragraph("Peças Utilizadas:", subtituloFont));
            if (os.getItensPeca() != null && !os.getItensPeca().isEmpty()) {
                for (var item : os.getItensPeca()) {
                    doc.add(new Paragraph(String.format("- %s | Qtd: %d | Valor unitário: %s",
                            item.getPeca().getDescricao(),
                            item.getQuantidade(),
                            formatador.formatarParaMoedaBR(item.getValorUnitario())), textoFont));
                }
            } else {
                doc.add(new Paragraph("Nenhuma peça vinculada.", textoFont));
            }

            doc.add(new Paragraph(" "));

            doc.add(new Paragraph("Resumo Financeiro:", subtituloFont));
            doc.add(new Paragraph("Valor total: " + formatador.formatarParaMoedaBR(os.getValorTotal()), textoFont));
            doc.add(new Paragraph("Valor pago: " + formatador.formatarParaMoedaBR(os.getValorPago()), textoFont));

            doc.close();
            return out.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
    }

    public byte[] gerarRelatorioGeral(List<OS> listaOs) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, out);
            doc.open();

            Font tituloFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Font subtituloFont = new Font(Font.HELVETICA, 14, Font.BOLD);
            Font textoFont = new Font(Font.HELVETICA, 12);

            doc.add(new Paragraph("Relatório Geral de Ordens de Serviço", tituloFont));
            doc.add(new Paragraph(" "));

            for (OS os : listaOs) {
                doc.add(new Paragraph("Ordem de Serviço #" + os.getId(), subtituloFont));
                doc.add(new Paragraph("Status: " + (os.getEtapa() != null ? os.getEtapa().getDescricao() : "Indefinido"), textoFont));
                doc.add(new Paragraph(" "));

                if (os.getVeiculo() != null) {
                    var veiculo = os.getVeiculo();
                    doc.add(new Paragraph(String.format("Veículo: %s - Placa: %s",
                            veiculo.getModelo().getNome(), veiculo.getPlaca()), textoFont));

                    if (veiculo.getCliente() != null) {
                        doc.add(new Paragraph("Cliente: " + veiculo.getCliente().getNome(), textoFont));
                    } else {
                        doc.add(new Paragraph("Cliente: [Não vinculado ao veículo]", textoFont));
                    }
                }

                doc.add(new Paragraph("Serviços Realizados:", textoFont));
                if (os.getItensServico() != null && !os.getItensServico().isEmpty()) {
                    for (var item : os.getItensServico()) {
                        String inicio = item.getDataInicio() != null ? FORMATADOR_DATA.format(item.getDataInicio()) : "Início não informado";
                        String fim = item.getDataFim() != null ? FORMATADOR_DATA.format(item.getDataFim()) : "Em andamento";
                        String responsavel = item.getColaborador() != null ? item.getColaborador().getNome() : "Sem responsável";

                        doc.add(new Paragraph(String.format("- %s | Resp.: %s | Início: %s | Fim: %s",
                                item.getServico().getDescricao(), responsavel, inicio, fim), textoFont));
                    }
                } else {
                    doc.add(new Paragraph("Nenhum serviço vinculado.", textoFont));
                }

                doc.add(new Paragraph("Peças Utilizadas:", textoFont));
                if (os.getItensPeca() != null && !os.getItensPeca().isEmpty()) {
                    for (var item : os.getItensPeca()) {
                        doc.add(new Paragraph(String.format("- %s | Qtd: %d | Valor unitário: %s",
                                item.getPeca().getDescricao(),
                                item.getQuantidade(),
                                formatador.formatarParaMoedaBR(item.getValorUnitario())), textoFont));
                    }
                } else {
                    doc.add(new Paragraph("Nenhuma peça vinculada.", textoFont));
                }

                doc.add(new Paragraph("Resumo Financeiro:", textoFont));
                doc.add(new Paragraph("Valor total: " + formatador.formatarParaMoedaBR(os.getValorTotal()), textoFont));
                doc.add(new Paragraph("Valor pago: " + formatador.formatarParaMoedaBR(os.getValorPago()), textoFont));

                doc.add(new Paragraph("------------------------------------------------------------", textoFont));
                doc.add(new Paragraph(" "));
            }

            doc.close();
            return out.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório geral de OSs", e);
        }
    }
}
