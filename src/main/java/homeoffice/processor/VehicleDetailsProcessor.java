package homeoffice.processor;

import homeoffice.model.VehicleDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by musti on 05/06/2018.
 */
public class VehicleDetailsProcessor implements ItemProcessor<VehicleDetails, VehicleDetails> {

    private static final Logger log = LoggerFactory.getLogger(VehicleDetailsProcessor.class);

    @Override
    public VehicleDetails process(final VehicleDetails VehicleDetails) throws Exception {
        final String id = VehicleDetails.getId().toUpperCase();
        final String vehicleMake = VehicleDetails.getVehicleMake().toUpperCase();
        final String colour = VehicleDetails.getColour().toUpperCase();


        final VehicleDetails transformedVehicleDetails = new VehicleDetails(id, vehicleMake,colour);

        log.info("Converting (" + VehicleDetails + ") into (" + transformedVehicleDetails + ")");

        return transformedVehicleDetails;
    }

}
