package fi.nsev.roadinfo.api.roadFluency.server

import fi.digitraffic.tie.sujuvuus.schemas.LamDataResponse
import fi.nsev.roadinfo.api.roadFluency.common.LAMDataService
import fi.nsev.roadinfo.api.server.ApiController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class LAMDataController : ApiController {

    private val lamDataService: LAMDataService
    private val logger : Logger = LoggerFactory.getLogger(LAMDataController::class.java)

    @Autowired constructor(lamDataService: LAMDataService){
        this.lamDataService = lamDataService
    }

    @RequestMapping(value =  "/lamData", method = arrayOf(RequestMethod.GET))
    fun lamData(): LamDataResponse {
        logger.debug("/lamData called")
        val lamDataRes : LamDataResponse = lamDataService.getLAMData()

        return lamDataRes
    }
}