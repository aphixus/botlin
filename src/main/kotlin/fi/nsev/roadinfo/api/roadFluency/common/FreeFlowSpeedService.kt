package fi.nsev.roadinfo.api.roadFluency.common

import fi.digitraffic.tie.sujuvuus.schemas.FreeFlowSpeedsResponse


public interface FreeFlowSpeedService {

    fun getFreeFlowSpeed() : FreeFlowSpeedsResponse
}

