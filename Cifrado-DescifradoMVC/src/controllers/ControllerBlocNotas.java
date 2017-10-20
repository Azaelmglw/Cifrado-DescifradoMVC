package controllers;

import models.ModelBlocNotas;
import views.ViewBlocNotas;

/**
 *
 * @author Azael_Mendoza
 */
public class ControllerBlocNotas {
    private final ModelBlocNotas model_bloc_notas;
    private final ViewBlocNotas view_bloc_notas;
    
    public ControllerBlocNotas(Object models[], Object views[]){
        this.model_bloc_notas = (ModelBlocNotas) models[1];
        this.view_bloc_notas = (ViewBlocNotas) views[1];
    }
    
    public void jmi_abrirMouseClicked(){
        model_bloc_notas.getFile_Chooser().showOpenDialog(view_bloc_notas);
        model_bloc_notas.Leer_Archivo();
        view_bloc_notas.jta_area_trabajo.setText(model_bloc_notas.getTexto());
    }
    
    public void jmi_guardarMouseClicked(){
        model_bloc_notas.setTexto(view_bloc_notas.jta_area_trabajo.getText());
        model_bloc_notas.Guardar_Archivo();
    }
    
    public void jmi_cifrarMouseClicked(){
       model_bloc_notas.setLlave( model_bloc_notas.getCuadro_Entrada().showInputDialog(view_bloc_notas, "Escribe la llave para cifrar el archivo"));
       System.out.println(model_bloc_notas.getLlave());
       model_bloc_notas.Cifrar();
       view_bloc_notas.jta_area_trabajo.setText(model_bloc_notas.getTexto());
    }
    
    public void jmi_descifrarMouseClicked(){
       model_bloc_notas.setLlave( model_bloc_notas.getCuadro_Entrada().showInputDialog(view_bloc_notas, "Escribe la llave para descifrar el texto"));
       System.out.println(model_bloc_notas.getLlave());
       model_bloc_notas.Descifrar();
       view_bloc_notas.jta_area_trabajo.setText(model_bloc_notas.getTexto());
    }
    
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
    
}
