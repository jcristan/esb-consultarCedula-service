/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.sti.bus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSSecurityException;



public class ServerPasswordCallback implements CallbackHandler 
{

private String addressBsg;

public void setAddressBSG(String addressBsg) {
    this.addressBsg = addressBsg;
}

@Override
 public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

        String strServerPwd = "";String strUsuario = "";

        try {

        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        if (pc.getUsage() != WSPasswordCallback.USERNAME_TOKEN) {
            throw new IOException(" Seguridad BSG:" + WSConstants.PW_DIGEST);
        }

        String strClientPwd = pc.getPassword();
        int usage = pc.getUsage();
        strUsuario = pc.getIdentifier();
        
        System.out.println("strClientPwd = " + strClientPwd);
        System.out.println("usage = " + usage);
        System.out.println("strUsuario = " + strUsuario);

        ec.gob.informatica.consultacontrasenaws.ConsultaContrasenaWS service = new ec.gob.informatica.consultacontrasenaws.ConsultaContrasenaWS();
        ec.gob.informatica.consultacontrasenaws.BSG06ConsultaContrasenia port = service.getConsultaContrasenaWSSoapPort();
        ec.gob.informatica.consultacontrasenaws.ConsultarContrasenaEntrada consultarContrasenaEntrada = new ec.gob.informatica.consultacontrasenaws.ConsultarContrasenaEntrada();
        consultarContrasenaEntrada.setCedula(strUsuario);
        consultarContrasenaEntrada.setUrl(addressBsg);

        ec.gob.informatica.consultacontrasenaws.ConsultarContrasenaSalida result = port.consultarContrasena(consultarContrasenaEntrada);
        if (result.getMensaje().getCodError().equals("000"))
        {
            strServerPwd=result.getContrasena();
        }else
        {
            throw new IOException(" Seguridad BSG:" + result.getMensaje().getDesError()+ ":"+addressBsg);
        }

        if(pc.getIdentifier().equals(strUsuario)){
            pc.setPassword(strServerPwd);
        }
       } catch (IOException e) {
            throw new IOException("La Seguridad del token no puede ser Autenticada o Autorizada; " + e.getMessage());
       }
    }
}