
package com.revature.ws;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-04-01T17:06:29.274-04:00
 * Generated source version: 3.3.0
 *
 */
public final class ItemRestock_ItemRestockImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://ws.revature.com/", "ItemRestockImplService");

    private ItemRestock_ItemRestockImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ItemRestockImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ItemRestockImplService ss = new ItemRestockImplService(wsdlURL, SERVICE_NAME);
        ItemRestock port = ss.getItemRestockImplPort();

        {
        System.out.println("Invoking restockItem...");
        com.revature.ws.Item _restockItem_arg0 = new com.revature.ws.Item();
        int _restockItem_arg1 = 0;
        java.lang.String _restockItem__return = port.restockItem(_restockItem_arg0, _restockItem_arg1);
        System.out.println("restockItem.result=" + _restockItem__return);


        }
        {
        System.out.println("Invoking discontinueItem...");
        com.revature.ws.Item _discontinueItem_arg0 = new com.revature.ws.Item();
        java.lang.String _discontinueItem__return = port.discontinueItem(_discontinueItem_arg0);
        System.out.println("discontinueItem.result=" + _discontinueItem__return);


        }
        {
        System.out.println("Invoking canRestock...");
        com.revature.ws.Item _canRestock_arg0 = new com.revature.ws.Item();
        java.lang.Boolean _canRestock__return = port.canRestock(_canRestock_arg0);
        System.out.println("canRestock.result=" + _canRestock__return);


        }

        System.exit(0);
    }

}
