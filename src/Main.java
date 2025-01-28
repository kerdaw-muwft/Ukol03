import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        Guest guestOne = new Guest("Adéla","Malíková",
                                   LocalDate.of(1993,3,13));
        Guest guestTwo = new Guest("Jan","Dvořáček",
                                   LocalDate.of(1995,5,5));
        guestTwo.setDateOfBirth(LocalDate.of(1995,4,5));
        System.out.println(guestTwo.getDescription());

        Room roomOne = new Room(1,1,true,true, new BigDecimal("1000.0"));
        Room roomTwo = new Room(2,1,true,true, new BigDecimal("1000.0"));
        Room roomThree = new Room(3,3,false,true, new BigDecimal("2400.0"));

        Booking firstBooking = new Booking(roomOne,guestOne,new ArrayList<>(),TypeOfVacation.WORK,
                LocalDate.of(2021,7,1),
                LocalDate.of(2021,7,19));

        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guestTwo);
        Booking secondBooking = new Booking(roomThree,guestOne,guests,TypeOfVacation.RECREATIONAL,
                LocalDate.of(2021,9,1),
                LocalDate.of(2021,9,14));

        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(firstBooking);
        bookings.add(secondBooking);

        for (Booking booking : bookings){
            System.out.print("Room number: " + booking.getRoom().getRoomNumber() +
                               " Guests: " + booking.getGuest().getName() + " " + booking.getGuest().getSurname());

            List<Guest> otherGuests = booking.getOtherGuests();
            for (Guest guest: otherGuests){
                System.out.print(", " + guest.getName() + " " + guest.getSurname());
            }

            System.out.println(" Type of vacation: " + booking.getTypeOfVacation() +
                               " Resereved from: " + booking.getStartDate() +
                               " to: " + booking.getEndDate());
        }
    }
}