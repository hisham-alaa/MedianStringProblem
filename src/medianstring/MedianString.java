
/* 
    the program is written by hisham alaa Ahmed and Abdelrahman Mostafa yousef
    both in cs department
*/












package medianstring;

import java.util.Scanner;

public class MedianString {

    // returns an array contains all permutations but it would take alot from the memory 
    public static String[] findPatterns(int k) {
    String[] patterns = new String[(int) Math.pow(4, k)];
    int index = 0;
    for (int i = 0; i < 4; i++) {
        if (k == 1) {
            patterns[index++] = "" + "acgt".charAt(i);
        } 
        else {
            for (String s : findPatterns(k- 1)) {
                patterns[index++] = "acgt".charAt(i) + s;
            }
        }
    }
    return patterns;
}
    
    // this one takes the permutation you want and find it directly.
    public static String currentPattern(int index,int k) {
        StringBuffer pattern=new StringBuffer ("");
        int tempk=k;
        String ourLetters="acgt";
        for(int i=k-1;i>=0;i--){
            pattern.append(ourLetters.charAt(((int)Math.ceil(index/Math.pow(4, i)))-1));
            index%=Math.pow(4, i);
        }
        return pattern.toString();
    }
    
    public static int reverse(int x) {
        int sign =1,counter=0;
        if(x<0){
            sign=-1;
            x*=-1;
        }
        int[] nums=new int[10];
        while (x!=0) {
            nums[counter]+=(x%10);
            x/=10;
        }
        
    }
    
    public static String FindBestMotif(int k,String[] DNA) {
        String pattern,res=new String("");
        int min=k,mismatches=0,temptotaldis=0,totaldis=100000000;
        
        /* 
            we will do this for all possible motifs (4 power K possibilities) to pick 
            the one with the minimum total haming distance.
        */
        
        for (int i=0;i<Math.pow(4, k);i++) {
            // we need to have all permutations " for now I make it fixed "
            pattern =currentPattern(i+1,k);
            temptotaldis=0;
            
            // iterate on all (t) sequences which forming the DNA
            for (int j=0;j<DNA.length;j++){
                min=k;
                
                // this loop to access all possible substrings of length k
                for (int l=0;l<DNA[j].length()-k;l++){
                    mismatches=0;
                    
                    //calculate haming distance for the currunt substring from l to l+k
                    for (int m=0;m<k;m++)
                        if(pattern.charAt(m)!=DNA[j].charAt(l+m))
                            mismatches++;
                    
                    if(mismatches<min) min=mismatches;
                }
                temptotaldis+=min;
            }
            if(temptotaldis<totaldis) {
                totaldis=temptotaldis;
                res=pattern;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int k,n,t;
        /*
        System.out.println("Enter motif length (K): ");
        k= sc.nextInt();
        System.out.println("Enter number of sequences (t): ");
        t= sc.nextInt();
        System.out.println("Enter the sequence's length (n): ");
        n= sc.nextInt();
        
        
        
        System.out.println("Enter "+ t +" sequences of length "+ n +" :");
        
        String[] DNA=new String[t];
        for(int i=0;i<t;i++) DNA[i]=sc.next();
        
        System.out.println("the best string Found is : "+FindBestMotif(k,DNA));
*/

        
        
        System.out.println("Enter the number to reverse : ");
        n= sc.nextInt();
        
        System.out.println(reverse(n));
        
    }

 
}
