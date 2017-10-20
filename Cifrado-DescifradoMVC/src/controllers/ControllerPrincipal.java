package controllers;

import models.ModelPrincipal;
import models.ModelBlocNotas;
import views.ViewPrincipal;
import views.ViewBlocNotas;

/**
 *
 * @author Azael_Mendoza
 */
public class ControllerPrincipal {
   private final ModelPrincipal model_principal;
   private final ModelBlocNotas model_bloc_notas;
   private final ViewPrincipal view_principal;
   private final ViewBlocNotas view_bloc_notas;
   private final ControllerBlocNotas controller_bloc_notas;
   
   public ControllerPrincipal(Object models[], Object views[], Object controllers[]){
       this. model_principal = (ModelPrincipal) models[0];
       this.model_bloc_notas = (ModelBlocNotas) models[1];
       this.view_principal = (ViewPrincipal) views[0];
       this.view_bloc_notas = (ViewBlocNotas) views[1];
       this.controller_bloc_notas = (ControllerBlocNotas) controllers[1];
       
       view_principal.jmi_bloc_notas.addActionListener(e-> jmi_bloc_notasMouseClicked());
       view_principal.jmi_abrir.addActionListener(e -> jmi_abrirMouseClicked());
       view_principal.jmi_guardar.addActionListener(e -> jmi_guardarMouseClicked());
       view_principal.jmi_cifrar.addActionListener(e -> jmi_cifrarMouseClicked());
       view_principal.jmi_descifrar.addActionListener(e -> jmi_descifrarMouseClicked());
       view_principal.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
       initView();
   }
   
   public void initView(){
       view_principal.jmi_abrir.setVisible(false);
       view_principal.jmi_guardar.setVisible(false);
       view_principal.jmi_cifrar.setVisible(false);
       view_principal.jmi_descifrar.setVisible(false);
       view_principal.jmi_salir.setVisible(false);
       view_principal.setTitle("Cifrado - Descifrado MVC");
       view_principal.setLocationRelativeTo(null);
       view_principal.setVisible(true);
   }
   
   public void jmi_bloc_notasMouseClicked(){
       view_principal.setContentPane(view_bloc_notas);
       view_principal.jmi_bloc_notas.setVisible(false);
       view_principal.jmi_abrir.setVisible(true);
       view_principal.jmi_guardar.setVisible(true);
       view_principal.jmi_cifrar.setVisible(true);
       view_principal.jmi_descifrar.setVisible(true);
       view_principal.jmi_salir.setVisible(true);
       view_principal.revalidate();
       view_principal.repaint();
   }
   
   public void jmi_abrirMouseClicked(){
       controller_bloc_notas.jmi_abrirMouseClicked();
   }
   
   public void jmi_guardarMouseClicked(){
       controller_bloc_notas.jmi_guardarMouseClicked();
   }
   
   public void jmi_cifrarMouseClicked(){
       controller_bloc_notas.jmi_cifrarMouseClicked();
   }
   
   public void jmi_descifrarMouseClicked(){
       controller_bloc_notas.jmi_descifrarMouseClicked();
   }
   
   public void jmi_salirMouseClicked(){
       controller_bloc_notas.jmi_salirMouseClicked();
   }
}