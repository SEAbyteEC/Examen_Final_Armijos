package ec.edu.espe.agrosmart.service;


import dev.langchain4j.service.*;
import dev.langchain4j.service.spring.AiService;


@AiService
public interface AgroSmartAIService {


    @UserMessage("""
Redacta una frase publicitaria de máximo 100 caracteres 
para vender {{producto}} dirigido a {{audiencia}}.
""")
    String generarPublicidad(
            @V("producto") String producto,
            @V("audiencia") String audiencia
    );
}