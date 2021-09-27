/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Atxel Rico
 */
public class AnalizadorLexico {
    public static void main(String[] args) throws Exception {
        //Aqui cada quien ponga su ruta
        //"C:/Users/Atxel Rico/Documents/NetBeansProjects/IDE joystick/src/Codigo/Lexer.flex" RUTA ATXEL
        //"/Users/Edsson/Desktop/IDE joystick/src/Codigo/Lexer.flex" RUTA PODRI
        String ruta="C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/src/Codigo/Lexer.flex";
        String ruta2="C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/src/Codigo/LexerCup.flex";
        String[] rutaSin = {"-parser","Sintax","C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/src/Codigo/Sintax.cup"};
        generaLexer(ruta,ruta2,rutaSin);
    }
    public static void generaLexer(String r1, String r2, String[] r3) throws IOException, Exception{
        File archivo;
        archivo = new File(r1);
        JFlex.Main.generate(archivo);
        archivo = new File(r2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(r3);
        
        Path rutasym = Paths.get("C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/src/Codigo/sym.java");
        if (Files.exists(rutasym)) Files.delete(rutasym);
        Path rutasin = Paths.get("C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/src/Codigo/Sintax.java");
        if (Files.exists(rutasin)) Files.delete(rutasin);
        
        Files.move(Paths.get("C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/sym.java"),
                Paths.get("C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/src/Codigo/sym.java"));
        Files.move(Paths.get("C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/Sintax.java"),
                Paths.get("C:/Users/eduar/OneDrive/Documentos/7mo semestre/LYA2/Unidad 1/proyecto/IDE joystick/src/Codigo/Sintax.java"));
    }
}
