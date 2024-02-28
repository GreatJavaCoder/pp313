package ru.komm.pp313.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.komm.pp313.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(" select u from User u where u.name = :name ")
    User findByUsername(@Param("name") String name);

}
