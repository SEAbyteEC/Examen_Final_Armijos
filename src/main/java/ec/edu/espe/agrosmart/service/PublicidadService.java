package ec.edu.espe.agrosmart.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Service
public class PublicidadService {

    private final AgroSmartAIService aiService;

    public PublicidadService(AgroSmartAIService aiService) {
        this.aiService = aiService;
    }

    public Mono<String> generarPublicidad(String producto, String audiencia) {

        return Mono.fromCallable(() ->
                        aiService.generarPublicidad(producto, audiencia))
                // La llamada HTTP al modelo es bloqueante.
                // Se ejecuta fuera del event loop de Netty.
                .subscribeOn(Schedulers.boundedElastic())

                // Tiempo máximo de espera.
                .timeout(Duration.ofSeconds(30))

                // Si falla la IA no se cae el endpoint.
                .onErrorResume(e -> Mono.just(
                        "Publicidad no disponible en este momento ("
                                + e.getClass().getSimpleName() + ")"));
    }
}