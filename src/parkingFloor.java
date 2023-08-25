import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class parkingFloor {
    String Name;
    HashMap<parkingType, List<parkingArea>>  mapping;

    parkingFloor(String Name)
    {
        this.Name=Name;
        this.mapping=new HashMap<parkingType,List<parkingArea>>();
    }
    public parkingArea parkVehicle(Vehicle vehicle)
    {
        List<parkingArea> parkingAreaList=mapping.get(vehicle.getVehicleType());
        boolean isparked=false;
        for(int i=0;i<parkingAreaList.size();i++)
        {
            parkingArea parkingArea=parkingAreaList.get(i);
            if(parkingArea.isAvailable)
            {
                parkingArea.isAvailable=false;System.out.println("vehicle is parked at:" + parkingArea.name);isparked=true;
                parkingAreaList.set(i,parkingArea);
                mapping.remove(vehicle.getVehicleType());mapping.put(vehicle.getVehicleType(),parkingAreaList);
                return parkingArea;

            }
        }
        if(!isparked)
        {System.out.println("no available parking in this floor for "+vehicle.getVehicleType()+" at this floor" +Name);}

        return null;
    }

    public void unparkVehicle(parkingType parkingType, parkingArea parkingArea)
    {
        if(!mapping.containsKey(parkingType))
        {
            System.out.println("this parking area is not available");
        }
        else {
            List<parkingArea> list=mapping.get(parkingType);
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).name.equals(parkingArea.name))
                {
                    parkingArea.isAvailable=true;
                    list.set(i,parkingArea);
                    System.out.println("parking Area :"+parkingArea.name +" is available now on "+Name);
                    break;
                }
            }
        }


    }

    public boolean isParkingAvailable(Vehicle vehicle)
    {
        List<parkingArea> parkingAreaList=mapping.get(vehicle.getVehicleType());
        for(int i=0;i<parkingAreaList.size();i++)
        {
            if(parkingAreaList.get(i).isAvailable==true)
            {return true;}
        }
        return false;
    }
    public void addParkingArea(parkingArea parkingArea,parkingType parkingType){
                if(mapping.containsKey(parkingType))
                {
                    List<parkingArea> list=new ArrayList<>();

                    List<parkingArea> temp=mapping.get(parkingType);
                    for(int i=0;i<temp.size();i++)
                    {
                        list.add(temp.get(i));
                    }
                    list.add(parkingArea);

                    mapping.put(parkingType,list);
                }
                else
                {
                    mapping.put(parkingType,List.of(parkingArea));
                }

    }
}
