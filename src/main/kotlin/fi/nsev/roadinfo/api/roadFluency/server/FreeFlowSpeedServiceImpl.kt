package fi.nsev.roadinfo.api.roadFluency.server

import fi.digitraffic.tie.sujuvuus.schemas.FreeFlowSpeedsResponse
import fi.nsev.roadinfo.api.roadFluency.common.FreeFlowSpeedService
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import org.springframework.stereotype.Service
import java.net.URL
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller
import javax.xml.ws.Service as wsService

@Service
class FreeFlowSpeedServiceImpl : FreeFlowSpeedService, ApiServiceImpl(){

    private final val FREE_FLOW_SPEED_URL : String = "http://tie.digitraffic.fi/sujuvuus/ws/freeFlowSpeeds"
    private final val FREE_FLOW_SPEED_WSDL_URL : URL = URL("http://tie.digitraffic.fi/sujuvuus/ws/freeFlowSpeeds?wsdl")

    override fun getFreeFlowSpeed() : FreeFlowSpeedsResponse {
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(FreeFlowSpeedsResponse::class.java).createUnmarshaller()
        val freeFlowSpeedRes : FreeFlowSpeedsResponse = queryApiUrl(FREE_FLOW_SPEED_URL, unmarshaller) as FreeFlowSpeedsResponse

        return freeFlowSpeedRes
    }

}