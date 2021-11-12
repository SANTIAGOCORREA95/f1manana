/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.ConsultasPilotos;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaHome;
import formula1.vistas.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 503
 */
public class ControladorIngreso implements ActionListener {
    
    VistaIngreso vistaingreso = new VistaIngreso();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();
    
    public ControladorIngreso(VistaIngreso vistaingreso,Escuderia escuderia, Piloto piloto ) {
        
        this.escuderia = escuderia;
        this.piloto = piloto;
        this.vistaingreso = vistaingreso;
        vistaingreso.botonIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        ConsultasEscuderia consultasEscuderia = new ConsultasEscuderia();
        
        ConsultasPilotos consultasPilotos = new ConsultasPilotos();
        
        escuderia.setId(vistaingreso.CajaIdEscuderia.getText());
        escuderia.setNombre(vistaingreso.CajaNombre.getText());
        escuderia.setPresupuesto(Integer.parseInt(vistaingreso.CajaPresupuesto.getText()));
        escuderia.setTipoMotor(vistaingreso.CajaMotor.getText());
        
        piloto.setNombres(vistaingreso.CajaPiloto.getText());
        piloto.setApellidos(vistaingreso.CajaApellido.getText());
        piloto.setSalario(Integer.parseInt(vistaingreso.CajaSalario.getText()));
        
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada = formato.format(entrada);
        piloto.setFechaIn(fechaEntrada);
        
        piloto.setIdEscuderia(vistaingreso.CajaIdEscuderia.getText());
        
        if(consultasEscuderia.registrarEscuderia(escuderia)&&consultasPilotos.registrarPiloto(piloto)){
            
            JOptionPane.showMessageDialog(null, "Exito agregando los datos");
        
        }else{
            
            JOptionPane.showMessageDialog(null, "Error agregando los datos");
        }
        
        
    
    }
        
    
}
