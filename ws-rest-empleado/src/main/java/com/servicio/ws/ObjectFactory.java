
package com.servicio.ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.servicio.empleado_ws package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.servicio.empleado_ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddEmpleadoResponse }
     * 
     */
    public AddEmpleadoResponse createAddEmpleadoResponse() {
        return new AddEmpleadoResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link EmpleadoType }
     * 
     */
    public EmpleadoType createEmpleadoType() {
        return new EmpleadoType();
    }

    /**
     * Create an instance of {@link AddEmpleadoRequest }
     * 
     */
    public AddEmpleadoRequest createAddEmpleadoRequest() {
        return new AddEmpleadoRequest();
    }

}
