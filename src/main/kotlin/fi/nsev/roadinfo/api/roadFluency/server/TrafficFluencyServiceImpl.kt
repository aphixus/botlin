package fi.nsev.roadinfo.api.roadFluency.server

import fi.digitraffic.tie.sujuvuus.schemas.TrafficFluencyResponse
import fi.nsev.roadinfo.api.roadFluency.common.TrafficFluencyService
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import org.springframework.stereotype.Service
import java.net.URL
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

@Service
class TrafficFluencyServiceImpl : TrafficFluencyService, ApiServiceImpl() {

    private final val TRAFFIC_FLUENCY_URL: String = "http://tie.digitraffic.fi/sujuvuus/ws/trafficFluency"
    private final val TRAFFIC_FLUENCY_WSDL_URL : URL = URL("http://tie.digitraffic.fi/sujuvuus/ws/trafficFluency?wsdl")

    override fun getTrafficFluency(): TrafficFluencyResponse {
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(TrafficFluencyResponse::class.java).createUnmarshaller()
        val trafficFluencyRes : TrafficFluencyResponse = queryApiUrl(TRAFFIC_FLUENCY_URL, unmarshaller) as TrafficFluencyResponse

        return trafficFluencyRes
    }
}