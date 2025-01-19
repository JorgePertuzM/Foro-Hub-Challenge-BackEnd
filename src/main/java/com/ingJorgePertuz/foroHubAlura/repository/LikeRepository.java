package com.ingJorgePertuz.foroHubAlura.repository;

import com.ingJorgePertuz.foroHubAlura.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}

