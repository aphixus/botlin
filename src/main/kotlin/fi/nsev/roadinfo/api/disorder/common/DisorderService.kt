package fi.nsev.roadinfo.api.disorder.common

import fi.digitraffic.tie.sujuvuus.schemas.TrafficDisordersDatex2Response

interface DisorderService {

    fun getTrafficDisorders() : TrafficDisordersDatex2Response

}