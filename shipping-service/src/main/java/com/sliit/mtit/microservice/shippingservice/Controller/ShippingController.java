package com.sliit.mtit.microservice.shippingservice.Controller;

import com.sliit.mtit.microservice.shippingservice.Model.Shipping;
import com.sliit.mtit.microservice.shippingservice.Model.ShippingRequest;
import com.sliit.mtit.microservice.shippingservice.Model.ShippingResponse;
import com.sliit.mtit.microservice.shippingservice.Model.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private RestTemplate restTemplate;

    //Stores all the shipping data
    private static List<Shipping> shippingList =  new ArrayList<>();

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ShippingResponse createShipping(@RequestBody ShippingRequest shippingRequest){

        System.out.println("Shipping Controller => Create Shipping => Request => " + shippingRequest.toString());

        String message = "Message: ";
        Boolean status = false;
        Shipping shipping = new Shipping();
        ShippingResponse shippingResponse = new ShippingResponse();

        // Check valid order


        // Check valid shipping type
        if(shippingRequest.getTransportType().equals("no") || shippingRequest.getTransportType().equals("yes")){
            //Transport type is correct
        }
        else{
            message += "Invalid shipping type || ";
            status = true;
        }

        // check valid transport
        String url1 = "http://localhost:8082/transport/viewTransportDetailsByTransportId-" + shippingRequest.getTransportId();
        ResponseEntity<Transport> transport = restTemplate.getForEntity(url1, Transport.class);

        if(shippingRequest.getTransportType().equals("yes") && transport.getBody().getTrasportId() == 0){
            status = true;
            message += "Invalid transport Id || ";
        }

        // check the order is already placed
        for(Shipping temp : shippingList){
            if(temp.getOrderId() == shippingRequest.getOrderId()){
                //This shipping is invalid duplicate order
                message += "Order already added || ";
                shippingResponse.setMessage(message);
                status = true;
            }
        }

        shippingResponse.setId(UUID.randomUUID().toString());
        // creation Shipping
        if(status == true){
            shippingResponse.setMessage(message);
        }
        else{
            // Adding data to the shipping object
            int id = shippingList.size() + 1;
            shipping.setShippingId(id);
            shipping.setOrderId(shippingRequest.getOrderId());
            shipping.setTransportType(shippingRequest.getTransportType());
            if(shipping.getTransportType().equals("none")){
                shipping.setTransportId(0);
                shipping.setAddress("");
            }
            else{
                shipping.setTransportId(shippingRequest.getTransportId());
                shipping.setAddress(shippingRequest.getAddress());
            }

            // adding the data to the list
            shippingList.add(shipping);

            // setting the success message
            message += "Successfully created the shipping details || ";
            shippingResponse.setMessage(message);

            //Displaying the shippingList
            for(Shipping temp : shippingList){
                System.out.println("### Shipping details from List ###");
                System.out.println(temp.toString());
            }
        }

        return shippingResponse;
    }

    @GetMapping("viewShippingDetailsByShippingId-{shippingId}")
    public @ResponseBody
    Shipping viewShippingDetailsByShippingId(@PathVariable int shippingId){

        System.out.println("Shipping Controller => viewShippingDetailsByShippingId => Request => " + shippingId);

        Shipping shipping = new Shipping(0, 0, "", 0, "");
        for(Shipping temp : shippingList){
            if(temp.getShippingId() == shippingId){
                return temp;
            }
        }
        return shipping;
    }

    @GetMapping("viewShippingDetailsByOrderId-{orderId}")
    public @ResponseBody
    Shipping viewShippingDetailsByOrderId(@PathVariable int orderId){

        System.out.println("Shipping Controller => viewShippingDetailsByOrderId => Request => " + orderId);

        Shipping shipping = new Shipping(0, 0, "", 0, "");
        for(Shipping temp : shippingList){
            if(temp.getOrderId() == orderId){
                return temp;
            }
        }
        return shipping;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}