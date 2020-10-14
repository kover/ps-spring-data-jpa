package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.SessionJpaRepository;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;

    @Autowired
    private SessionJpaRepository sessionJpaRepository;

    @Test
    public void test() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaNot() throws Exception {
        List<Session> sessions = sessionJpaRepository.findBySessionLengthNot(30);
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaNotLike() throws Exception {
        List<Session> sessions = sessionJpaRepository.findBySessionNameNotLike("Java%");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaStartingWith() throws Exception {
        List<Session> sessions = sessionJpaRepository.findBySessionNameStartingWith("Spring");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaEndingWith() throws Exception {
        List<Session> sessions = sessionJpaRepository.findBySessionNameEndingWith("Core");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaLessThan() throws Exception {
        List<Session> sessions = sessionJpaRepository.findBySessionLengthLessThan(45);
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testPagingSorting() throws Exception {
        Page<Session> page = sessionJpaRepository.getSessionsWithName(
            "S",
            PageRequest.of(1, 5, Sort.by(Sort.Direction.DESC, "sessionLength"))
        );
        assertTrue(page.getTotalElements() > 0);
    }

    @Test
    public void testCustomImpl() throws Exception {
        List<Session> sessions = sessionJpaRepository.customGetSessions();
        assertTrue(sessions.size() > 0);
    }
}
