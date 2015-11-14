package fi.nsev.roadinfo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import java.io.InputStream
import java.util.*


@Configuration
@EnableWebMvcSecurity
open class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    private val logger: Logger = LoggerFactory.getLogger(WebSecurityConfig::class.java)

    override protected fun configure(http: HttpSecurity) {
        http.authorizeRequests().anyRequest().access("hasRole('ROLE_API_USER')")
        //and()  not working here?
        http.httpBasic()
    }

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        //kinda hacky and then some. Move to DB...
        try {
            val input: InputStream = WebSecurityConfig::class.java.classLoader.getResourceAsStream("users.properties")
            val props: Properties = Properties();
            if (input != null) {
                props.load(input)

                for (key: String in props.stringPropertyNames()) {
                    val user: List<String> = props.getProperty(key).split(",");
                    auth.inMemoryAuthentication().withUser(key).password(user[0]).roles(user[1]);
                }
            } else {
                logger.error("Error loading users.properties. Is it loaded to classpath?")
            }
        } catch(e: Exception) {
            logger.error(e.message)
            logger.error("No user.properties found. Using generated defaults")
        }
    }
}
