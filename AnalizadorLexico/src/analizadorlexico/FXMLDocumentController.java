/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Javier
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Label label;
     @FXML
    private TextField resultado;
      @FXML
    private TextArea entrada;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    private void createLexFile(String path){
        File file = new File(path);
        jflex.Main.generate(file);
        System.out.println("creado");
    }
    
    @FXML
    private void accion(ActionEvent e){
        try {
            probarLexerFile();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void probarLexerFile() throws FileNotFoundException, IOException{
        File fichero = new File("fichero.txt");
        PrintWriter writer;
        try {
            writer = new  PrintWriter(fichero);
            writer.print(entrada.getText());
            writer.close();
        } catch (Exception ex) {
            
        }
        Reader reader;
        reader = new BufferedReader(new FileReader("fichero.txt"));
        Lexer lexer = new Lexer(reader);
        String Resultados="";
        
        while (true) {            
            Token token = lexer.yylex();
            if(token ==null){
                Resultados = Resultados + "FIN";
                resultado.setText(Resultados);
                return;
                
            }
            switch(token){
                case ERROR:
                    Resultados = Resultados + "ERROR, el simblo no coincide \n";
                    break;
                case Variable:
                case Numero:
                    Resultados = Resultados + "Token:"+token+" "+lexer.save+"\n";
                default:
                    Resultados = Resultados + "Token: "+token+"\n";
                    
            }
            
            
        }
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       String aux = "C:/Users/Javier/Documents/NetBeansProjects/ESD avanzada/MetodosDeOrdenamiento/AnalizadorLexico/src/analizadorlexico/lexico.flex";
        createLexFile(aux);
    }    
    
}
