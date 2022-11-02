package com.ejeemplazo.peliqueriacanina.persistencia;

import com.ejeemplazo.peliqueriacanina.logica.Duenio;
import com.ejeemplazo.peliqueriacanina.logica.Mascota;
import java.util.List;


public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();

    public void guardar(Duenio dueni, Mascota masco) {
        //crear en BD al dueño
        duenioJpa.create(dueni);
        
        //crear en BD a la mascota
        mascoJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
        return mascoJpa.findMascotaEntities();
    }
    
}
