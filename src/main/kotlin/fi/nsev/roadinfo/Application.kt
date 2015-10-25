package fi.nsev.roadinfo

import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer

@ComponentScan
@EnableAutoConfiguration
public class Application : SpringBootServletInitializer() {
    companion  object {
        @JvmStatic public fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

    override fun configure(application : SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Application::class.java)
    }

}