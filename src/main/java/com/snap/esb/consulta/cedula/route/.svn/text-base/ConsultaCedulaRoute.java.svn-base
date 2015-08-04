package com.snap.esb.consulta.cedula.route;

import java.net.ConnectException;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapHeader;

import com.ctc.wstx.compat.QNameCreator;

import javax.xml.namespace.QName;

import org.apache.camel.builder.xml.Namespaces;
import org.apache.camel.component.cxf.CxfPayload;
import org.apache.camel.converter.jaxp.XmlConverter;
import org.w3c.dom.Element;

public class ConsultaCedulaRoute extends RouteBuilder {
    
	@Override
	public void configure() throws Exception {       
		
		
		final Log log = LogFactory.getLog(ConsultaCedulaRoute.class);
		
		Namespaces ns = new Namespaces("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
		ns.add("con", "http://www.registrocivil.gob.ec/ConsultaCedula");
		ns.add("ccn", "http://www.informatica.gob.ec/ConsultaContrasenaWS");
		ns.add("wss","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
		ns.add("wsu","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
		
		// ruta 1  ingreso ws
		from("cxf:bean:ConsultarCedulaServiceEndpoint?dataFormat=PAYLOAD").id("consultarCedulaService")
		    .log("BODY ---> ${body}")
			//.doTry()
		    	.process(new Processor() {
					
					@Override
	                @SuppressWarnings("unchecked")
					public void process(Exchange exchange) throws Exception {
	                    CxfPayload<SoapHeader> requestPayload = exchange.getIn().getBody(CxfPayload.class);
	                    List<SoapHeader> headers = requestPayload.getHeaders();
	                    Element e = (Element)(headers.get(0).getObject());
	                    String theheaders = "";
	                    for (SoapHeader h: headers)
	                    {
	                    	theheaders += "\nh.name --> " + h.getName()  + ", class = " + h.getObject().getClass().getName() + "\nValue=" + h.getObject().toString() ;
	                    }
	                    exchange.setProperty("theheaders", theheaders);
					}
				})
				.log("HEADERS ---> ${property.theheaders}")
				
				.setHeader("cedula").xpath("//con:BusquedaPorCedula/Cedula/text()", ns)
				.setHeader("usuario").xpath("//con:BusquedaPorCedula/Usuario/text()", ns)
				.setHeader("contrasenia").xpath("//con:BusquedaPorCedula/Contrasenia/text()", ns)
				
				.setHeader("username").xpath("//soapenv:Envelope/soapenv:Header/wss:Security/wss:UsernameToken/wss:Username/text()", String.class, ns)
				.setHeader("pass").xpath("//soapenv:Envelope/soapenv:Header/wss:Security/wss:UsernameToken/wss:Password/text()", String.class, ns)
				.setHeader("nonce").xpath("//soapenv:Envelope/soapenv:Header/wss:Security/wss:UsernameToken/wss:Nonce/text()", String.class, ns)
				.setHeader("created").xpath("//soapenv:Envelope/soapenv:Header/wss:Security/wss:UsernameToken/wsu:Created/text()", String.class, ns)
				
				.setHeader("fcreated").xpath("//soapenv:Envelope/soapenv:Header/wss:Security/wsu:Timestamp/wsu:Created/text()", String.class, ns)
				.setHeader("fexpires").xpath("//soapenv:Envelope/soapenv:Header/wss:Security/wsu:Timestamp/wsu:Expires/text()", String.class, ns)
					
				
				
				

				/*
				 //Llamada consulta contraseña
				.log("inicio consultarContrasenia")
				.setHeader("urlCC", simple("{{urlServicioEnBsg.ConsultarCedula}}"))
				.to("velocity:requestConsultarContraseniaBSG.vm")
				.log("REQUEST CC ---> ${body}")
				.to("invokeConsultarContraseniaService").convertBodyTo(String.class)
				.setHeader("contraseniaFunc").xpath("//soapenv:Envelope/soapenv:Body/ccn:consultarContrasenaResponse/return/contrasena/text()", ns)
				.log("contrasenia --> ${headers.contraseniaFunc}")
				*/	
				
				 //Llamada consulta cedula
				.setBody(simple("${headers.cedula},${headers.usuario},${headers.contrasenia},${headers.username},${headers.pass},${headers.nonce},${headers.created},${headers.fcreated},${headers.fexpires}")).convertBodyTo(String.class)
				.log("DATA ---> ${body}")
				.log("inicio ConsultarCedulaService")
				.to("direct:log")
				.to("messageConsultarCedulaProcessor")
				.to("velocity:requestConsultarCedula.vm")
				.to("invokeconsultarCedulaService").convertBodyTo(String.class)
		     
		     	.stop()
		     /*	
		     .doCatch(Throwable.class)
			 	.to("velocity:fault.vm")
				.stop()
		     .end()
		     */	
		     ;	
       
		//ruta log
		from("direct:log").id("rutaLog")
		    .doTry()
		    .log("log")
		    .to("snapJdbcPreProcessor")
		    //.to("jdbc:snapdb")
		    .to("snapJdbcPostProcessor")
	        .end();
		
	}

}
