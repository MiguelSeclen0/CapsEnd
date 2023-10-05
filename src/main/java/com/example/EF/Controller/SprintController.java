package com.example.EF.Controller;

import com.example.EF.Domain.Sprint;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EF.Service.SprintService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/sprint/")
@RestController
public class SprintController {
    @Autowired
    private SprintService sprintService;
    
    @GetMapping(value="/all")
    public List<Sprint> getAllSprint(){
        return sprintService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Sprint findSprint(@PathVariable String id){
        return sprintService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Sprint> saveSprint(@RequestBody Sprint sprint) {
        Sprint obj = sprintService.Guardar(sprint);
        return new ResponseEntity<Sprint>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Sprint> deleteSprint(@PathVariable String id) {
        Sprint sprint = sprintService.ConsultarId(id);
        if (sprint != null) {
            sprintService.Eliminar(id);
            return new ResponseEntity<Sprint>(sprint, HttpStatus.OK);
        } else {
            return new ResponseEntity<Sprint>(HttpStatus.NO_CONTENT);
        }
    }
}


