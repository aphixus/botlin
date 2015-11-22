package fi.nsev.roadinfo.api.fluency.common

import fi.digitraffic.tie.sujuvuus.schemas.JourneyTimeResponse

interface JourneyTimeService {

    fun getJourneyTime() : JourneyTimeResponse

}