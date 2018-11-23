package de.resistome.resistomedb;

import de.resistome.resistomedb.service.DataFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResistomeDbFiller implements CommandLineRunner {


    @Autowired
    DataFileReader dataFileReader;




    public static void main(String[] args) {
        SpringApplication.run(ResistomeDbFiller.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        dataFileReader.readMetaRuns("");

        dataFileReader.readMeta2("");

        dataFileReader.readDeepArgKaiju("");

        dataFileReader.readFpkm("data/FPKMs.tsv");

    }
}
