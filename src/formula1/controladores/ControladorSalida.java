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
import formula1.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author 503
 */
public class ControladorSalida implements ActionListener {
    
    VistaSalida vistasalida = new VistaSalida();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();

    public ControladorSalida(VistaSalida vistasalida,Escuderia escuderia,Piloto piloto ) {
        
        this.vistasalida = vistasalida;
        this.escuderia = escuderia;
        this.piloto = piloto;
        vistasalida.botonSalir.addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        ConsultasEscuderia consultasEscuderia = new ConsultasEscuderia();
        
        ConsultasPilotos consultasPilotos = new ConsultasPilotos();
        
        piloto = consultasPilotos.buscarPiloto(Integer.parseInt(vistasalida.cajaSalida.getText()));
        
        String fechaEntrada = piloto.getFechaIn();
        
        try{
            
            Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
            
            Date salida = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaSalida = formato.format(salida);
            
            long tiempoDiferencia = salida.getTime()-entrada.getTime();
            TimeUnit unidadTiempo = TimeUnit.MINUTES;
            long tiempoEnEscuderia = unidadTiempo.convert(tiempoDiferencia,TimeUnit.MILLISECONDS);
            
            piloto.setFechaOut(fechaSalida);
            
            if(consultasPilotos.actualizarPiloto(piloto)){
                
                JOptionPane.showMessageDialog(null, "Exito agregando los datos");
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Error agregando los datos");
            
            }
        
        }catch(ParseException error){
            
            System.out.println("upsss.." + error);
        
        }
        
    }
    
    
    
}
