package fi.nsev.botlin

import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer

/**
 * Created by aphixus on 22.10.2015.
 */

@ComponentScan
@EnableAutoConfiguration
public class Application : SpringBootServletInitializer() {
    companion  object {
        @JvmStatic public fun main(args: Array<String>) {
            SpringApplication.run(javaClass<Application>(), *args)
        }
    }

    override fun configure(application : SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(javaClass<Application>())
    }

}