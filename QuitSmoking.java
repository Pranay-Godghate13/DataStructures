public class QuitSmoking {
    public static void main(String[] args) {
        long no=2;
        long years=5;
        String gender="M";
        long avg=70;
        long daysLeft=0;
        long age=25;
        long ageLeft=avg-age;
        long noOfCiggrates=no*years*365;
        switch (gender) {
            case "M":
            {
                
                daysLeft=ageLeft*365-(noOfCiggrates*20)/(24*60);
                break;
            }
                
        
            // case "F":
            // {
                
            //     daysLeft=(time-no*22*years*365)/60;
            //     break;
            // }       

        }
        System.out.println("No of days left in your life is "+daysLeft);
        System.out.println("No of years left in your life is "+daysLeft/365);
        long ageDie=(daysLeft/365)+age;
        System.out.println("You will die at the age of "+ageDie);
    }
}
