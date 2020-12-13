public class KBestTester{
    
    public static void main(String[] args){
        
        KBestCounter<Integer> intCounter = new KBestCounter<>(5);
        KBestCounter<String> strCounter = new KBestCounter<>(3);
        
        System.out.println("Inserting 1 through 3");
        for(int i = 1; i <=3;i++){
            intCounter.count(i);
        }
        System.out.println("5 best - Expected: [1,2,3]. Result: " + intCounter.kbest());
        
        System.out.println("Inserting 0 through 10.");
        for(int i = 0; i <= 10;i++){
            intCounter.count(i);
        }
        System.out.println("5 best - Expected: [6,7,8,9,10]. Result: " + intCounter.kbest());
        
        
        System.out.println("Inserting -100 through 301.");
        for(int i = -100; i <= 301;i++){
            intCounter.count(i);
        }
        System.out.println("5 best - Expected: [297,298,299,300,301]. Result: " + intCounter.kbest());
        System.out.println("----------------------------------------");
        System.out.println("Inserting Ege, Angel, Antonio, Julia, Kaan");
        strCounter.count("Ege");
        strCounter.count("Angel");
        strCounter.count("Antonio");
        strCounter.count("Julia");
        strCounter.count("Kaan");
        strCounter.count("Can");
        System.out.println("3 best | Expected: [Ege, Julia, Kaan]. Result: " + strCounter.kbest());
        
        System.out.println("----------------------------------------");
        System.out.println("Testing when k = 0: " );
        KBestCounter<Integer> zeroCounter = new KBestCounter<>(0);
        System.out.println("Inserting 0 through 10.");
        for(int i = 0; i <= 10;i++){
            zeroCounter.count(i);
        }
        System.out.println("0 best | Expected: [ ]. Result: " + zeroCounter.kbest());
    }  
}