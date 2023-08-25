import java.security.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class parkingLot {
    private String name;
    private String address;
    private List<parkingFloor> parkingFloor;
    private HashMap<Vehicle,tickets> vehicleticketsMap;


    parkingLot(String name,String address,List<parkingFloor> parkingFloor)
    {
        this.name=name;
        this.address=address;
        this.parkingFloor=parkingFloor;
        vehicleticketsMap=new HashMap<Vehicle,tickets>();
    }

    private parkingFloor isparkingAvailable(Vehicle vehicle)
    {
        boolean isAvailable=false;
        for(int i=0;i<parkingFloor.size();i++)
        {
            parkingFloor floor= parkingFloor.get(i);
            if(floor.isParkingAvailable(vehicle))
            {
                System.out.println("parking is available on " + floor.Name);
                isAvailable=true;
                return floor;
            }
        }
        System.out.println("parking is not available on any floor");
        return null;
    }

    public void vehicleIncoming(Vehicle vehicle)
    {
        System.out.println("welcome to Abhimesh parking lot");
        parkingFloor floor= isparkingAvailable(vehicle);
        if(floor!=null) {
            parkingArea parkingArea=floor.parkVehicle(vehicle);
            tickets tickets=new tickets(vehicle,parkingArea, floor,new Date());
            vehicleticketsMap.put(vehicle,tickets);

        }
    }

    public void vehicleOutgoing(Vehicle vehicle)
    {
        tickets tickets_corresponding_to_vehicle=vehicleticketsMap.get(vehicle);
        double fare=fareCalculation(tickets_corresponding_to_vehicle.inDate,new Date(),vehicle.getVehicleType());
        System.out.println("Fare of your vehicle:"+vehicle.getVehicleNumber()+ " is: "+fare+ "Rs.");
        parkingFloor parkingFloor=tickets_corresponding_to_vehicle.parkingFloor;
        parkingFloor.unparkVehicle(vehicle.getVehicleType(),tickets_corresponding_to_vehicle.parkingArea);
    }
    private double fareCalculation(Date startDate,Date endDate,parkingType parkingType)
    {
        long difference_In_Time
                = endDate.getTime() - startDate.getTime();
        long difference_In_Minutes
                = TimeUnit
                .MILLISECONDS
                .toMinutes(difference_In_Time)
                % 60;
        if(parkingType==parkingType.SMALL)
        {return difference_In_Minutes*0.33;}
        else if(parkingType== parkingType.MEDIUM)
        {return difference_In_Minutes*0.66;}
        else
        {return difference_In_Minutes*1;}
    }



}
