package com.ingJorgePertuz.foroHubAlura.service;

import com.ingJorgePertuz.foroHubAlura.model.Thread;
import com.ingJorgePertuz.foroHubAlura.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThreadService {

    @Autowired
    private ThreadRepository threadRepository;

    public List<Thread> getAllThreads() {
        return threadRepository.findAll();
    }

    public Optional<Thread> getThreadById(Long id) {
        return threadRepository.findById(id);
    }

    public Thread createThread(Thread thread) {
        return threadRepository.save(thread);
    }

    public Optional<Thread> updateThread(Long id, Thread thread) {
        return threadRepository.findById(id).map(existingThread -> {
            existingThread.setTitle(thread.getTitle());
            existingThread.setUser(thread.getUser());
            existingThread.setCategory(thread.getCategory());
            return threadRepository.save(existingThread);
        });
    }

    public boolean deleteThread(Long id) {
        if (threadRepository.existsById(id)) {
            threadRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
