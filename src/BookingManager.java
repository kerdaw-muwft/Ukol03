import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings;

    public BookingManager() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public Booking getBooking(int index) {
        return bookings.get(index);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void clearBookings(){
        this.bookings.clear();
    }

    public int getNumberOfWorkingBookings(){
        int numberOfWorkingBookings = 0;
        for(Booking booking : bookings){
            if(booking.getTypeOfVacation()==TypeOfVacation.WORK){
                numberOfWorkingBookings++;
            }
        }
        return numberOfWorkingBookings;
    }

    public double getAverageGuests(){
        int totalSum = 0;
        for(Booking booking : bookings){
            if(booking.getGuest() != null){
                totalSum++;
            }
            totalSum += booking.getOtherGuests().size();
        }
        return (double) totalSum/bookings.size();
    }

    public ArrayList<Booking> getTopNHolidayBookings(int amount){
        ArrayList<Booking> holidayBookings = new ArrayList<>();
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = getBooking(i);
            if (booking.getTypeOfVacation() == TypeOfVacation.RECREATIONAL){
                holidayBookings.add(getBooking(i));
                if(holidayBookings.size()==amount){
                    return holidayBookings;
                }
            }
        }
        return holidayBookings;
    }
    public void printGuestStatistics(){
        int oneGuest = 0;
        int twoGuests = 0;
        int severalGuests = 0;

        for (Booking booking : bookings){
            if (booking.getOtherGuests().isEmpty()){
                oneGuest++;
            }
            if(booking.getOtherGuests().size()==1){
                twoGuests++;
            }
            if (booking.getOtherGuests().size()>1){
                severalGuests++;
            }
        }
        System.out.println("\nStatistiky hostů:");
        System.out.println("Počet rezervací s jedním hostem: " + oneGuest);
        System.out.println("Počet rezervací se dvěma hosty: " + twoGuests);
        System.out.println("Počet rezervací s více hosty: " + severalGuests + "\n");
    }
}
