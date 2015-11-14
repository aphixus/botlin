package fi.nsev.roadinfo.api.weather.common

import fi.digitraffic.tie.sujuvuus.schemas.RoadWeatherResponse

interface RoadWeatherService {

    fun getRoadWeather() : RoadWeatherResponse
}