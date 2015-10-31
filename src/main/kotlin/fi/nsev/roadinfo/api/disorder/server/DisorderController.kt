package fi.nsev.roadinfo.api.disorder.server

import fi.digitraffic.tie.sujuvuus.schemas.TrafficDisordersDatex2Response
import fi.nsev.roadinfo.api.disorder.common.DisorderService
import fi.nsev.roadinfo.api.server.ApiController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DisorderController : ApiController{

    private val disorderService: DisorderService
    private val logger : Logger = LoggerFactory.getLogger(DisorderController::class.java)

    @Autowired constructor(disorderService: DisorderService){
        this.disorderService = disorderService
    }

    @RequestMapping(value =  "/trafficDisorders", method = arrayOf(RequestMethod.GET))
    fun trafficDisorders(): TrafficDisordersDatex2Response {
        logger.debug("/trafficDisorders called")
        val trafficDisordersRes : TrafficDisordersDatex2Response = disorderService.getTrafficDisorders()
        return trafficDisordersRes
    }
}