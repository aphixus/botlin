package fi.nsev.roadinfo.api.roadFluency.common

import fi.digitraffic.tie.sujuvuus.schemas.JourneyTimeResponse

interface JourneyTimeService {

    fun getJourneyTime() : JourneyTimeResponse

}