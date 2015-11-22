package fi.nsev.roadinfo.api.roadFluency.server

import fi.digitraffic.tie.sujuvuus.schemas.TrafficFluencyResponse
import fi.nsev.roadinfo.api.roadFluency.common.TrafficFluencyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class TrafficFluencyController {

    private val trafficFluencyService: TrafficFluencyService
    private val logger : Logger = LoggerFactory.getLogger(JourneyTimeController::class.java)

    @Autowired constructor(trafficFluencyService: TrafficFluencyService){
        this.trafficFluencyService = trafficFluencyService
    }

    @RequestMapping(value =  "/trafficFluency", method = arrayOf(RequestMethod.GET))
    fun trafficFluency(): TrafficFluencyResponse {
        logger.debug("/journeyTime called")
        val trafficFluencyRes : TrafficFluencyResponse = trafficFluencyService.getTrafficFluency()

        return trafficFluencyRes
    }
}