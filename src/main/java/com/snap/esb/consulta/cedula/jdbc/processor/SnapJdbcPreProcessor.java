package com.snap.esb.consulta.cedula.jdbc.processor;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.apache.log4j.Logger;




public class SnapJdbcPreProcessor implements Processor {


	private Logger logger = Logger.getLogger(getClass());
	
	
	private String query = "INSERT INTO camelmessagetraced (ttimestamp,fromendpoint,tonode,exchangeid,exchangepattern,properties,headers,body) VALUES ({0},{1},{2},{3},{4},{5},{6},{7});";
	private String message;
    
	@Override
	public void process(Exchange exchange) throws Exception {

		logger.debug("-------SnapJdbcPreProcessor-----");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String  request = exchange.getIn().getBody(String.class);
		String[]  lista = request.split(",");
		
	    exchange.setProperty("listado",lista);
		
		
		message = MessageFormat.format(query,new Object[] {"'"+df.format(new Date())+"'","'"+exchange.getFromEndpoint()+"'","'"+exchange.getProperties().get("CamelToEndpoint")+"'","'"+exchange.getExchangeId()+"'","'"+exchange.getPattern().name()+"'","''"
				                                           ,"'"+exchange.getIn().getHeaders().toString()+"'","'"+request+"'"});

		
		exchange.getOut().setBody(message);
		
	}

}
