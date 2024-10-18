package com.postgresql.learnhub.DAO;

import com.postgresql.learnhub.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDAO extends JpaRepository<Students, Integer> {
    boolean existsByMailIdAndPassword(String mailId,String password);
    boolean existsByMailId(String mailId);
    Students findByMailId(String mailId);
}
