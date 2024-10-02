package com.servicio.empleado.service.impl;

import org.springframework.stereotype.Service;
import com.servicio.empleado.dto.EmpleadoResponse;
import com.servicio.empleado.model.Empleado;
import com.servicio.empleado.service.EmpleadoService;
import com.servicio.empleado.utils.FunctionUtils;
import com.servicio.empleado.ws.AddEmpleadoRequest;
import com.servicio.empleado.ws.EmpleadosPort;
import com.servicio.empleado.ws.EmpleadosPortService;

import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Override
    public EmpleadoResponse saveEmpleado(Empleado request) {
        EmpleadoResponse response = new EmpleadoResponse();

        if (validarEmpleado(request)) {
            try {
                EmpleadosPort empleadoSoap = new EmpleadosPortService().getEmpleadosPortSoap11();
                AddEmpleadoRequest requestSoap = createAddEmpleadoRequest(request);

                empleadoSoap.addEmpleado(requestSoap);

                populateEmpleadoResponse(response, request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    private AddEmpleadoRequest createAddEmpleadoRequest(Empleado request) {
        AddEmpleadoRequest requestSoap = new AddEmpleadoRequest();
        requestSoap.setNombres(request.getNombres());
        requestSoap.setApellidos(request.getApellidos());
        requestSoap.setTipoDocumento(request.getTipoDocumento());
        requestSoap.setNumeroDocumento(request.getNumeroDocumento());
        requestSoap.setFechaNacimiento(FunctionUtils.dateToString(request.getFechaNacimiento()));
        requestSoap.setFechaVinculacion(FunctionUtils.dateToString(request.getFechaVinculacion()));
        requestSoap.setCargo(request.getCargo());
        requestSoap.setSalario(request.getSalario());
        return requestSoap;
    }

    private void populateEmpleadoResponse(EmpleadoResponse response, Empleado request) {
        response.setNombres(request.getNombres());
        response.setApellidos(request.getApellidos());
        response.setTipoDocumento(request.getTipoDocumento());
        response.setNumeroDocumento(request.getNumeroDocumento());
        response.setFechaNacimiento(request.getFechaNacimiento());
        response.setFechaVinculacion(request.getFechaVinculacion());
        response.setCargo(request.getCargo());
        response.setSalario(request.getSalario());
        response.setTiempoVinculacion(FunctionUtils.vinculacionEmpleado(FunctionUtils.dateToString(request.getFechaVinculacion())));
        response.setEdadEmpleado(FunctionUtils.edadEmpleado(FunctionUtils.dateToString(request.getFechaNacimiento())));
    }

    private boolean validarEmpleado(Empleado request) {
        return Optional.ofNullable(request)
            .map(emp -> !emp.getNombres().isEmpty() &&
                        !emp.getApellidos().isEmpty() &&
                        !emp.getTipoDocumento().isEmpty() &&
                        !emp.getNumeroDocumento().isEmpty() &&
                        emp.getFechaVinculacion() != null &&
                        emp.getFechaNacimiento() != null &&
                        FunctionUtils.mayorEdad(FunctionUtils.dateToString(emp.getFechaNacimiento())) >= 18)
            .orElse(false);
    }
}