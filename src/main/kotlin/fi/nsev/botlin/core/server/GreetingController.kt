package fi.nsev.botlin.core.server

import fi.nsev.botlin.core.common.Greeting
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by aphixus on 22.10.2015.
 */

@RestController
public class GreetingController {

    val counter = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}