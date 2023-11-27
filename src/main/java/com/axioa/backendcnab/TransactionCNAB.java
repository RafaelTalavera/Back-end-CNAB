package com.axioa.backendcnab;

import java.math.BigDecimal;

public record TransactionCNAB(
        Integer tipo,
        String data,
        BigDecimal valor,
        Long cpf,
        String cartao,
        String donoDaloja,
        String nomeDaloja
){
}
