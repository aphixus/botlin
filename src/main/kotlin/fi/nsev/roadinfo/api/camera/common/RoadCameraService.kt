package fi.nsev.roadinfo.api.camera.common

import fi.digitraffic.tie.sujuvuus.schemas.CameraPresetsResponse

interface RoadCameraService {

    fun getCameraPresets() : CameraPresetsResponse
}