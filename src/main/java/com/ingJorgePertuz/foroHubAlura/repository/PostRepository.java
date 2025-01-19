package com.ingJorgePertuz.foroHubAlura.repository;

import com.ingJorgePertuz.foroHubAlura.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
