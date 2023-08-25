package com.tavaresgmg.helpdesk.controllers;

import com.tavaresgmg.helpdesk.entities.Chamado;
import com.tavaresgmg.helpdesk.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {
    
    private final ChamadoRepository chamadoRepository;

    @Autowired
    public ChamadoController(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    @PostMapping
    public Chamado createChamado(@RequestBody Chamado chamado){
        return chamadoRepository.save(chamado);
    }

    @GetMapping
    public List<Chamado> getAllChamados(){
        return chamadoRepository.findAll();
    }
}
