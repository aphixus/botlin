package fi.nsev.roadinfo.api.fluency.server

import fi.digitraffic.tie.sujuvuus.schemas.JourneyTimeResponse
import fi.nsev.roadinfo.api.fluency.common.JourneyTimeService
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import org.springframework.stereotype.Service
import java.net.URL
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

@Service
class JourneyTimeServiceImpl : JourneyTimeService, ApiServiceImpl() {

    private final val JOURNEY_TIME_URL : String = "http://tie.digitraffic.fi/sujuvuus/ws/journeyTime"
    private final val JOURNEY_TIME_WSDL_URL : URL = URL("http://tie.digitraffic.fi/sujuvuus/ws/journeyTime?wsdl")

    override fun getJourneyTime(): JourneyTimeResponse {
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(JourneyTimeResponse::class.java).createUnmarshaller()
        val journeyTimeRes : JourneyTimeResponse = queryApiUrl(JOURNEY_TIME_URL, unmarshaller) as JourneyTimeResponse

        return journeyTimeRes
    }
}