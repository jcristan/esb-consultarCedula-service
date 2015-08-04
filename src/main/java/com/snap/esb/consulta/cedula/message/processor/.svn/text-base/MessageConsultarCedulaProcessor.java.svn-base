package com.snap.esb.consulta.cedula.message.processor;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;




public class MessageConsultarCedulaProcessor implements Processor {


	private Logger logger = Logger.getLogger(getClass());
    
	@Override
	public void process(Exchange exchange) throws Exception {

		logger.debug("-------MessageConsultarCedulaProcessor-----");        
		
	//	MessageContentsList  listado = (MessageContentsList) exchange.getIn().getBody();
	   
		String[] listado = (String[]) exchange.getProperty("listado");
	  //security
		 exchange.getOut().setHeader("Username",listado[3]);
	    exchange.getOut().setHeader("digest",listado[4]);
	    exchange.getOut().setHeader("fecha",listado[7]);
	    exchange.getOut().setHeader("fechaf",listado[8]);
	    exchange.getOut().setHeader("nonce",listado[5]);
        
		
		
        exchange.getOut().setHeader("cedula",listado[0]);
        exchange.getOut().setHeader("Usuario",listado[1]);
        exchange.getOut().setHeader("Contrasenia",listado[2]);
        
        System.out.println("here!!!!!!!!");
		
	}

}
