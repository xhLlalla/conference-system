package com.conferenceSystem.repository;

import com.conferenceSystem.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
