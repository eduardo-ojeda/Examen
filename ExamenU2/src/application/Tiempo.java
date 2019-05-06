package application;

public class Tiempo extends Thread {
    public Tiempo(){
        super();
    }
    int nuMin=0, nuSeg=0;
    String min="00", seg="";
    public void run() {

        try {
            for (; ;){
               if(nuSeg!=59) {
            	   nuSeg++;
            	   if(nuSeg<10)
            	   {
            		   seg = "0"+nuSeg;
            	   }
            	   else
            	   {
            		   seg = ""+nuSeg;
            	   }
                }
               else{
                	nuSeg=0;
                	seg="00";
                    if(nuMin!=59){
                        nuMin++;

                        if(nuMin<10)
                        {
                        	min="0"+nuMin;
                        }
                        else
                        {
                            min =""+nuMin;
                        }

                    }
                }
            System.out.println(min+":"+seg);
            sleep(999);
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
 }

 public static void main(String[] args) {


    }
}