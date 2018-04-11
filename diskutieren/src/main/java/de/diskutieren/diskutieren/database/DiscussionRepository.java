package de.diskutieren.diskutieren.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends CrudRepository<Discussion, String> {
    Discussion findByid(String id);
}
