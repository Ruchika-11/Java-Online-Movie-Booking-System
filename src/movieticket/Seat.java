package movieticket;
import java.util.Scanner;

class Seat
{
    int seat[]=new int[101];
    int cnr;
    int cost;
    int no_of_seat;
    int avail_seat;
    int no_of_tickets_booked;
    int last_booked_seat_indx;
    int seat_choice;
    Seat()
    {
        this.no_of_seat=no_of_seat;
        this.avail_seat=100;
        this.last_booked_seat_indx = 100;
        no_of_tickets_booked=0;
        for (int i=0;i<100;i++)
        {
            seat[i]=i+1;
        }
    }
    boolean SeatBooking(int no_of_seat, TicketBooking objticket)
    { 
        boolean flag=false;
        if(avail_seat>no_of_seat)
        {
            System.out.println("------------PAYMENT--------------");
            System.out.println("Price : Rs. 300 per seat");
            cost=300*no_of_seat;
            System.out.println("You have to pay Rs. "+cost+" for "+no_of_seat+" seats\n");
            objticket.cost=cost;
            Scanner sc4=new Scanner(System.in);
            System.out.print("Pay the displayed amount of money: \t");
            int card=sc4.nextInt();
            int s;
            if(card==cost)
            {
                System.out.println("PAYMENT SUCCESSFUL");
                System.out.println("------------------------------------------------------");
                System.out.println("             ***** Before the seat is chosen *****");
                display_seat();
                System.out.println("Enter the seat numbers that who want to choose");
                for(s=0;s<no_of_seat;)
                {
                    System.out.println("Enter seat number "+(s+1)+": ");
                    seat_choice=sc4.nextInt();
                    if(seat_choice<=100 && seat_choice>0)
                    {
                        if(seat[seat_choice-1]!=-1)
                        {
                            seat[seat_choice-1]=-1;
                            objticket.seat_reserved[s]=seat_choice;
                            s++;
                        }
                        else
                        {
                            System.out.println("Seat not available\nEnter another seat number");
                        }
                        
                    }
                    else
                    {
                        System.out.println("Enter a valid seat number");
                    }
                    
                }
                System.out.println("               ***** After the seat is chosen *****");
                avail_seat=avail_seat-no_of_seat;
                display_seat();
                no_of_tickets_booked++;
                flag = true;
            }
            else
            {
                System.out.println("**********ERROR**********");
                System.out.println("Unable to book ticket\nPay the exact amount");
                //return false;
            }
        }
        else if(avail_seat<no_of_seat)
        {
            System.out.println("SORRY\nSeats Not Available");
            //return false;
        }
        return flag;
    }
    void display_seat()
    {
        for (int i=0;i<100;i++)
        {
            System.out.print(seat[i]+"\t"); 
            if((i+1)%10==0)
                System.out.println("\n");
        }
    }
}
