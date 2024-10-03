
package com.servicio.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "productPortService", targetNamespace = "http://www.example.com/empleado-ws", wsdlLocation = "file:/D:/src/empleado.wsdl")
public class ProductPortService
    extends Service
{

    private final static URL PRODUCTPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException PRODUCTPORTSERVICE_EXCEPTION;
    private final static QName PRODUCTPORTSERVICE_QNAME = new QName("http://www.example.com/empleado-ws", "productPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/src/empleado.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PRODUCTPORTSERVICE_WSDL_LOCATION = url;
        PRODUCTPORTSERVICE_EXCEPTION = e;
    }

    public ProductPortService() {
        super(__getWsdlLocation(), PRODUCTPORTSERVICE_QNAME);
    }

    public ProductPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRODUCTPORTSERVICE_QNAME, features);
    }

    public ProductPortService(URL wsdlLocation) {
        super(wsdlLocation, PRODUCTPORTSERVICE_QNAME);
    }

    public ProductPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRODUCTPORTSERVICE_QNAME, features);
    }

    public ProductPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ProductPort
     */
    @WebEndpoint(name = "productPortSoap11")
    public ProductPort getProductPortSoap11() {
        return super.getPort(new QName("http://www.example.com/empleado-ws", "productPortSoap11"), ProductPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductPort
     */
    @WebEndpoint(name = "productPortSoap11")
    public ProductPort getProductPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.example.com/empleado-ws", "productPortSoap11"), ProductPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRODUCTPORTSERVICE_EXCEPTION!= null) {
            throw PRODUCTPORTSERVICE_EXCEPTION;
        }
        return PRODUCTPORTSERVICE_WSDL_LOCATION;
    }

}