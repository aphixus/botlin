package fi.nsev.roadinfo.api.weather.server

import fi.digitraffic.tie.sujuvuus.schemas.RoadWeatherResponse
import fi.nsev.roadinfo.api.server.ApiController
import fi.nsev.roadinfo.api.weather.common.RoadWeatherService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RoadWeatherController : ApiController{

    private val roadWeatherService: RoadWeatherService
    private val logger : Logger = LoggerFactory.getLogger(RoadWeatherController::class.java)

    @Autowired constructor(roadWeatherService: RoadWeatherService){
        this.roadWeatherService = roadWeatherService
    }

    @RequestMapping(value =  "/roadWeather", method = arrayOf(RequestMethod.GET))
    fun roadWeather(): RoadWeatherResponse {
        logger.debug("/roadWeather called")
        val roadWeatherResponse : RoadWeatherResponse = roadWeatherService.getRoadWeather()

        return roadWeatherResponse
    }
}