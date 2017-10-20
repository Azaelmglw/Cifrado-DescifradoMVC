package main;

import models.*;
import views.*;
import controllers.*;
/**
 *
 * @author Azael_Mendoza
 */
public class Main {
    
    public static void main (String oamg[]){
        ModelPrincipal model_principal = new ModelPrincipal();
        ModelBlocNotas model_bloc_notas = new ModelBlocNotas();
        
        ViewPrincipal view_principal = new ViewPrincipal();
        ViewBlocNotas view_bloc_notas = new ViewBlocNotas();
        
        Object models[] = new Object[2];
        Object views[] = new Object[2];
        Object controllers[] = new Object[2];
        
        models[0] = model_principal;
        models[1] = model_bloc_notas;
        
        views[0] = view_principal;
        views[1] = view_bloc_notas;
        
        ControllerBlocNotas controller_bloc_notas = new ControllerBlocNotas(models, views);
        controllers[1] = controller_bloc_notas;
        ControllerPrincipal controller_principal = new ControllerPrincipal(models, views, controllers);
        controllers[0] = controller_principal;
        
    }
    
}
