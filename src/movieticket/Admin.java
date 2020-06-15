package movieticket;
import java.util.*;

class Admin
{
    String MovieTimeList[] = {"9:00 AM -12:00 PM","12:30 PM - 3:30 PM",
                                        "4:00 PM - 7:00 PM","7:30 PM - 10:30 PM"};
    static int cnr=1000;
    Room RoomList[];
    Movie obj1 = new Movie();
    
    String name;
    String pw;
    String email;
    long phoneNo;
    String Location="";
    int lang;
    int movieno;
    int no_of_tickets_booked = 0;
    HashMap<Integer,TicketBooking> TicketMap=new HashMap<>();
    void Setup()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("*-*-*-*-*-*-*-* WLCOME TO THE THE ONLINE MOVIE TICKET BOOKING SYSTEM *-*-*-*-*-*-*-*");
        System.out.println("***********Sign-Up**********");
        System.out.println("Enter Your Credentials ::");
        System.out.print("Enter Your Name : ");
        name=sc.nextLine();
        System.out.print("\nEnter Your Password : ");
        Scanner sc2=new Scanner(System.in);
        pw=sc2.next();
        System.out.print("\nEnter Your E-Mail ID : ");
        email=sc.next();
        System.out.print("\nEnter your Mobile Number : ");
        Scanner sc3=new Scanner(System.in);
        phoneNo=sc3.nextLong();
        long mob=phoneNo;
        int countt = 0; 
        while (mob != 0) 
        { 
            mob = mob / 10; 
            countt++; 
        } 
        System.out.println("\n");
        
        boolean flag1=false;
        boolean flag_mob=false;
        boolean flag_email=false;
        boolean flag_pw=false;
        boolean flag_name=false;
        if(countt==10)
        {
            flag_mob=true;
            if(email.contains("@")&& email.substring(email.length()-4).equals(".com"))
            {
                flag_email = true;
                if(pw.length()>=8 && pw.length()<=15)
                {
                    flag_pw=true;
                    for(int m=0;m<name.length();m++)
                    {
                        char chr = name.charAt(m);
                        if (Character.isLetter(chr) || chr == ' ')
                        {
                            flag1=true;
                            flag_name=true;
                        }
                        else
                        {
                            flag1=false;
                            flag_name = false;
                            break;
                        }
                    }
                }
            }
        }
        if(flag_name==false)
        {
            System.out.println("Name should not contain special characters");
        }
        if(flag_mob==false)
        {
            System.out.println("Phone number should contain exactly 10 digits");
        }
        if(flag_email==false)
        {
            System.out.println("Enter valid E-Mail ID");
        }
        if(flag_pw==false)
        {
            System.out.println("Password should consist of mimimum 8 characters and should not exceed 15 characters");
        }
        if(flag1==true)
        {
            System.out.println("User Registered Successfully");
            SignUp obj=new SignUp(name,pw,email,phoneNo);
            obj.display();
        }
        else
        {
            System.out.println("Enter valid credentials");
            System.exit(0);
        }
        //SignUp obj=new SignUp(name,pw,email,phoneNo);
        //obj.display();
        System.out.println("---------------CHOOSE YOUR LOCATION---------------");
        System.out.println("Enter 1: MG Road\nEnter 2: Kormangala\nEnter 3: Orion Mall\nEnter 4: Malleshwaram");
        int e=0;
        while(e==0)
        {
            int ce=sc3.nextInt();
            switch(ce)
            {
                case 1:
                {
                    Location = "MG Road";
                    e=1;
                    break;
                }
                case 2:
                {
                    Location = "Kormangala";
                    e=1;
                    break;
                }
                case 3:
                {
                    Location = "Orion Mall";
                    e=1;
                    break;
                }
                case 4:
                {
                    Location = "Malleshwaram";
                    e=1;
                    break;
                }
                default:
                {
                    System.out.println("Enter a valid location");
                    e=0;
                    break;
                }
            }
        }
        System.out.println("Location Chosen SUCCESSFULLY\n");
        int k=0;
        System.out.println("\n");
        System.out.println("*-*-*-*-*-*-*-*-* ADMIN PORTAL *-*-*-*-*-*-*-*-*-*");
        System.out.println("Enter the number of languages: "); // Put 3 languages
        lang=sc.nextInt();
        System.out.println("Enter the number of movies for each language");
        movieno=sc.nextInt();
        sc.nextLine();
        String array[][]=new String[lang][movieno];
        RoomList = new Room[(lang*movieno)]; 
        for(int i=0;i<lang;i++)
        {
            for(int j=0;j<movieno;j++)
            {
                System.out.println("Enter the name of movie "+(k+1));
                array[i][j]=sc.nextLine();
                RoomList[k]=new Room();
                k++;
            }
        }
        int exit=0;
        
