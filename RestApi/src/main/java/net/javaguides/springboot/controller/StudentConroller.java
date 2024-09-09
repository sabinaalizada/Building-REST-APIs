package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentConroller {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student=new Student(
                1,
                "Sabina",
                "Alizada"
        );
        //return new ResponseEntity<>(student,HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header","Sabina").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Sabina","Aliada"));
        students.add(new Student(2,"Leyla","Aliada"));
        students.add(new Student(3,"Nigar","Aliada"));
        return ResponseEntity.ok(students);

    }
    //path variable
    @GetMapping("{id}/{name}/{surname}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentid,@PathVariable String name,@PathVariable String surname){
        Student student=new Student(studentid,name,surname);
        return ResponseEntity.ok(student);
    }

    //Request Param
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,@RequestParam String name,@RequestParam String surname){
        Student student=new Student(id,name,surname);
        return ResponseEntity.ok(student);
    }

    //HTTP POST Request - creating - creating
    //PostMapping and RequestBody
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println( student.getId());
        System.out.println( student.getName());
        System.out.println( student.getSurname());
        return new ResponseEntity<>(student,HttpStatus.CREATED);

    }

    //HTTP PUT Request - updating
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentid){
        System.out.println( student.getName());
        System.out.println( student.getSurname());
        return ResponseEntity.ok(student);
    }

    //HTTP DELETE Request
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        System.out.println(id);
        return ResponseEntity.ok("Student deleted");
    }
}
