public class Vehicle {
    private String vehicleNumber;
    private parkingType vehicleType;

    Vehicle(String vehicleNumber, parkingType vehicleType)
    {
        this.vehicleNumber=vehicleNumber;
        this.vehicleType=vehicleType;
    }

    public parkingType getVehicleType() {
        return vehicleType;
    }
    public String getVehicleNumber()
    {
        return vehicleNumber;
    }
}
