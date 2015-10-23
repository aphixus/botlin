package fi.nsev.botlin.road.common

import fi.digitraffic.tie.sujuvuus.schemas.FreeFlowSpeedsResponse


/**
 * Created by aphixus on 23.10.2015.
 */

public interface FlowSpeedService {

    fun getFreeFlowSpeed() : FreeFlowSpeedsResponse
}

