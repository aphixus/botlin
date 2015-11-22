package fi.nsev.roadinfo.api.roadFluency.common

import fi.digitraffic.tie.sujuvuus.schemas.TrafficFluencyResponse


interface TrafficFluencyService {

    fun getTrafficFluency() : TrafficFluencyResponse
}