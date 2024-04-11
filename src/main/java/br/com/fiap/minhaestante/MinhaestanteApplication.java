package br.com.fiap.minhaestante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class MinhaestanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinhaestanteApplication.class, args);
	}
	
	@RequestMapping
	@ResponseBody
	public String home(){
		return "Minha Estante";
	}
}
