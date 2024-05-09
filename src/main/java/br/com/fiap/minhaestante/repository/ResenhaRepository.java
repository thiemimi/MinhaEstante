package br.com.fiap.minhaestante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.minhaestante.model.Resenha;
public interface ResenhaRepository extends JpaRepository<Resenha, Long> {

    Page<Resenha> findByEstanteTitulo(String estante, Pageable pageable);
}
