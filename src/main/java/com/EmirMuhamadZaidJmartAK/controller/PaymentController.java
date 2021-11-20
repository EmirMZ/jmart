
package com.EmirMuhamadZaidJmartAK.controller;
import com.EmirMuhamadZaidJmartAK.dbjson.*;
import com.EmirMuhamadZaidJmartAK.ObjectPoolThread;
import com.EmirMuhamadZaidJmartAK.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    public static JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread;
    public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERIY_LIMIT_MS = 0;
    public static final long ON_PROGRESS_LIMIT_MS = 0;
    public static final long WAITING_CONF_LIMIT_MS = 0;


    @Override
    public JsonTable<Payment> getJsonTable() {
        
    	
    	return null;
    }

    @PostMapping
    ("/{id}/accept")
    public boolean accept(int id) {
        
    	
    	return false;
    }

    @PostMapping
    ("/{id}/cancel")
    public boolean cancel(int id) {
        
    	
    	return false;
    }

    @PostMapping
    ("/create")
    public Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
        
    	
    	return null;
    }

    @PostMapping
    ("/submit")
    public boolean submit(int id, String receipt) {
        
    	
    	return false;
    }

    private static boolean timekeeper(Payment payment) {
        
    	
    	return false;
    }
}