package de.diskutieren.diskutieren.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArgumentRepository extends CrudRepository<Argument, Integer> {
}
