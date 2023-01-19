package main.models.vehicles;


public enum TrainSize{
    BIG(6, VehicleSize.BIG),
    SMALL(8, VehicleSize.SMALL);

    private final int capacity;
    private final VehicleSize vehicleSizeType;

    TrainSize(final int capacity, final VehicleSize vehicleSizeType){
        this.capacity = capacity;
        this.vehicleSizeType = vehicleSizeType;
    }

    public int getCapacity() {
        return capacity;
    }

    public VehicleSize getVehicleSizeType() {
        return vehicleSizeType;
    }
}


