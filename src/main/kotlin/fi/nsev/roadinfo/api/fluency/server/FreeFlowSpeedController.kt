package fi.nsev.roadinfo.api.fluency.server


import fi.digitraffic.tie.sujuvuus.schemas.FreeFlowSpeedsResponse
import fi.nsev.roadinfo.api.fluency.common.FreeFlowSpeedService
import fi.nsev.roadinfo.api.server.ApiController
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

class FreeFlowSpeedController : ApiController {

    private val freeFlowSpeedService: FreeFlowSpeedService
    private val logger : Logger

    @Autowired constructor(flowSpeedService: FreeFlowSpeedService, logger : Logger){
        this.freeFlowSpeedService = flowSpeedService
        this.logger = logger
    }

    @RequestMapping(value =  "/freeFlowSpeed", method = arrayOf(RequestMethod.GET))
    fun freeFlowSpeed(): FreeFlowSpeedsResponse {
        logger.debug("/freeFlowSpeed called")
        val freeFlowSpeedsResponse : FreeFlowSpeedsResponse = freeFlowSpeedService.getFreeFlowSpeed()

        return freeFlowSpeedsResponse
    }
}