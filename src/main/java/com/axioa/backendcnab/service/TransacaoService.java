package com.axioa.backendcnab.service;

import com.axioa.backendcnab.entity.Transacao;
import com.axioa.backendcnab.entity.TransacaoReport;
import com.axioa.backendcnab.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransacaoService {
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public List<TransacaoReport> getTotaisTransacoesByNomeDaLoja() {
        List<Transacao> transacoes = repository.findAllByOrderByNomeDaLojaAscIdDesc();

        // preserves order
        Map<String, TransacaoReport> reportMap = new LinkedHashMap<>();

        transacoes.forEach(transacao -> {
            var nomeDaLoja = transacao.nomeDaLoja();
            var valor = transacao.valor();

            reportMap.compute(nomeDaLoja, (key, existingReport) -> {
                TransacaoReport report = (existingReport != null) ? existingReport
                        : new TransacaoReport(BigDecimal.ZERO, key, new ArrayList<>());
                return report.addTotal(valor).addTransacao(transacao);
            });
        });

        return new ArrayList<>(reportMap.values());
    }
}