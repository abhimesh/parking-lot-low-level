import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        parkingArea parkingArea1=new parkingArea("area 1",true);
        parkingArea parkingArea2=new parkingArea("area 2",true);
        parkingArea parkingArea3=new parkingArea("area 3",true);
        parkingArea parkingArea4=new parkingArea("area 4",true);
        parkingArea parkingArea5=new parkingArea("area 5",true);

        parkingFloor parkingFloor1=new parkingFloor("floor 1");
        parkingFloor1.addParkingArea(parkingArea1,parkingType.SMALL);
        parkingFloor1.addParkingArea(parkingArea2,parkingType.SMALL);
        parkingFloor1.addParkingArea(parkingArea3,parkingType.MEDIUM);
        parkingFloor1.addParkingArea(parkingArea4,parkingType.MEDIUM);
        parkingFloor1.addParkingArea(parkingArea5,parkingType.LARGE);

        parkingLot parkingLot= new parkingLot("abhimesh_parking_lot","kheria mod agra", List.of(parkingFloor1));
        Vehicle vehicle1=new Vehicle("1234",parkingType.SMALL);
        Vehicle vehicle2=new Vehicle("5678",parkingType.SMALL);
        Vehicle vehicle3=new Vehicle("9101112",parkingType.SMALL);

        parkingLot.vehicleIncoming(vehicle1);
        parkingLot.vehicleIncoming(vehicle2);
        parkingLot.vehicleOutgoing(vehicle1);
        parkingLot.vehicleIncoming(vehicle3);

    }
}