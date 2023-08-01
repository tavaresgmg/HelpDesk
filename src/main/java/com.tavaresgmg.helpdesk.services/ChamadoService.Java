package com.tavaresgmg.helpdesk.services;

import com.tavaresgmg.helpdesk.entities.Chamado;
import com.tavaresgmg.helpdesk.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    @Autowired
    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public List<Chamado> findAll(){
        return chamadoRepository.findAll();
    }
}