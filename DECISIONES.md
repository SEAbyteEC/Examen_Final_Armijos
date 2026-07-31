# 🧭 DECISIONES.md — Bitácora de diseño

> **Instrucciones.** Completa **una entrada por fase**, en **primera persona** y
> **refiriéndote a tu propio código**: nombres reales de tus clases, tu tabla, tus
> líneas, tu salida real de terminal.
>
> ❌ **No puntúa** una justificación genérica que podría pegarse en cualquier proyecto
> (ej.: *"usé boundedElastic porque es una buena práctica para operaciones bloqueantes"*).
> ✅ **Sí puntúa** una justificación anclada a tu código (ej.: *"en `ProductoService`
> línea 34 envolví `productoRepository.findAll()` porque Hibernate abre la conexión
> JDBC en el hilo llamante; al probarlo sin `subscribeOn` vi en el log el hilo
> `reactor-http-nio-2`, que es el event loop de Netty"*).
>
> Estas mismas preguntas se te harán en la **defensa oral**.

---

## Datos

- **Nombre:** Klever Stalin Armijos Hurtado
- **Cédula:**1715984835
- **NN (dos últimos dígitos):**35
- **Categoría asignada (según el último dígito):**banano

---

## Fase 1 — Configuración y perfiles

**1.1** ¿Qué archivo activa el perfil `prod` y qué línea exacta lo hace?

> Porque que update aqui conserva los datos sembrados, mientras que create-drop los eliminaría y recrearía las tablas al detener la aplicación, perdiendo esos datos y no cumpliriamos con el objetivo.

**1.2** Pega la línea del log de arranque donde se ve tu puerto y el perfil activo.

2026-07-30T22:02:47.520-05:00  INFO 7700 --- [agrosmart] [           main] o.s.boot.reactor.netty.NettyWebServer    : Netty started on port 8135 (http)
2026-07-30T22:02:45.077-05:00  INFO 7700 --- [agrosmart] [           main] e.e.e.A.ArmijosAgrosmartApplication      : The following 1 profile is active: "prod"
 :: Spring Boot ::                (v4.1.0)

2026-07-30T22:02:45.075-05:00  INFO 7700 --- [agrosmart] [           main] e.e.e.A.ArmijosAgrosmartApplication      : Starting ArmijosAgrosmartApplication using Java 21.0.11 with PID 7700 (C:\Users\stali\IdeaProjects\Examen_Final_Armijos\target\classes started by stali in C:\Users\stali\IdeaProjects\Examen_Final_Armijos)
2026-07-30T22:02:45.077-05:00  INFO 7700 --- [agrosmart] [           main] e.e.e.A.ArmijosAgrosmartApplication      : The following 1 profile is active: "prod"
2026-07-30T22:02:45.117-05:00  INFO 7700 --- [agrosmart] [           main] .s.b.d.c.l.DockerComposeLifecycleManager : Using Docker Compose file C:\Users\stali\IdeaProjects\Examen_Final_Armijos\compose.yaml
2026-07-30T22:02:45.654-05:00  INFO 7700 --- [agrosmart] [           main] .s.b.d.c.l.DockerComposeLifecycleManager : There are already Docker Compose services running, skipping startup
2026-07-30T22:02:46.115-05:00  INFO 7700 --- [agrosmart] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-07-30T22:02:46.127-05:00  INFO 7700 --- [agrosmart] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 6 ms. Found 0 JPA repository interfaces.
2026-07-30T22:02:46.449-05:00  INFO 7700 --- [agrosmart] [           main] org.hibernate.orm.jpa                    : HHH008540: Processing PersistenceUnitInfo [name: default]
2026-07-30T22:02:46.491-05:00  INFO 7700 --- [agrosmart] [           main] org.hibernate.orm.core                   : HHH000001: Hibernate ORM core version 7.4.1.Final
2026-07-30T22:02:46.777-05:00  INFO 7700 --- [agrosmart] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2026-07-30T22:02:46.798-05:00  INFO 7700 --- [agrosmart] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2026-07-30T22:02:46.915-05:00  INFO 7700 --- [agrosmart] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection@87aec6a
2026-07-30T22:02:46.916-05:00  INFO 7700 --- [agrosmart] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2026-07-30T22:02:46.961-05:00  INFO 7700 --- [agrosmart] [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
        Database JDBC URL [jdbc:postgresql://127.0.0.1:5432/agrosmart_db?ApplicationName=agrosmart]
        Database driver: PostgreSQL JDBC Driver
        Database dialect: PostgreSQLDialect
        Database version: 16.14
        Default catalog/schema: agrosmart_db/public
        Autocommit mode: undefined/unknown
        Isolation level: READ_COMMITTED [default READ_COMMITTED]
        JDBC fetch size: none
        Pool: DataSourceConnectionProvider
        Minimum pool size: undefined/unknown
        Maximum pool size: undefined/unknown
2026-07-30T22:02:47.208-05:00  INFO 7700 --- [agrosmart] [           main] org.hibernate.orm.core                   : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2026-07-30T22:02:47.240-05:00  INFO 7700 --- [agrosmart] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2026-07-30T22:02:47.520-05:00  INFO 7700 --- [agrosmart] [           main] o.s.boot.reactor.netty.NettyWebServer    : Netty started on port 8135 (http)
2026-07-30T22:02:47.523-05:00  INFO 7700 --- [agrosmart] [           main] e.e.e.A.ArmijosAgrosmartApplication      : Started ArmijosAgrosmartApplication in 2.699 seconds (process running for 2.955)

**1.3** ¿Qué habría pasado si dejabas `ddl-auto=create-drop` en lugar de `update`?
Responde pensando en tus datos sembrados.

>

**1.4** ¿Levantaste PostgreSQL con `compose.yaml` (Opción A) o con una instalación local
(Opción B)? ¿Qué ventaja tiene la que elegiste?

>

---

## Fase 2 — Persistencia con JPA/Hibernate

**2.1** ¿Cuál es el nombre exacto de tu tabla y de dónde salió ese nombre?
El nombre de mi tabla es tbl_productos_base_35. Lo obtuve a partir de los dos últimos dígitos de mi cédula (35), siguiendo la regla del examen en el que usted indica usar el formato tbl_productos_base_NN.

**2.2** Pega la salida de `psql -d agrosmart_db -c "\d tbl_productos_base_NN"` y
señala dónde se ve la restricción `unique` y el `length` de 120.
PS C:\Users\stali\IdeaProjects\Examen_Final_Armijos> docker exec -it agrosmart-postgres psql -U postgres -d agrosmart_db
psql (16.14 (Debian 16.14-1.pgdg13+1))
Type "help" for help.

agrosmart_db=# \d tbl_productos_base_35
                                  Table "public.tbl_productos_base_35"
        Column        |          Type          | Collation | Nullable |             Default              
----------------------+------------------------+-----------+----------+----------------------------------
 id_producto          | bigint                 |           | not null | generated by default as identity
 categoria            | character varying(40)  |           |          | 
 correos_notificacion | character varying(500) |           |          | 
 nombre_producto      | character varying(120) |           | not null | 
 precio_usd           | numeric(10,2)          |           |          | 
 stock_kg             | integer                |           | not null | 
Indexes:
    "tbl_productos_base_35_pkey" PRIMARY KEY, btree (id_producto)
    "ukr1tt4xe0m3oaa44ooc4e5kk33" UNIQUE CONSTRAINT, btree (nombre_producto)

agrosmart_db=# 
En la sección Indexes aparece:

"ukr1tt4xe0m3oaa44ooc4e5kk33" UNIQUE CONSTRAINT, btree (nombre_producto)

Esto demuestra que la columna nombre_producto tiene una restricción UNIQUE, generada por Hibernate a partir de:

@Column(
    name = "nombre_producto",
    length = 120,
    nullable = false,
    unique = true
)

Dónde se observa el length = 120:

En la definición de la columna:

nombre_producto | character varying(120) | not null

El 120 corresponde directamente al atributo:

length = 120

definido en la entidad ProductoEntity.

**2.3** ¿Por qué usaste `BigDecimal` y no `double` para `precio_usd`? Relaciónalo con el
tipo que generó Hibernate en PostgreSQL.

>Se utilizó BigDecimal porque representa valores monetarios con precisión decimal y evita los errores de redondeo propios de los tipos de punto flotante como double.

Hibernate generó en PostgreSQL un tipo similar a:

numeric(10,2)

que mantiene exactamente dos decimales.

**2.4** ¿Cómo hiciste idempotente tu siembra y qué pasaría en el segundo arranque si no
lo fuera? (piensa en la restricción `unique` de `nombre_producto`)

>La siembra se hizo verificando si el producto ya existía antes de insertarlo.

De esta manera el programa puede iniciarse varias veces sin duplicar registros.

Si no fuera idempotente, en el segundo arranque Hibernate intentaría insertar nuevamente el mismo producto y PostgreSQL lanzaría una excepción por violar la restricción:

UNIQUE(nombre_producto)

---

## Fase 3 — Modelo inmutable y lógica funcional

**3.1** ¿Por qué tienes **dos** clases (`ProductoEntity` y `Producto`) en lugar de una?
¿Qué te impide hacer inmutable directamente la entidad de Hibernate?

>Porque cumplen responsabilidades distintas.

ProductoEntity

representa la tabla de la base de datos
es administrada por Hibernate
necesita setters para que JPA pueda hidratar los objetos

Producto

representa el modelo del dominio
es completamente inmutable
se utiliza para aplicar la lógica funcional y reactiva.

No es recomendable hacer completamente inmutable una entidad JPA porque Hibernate necesita modificar su estado durante la persistencia.

**3.2** Escribe el código exacto de **tus dos** copias defensivas e indica en qué línea
está cada una.
En el constructor:
```java
this.correosNotificacion =
        correosNotificacion == null
                ? new ArrayList<>()
                : new ArrayList<>(correosNotificacion);
```
En el getter:
```java
return Collections.unmodifiableList(
        new ArrayList<>(correosNotificacion)
);
```

**3.3** ¿Por qué la copia defensiva **solo en el getter** no sería suficiente? Describe
el ataque concreto que quedaría abierto sobre **tu** clase.

>Porque quien construya el objeto aún conservaría una referencia a la lista original.

Ejemplo:

List<String> lista = new ArrayList<>();

Producto p = new Producto(..., lista);

lista.add("nuevo@correo.com");

Si el constructor no hiciera copia defensiva, el contenido interno del objeto cambiaría aunque la clase sea inmutable.

Por eso también se realiza la copia dentro del constructor.

**3.4** ¿Cómo implementaste `A_MAYUSCULAS` para no mutar el `Producto` recibido?
No se modifica el objeto existente.

Se crea un nuevo objeto:
```java
public static Function<Producto, Producto> A_MAYUSCULAS =
        p -> new Producto(
                p.getId(),
                p.getNombre().toUpperCase(),
                p.getCategoria(),
                p.getPrecioUsd(),
                p.getCorreosNotificacion()
        );
```

---
Así el objeto original permanece sin cambios.

## Fase 4 — Servicio reactivo y aislamiento del bloqueo

**4.1** Pega tu método `obtenerProductosComercializables()` completo.

```java
package ec.edu.espe.agrosmart.service;


import ec.edu.espe.agrosmart.domain.ProductoFilters;
import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.mapper.ProductoMapper;
import ec.edu.espe.agrosmart.domain.Producto;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import ec.edu.espe.agrosmart.exception.ProductoNoEncontradoException;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@Service
public class ProductoService {


    private final ProductoRepository repository;


    // Producto genérico requerido por defaultIfEmpty
    private static final Producto PRODUCTO_GENERICO =
            new Producto(
                    0L,
                    "PRODUCTO NO DISPONIBLE",
                    "GENERAL",
                    java.math.BigDecimal.ZERO,
                    java.util.List.of()
            );


    public ProductoService(ProductoRepository repository){
        this.repository = repository;
    }



    /**
     * Obtiene solamente productos comercializables
     */
    public Flux<Producto> obtenerProductosComercializables(){


        return Mono.fromCallable(repository::findAll)

                /*
                 * JPA/Hibernate es bloqueante.
                 * boundedElastic mueve la ejecución fuera
                 * del event loop de Netty.
                 */
                .subscribeOn(Schedulers.boundedElastic())


                /*
                 * Convierte Mono<List<ProductoEntity>>
                 * en Flux<ProductoEntity>
                 */
                .flatMapMany(Flux::fromIterable)


                /*
                 * Entity mutable -> dominio inmutable
                 */
                .map(ProductoMapper::toDominio)


                /*
                 * Crea un nuevo objeto con nombre mayúscula
                 */
                .map(ProductoFilters.A_MAYUSCULAS)


                /*
                 * Regla de negocio:
                 * precio > 0 y correos existentes
                 */
                .filter(ProductoFilters.IS_VALID)


                /*
                 * Trazabilidad sin modificar datos
                 */
                .doOnNext(ProductoFilters.LOG_PRODUCTO)


                /*
                 * Si todos fueron inválidos,
                 * devuelve producto genérico
                 */
                .defaultIfEmpty(PRODUCTO_GENERICO);

    }




    /**
     * Buscar producto por ID
     */
    public Mono<Producto> buscarPorId(Long id){


        return Mono.fromCallable(() ->
                        repository.findById(id)
                )


                /*
                 * Consulta JPA fuera del event loop
                 */
                .subscribeOn(Schedulers.boundedElastic())


                /*
                 * Optional vacío -> Mono vacío
                 */
                .flatMap(Mono::justOrEmpty)


                /*
                 * Entity -> dominio
                 */
                .map(ProductoMapper::toDominio)


                /*
                 * Si no existe lanza error reactivo
                 */
                .switchIfEmpty(
                        Mono.error(
                                new ProductoNoEncontradoException(id)
                        )
                );

    }

}
```

**4.2** ¿Qué pasa **exactamente** si eliminas
`.subscribeOn(Schedulers.boundedElastic())` de ese método? Si lo probaste, indica qué
hilo aparecía en el log antes y después.

>El acceso a la base de datos es bloqueante.

Sin .subscribeOn(Schedulers.boundedElastic())
la consulta se ejecuta sobre el hilo reactivo principal (event-loop), bloqueándolo.

Con boundedElastic la operación se mueve a un pool de hilos preparado para tareas bloqueantes, evitando afectar el rendimiento del flujo reactivo.

**4.3** ¿Por qué `Mono.fromCallable(...)` y no `Mono.just(repository.findAll())`?
(pista: cuándo se ejecuta cada uno)

>Porque

Mono.fromCallable(...)

ejecuta la consulta cuando alguien se suscribe al flujo.

En cambio

Mono.just(repository.findAll())

ejecuta inmediatamente

repository.findAll()

antes de crear el Mono, perdiendo el diferimiento (lazy execution) y bloqueando el hilo actual.

**4.4** En **tu** código, ¿dónde usaste `defaultIfEmpty` y dónde `switchIfEmpty`, y por
qué no son intercambiables en esos dos lugares?

>defaultIfEmpty() se utilizó cuando un flujo podía quedarse vacío y se quería devolver un valor por defecto.
switchIfEmpty() se utilizó cuando un producto no existía para lanzar:
new ProductoNoEncontradoException(id)

No son intercambiables porque:

defaultIfEmpty reemplaza por un valor.
switchIfEmpty cambia completamente el flujo reactivo, incluso puede devolver un error.

**4.5** ¿Por qué `doOnNext` no sirve para transformar el elemento, si aparentemente
"recibe" el producto?

>Porque

doOnNext()

solo ejecuta efectos secundarios.

Siempre devuelve exactamente el mismo objeto.

Para transformar un elemento debe utilizarse

map()

que sí produce un nuevo objeto dentro del flujo.

---

## Fase 5 — Módulo de IA con LangChain4j

**5.1** Pega tu interfaz `AgroSmartAIService` completa.

```java
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
```

**5.2** ¿Qué hace `@V("producto")` y qué pasaría si lo quitaras dejando solo el
parámetro?

>Indica que el parámetro Java reemplazará la variable

{{producto}}

del prompt.

Si se eliminara @V, LangChain4j no sabría qué variable debe sustituir y el prompt no podría construirse correctamente.

**5.3** ¿En qué archivo y con qué líneas configuraste el modelo? ¿Por qué **no** hizo
falta declarar un `@Bean`?

>Se configuró en:

application.properties

mediante las propiedades de Spring AI/LangChain4j.

No fue necesario declarar un @Bean porque la integración de Spring Boot realiza la autoconfiguración y crea automáticamente el servicio anotado con @AiService.

**5.4** ¿Por qué la llamada a la IA también necesita `boundedElastic`, si no es una
consulta a base de datos?

>Aunque no consulta una base de datos, la llamada al proveedor de IA realiza una petición HTTP externa.

Es una operación bloqueante de entrada/salida (I/O).

Por ello también debe ejecutarse sobre:

Schedulers.boundedElastic()

para no bloquear el hilo reactivo principal.

**5.5** Si tu proveedor devolvió un error durante el examen, pega el mensaje real y la
respuesta que produjo tu `onErrorResume`.

```
Durante la ejecución del examen el proveedor respondió correctamente, por lo que no fue necesario ejecutar el flujo de recuperación con onErrorResume. Si hubiera ocurrido un error, este habría capturado la excepción y devuelto un mensaje alternativo para que la aplicación no fallara.
```

---

## Fase 6 — API reactiva con WebFlux

**6.1** Pega la salida real de tus cuatro `curl`.

```

```

**6.2** ¿Cómo lograste que el id inexistente responda **404** y no 500?

>

**6.3** ¿Qué pasaría si tu controlador devolviera `List<Producto>` en lugar de
`Flux<Producto>`? ¿Seguiría compilando? ¿Seguiría siendo no bloqueante?

>

---

## Fase 7 — Pruebas unitarias

**7.1** Pega la salida real de tus pruebas (`./mvnw test` o `./gradlew test`).

```

```

**7.2** ¿Cuántos productos espera tu `expectNextCount(...)` y por qué ese número
concreto? Relaciónalo con tu semilla.

>

**7.3** ¿Por qué mockeaste `ProductoRepository` en lugar de dejar que la prueba consulte
PostgreSQL?

>

**7.4** ¿Qué demuestra `assertNotSame` que `assertEquals` **no** demuestra en tu prueba
de copia defensiva?

>

**7.5** ¿Por qué una prueba de un `Flux` que no llama a `verifyComplete()` (o a
`verify()`) no está probando nada?

>

---

## Fase 8 — Integración y cierre

**8.1** Pega tu `git log --oneline --graph --all`.

```

```

**8.2** ¿Qué fase te tomó más tiempo del previsto y por qué?

>

**8.3** Si tuvieras 30 minutos más, ¿qué mejorarías **primero** de tu entrega y por qué
esa y no otra?

>

**8.4** Declara honestamente qué herramientas consultaste durante el examen
(documentación, apuntes, asistentes de IA) y para qué. **Esta declaración no descuenta
puntaje**; su omisión o falsedad sí constituye falta de honestidad académica.

>
