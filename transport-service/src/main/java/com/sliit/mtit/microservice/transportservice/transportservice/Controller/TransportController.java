package com.sliit.mtit.microservice.transportservice.transportservice.Controller;

import com.sliit.mtit.microservice.transportservice.transportservice.Model.Transport;
import com.sliit.mtit.microservice.transportservice.transportservice.Model.TransportRequest;
import com.sliit.mtit.microservice.transportservice.transportservice.Model.TransportResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transport")
public class TransportController {

    //Stores all the transport data
    private static List<Transport> transportList =  new ArrayList<>();

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody
    TransportResponse createTransport(@RequestBody TransportRequest transportRequest){

        System.out.println("Transport Controller => Create Transport => Request => " + transportRequest.toString());

        String message = "Message: ";
        Boolean status = false;
        Transport transport = new Transport();
        TransportResponse transportResponse = new TransportResponse();

        // check the transport is already added by transport mode
        for(Transport temp : transportList){
            if(temp.getTransportMode().equals(transportRequest.getTransportMode())){
                message += "Transport is already added";
                status = true;
            }
        }

        // check for transport type
        if(transportRequest.getTransportType().equals("local") || transportRequest.getTransportType().equals("out")){
            // This means transport type is correct
        }
        else{
            message += "Invalid transport type";
            status = true;
        }

        transportResponse.setId(UUID.randomUUID().toString());
        // creation Transport
        if(status == true){
            transportResponse.setMessage(message);
        }
        else{
            int id = transportList.size() + 1;
            transport.setTrasportId(id);
            transport.setTransportType(transportRequest.getTransportType());
            transport.setTransportMode(transportRequest.getTransportMode());
            transport.setCharges(transportRequest.getCharges());

            // adding the data to the list
            transportList.add(transport);

            // setting the success message
            message += "Successfully created the trasnport details || ";
            transportResponse.setMessage(message);

            //Displaying the trasnportList
            for(Transport temp : transportList){
                System.out.println("### Transport details from List ###");
                System.out.println(temp.toString());
            }
        }

        return transportResponse;
    }

    @GetMapping("viewTransportDetailsByTransportId-{transportId}")
    public @ResponseBody
    Transport viewTransportDetailsByTransportId(@PathVariable int transportId){

        System.out.println("Transport Controller => viewTransportDetailsByTransportId => Request => " + transportId);

        Transport transport = new Transport(0, "", "", 0);
        for(Transport temp : transportList){
            if(temp.getTrasportId() == transportId){
                return temp;
            }
        }
        return transport;
    }
}
