package br.com.fiap.minhaestante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResenhaController {
    //localhost
    @RequestMapping(
        method = RequestMethod.GET, 
        path= "/resenha", 
        produces ="application/json")
    @ResponseBody
    public String index(){
        return 
        """   
            [ 
                { 
                    "id": 1,
                    "nome": "Resenha",
                    "icone": "Resenha"
                }
            ]
        """;
    }
}
