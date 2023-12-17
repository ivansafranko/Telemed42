package com.telemed.model;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    List<User> findByType(int type);

//    List<User> findByFirstName(String firstName);

    User findByEmailAndPassword(String email, String password);
    User findUserByEmailAndPassword(String email, String password);
    Iterable<User> findAllByType(int type);

    @Query(value = "SELECT * FROM app_user t WHERE t.first_name LIKE %?1%", nativeQuery = true)
    List<User> findByTitleAndSortNative(String first_name);


}
