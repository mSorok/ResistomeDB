# Files for database

## *.fa files

- 12 fasta files with contigs co-assembled from 12 regions of TARA ocean. Used as input for metagenmark for ORFs detection. Names of these files are used (excluding .fa) as "sample" name for table deepARG_plas_kaiju.tsv.
The name of each contig in the fasta is used in the table deepARG_plas_kaiju.tsv as "contig_id".

## *.fna 

- ORFs (nucleotide) sequences from each of 12 tara co-assemblies. It was the files used with deepARG tool for ARG screening. The header of sequences are used in table deepARG_plas_kaiju.tsv as nt_id.

## *.faa 

- ORFs (protein) sequences from each of 12 tara co-assemblies. The header of sequences are used in table deepARG_plas_kaiju.tsv as ptn_id.

## deepARGdb.fasta

- Fasta file from deepARG, used as reference for ARG screening in *.fna files. The header of each sequence in this file is on "best-hit", when the sequence was the best-hit on metagenomic *.fna file. 

## ALL_ARGS.fasta

- Fasta file with all ORFs (nucleotide) classified as ARG on all 12 samples (co-assembies). The header here is the "ORF_ID" from table deepARG_plas_kaiju.tsv

## ALL_ARGS_ptn.fasta

- Fasta file with all ORFs (protein) classified as ARG on all 12 samples (co-assembies). The header here is analog to the "ORF_ID" from table deepARG_plas_kaiju.tsv, but as this is protein file, its concatanation of ptn_id and sample, using "|" separator

## all_contigs_with_args.fasta

- Fasta file with all contigs with at least one ARG from all samples. Header is "contig_id" on table deepARG_plas_kaiju.tsv

## deepARG_plas_kaiju.tsv

### Columns explanation

- #ARG -> Antibiotic resistance gene 
- query-start / query-end -> position of alignment from enviromental sequences with ARG sequence (diamond result)
- nt_id -> ORF ID for nucletide sequence, for ORFs extracted (with metagenmark) from TARA co-assemblies. The ID is sequential (gene_1 ... gene_n) and also has infos about model used, size of ORF in NT, strand and position start and stop. **PS: can be redundant between samples (co-assemblies), so when used as key, should be used with adition of "sample" columun.**
- predicted_ARG-class -> Class of ARG. 
- best-hit -> ID of ARG sequence on deepARG database (provided as deepARGdb.fasta). It came from the header of the fasta. Shows the ID of sequence, the database from where deepARGdb got it (CARD, ARDB or UNIPROT), the class and the ARG name. 
- probability -> statistical value for the probability of the ORF analysed be actually the ARG. 
- identity -> indentity percentual from the alignment (ORF versus ARG)
- alignment-length -> size of the sequence aligned (ORF versus ARG)
- alignment-bitscore -> score of the aligment (ORF versus ARG)
- alignment-evalue -> evalue of the aligment (ORF versus ARG)
- problematic_classification -> deprecated, to not be used
- sample -> name of co-assembled sample by region (name of *.fa files, excluding .fa string)
- gene -> ARG gene name (same of #ARG, but writen in gene name convection way)
- contig_id -> ID of contig from where the ARG came (extracted from the header of contig sequences on *.fa file)
- ptn_id -> ORF ID for protein sequence, for ORFs extracted (with metagenmark) from TARA co-assemblies. The ID is sequential (gene_1 ... gene_n) and also has infos about model used, size of ORF in ptn, strand and position start and stop. **PS: can be redundant between samples (co-assemblies), so when used as key, should be used with adition of "sample" columun.**
- contig_length -> size in bp of contig from where the ORF came. 
- label -> label provided by plasflow, with information if the sequence is in plasmid, chromosome or unclassified, in addition of information about phyla.
- plasmid -> yes if the orf is in a contig classified as plasmid, no if is unclassified or chromosome.
- Plasflow_phyla -> extracted from label, shows the phyla classification by plasflow
- ORF_ID -> concatanation of nt_id and sample with a "|" in between. 
- taxon_kaiju -> ncbi taxon number obtained by kaiju taxon classification for the ORF
- taxon_name_kaiju -> taxon name (obtained from ncbi taxon number) 
- header_ptn_for_phylogeny -> new header for phylogeny. It was parsed from ptn_id (gene number) and concatanated + sample + taxon_name_kaiju


## FPKM.tsv

- ORF_ID - concatanation of nt_id and sample with a "|" in between. **The same from deepARG_plas_kaiju.tsv**
- All the other columns - ERRXXXXXX - FPKM values for each sample on meta tables (column "value") on meta_runs.tsv


## deepARG_plas_kaiju_rna.tsv

- just adding one column to deepARG_plas_kaiju.tsv. The column is "expressed", values yes or no, if sum of FPKM of all RNA samples is > 5, the ARG is considered expressed and value yes.  


## meta_runs.tsv

- Modification of table with metadata from paper (http://science.sciencemag.org/content/348/6237/1261359). The original table was modified to show now one row per run (no more per sample). The id of run (splitted from "INSDC run accession number(s)") now is "value", and this "value" new column is the key for the columns names ERRXXXX on FPKM.tsv. 

## meta2.tsv

- More metadata about pangea samples. The column "PANGAEA Sample ID" refers to "PANGAEA sample identifier" on meta_runs.tsv




