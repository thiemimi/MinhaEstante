package br.com.fiap.minhaestante.model;

import br.com.fiap.minhaestante.validation.TipoEstante;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estante {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   // @NotBlank(message = "{estante.tituloLivro.notblank}")
    private String tituloLivro;

    private String genero;

    private String autor;

    private String icone;

    //@TipoEstante
    //private String StatusLeitura;
}
