package movieticket;
import java.util.*;
class Room
{
    Seat seatobj[] = new Seat[4]; // since seats are required for all the 4 time slot
    Room()
    {
        for(int i=0;i<4;i++)
        {
            seatobj[i] = new Seat();
        }
    }
}
class Movie
{
    String Language[] = {"English","Hindi","Telugu"};
    String MovieName;
    int Langchoice;
    int Movchoice;
    int MovieTimeSlot;
    int RoomNo;
    String MovieType;

    void movieChoice(String array[][],int num_movies)
    {
        System.out.println("---------------CHOOSE YOUR LANGUAGE---------------");
        System.out.println("Enter 1: English\nEnter 2: Hindi\nEnter 3: Telugu\n");
        Scanner sc=new Scanner(System.in);
        int e3=0;
        while(e3==0)
        {
            Langchoice=sc.nextInt();
            if(Langchoice==1||Langchoice==2||Langchoice==3)
            {
                break;
            }
            else
            {
                System.out.println("Enter a valid language\n");
                e3=0;
            }
        }
        System.out.println("Language Chosen SUCCESSFULLY\n");
        System.out.println("---------------CHOOSE YOUR MOVIE---------------");
        for(int i = 0; i < num_movies ;i++ )
        {
            System.out.println("Enter  "+ (i+1) + ":"+array[Langchoice-1][i]);
        }
        int movchoice=0;
        int e5=0;
        while(e5==0)
        {
            movchoice = sc.nextInt();
            if(movchoice>0 && movchoice<=num_movies)
            {
                break;
            }
            else
            {
                System.out.println("Enter a valid movie choice\n");
                e5=0;
            }
        }
        System.out.println("Movie Chosen SUCCESSFULLY\n");
        RoomNo=((Langchoice-1)*num_movies) + movchoice;  //choice is same as room number
        MovieName = array[Langchoice-1][movchoice-1];
        MovieType = Language[Langchoice-1];
    }
    void showTiming()
    {
        System.out.println("---------------CHOOSE YOUR SHOW TIMING---------------");
        System.out.println("Enter 1: 9:00 AM -12:00 PM\nEnter 2: 12:30 PM - 3:30 PM\nEnter 3: 4:00 PM - 7:00 PM\nEnter 4: 7:30 PM - 10:30 PM\n ");
        Scanner sc5=new Scanner(System.in);
        int e4=0;
        while(e4==0)
        {
            MovieTimeSlot=sc5.nextInt(); 
            if(MovieTimeSlot==1||MovieTimeSlot==2||MovieTimeSlot==3||MovieTimeSlot==4)
            {
                break;
            }
            else
            {
                System.out.println("Enter a valid Show Timing\n");
                e4=0;
            }
        }
        System.out.println("Show-Timing Chosen SUCCESSFULLY\n");
    }
}