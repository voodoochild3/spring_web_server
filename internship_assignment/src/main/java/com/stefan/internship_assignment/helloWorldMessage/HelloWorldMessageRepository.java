package com.stefan.internship_assignment.helloWorldMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelloWorldMessageRepository extends
        JpaRepository<HelloWorldMessage, Integer> {

    Optional<HelloWorldMessage> findByLanguage(String language);

}
