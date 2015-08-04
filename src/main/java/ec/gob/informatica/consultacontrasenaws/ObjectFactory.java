
package ec.gob.informatica.consultacontrasenaws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.gob.informatica.consultacontrasenaws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarContrasenaResponse_QNAME = new QName("http://www.informatica.gob.ec/ConsultaContrasenaWS", "consultarContrasenaResponse");
    private final static QName _ConsultarContrasena_QNAME = new QName("http://www.informatica.gob.ec/ConsultaContrasenaWS", "consultarContrasena");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.gob.informatica.consultacontrasenaws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MensajeError }
     * 
     */
    public MensajeError createMensajeError() {
        return new MensajeError();
    }

    /**
     * Create an instance of {@link ConsultarContrasena }
     * 
     */
    public ConsultarContrasena createConsultarContrasena() {
        return new ConsultarContrasena();
    }

    /**
     * Create an instance of {@link ConsultarContrasenaResponse }
     * 
     */
    public ConsultarContrasenaResponse createConsultarContrasenaResponse() {
        return new ConsultarContrasenaResponse();
    }

    /**
     * Create an instance of {@link ConsultarContrasenaSalida }
     * 
     */
    public ConsultarContrasenaSalida createConsultarContrasenaSalida() {
        return new ConsultarContrasenaSalida();
    }

    /**
     * Create an instance of {@link ConsultarContrasenaEntrada }
     * 
     */
    public ConsultarContrasenaEntrada createConsultarContrasenaEntrada() {
        return new ConsultarContrasenaEntrada();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarContrasenaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.informatica.gob.ec/ConsultaContrasenaWS", name = "consultarContrasenaResponse")
    public JAXBElement<ConsultarContrasenaResponse> createConsultarContrasenaResponse(ConsultarContrasenaResponse value) {
        return new JAXBElement<ConsultarContrasenaResponse>(_ConsultarContrasenaResponse_QNAME, ConsultarContrasenaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarContrasena }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.informatica.gob.ec/ConsultaContrasenaWS", name = "consultarContrasena")
    public JAXBElement<ConsultarContrasena> createConsultarContrasena(ConsultarContrasena value) {
        return new JAXBElement<ConsultarContrasena>(_ConsultarContrasena_QNAME, ConsultarContrasena.class, null, value);
    }

}
