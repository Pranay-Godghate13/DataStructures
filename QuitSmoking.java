public class QuitSmoking {
    public static void main(String[] args) {
        long no=2;
        long years=5;
        String gender="F";
        long avg=70;
        long daysLeft=0;
        long age=25;
        long currAge=age*12*30*24*60;
        long time=avg*12*30*24*60-currAge;
        switch (gender) {
            case "M":
            {
                
                daysLeft=(time-no*20*years*365)/60;
                break;
            }
                
        
            case "F":
            {
                
                daysLeft=(time-no*22*years*365)/60;
                break;
            }       

        }
        System.out.println("No of days left in your life is "+daysLeft);
        System.out.println("No of minutes left in your life is "+daysLeft/60);
    }
}
