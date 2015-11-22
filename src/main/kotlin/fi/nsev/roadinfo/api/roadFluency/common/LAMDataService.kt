package fi.nsev.roadinfo.api.roadFluency.common

import fi.digitraffic.tie.sujuvuus.schemas.LamDataResponse

interface LAMDataService {

    fun getLAMData() : LamDataResponse

}