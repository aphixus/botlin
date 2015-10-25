package fi.nsev.roadinfo.api.fluency.common

import fi.digitraffic.tie.sujuvuus.schemas.FreeFlowSpeedsResponse


public interface FreeFlowSpeedService {

    fun getFreeFlowSpeed() : FreeFlowSpeedsResponse
}

