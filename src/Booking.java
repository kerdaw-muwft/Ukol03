import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Booking {
    private Room room;
    private Guest guest;
    private List otherGuests;
    private TypeOfVacation typeOfVacation;
    private LocalDate startDate;
    private LocalDate endDate;
    private DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-M-yyy");

    public Booking(Room room, Guest guest, List otherGuests, TypeOfVacation typeOfVacation, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.guest = guest;
        this.otherGuests = otherGuests;
        this.typeOfVacation = typeOfVacation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public List getOtherGuests() {
        return otherGuests;
    }

    public void setOtherGuests(List otherGuests) {
        this.otherGuests = otherGuests;
    }

    public TypeOfVacation getTypeOfVacation() {
        return typeOfVacation;
    }

    public void setTypeOfVacation(TypeOfVacation typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }

    public String getStartDate() {
        String date = startDate.format(DATE_FORMAT);
        return date;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        String date = endDate.format(DATE_FORMAT);
        return date;
    }
    public String getFormattedSummary(){
        return (this.getStartDate() + " až " + this.getEndDate() + ": "+
                         this.guest.getDescription() + "[" +
                         (this.otherGuests.size()+1) + ", " + (this.room.hasSeaView()?"ano":"ne") +
                         "] za " + this.getTotalPrice() + " kč");
    }
    public int getBookingLength(){
        return (int) ChronoUnit.DAYS.between(startDate,endDate);
    }
    public BigDecimal getTotalPrice(){
        return room.getCostPerNight().multiply(BigDecimal.valueOf(getBookingLength()));
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
