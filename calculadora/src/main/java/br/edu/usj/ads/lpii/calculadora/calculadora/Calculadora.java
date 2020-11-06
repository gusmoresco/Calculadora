package br.edu.usj.ads.lpii.calculadora.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Calculadora {

    Double resultado;
    String calculo = "";
        
    @PostMapping(value="/calcular")
    public ModelAndView postCalculo(@RequestParam String valor1, @RequestParam String valor2, @RequestParam String opcaoOperacao) {
        
        ModelAndView modelAndView = new ModelAndView("index");
        
        Double valor1Double = Double.valueOf(valor1);
        Double valor2Double = Double.valueOf(valor2);
        String opcaoOperacaoString = String.valueOf(opcaoOperacao);

        if(opcaoOperacaoString.equals("+")){

            resultado = valor1Double + valor2Double;
        }
        else if(opcaoOperacaoString.equals("-")){

            resultado = valor1Double - valor2Double;
        }
        else if(opcaoOperacaoString.equals("*")){

            resultado = valor1Double * valor2Double;
        }
        else if(opcaoOperacaoString.equals("/")){

            resultado = valor1Double / valor2Double;
        }

        calculo = valor1 + opcaoOperacao + valor2 + "=" + resultado;

        modelAndView.addObject("calculo", calculo);

        return modelAndView;
    }
    

}
