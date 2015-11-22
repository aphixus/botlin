package fi.nsev.roadinfo.api.roadFluency.server

import fi.digitraffic.tie.sujuvuus.schemas.LamDataResponse
import fi.nsev.roadinfo.api.roadFluency.common.LAMDataService
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import org.springframework.stereotype.Service
import java.net.URL
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

@Service
class LAMDataServiceImpl : LAMDataService, ApiServiceImpl(){

    private final val LAMDATA_URL: String = "http://tie.digitraffic.fi/sujuvuus/ws/lamData"
    private final val LAMDATAY_WSDL_URL : URL = URL("http://tie.digitraffic.fi/sujuvuus/ws/lamData?wsdl")

    override fun getLAMData(): LamDataResponse {
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(LamDataResponse::class.java).createUnmarshaller()
        val lamDataRes : LamDataResponse = queryApiUrl(LAMDATA_URL, unmarshaller) as LamDataResponse

        return lamDataRes
    }
}