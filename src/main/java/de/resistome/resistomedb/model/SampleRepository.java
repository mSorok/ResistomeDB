package de.resistome.resistomedb.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SampleRepository extends CrudRepository<Sample, Integer> {


    @Query(nativeQuery = true, value = "SELECT * FROM sample WHERE sample_id_explained= :sample_id_explained")
    Sample findBySampleExplained(@Param("sample_id_explained") String sample_id_explained);

    @Query(nativeQuery = true, value = "SELECT * FROM sample WHERE run_accession LIKE %:run_accession%")
    Sample findByRunAccession(@Param("run_accession") String one_run_accession);

    @Query(nativeQuery = true, value = "SELECT sample_id FROM sample WHERE run_accession LIKE %:run_accession%")
    Integer findIdByRunAccession(@Param("run_accession") String one_run_accession);

}
