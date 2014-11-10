/*************************************************************************
 *  Compilation:  javac GeneFind.java
 *  Execution:    java GeneFind start stop < input.txt
 *
 *  To find a gene in a genome, we scan for the start codon,
 *  remember its index, then scan from the next stop codon.
 *  If the length of the intervening sequence is a multiple of 3,
 *  we have found a gene.
 *
 *  % more genomeTiny.txt
 *  ATAGATGCATAGCGCATAGCTAGATGTGCTAGCAT
 *
 *  % java GeneFind ATG TAG < genomeTiny.txt
 *  CATAGCGCA
 *  TGC
 *
 *  % java GeneFind ATG TAG < genomeVirus.txt
 *  CGCCTGCGTCTGTAC
 *  TCGAGCGGATCGCTCACAACCAGTCGG
 *  AGATTATCAAAAAGGATCTTCACC
 *
 *************************************************************************/

public class GeneFind {
    public static void main(String[] args)  {

        // read in data
        String start = args[0];
        String stop  = args[1];
        String genome = StdIn.readAll();
        System.out.println("genome = '" + genome + "'");
        System.out.println("start  = '" + start  + "'");
        System.out.println("stop   = '" + stop   + "'");

        // find genes
        int beg = -1;
        for (int i = 0; i < genome.length() - 2; i++) {
            String codon = genome.substring(i, i+3);

            // start codon
            if (codon.equals(start)) beg = i;

            // stop codon
            if ((codon.equals(stop)) && (beg != -1) && (beg + 3 < i)) {
                // check putative gene alignment
                String gene = genome.substring(beg+3, i);
                if (gene.length() % 3 == 0) {
                    System.out.println(gene);
                    beg = -1;
                }
            }
        }
    }
}
