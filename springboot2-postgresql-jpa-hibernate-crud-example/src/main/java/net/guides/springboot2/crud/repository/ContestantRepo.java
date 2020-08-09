package net.guides.springboot2.crud.repository;

import net.guides.springboot2.crud.model.Contestant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestantRepo extends JpaRepository<Contestant, Long> {
}
