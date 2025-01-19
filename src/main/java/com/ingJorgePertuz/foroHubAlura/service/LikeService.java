package com.ingJorgePertuz.foroHubAlura.service;

import com.ingJorgePertuz.foroHubAlura.model.Like;
import com.ingJorgePertuz.foroHubAlura.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    public Optional<Like> getLikeById(Long id) {
        return likeRepository.findById(id);
    }

    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    public Optional<Like> updateLike(Long id, Like like) {
        return likeRepository.findById(id).map(existingLike -> {
            existingLike.setPost(like.getPost());
            existingLike.setUser(like.getUser());
            return likeRepository.save(existingLike);
        });
    }

    public boolean deleteLike(Long id) {
        if (likeRepository.existsById(id)) {
            likeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
