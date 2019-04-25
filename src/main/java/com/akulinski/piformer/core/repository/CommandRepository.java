package com.akulinski.piformer.core.repository;

import com.akulinski.piformer.core.domain.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends CrudRepository<Command, Long> {

}
