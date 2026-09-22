package com.example.demo.controller;

import com.example.demo.entity.Demo;
import com.example.demo.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
//tells a controller that the obj returned is automatically serialized into JSON and passed back into the HTTP response obj
//@ResponseBody
@RestController // combination on @Controller and @ResponseBody
public class DemoController {

    private DemoService demoServ;

    public DemoController(DemoService demoServ) {
        super();
        this.demoServ = demoServ;
    }

    // handler method to handle list demo
//    @GetMapping("/demo")
//    public String listDemo(Model model){
//        model.addAttribute("DEMO", demoServ.getAllDemos());
//        return "DEMO";
//    }

    // Returning bean
    @GetMapping("/demo")
    public Demo getDemo(){
        Demo demo = new Demo(
                1L, "Arya", "Panday", "arya@email.com"
        );
        return  demo;
    }

    // Return a LIST
    @GetMapping("/listDemo")
    public List<Demo> getDemos(){
        List<Demo> d = new ArrayList<>();
        d.add(new Demo(1L, "Arya", "Sharma", "arya@email.com"));
        d.add(new Demo(2L, "Bhavana", "R", "bhavana@email.com"));
        d.add(new Demo(3L, "Chetan", "Singh", "chetan@email.com"));
        return d;
    }

    // SB with path variable
    // URI template variable - {id}
    @GetMapping("/demo/{id}")
    public Demo demoPathVariable(@PathVariable("id") long demoId){
        return new Demo(demoId, "Ram", "Kumar", "ram@email.com");
    }

    // request param
    // http://localhost:8080/demo/query?demoId=1
    @GetMapping("demo/query")
    public Demo demoRequestVariable(@RequestParam long demoId){
        return new Demo(demoId, "What", "ever", "whatever@email.com");
    }

    // POST request
    @PostMapping("/demo/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Demo createDemo(@RequestBody Demo demo){
        System.out.println(demo.getId());
        System.out.println(demo.getFirstName());
        System.out.println(demo.getLastName());
        return demo;
    }

    // PUT request
    // update existing data
    @PutMapping("/demo/{demoId}/update")
    public Demo updateDemo(@RequestBody Demo demo, @PathVariable long demoId){
        System.out.println(demo.getFirstName());
        System.out.println(demo.getLastName());
        return demo;
    }

    @DeleteMapping("/demo/{id}/delete")
    public String deleteDemo(@PathVariable("id") long demoId){
        System.out.println(demoId);
        return "Demo deleted successfully!";
    }

}
