package fi.nsev.roadinfo.api.condition.common

import fi.digitraffic.tie.sujuvuus.schemas.RoadConditionsResponse

interface RoadConditionService {

    fun getRoadConditions() : RoadConditionsResponse
}