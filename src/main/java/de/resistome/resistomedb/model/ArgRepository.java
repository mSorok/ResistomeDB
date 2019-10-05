package de.resistome.resistomedb.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArgRepository  extends CrudRepository<Arg, Integer> {

    @Query(nativeQuery = true, value="SELECT * FROM arg WHERE arg= :arg")
    List<Arg> findByArgName(@Param("arg") String arg);


}
