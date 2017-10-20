package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Azael_Mendoza
 */
public class ModelBlocNotas {
    private FileWriter file_writer;
    private FileReader file_reader;
    private final JFileChooser file_chooser = new JFileChooser();
    private final JOptionPane cuadro_entrada = new JOptionPane();
     
    private File archivo;
    private String texto;
    private String llave;
    
    public String getTexto(){
        return texto;
    }
    
    public String getLlave(){
        return llave;
    }
    
    public JFileChooser getFile_Chooser() {
        return file_chooser;
    }
    
    public JOptionPane getCuadro_Entrada() {
        return cuadro_entrada;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public void setLlave(String llave){
        this.llave = llave;
    }
    
    public void Leer_Archivo(){
        try {
            archivo = (file_chooser.getSelectedFile());
            file_reader = new FileReader(archivo);
            int character = 0;
            String content = "";
            while ((character = file_reader.read()) != -1) {
                content += (char) character;
            }
            file_reader.close();
            texto = content;
            } catch (FileNotFoundException err) {
                System.err.println("Archivo no encontrado");
            } catch (IOException err) {
                System.err.println("Error en el archivo");
            } finally {
            try {
                file_reader.close();
            } catch (IOException err) {
                System.err.println("Error al cerrar");
            }
        }
    }
    
    public void Guardar_Archivo(){
        try {
            file_writer = new FileWriter(archivo, false);
            file_writer.write(texto);
            file_writer.close();

        } catch (FileNotFoundException err) {
            System.err.println("Archivo no Encontrado");
        } catch (IOException err) {
            System.err.println("Error en el archivo");
        }
    }  
    
    public void Cifrar(){
        int llave_ascii = 0;
        int text_pointer = 'a';
        String texto_cifrado = "";
        for(int x = 0; x < llave.length(); x ++){
            llave_ascii += (int) llave.charAt(x);
        }
        System.out.println(llave_ascii);
        for(int y = 0; y < texto.length(); y ++){
            text_pointer = (int)texto.charAt(y);
            text_pointer = (int)text_pointer + llave_ascii;
            texto_cifrado += (char)text_pointer;
            text_pointer = 0;
        }
        texto = texto_cifrado;
    }
    
    public void Descifrar(){
         int llave_ascii = 0;
        int text_pointer = 'a';
        String texto_cifrado = "";
        for(int x = 0; x < llave.length(); x ++){
            llave_ascii += (int) llave.charAt(x);
        }
        System.out.println(llave_ascii);
        for(int y = 0; y < texto.length(); y ++){
            text_pointer = (int)texto.charAt(y);
            text_pointer = (int)text_pointer - llave_ascii;
            texto_cifrado += (char)text_pointer;
            text_pointer = 0;
        }
        texto = texto_cifrado;
        }
    }