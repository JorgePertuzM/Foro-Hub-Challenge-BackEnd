package com.ingJorgePertuz.foroHubAlura.controller;

import com.ingJorgePertuz.foroHubAlura.model.Thread;
import com.ingJorgePertuz.foroHubAlura.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/threads")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @GetMapping
    public ResponseEntity<List<Thread>> getAllThreads() {
        List<Thread> threads = threadService.getAllThreads();
        return new ResponseEntity<>(threads, HttpStatus.OK);
    }

    @GetMapping("/{id}") public ResponseEntity<Thread> getThreadById(@PathVariable("id") Long id) {
        Optional<Thread> thread = threadService.getThreadById(id);
        return thread.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Thread> createThread(@RequestBody Thread thread) {
        Thread createdThread = threadService.createThread(thread);
        return new ResponseEntity<>(createdThread, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Thread> updateThread(@PathVariable("id") Long id, @RequestBody Thread thread) {
        Optional<Thread> updatedThread = threadService.updateThread(id, thread);
        return updatedThread.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThread(@PathVariable("id") Long id) {
        if (threadService.deleteThread(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
