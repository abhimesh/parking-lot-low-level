import java.security.Timestamp;
import java.util.Date;

public class tickets {
    Vehicle vehicle;
    parkingFloor parkingFloor;
    parkingArea parkingArea;
    Date inDate;
    tickets(Vehicle vehicle,parkingArea parkingArea,parkingFloor parkingFloor, Date inDate)
    {
        this.vehicle=vehicle;
        this.parkingArea=parkingArea;
        this.parkingFloor=parkingFloor;
        this.inDate=inDate;
    }
}
