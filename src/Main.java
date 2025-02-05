import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        BookingManager bm = new BookingManager();
        fillBookings(bm);

        System.out.println("Počet pracovních pobytů: " + bm.getNumberOfWorkingBookings() + "\n");

        System.out.println("Průměrný počet hostů na rezervaci: " + bm.getAverageGuests()+ "\n");

        ArrayList<Booking> topEightRecreational  = bm.getTopNHolidayBookings(8);
        System.out.println("Prvních osm rekreačních rezervací:");
        for (Booking booking : topEightRecreational){
            System.out.println("Rezervace pro: " + booking.getGuest().getDescription() + " na: " +
                               booking.getRoom().getRoomNumber() + " termín: " + booking.getStartDate()
                               + " - " + booking.getEndDate() + " pracovní pobyt: " +
                               (booking.getTypeOfVacation()==TypeOfVacation.WORK?"ano":"ne"));
        }

        bm.printGuestStatistics();

        System.out.println("Počet pracovních pobytů: " + bm.getNumberOfWorkingBookings() + "\n");

        System.out.println("Formátovaný výpis všech rezervací v systému:");
        for (Booking booking : bm.getBookings()){
            System.out.println(booking.getFormattedSummary());
        }


    }
    public static void fillBookings(BookingManager bm){

        // guests and rooms settings
        Guest guestOne = new Guest("Karel","Dvořák",
                LocalDate.of(1990,5,15));
        Guest guestTwo = new Guest("Karel","Dvořák",
                LocalDate.of(1979,1,3));
        Guest guestThree = new Guest("Karolína","Tmavá",
                LocalDate.of(1992,10,18));
        Room roomOne = new Room(1,1,true,true, new BigDecimal("1000.0"));
        Room roomTwo = new Room(2,1,true,true, new BigDecimal("1000.0"));
        Room roomThree = new Room(3,3,false,true, new BigDecimal("2400.0"));

        // creating testing data
        Booking booking1 = new Booking(roomThree,guestOne,new ArrayList<>(),TypeOfVacation.WORK,
                LocalDate.of(2023,6,1),
                LocalDate.of(2023,6,7));
        Booking booking2 = new Booking(roomTwo,guestTwo,new ArrayList<>(),TypeOfVacation.RECREATIONAL,
                LocalDate.of(2023,7,18),
                LocalDate.of(2023,7,21));
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guestOne);
        Booking booking3 = new Booking(roomThree,guestThree,guests,TypeOfVacation.WORK,
                LocalDate.of(2023,8,1),
                LocalDate.of(2023,8,31));
        bm.addBooking(booking1);
        bm.addBooking(booking2);
        bm.addBooking(booking3);
        for (int i = 0; i < 20; i+=2) {
            Booking booking = new Booking(roomTwo,guestThree,new ArrayList<>(),TypeOfVacation.RECREATIONAL,
                    LocalDate.of(2023,8,i+1),
                    LocalDate.of(2023,8,i+2));
            bm.addBooking(booking);
        }
    }
}