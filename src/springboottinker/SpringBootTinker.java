/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package springboottinker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author desarrollo
 */
public class SpringBootTinker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String className = "Plaza";
        String tableName = "plaza";
        String packageName = "artplusplus";
        /*try {
            className = args[0];
            tableName = args[1];
            packageName = args[2];
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("args required.");
        }*/
        Templates templates = new Templates();
        String modeloTemplate = templates.getModeloTemplate();
        modeloTemplate = buildTemplate(modeloTemplate, className, 
                tableName, packageName);
        File myFile = createFile(className);
        writeFile(myFile, modeloTemplate);
    }
    
    public static String buildTemplate(String template, String className, 
            String tableName, String packageName){
        template = template.replaceAll("packageName", packageName);
        template = template.replaceAll("className", className);
        template = template.replaceAll("tableName", tableName);
        return template;
    }
    
    public static File createFile(String className){
        File myObj = null;
        try {
            myObj = new File("/home/desarrollo/Desktop/"+className+".java");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myObj;
    }
    
    public static void writeFile(File myFile, String content){
        try {
            FileWriter myWriter = new FileWriter(myFile);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
