package br.com.fiap.minhaestante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.minhaestante.model.Estante;

public interface EstanteRepository extends JpaRepository<Estante, Long> {
    
}
