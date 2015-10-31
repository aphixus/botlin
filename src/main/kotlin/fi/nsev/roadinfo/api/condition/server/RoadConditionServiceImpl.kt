package fi.nsev.roadinfo.api.condition.server

import fi.digitraffic.tie.sujuvuus.schemas.RoadConditionsResponse
import fi.nsev.roadinfo.api.condition.common.RoadConditionService
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import org.springframework.stereotype.Service
import java.net.URL
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

@Service
class RoadConditionServiceImpl : RoadConditionService, ApiServiceImpl() {

    private final val ROAD_CONDITIONS_URL : String = "http://tie.digitraffic.fi/sujuvuus/ws/roadConditions"
    private final val ROAD_CONDITIONS_WSDL_URL : URL = URL("http://tie.digitraffic.fi/sujuvuus/ws/roadConditions?wsdl")

    override fun getRoadConditions(): RoadConditionsResponse {
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(RoadConditionsResponse::class.java).createUnmarshaller()
        val roadConditions : RoadConditionsResponse = queryApiUrl(ROAD_CONDITIONS_URL, unmarshaller) as RoadConditionsResponse

        return roadConditions
    }
}