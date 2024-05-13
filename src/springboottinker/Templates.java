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
    
    private void setModeloTemplate(){
        modeloTemplate = """
                         package com.packageName.artifactName.model;
                         
                         import jakarta.persistence.Entity;
                         import jakarta.persistence.Table;
                         import jakarta.persistence.GeneratedValue;
                         import jakarta.persistence.GenerationType;
                         import jakarta.persistence.Id;
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

                             private String descripcion;
                         
                             private int status;
                         }""";
    }
    
    public String getModeloTemplate(){
        return modeloTemplate;
    }
    
    private void setRepositoryTemplate(){
        repositoryTemplate = """
                             package com.packageName.artifactName.repository;
                             
                             import org.springframework.data.repository.CrudRepository;
                             
                             import com.packageName.artifactName.model.className;
                             
                             public interface classNameRepository extends CrudRepository<className, Long> {
                                 
                             }
                             """;
    }
    
    public String getRepositoryTemplate(){
        return repositoryTemplate;
    }
    
    private void setServiceTemplate(){
        serviceTemplate = """
                          package com.packageName.artifactName.service;
                          
                          import java.util.List;
                          
                          import com.packageName.artifactName.model.className;
                          
                          public interface classNameService {
                              //Create operation
                              className save(className objName);
                              
                              //Read operation
                              List<className> list();
                          
                              //Delete operation
                              void deleteById(Long id);
                          
                              //Exists by id operation
                              boolean existsById(Long id);
                          }
                          """;
    }
    
    public String getServiceTemplate(){
        return serviceTemplate;
    }
    
    private void setServiceImplTemplate(){
        serviceImplTemplate = """
                              package com.packageName.artifactName.service;
                              
                              import org.springframework.beans.factory.annotation.Autowired;
                              import org.springframework.stereotype.Service;
                              
                              import com.packageName.artifactName.model.className;
                              import com.packageName.artifactName.repository.classNameRepository;
                              
                              import java.util.List;
                              
                              @Service
                              public class classNameServiceImpl implements classNameService {
                                  @Autowired 
                                  private classNameRepository objNameRepository;
                              
                                  @Override
                                  public className save(className objName) {
                                      return objNameRepository.save(objName);
                                  }
                              
                                  @Override
                                  public List<className> list(){
                                      return (List<className>) objNameRepository.findAll();
                                  }
                              
                                  @Override
                                  public void deleteById(Long id){
                                      objNameRepository.deleteById(id);
                                  }
                              
                                  @Override
                                  public boolean existsById(Long id) {
                                      return objNameRepository.existsById(id);
                                  }
                              }
                              """;
    }
    
    public String getServiceImplTemplate(){
        return serviceImplTemplate;
    }
    
    private void setControllerTemplate(){
        controllerTemplate = """
                             package com.packageName.artifactName.controller;
                             
                             import org.springframework.beans.factory.annotation.Autowired;
                             import org.springframework.http.ResponseEntity;
                             import org.springframework.web.bind.annotation.CrossOrigin;
                             import org.springframework.web.bind.annotation.DeleteMapping;
                             import org.springframework.web.bind.annotation.RestController;
                             import org.springframework.web.bind.annotation.GetMapping;
                             import org.springframework.web.bind.annotation.PathVariable;
                             import org.springframework.web.bind.annotation.PostMapping;
                             import org.springframework.web.bind.annotation.PutMapping;
                             import org.springframework.web.bind.annotation.RequestBody;
                             import org.springframework.web.bind.annotation.RequestMapping;
                             import org.springframework.web.bind.annotation.ResponseBody;
                             
                             import com.packageName.artifactName.model.className;
                             import com.packageName.artifactName.service.classNameService;
                             
                             import java.util.List;
                             
                             @CrossOrigin(origins = "http://localhost:3000")
                             @RestController // This means that this class is a Controller
                             @RequestMapping(path="/api/tableName") // This means URL's start with / (after Application path)
                             public class classNameController {
                                 @Autowired 
                                 private classNameService objNameService;
                             
                                 @PostMapping(path="/add") // Map ONLY POST Requests
                                 public ResponseEntity<className> add(@RequestBody className objName) {
                                     // @ResponseBody means the returned Entity is the response, not a view name
                                     // @RequestParam means it is a parameter from the GET or POST request
                                     className obj = objNameService.save(objName);
                                     return ResponseEntity.ok(obj);
                                 }
                             
                                 @PutMapping(path="/{id}")
                                 public ResponseEntity<className> update(@RequestBody className objName,
                                                  @PathVariable Long id){
                                     className obj = objNameService.save(objName);
                                     return ResponseEntity.ok(obj);
                                 }
                             
                                 @GetMapping(path="/")
                                 public @ResponseBody List<className> all() {
                                     // This returns a JSON or XML
                                     return objNameService.list();
                                 }
                             
                                 @DeleteMapping(path="/{id}")
                                 public ResponseEntity<String> deleteById(@PathVariable String id) {
                                     Long objNameId = Long.parseLong(id);
                                     if(objNameService.existsById(objNameId)){
                                         objNameService.deleteById(objNameId);
                                         return ResponseEntity.ok("Deleted");
                                     }
                                     return ResponseEntity.ok("ID not found");
                                 }
                             }
                             """;
    }
    
    public String getControllerTemplate(){
        return controllerTemplate;
    }
}
