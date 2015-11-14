package fi.nsev.roadinfo.api.camera.server

import fi.digitraffic.tie.sujuvuus.schemas.CameraPresetsResponse
import fi.nsev.roadinfo.api.camera.common.RoadCameraService
import fi.nsev.roadinfo.api.server.ApiServiceImpl
import org.springframework.stereotype.Service
import java.net.URL
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

@Service
class RoadCameraServiceImpl : RoadCameraService, ApiServiceImpl() {

    private final val CAMERA_PRESETS_URL : String = "http://tie.digitraffic.fi/sujuvuus/ws/cameraPresets"
    private final val CAMERA_PRESETS_WSDL_URL : URL = URL("http://tie.digitraffic.fi/sujuvuus/ws/cameraPresets?wsdl")

    override fun getCameraPresets(): CameraPresetsResponse {
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(CameraPresetsResponse::class.java).createUnmarshaller()
        val cameraPresets : CameraPresetsResponse = queryApiUrl(CAMERA_PRESETS_URL, unmarshaller) as CameraPresetsResponse

        return cameraPresets
    }
}