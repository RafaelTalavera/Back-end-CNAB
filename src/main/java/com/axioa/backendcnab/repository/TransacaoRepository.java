package com.axioa.backendcnab.repository;

import com.axioa.backendcnab.entity.Transacao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
    List<Transacao> findAllByOrderByNomeDaLojaAscIdDesc();
}