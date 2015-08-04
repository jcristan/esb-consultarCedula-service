
package ec.gob.informatica.consultacontrasenaws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarContrasenaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultarContrasenaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.informatica.gob.ec/ConsultaContrasenaWS}consultarContrasenaSalida" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarContrasenaResponse", propOrder = {
    "_return"
})
public class ConsultarContrasenaResponse {

    @XmlElement(name = "return")
    protected ConsultarContrasenaSalida _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ConsultarContrasenaSalida }
     *     
     */
    public ConsultarContrasenaSalida getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultarContrasenaSalida }
     *     
     */
    public void setReturn(ConsultarContrasenaSalida value) {
        this._return = value;
    }

}
