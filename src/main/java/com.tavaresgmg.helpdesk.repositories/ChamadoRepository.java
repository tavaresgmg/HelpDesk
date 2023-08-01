package com.tavaresgmg.helpdesk.repositories;

import com.tavaresgmg.helpdesk.entities.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    
}
