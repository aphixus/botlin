package fi.nsev.roadinfo.api.server

import java.io.ByteArrayInputStream
import java.net.URL
import javax.xml.bind.Unmarshaller
import javax.xml.soap.MessageFactory
import javax.xml.soap.MimeHeaders
import javax.xml.soap.SOAPMessage

abstract class ApiServiceImpl {

    // https://stackoverflow.com/questions/13180372/creating-a-soapmessage-from-string-xml-of-entire-soap-message
     fun soapMessageFromString(xmlString : String) : SOAPMessage {
        val factory : MessageFactory = MessageFactory.newInstance()
        val inputStream : ByteArrayInputStream = ByteArrayInputStream(xmlString.toByteArray())
        val message = factory.createMessage(MimeHeaders(), inputStream)
        return message
    }


    //https://stackoverflow.com/questions/26097760/how-to-unmarshall-soap-xml-to-java-object
    fun queryApiUrl(apiUrlAsString : String, unmarshaller: Unmarshaller) : Any{
        val requestResult : String = URL(apiUrlAsString).readText()
        val soapMsg : SOAPMessage = soapMessageFromString(requestResult)
        val parsedData : Any =  unmarshaller.unmarshal(soapMsg.soapBody.extractContentAsDocument())

        return parsedData;
    }
}