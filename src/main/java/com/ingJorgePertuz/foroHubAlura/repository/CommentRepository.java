package com.ingJorgePertuz.foroHubAlura.repository;

import com.ingJorgePertuz.foroHubAlura.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
