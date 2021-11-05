/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;

import formula1.controladores.ControladorHome;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaHome;

/**
 *
 * @author 505
 */
public class Formula1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    VistaHome vistahome = new VistaHome();
    vistahome.setVisible(true);
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();
    
    ControladorHome controladorHome = new ControladorHome(vistahome,escuderia,piloto);
        
        
        
    }
    
}
