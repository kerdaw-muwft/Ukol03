import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private boolean hasSeaView;
    private BigDecimal bookingCost; //in czech crowns per night

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, boolean hasSeaView, BigDecimal bookingCost) {
        this.bookingCost = bookingCost;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
    }

    public BigDecimal getBookingCost() {
        return bookingCost;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public boolean isHasSeaView() {
        return hasSeaView;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public void setHasSeaView(boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
