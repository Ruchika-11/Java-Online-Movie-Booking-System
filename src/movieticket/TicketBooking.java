package movieticket;
class TicketBooking
{
    int cnr;
    String MovieName;
    int ShowTimeSlot;
    String MovieType;
    int RoomNo;
    String Location;
    int seat_reserved[];
    int cost;
    int no_of_seat;
    void Setvalue(int cnr,String MovieType,String MovieName,int timeslot,int RoomNo,int no_of_seat,String Location)
    {
        this.cnr=cnr;
        this.Location=Location;
        this.MovieType=MovieType;
        this.MovieName=MovieName;
        this.ShowTimeSlot=timeslot;
        this.RoomNo=RoomNo;
        this.no_of_seat=no_of_seat;
        seat_reserved= new int[no_of_seat];
    }
}