/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springboottinker;

/**
 *
 * @author desarrollo
 */
public class Templates {
    private String packageName;
    private String modeloTemplate;
    private String repositoryTemplate;
    private String serviceTemplate;
    private String serviceImplTemplate;
    private String controllerTemplate;
    
    public Templates(){
        setModeloTemplate();
        setRepositoryTemplate();
        setServiceTemplate();
        setServiceImplTemplate();
        setControllerTemplate();
    }
    
    public void setPackageName(String packageName){
        this.packageName = packageName;
    }
    
    public String getPackageName(){
        return packageName;
    }
    
    private void setModeloTemplate(){
        modeloTemplate = """
                         package com.packageName.contpp.model;
                         
                         import jakarta.persistence.Entity;
                         import jakarta.persistence.Table;
                         import jakarta.persistence.GeneratedValue;
                         import jakarta.persistence.GenerationType;
                         import jakarta.persistence.Id;
                         import jakarta.persistence.ManyToOne;
                         import lombok.Data;
                         import lombok.Getter;
                         import lombok.RequiredArgsConstructor;
                         import lombok.Setter;
                         
                         @Entity
                         @Table(name = "tableName")
                         @Data
                         @RequiredArgsConstructor
                         @Getter
                         @Setter
                         public class className {
                             @Id
                             @GeneratedValue(strategy=GenerationType.IDENTITY)
                             private Long id;

                         }""";
    }
    
    public String getModeloTemplate(){
        return modeloTemplate;
    }
    
    private void setRepositoryTemplate(){
        repositoryTemplate = "";
    }
    
    public String getRepositoryTemplate(){
        return repositoryTemplate;
    }
    
    private void setServiceTemplate(){
        serviceTemplate = "";
    }
    
    public String getServiceTemplate(){
        return serviceTemplate;
    }
    
    private void setServiceImplTemplate(){
        serviceImplTemplate = "";
    }
    
    public String getServiceImplTemplate(){
        return serviceImplTemplate;
    }
    
    private void setControllerTemplate(){
        controllerTemplate = "";
    }
    
    public String getControllerTemplate(){
        return controllerTemplate;
    }
}
