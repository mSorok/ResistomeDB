# ResistomeDB

The rise of antibiotic resistance (AR) in clinical settings is one of the biggest modern global public health concerns. Therefore, the understanding of AR mechanisms, evolution, and global distribution is a priority due to its impact on the treatment course and patient survival. Besides all efforts in the elucidation of AR mechanisms in clinical strains, little is known about its prevalence and evolution in environmental microorganisms. In this study, 293 metagenomic samples from the TARA Oceans project were used to detect and quantify environmental antibiotic resistance genes (ARGs) using machine learning tools. After manual curation of ARGs, their abundance and distribution in the global ocean are presented, including taxonomical and phylogenetic classification.
Additionally, the potential of horizontal ARG transfer by plasmids and their correlation with environmental and geographical parameters is shown. A total of 99,205 environmental open reading frames (ORFs) were classified as one of 560 different ARGs conferring resistance to 26 antibiotic classes. We found 24,567 ORFs in contigs classified as plasmid sequences, suggesting the importance of mobile genetic elements (MGEs) in the dynamics of environmental ARG transmission. Moreover, 4,804 contigs with more than two putative ARGs were found, including two plasmid-like contigs with five different ARGs, highlighting the potential presence of multi-resistant microorganisms in the natural ocean environment. Finally, we identified ARGs conferring resistance to some of the most relevant clinical antibiotics, revealing the presence of 15 ARGs similar to Mobilized Colistin Resistance genes (mcr) with high abundance on Polar Biomes. Of these, five are assigned to the genus Psychrobacter, a genus including opportunistic pathogens that can cause fatal infections in humans. Our results are available on Zenodo in MySQL database dump format, and all the code used for the analyses, including a Jupyter notebook, can be accessed on GitHub (https://github.com/rcuadrat/ocean_resistome). We also developed a dashboard web application (available at http://www.resistomedb.com) for data visualization.


In this context, a manually curated MySQL database was created with the environmental ARGs described and all the subsequent analysis results. Data downloaded and processed as described above was parsed with Java 8 and stored in the database with Hibernate. The database model is also managed by Hibernate in Java 8. The resulting database contains 5 main data tables (‘orf’, ‘arg’, ‘sample’, ‘organism’ and ‘xref’, containing cross-references between the different data sources) and 5 connection tables to map in a SQL engine-free way the correspondences between the items from different tables. We provide the SQL dump and the database schema at Zenodo (https://zenodo.org/record/3473960). 

The present repository contains the model of the database and file parsers to fill it. It runs with Java 8 and later, and Maven shoud be used to compile the project.



