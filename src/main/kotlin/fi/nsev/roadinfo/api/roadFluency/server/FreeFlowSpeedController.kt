package fi.nsev.roadinfo.api.roadFluency.server


import fi.digitraffic.tie.sujuvuus.schemas.FreeFlowSpeedsResponse
import fi.nsev.roadinfo.api.roadFluency.common.FreeFlowSpeedService
import fi.nsev.roadinfo.api.server.ApiController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class FreeFlowSpeedController : ApiController {

    private val freeFlowSpeedService: FreeFlowSpeedService
    private val logger : Logger = LoggerFactory.getLogger(FreeFlowSpeedController::class.java)

    @Autowired constructor(flowSpeedService: FreeFlowSpeedService){
        this.freeFlowSpeedService = flowSpeedService
    }

    @RequestMapping(value =  "/freeFlowSpeed", method = arrayOf(RequestMethod.GET))
    fun freeFlowSpeed(): FreeFlowSpeedsResponse {
        logger.debug("/freeFlowSpeed called")
        val freeFlowSpeedsResponse : FreeFlowSpeedsResponse = freeFlowSpeedService.getFreeFlowSpeed()

        return freeFlowSpeedsResponse
    }
}