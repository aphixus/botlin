package fi.nsev.roadinfo.api.disorder.server

import fi.digitraffic.tie.sujuvuus.schemas.TrafficDisordersDatex2Response
import fi.nsev.roadinfo.api.disorder.common.DisorderService
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import org.springframework.stereotype.Service
import java.net.URL
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

@Service
class DisorderServiceImpl : DisorderService, ApiServiceImpl() {


    private final val TRAFFIC_DISORDERS_URL : String = "http://tie.digitraffic.fi/sujuvuus/ws/trafficDisorders"
    private final val TRAFFIC_DISORDERS_WSDL_URL : URL = URL("http://tie.digitraffic.fi/sujuvuus/ws/trafficDisorders?wsdl")

    override fun getTrafficDisorders() : TrafficDisordersDatex2Response {
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(TrafficDisordersDatex2Response::class.java).createUnmarshaller()
        val freeFlowSpeedRes : TrafficDisordersDatex2Response = queryApiUrl(TRAFFIC_DISORDERS_URL, unmarshaller) as TrafficDisordersDatex2Response

        return freeFlowSpeedRes
    }
}