package fi.nsev.botlin.road.server


import com.fasterxml.jackson.dataformat.xml.XmlMapper
import fi.digitraffic.tie.sujuvuus.schemas.FreeFlowSpeedsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by aphixus on 23.10.2015.
 */

@RestController
class FlowSpeedController {

    private val flowSpeedService : FlowSpeedServiceImpl

    @Autowired constructor(flowSpeedService: FlowSpeedServiceImpl){
        this.flowSpeedService = flowSpeedService
    }

    @RequestMapping("/getFlowSpeed")
    fun flowSpeed(): FreeFlowSpeedsResponse {
        println("Calling FlowSpeedService")
        val freeFlowSpeedsResponse : FreeFlowSpeedsResponse = flowSpeedService.getFreeFlowSpeed()


        return freeFlowSpeedsResponse
    }
}