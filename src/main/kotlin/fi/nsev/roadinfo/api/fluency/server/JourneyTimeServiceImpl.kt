package fi.nsev.roadinfo.api.fluency.server

import fi.digitraffic.tie.sujuvuus.schemas.JourneyTimeResponse
import fi.nsev.roadinfo.api.fluency.common.JourneyTimeService
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import org.springframework.stereotype.Service

@Service
class JourneyTimeServiceImpl : JourneyTimeService, ApiServiceImpl() {

    override fun getJourneyTime(): JourneyTimeResponse {
        throw UnsupportedOperationException()
    }
}