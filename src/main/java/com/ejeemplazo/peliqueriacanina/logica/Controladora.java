
package com.ejeemplazo.peliqueriacanina.logica;

import com.ejeemplazo.peliqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String duenio, 
            String celDuenio, String alergico, String atEsp) {

        //creamos dueño y asignamos valores
        Duenio dueni = new Duenio();
        dueni.setNombre(duenio);
        dueni.setCelDuenio(celDuenio);
        
        
        //creamos mascota y asignamos valores        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(dueni);
        
        controlPersis.guardar(dueni,masco);
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
        }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMasco(Mascota masco, String nombreMasco, String raza, 
            String color, String observaciones, String alergico, String atEsp, String duenio, String celDuenio) {
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEsp);
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        
        //seteo los valores del dueño
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());        
        dueno.setNombre(duenio);
        dueno.setCelDuenio(celDuenio);
        
        //llamar al modificador
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }
          
    
}
