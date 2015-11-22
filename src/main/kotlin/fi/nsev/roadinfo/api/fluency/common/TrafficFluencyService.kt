package fi.nsev.roadinfo.api.fluency.common

import fi.digitraffic.tie.sujuvuus.schemas.TrafficFluencyResponse


interface TrafficFluencyService {

    fun getTrafficFluency() : TrafficFluencyResponse
}