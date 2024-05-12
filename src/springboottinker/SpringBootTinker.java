/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package springboottinker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author desarrollo
 */
public class SpringBootTinker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String className = "";
        String tableName = "";
        String packageName = "";
        String artifactName = "";
        if(args.length != 4){
            System.out.println("Error args required [className, tableName, packageName, artifactName]");
            System.exit(0);
        }
        try {
            className = args[0];
            tableName = args[1];
            packageName = args[2];
            artifactName = args[3];
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("args required.");
            System.exit(0);
        }
        String objName = className.substring(0, 1).toLowerCase() 
                + className.substring(1);
        HashMap<String, String> keys = new HashMap<>();
        keys.put("packageName", packageName);
        keys.put("artifactName", artifactName);
        keys.put("className", className);
        keys.put("objName", objName);
        keys.put("tableName", tableName);
        
        Templates templates = new Templates();
        
        String template = templates.getModeloTemplate();
        createJavaFile(template, "model", keys);
        
        template = templates.getRepositoryTemplate();
        createJavaFile(template, "Repository", keys);
        
        template = templates.getServiceTemplate();
        createJavaFile(template, "Service", keys);
        
        template = templates.getServiceImplTemplate();
        createJavaFile(template, "ServiceImpl", keys);
        
        template = templates.getControllerTemplate();
        createJavaFile(template, "Controller", keys);
    }
    
    public static String buildTemplate(String template, Map keys){
        Iterator it = keys.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            String key = pair.getKey().toString().trim();
            String value = pair.getValue().toString().trim();
            template = template.replaceAll(key, value);
        }
        return template;
    }
    
    public static File createFile(String dir, String className, String fileType){
        File file = null;
        if(fileType.equalsIgnoreCase("model"))
            fileType = "";
        try {
            file = new File(dir+className+fileType+".java");
            if (file.createNewFile())
                System.out.println("Successfully created: " + file.getName());
            else{
                System.out.println("File already exists.");
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            System.exit(0);
        }
        return file;
    }
    
    public static void createJavaFile(String template, String fileType, 
            HashMap<String, String> keys){
        template = buildTemplate(template, keys);
        String className = keys.get("className");
        String packageName = keys.get("packageName");
        String artifactName = keys.get("artifactName");
        String basedir = "src/main/java/com/"+packageName+"/"+artifactName;
        String dir = getDirectory(fileType, basedir);
        if(dir.equals("")){
            System.out.println("Directory cannot be empty.");
            System.exit(0);
        }
        File file = createFile(dir, className, fileType);
        writeFile(file, template);
    }
    
    public static String getDirectory(String fileType, String basedir){
        if(fileType.equalsIgnoreCase("model"))
            return basedir+"/model/";
        if(fileType.equalsIgnoreCase("repository"))
            return basedir+"/repository/";
        if(fileType.equalsIgnoreCase("service"))
            return basedir+"/service/";
        if(fileType.equalsIgnoreCase("serviceimpl"))
            return basedir+"/service/";
        if(fileType.equalsIgnoreCase("controller"))
            return basedir+"/controller/";
        return "";
    }
    
    public static void writeFile(File file, String content){
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            System.exit(0);
        }
    }
    
}
