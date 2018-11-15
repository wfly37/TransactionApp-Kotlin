package edu.dcccd.trans.repository;

import edu.dcccd.trans.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername( String username );
}