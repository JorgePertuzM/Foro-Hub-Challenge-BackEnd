package com.ingJorgePertuz.foroHubAlura.service;

import com.ingJorgePertuz.foroHubAlura.model.Post;
import com.ingJorgePertuz.foroHubAlura.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> updatePost(Long id, Post post) {
        return postRepository.findById(id).map(existingPost -> {
            existingPost.setThread(post.getThread());
            existingPost.setUser(post.getUser());
            existingPost.setContent(post.getContent());
            return postRepository.save(existingPost);
        });
    }

    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
