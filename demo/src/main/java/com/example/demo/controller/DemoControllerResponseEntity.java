package com.example.demo.controller;

import com.example.demo.entity.Demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class DemoControllerResponseEntity {

    @GetMapping("/")
    public ResponseEntity<Demo> getDemo(){
        Demo d = new Demo(1L, "Alia", "Sharma", "alia@email.com");
//        return new ResponseEntity<>(d, HttpStatus.OK);
//        return ResponseEntity.ok(d);
        // passing header
        return ResponseEntity.ok().header("custom-header", "Alia").body(d);
    }

    // Return a LIST
    @GetMapping("/response")
    public ResponseEntity<List<Demo>> getDemos(){
        List<Demo> d = new ArrayList<>();
        d.add(new Demo(1L, "Area", "Sharma", "arya@email.com"));
        d.add(new Demo(2L, "Bhavana", "R", "bhavana@email.com"));
        d.add(new Demo(3L, "Chan", "Singh", "chetan@email.com"));
        return ResponseEntity.ok(d);
    }

    // SB with path variable
    // URI template variable - {id}
    @GetMapping("/demo/{id}")
    public ResponseEntity<Demo> demoPathVariable(@PathVariable("id") long demoId){
        Demo demo = new Demo(demoId, "Ram", "Kumar", "ram@email.com");
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }

    // request param
    // http://localhost:8080/demo/query?demoId=1
    @GetMapping("demo/query")
    public ResponseEntity<Demo> demoRequestVariable(@RequestParam long demoId){
        Demo demo = new Demo(demoId, "What", "ever", "whatever@email.com");
        return ResponseEntity.ok(demo);
    }

    // POST request
    @PostMapping("/demo/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Demo> createDemo(@RequestBody Demo demo){
        System.out.println(demo.getId());
        System.out.println(demo.getFirstName());
        System.out.println(demo.getLastName());
        return new ResponseEntity<>(demo, HttpStatus.CREATED);
    }

    // PUT request
    // update existing data
    @PutMapping("/demo/{demoId}/update")
    public ResponseEntity<Demo> updateDemo(@RequestBody Demo demo, @PathVariable long demoId){
        System.out.println(demo.getFirstName());
        System.out.println(demo.getLastName());
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }

    @DeleteMapping("/demo/{id}/delete")
    public ResponseEntity<String> deleteDemo(@PathVariable("id") long demoId){
        System.out.println(demoId);
        return ResponseEntity.ok("Demo removed successfully!");
    }

}
