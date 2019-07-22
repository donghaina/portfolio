package com.donghn.portfolio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.donghn.portfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
