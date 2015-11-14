package fi.nsev.roadinfo.api.weather.server

import fi.digitraffic.tie.sujuvuus.schemas.RoadWeatherResponse
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import fi.nsev.roadinfo.api.weather.common.RoadWeatherService
import org.springframework.stereotype.Service
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

@Service
class RoadWeatherServiceImpl : RoadWeatherService, ApiServiceImpl() {

    private val ROAD_WEATHER_URL : String = "http://tie.digitraffic.fi/sujuvuus/ws/roadWeather"

    override fun getRoadWeather(): RoadWeatherResponse {
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(RoadWeatherResponse::class.java).createUnmarshaller()
        val freeFlowSpeedRes : RoadWeatherResponse = queryApiUrl(ROAD_WEATHER_URL, unmarshaller) as RoadWeatherResponse

        return freeFlowSpeedRes
    }
}