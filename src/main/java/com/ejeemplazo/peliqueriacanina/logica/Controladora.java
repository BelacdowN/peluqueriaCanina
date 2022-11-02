
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
          
    
}
