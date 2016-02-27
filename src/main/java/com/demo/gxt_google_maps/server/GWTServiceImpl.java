/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.gxt_google_maps.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.demo.gxt_google_maps.client.GWTService;
import com.demo.gxt_google_maps.client.entidades.Usuario;
import com.demo.gxt_google_maps.server.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author josorio
 */
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {
    
    @Autowired
    private ServicioUsuarios servicioUsuarios;

    /**{@inheritDoc} */
    @Override
    public String myMethod(String s) {
        // Do something interesting with 's' here on the server.
        return "Server says: " + s;
    }

    /**{@inheritDoc} */
    @Override
    public Integer guardarEntidad(Usuario usuario) {
        return servicioUsuarios.guardarUsuario(usuario);
    }
}
