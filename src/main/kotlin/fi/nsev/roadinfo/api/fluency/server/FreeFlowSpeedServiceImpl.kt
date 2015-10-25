package fi.nsev.roadinfo.api.fluency.server

import fi.digitraffic.tie.sujuvuus.schemas.FreeFlowSpeedsResponse
import fi.nsev.roadinfo.api.fluency.common.FreeFlowSpeedService
import org.springframework.stereotype.Service
import java.io.ByteArrayInputStream
import java.net.URL
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller
import javax.xml.soap.MessageFactory
import javax.xml.soap.MimeHeaders
import javax.xml.soap.SOAPMessage
import javax.xml.ws.Service as wsService

@Service
class FreeFlowSpeedServiceImpl : FreeFlowSpeedService {

    private final val FREE_FLOW_SPEED_URL : String = "http://tie.digitraffic.fi/sujuvuus/ws/freeFlowSpeeds"
    private final val FREE_FLOW_SPEED_WSDL_URL : URL = URL("http://tie.digitraffic.fi/sujuvuus/ws/freeFlowSpeeds?wsdl")

    // https://stackoverflow.com/questions/13180372/creating-a-soapmessage-from-string-xml-of-entire-soap-message
    private fun soapMessageFromString(xmlString : String) : SOAPMessage {
        val factory : MessageFactory = MessageFactory.newInstance()
        val inputStream : ByteArrayInputStream = ByteArrayInputStream(xmlString.toByteArray())
        val message = factory.createMessage(MimeHeaders(), inputStream)
        return message
    }

    //https://stackoverflow.com/questions/26097760/how-to-unmarshall-soap-xml-to-java-object
    override fun getFreeFlowSpeed() : FreeFlowSpeedsResponse {
        val requestResult : String = URL(FREE_FLOW_SPEED_URL).readText()
        val soapMsg : SOAPMessage = soapMessageFromString(requestResult)
        val unmarshaller : Unmarshaller = JAXBContext.newInstance(FreeFlowSpeedsResponse::class.java).createUnmarshaller()
        val freeFlowSpeedRes : FreeFlowSpeedsResponse =  unmarshaller.unmarshal(soapMsg.soapBody.extractContentAsDocument()) as FreeFlowSpeedsResponse
        return freeFlowSpeedRes
    }

}