        while(exit==0)
        {
            System.out.println("*-*-*-*-*-*-*-*-* CUSTOMER PORTAL *-*-*-*-*-*-*-*-*-*");
            System.out.println("Enter 1: To Book Ticket\nEnter 2: To Enquire about the ticket you booked\n"
                    + "Enter 3: To cancel the ticket\nEnter 4: To Exit");
            int choi=sc.nextInt();
            
            switch(choi)   
            {
                case 1:
                {

                    obj1.movieChoice(array,movieno);
                    obj1.showTiming();
                    TicketBooking objticket = new TicketBooking();
                    int no_of_seat;
                    System.out.println("--------------------CHOOSE YOUR SEAT------------------------");
                    System.out.println("Enter the number of seats that you want to book");
                    no_of_seat=sc.nextInt();
                    int timeslot = obj1.MovieTimeSlot;
                    //SeatBooking(no_of_seat,objticket);
                    objticket.Setvalue(cnr,obj1.MovieType,obj1.MovieName,timeslot,obj1.RoomNo,no_of_seat,Location);
                    if((RoomList[(obj1.RoomNo-1)]).seatobj[timeslot-1].SeatBooking(no_of_seat,objticket))
                    {
                        TicketMap.put(objticket.cnr,objticket);
                        System.out.println("Your cnr number is : "+cnr);
                        System.out.println("********** TICKET BOOKED SUCCESSFULLY **********");
                        System.out.println("The copy of your ticket is sent to your Email-ID ");
                        System.out.println("-----------------------------------------------------------");
                        no_of_tickets_booked++;
                        cnr++;
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("Enter your cnr number");
                    Scanner sc5=new Scanner(System.in);
                    int cus_cnr=sc5.nextInt();
                    try
                    {
                        if(cus_cnr==TicketMap.get(cus_cnr).cnr)
                        {
                            System.out.println("----------------------------------------------");
                            System.out.println("Your ticket details are: ");
                            System.out.println("cnr Number       : "+TicketMap.get(cus_cnr).cnr);
                            System.out.println("Location         : "+TicketMap.get(cus_cnr).Location);
                            System.out.println("Movie            : "+TicketMap.get(cus_cnr).MovieName);
                            System.out.println("Type             : "+TicketMap.get(cus_cnr).MovieType);
                            System.out.println("Time             : "+MovieTimeList[(TicketMap.get(cus_cnr).ShowTimeSlot)-1]);
                            System.out.println("Room Number      : "+TicketMap.get(cus_cnr).RoomNo);
                            System.out.println("Number of Seats  : "+TicketMap.get(cus_cnr).no_of_seat);
                            System.out.println("Ticket Cost      : Rs. "+TicketMap.get(cus_cnr).cost);
                            System.out.println("Your Seat Numbers are : ");
                            for(int j=0;j<TicketMap.get(cus_cnr).no_of_seat;j++)
                            {
                                System.out.println(TicketMap.get(cus_cnr).seat_reserved[j]);
                            }
                            System.out.println("----------------------------------------------");
                            break;
                        }
                    }
                    catch(Exception p)
                    {
                        System.out.println("Invalid cnr\n"); 
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("Enter your cnr number");
                    Scanner sc5=new Scanner(System.in);
                    int cus_cnr=sc5.nextInt();
                    try
                    {
                        if(cus_cnr==TicketMap.get(cus_cnr).cnr)
                        {
                            int timeslot =  TicketMap.get(cus_cnr).ShowTimeSlot;
                            int room_no = TicketMap.get(cus_cnr).RoomNo;
                            RoomList[room_no-1].seatobj[timeslot-1].avail_seat += TicketMap.get(cus_cnr).no_of_seat;
                            for(int j=0;j<TicketMap.get(cus_cnr).no_of_seat;j++)
                            {
                                int indx = TicketMap.get(cus_cnr).seat_reserved[j];
                                RoomList[room_no-1].seatobj[timeslot-1].seat[indx-1]=indx;
                            }
                            //RoomList[room_no-1].seatobj[timeslot-1].display_seat();
                            TicketMap.remove(cus_cnr);
                            System.out.println("********** CANCELLED SUCCESSFULLY **********");
                            System.out.println("Your Money will be returned at the source of payment");
                            System.out.println("-----------------------------------------------------------");
                            break;
                        }
                    }
                    catch(Exception p)
                    {
                        System.out.println("Invalid cnr\n"); 
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("Do you want to log out ?");
                    System.out.println("Enter 1: YES\nEnter 2: NO");
                    Scanner scan5=new Scanner(System.in);
                    int e1=0;
                    while(e1==0)
                    {
                        int choi2=scan5.nextInt();
                        switch(choi2)
                        {
                            case 1:
                            {
                                exit=1;
                                System.out.println("You have been successfully logged out");
                                System.out.println(" *************** END ***************");
                                e1=1;
                                break;
                            }
                            case 2:
                            {
                                e1=1;
                                exit=0;
                                break;
                            }
                            default:
                            {
                                System.out.println("Enter a valid choice\n");
                                e1=0;
                                break;
                            }
                        }
                    }
                    break;
                }
                default:
                {
                    System.out.println("Enter a valid option\n");
                    exit=0;
                    break;
                }
            }
        }
    }
}
class SignUp
{
    String name;
    String pw;
    String email;
    long phoneNo;
    SignUp(String name,String pw,String email,long phoneNo)
    {
        this.name=name;
        this.pw=pw;
        this.email=email;
        this.phoneNo=phoneNo;
    }
    void display()
    {
        System.out.println("---------------------------------------------------");
        System.out.println("User Credentials are: ");
        System.out.println("UserName     : "+name);
        System.out.println("Password     : "+pw);
        System.out.println("E-Mail ID    : "+email);
        System.out.println("Phone Number : "+phoneNo);
        System.out.println("---------------------------------------------------");
    }
}