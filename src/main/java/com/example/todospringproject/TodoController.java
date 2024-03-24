package com.example.todospringproject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {


    private static final String TODO_NOT_FOUND = "Todo not found";
    private static List<ToDo> toDoList;

    public TodoController() {
        toDoList = new ArrayList<>();
        toDoList.add(new ToDo(1, false, "ToDo 1", 1));
        toDoList.add(new ToDo(2, false, "ToDo 2", 2));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getToDoById(@PathVariable("id") int id) {

        for (ToDo todo : toDoList) {
            if (todo.getId() == id) {
                return ResponseEntity.ok(todo);
            }
        }

        return ResponseHandler.generateResponse(TODO_NOT_FOUND, HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDoById(@PathVariable("id") int id) {

        if (toDoList.removeIf(i -> i.getId() == id))
            return ResponseEntity.ok().build();

        return ResponseEntity.notFound().build();
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> updateToDoById(@PathVariable("id") int id) {

        for (ToDo toDo : toDoList) {
            if (toDo.getId() == id) {
                toDo.setCompleted(true);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }


}
