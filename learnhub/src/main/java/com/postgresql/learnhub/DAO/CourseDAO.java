package com.postgresql.learnhub.DAO;

import com.postgresql.learnhub.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Courses,String> {
}
