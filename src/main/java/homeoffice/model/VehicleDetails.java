package homeoffice.model;

/**
 * Created by musti on 05/06/2018.
 */
public class VehicleDetails {
    private String id;
    private String vehicleMake;
    private String colour;

    public VehicleDetails() {
    }
    public VehicleDetails(String id, String vehicleMake, String colour) {
        super();
        this.id = id;
        this.vehicleMake = vehicleMake;
        this.colour = colour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }



    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }



  /*  @Override
    public String toString() {
        return "VehicleDetails [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
    }*/

}
