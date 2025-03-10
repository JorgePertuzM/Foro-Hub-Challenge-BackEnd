package com.ingJorgePertuz.foroHubAlura.repository;

import com.ingJorgePertuz.foroHubAlura.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {
}
