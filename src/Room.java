import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private boolean hasSeaView;
    private BigDecimal costPerNight; //in czech crowns per night

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, boolean hasSeaView, BigDecimal costPerNight) {
        this.costPerNight = costPerNight;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
    }

    public BigDecimal getCostPerNight() {
        return costPerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public boolean hasSeaView() {
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
