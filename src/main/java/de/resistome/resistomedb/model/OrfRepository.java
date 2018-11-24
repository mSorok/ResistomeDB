package de.resistome.resistomedb.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrfRepository extends CrudRepository<Orf, Integer> {

    @Query(nativeQuery = true, value="SELECT * FROM orf WHERE orf_nt=:orf_nt")
    Orf findByOrfNt(@Param("orf_nt") String orf_nt);


    @Query(nativeQuery = true, value="SELECT * FROM orf WHERE orf_pt=:orf_pt")
    Orf findByOrfPt(@Param("orf_pt") String orf_pt);

    @Query(nativeQuery = true, value="SELECT orf_id FROM orf WHERE orf_nt=:orf_nt")
    Integer findIdByyOrfNt(@Param("orf_nt") String orf_nt);




}
