package fi.nsev.roadinfo.api.camera.server

import fi.digitraffic.tie.sujuvuus.schemas.CameraPresetsResponse
import fi.nsev.roadinfo.api.camera.common.RoadCameraService
import fi.nsev.roadinfo.api.server.ApiController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RoadCameraController : ApiController{

    private val roadCameraService: RoadCameraService
    private val logger : Logger = LoggerFactory.getLogger(RoadCameraController::class.java)

    @Autowired constructor(roadCameraService: RoadCameraService){
        this.roadCameraService = roadCameraService
    }

    @RequestMapping(value =  "/cameraPresets", method = arrayOf(RequestMethod.GET))
    fun cameraPresets(): CameraPresetsResponse {
        logger.debug("/roadConditions called")
        val roadCameraPresetsRes : CameraPresetsResponse = roadCameraService.getCameraPresets()

        return roadCameraPresetsRes
    }
}