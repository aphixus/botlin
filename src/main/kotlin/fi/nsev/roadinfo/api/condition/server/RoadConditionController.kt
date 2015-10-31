package fi.nsev.roadinfo.api.condition.server

import fi.digitraffic.tie.sujuvuus.schemas.RoadConditionsResponse
import fi.nsev.roadinfo.api.condition.common.RoadConditionService
import fi.nsev.roadinfo.api.server.ApiController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RoadConditionController : ApiController{

    private val roadConditionService: RoadConditionService
    private val logger : Logger = LoggerFactory.getLogger(RoadConditionController::class.java)

    @Autowired constructor(roadConditionService: RoadConditionService){
        this.roadConditionService = roadConditionService
    }

    @RequestMapping(value =  "/roadConditions", method = arrayOf(RequestMethod.GET))
    fun roadConditions(): RoadConditionsResponse {
        logger.debug("/roadConditions called")
        val roadConditionsRes : RoadConditionsResponse = roadConditionService.getRoadConditions()

        return roadConditionsRes
    }
}