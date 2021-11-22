
package com.EmirMuhamadZaidJmartAK.controller;
import com.EmirMuhamadZaidJmartAK.dbjson.*;
import com.EmirMuhamadZaidJmartAK.ObjectPoolThread;
import com.EmirMuhamadZaidJmartAK.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController {
    public static final long DELIVERED_LIMIT_MS = 100;
    public static final long ON_DELIVERY_LIMIT_MS = 100;
    public static final long ON_PROGRESS_LIMIT_MS = 100;
    public static final long WAITING_CONF_LIMIT_MS = 100;
    @JsonAutowired(value = Payment.class, filepath = "Payment.json")
    public static JsonTable<Payment> paymentTable;
    ObjectPoolThread<Payment> poolThread;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/create")
    @ResponseBody Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmnetPlan
            )
    {
        return null;
    }

    @PostMapping(" /{id}/accept ")
    @ResponseBody boolean accept
            (
                    @RequestParam int id
            )
    {
        return false;
    }

    @PostMapping(" /{id}/cancel ")
    @ResponseBody boolean cancel
            (
                    @RequestParam int id
            )
    {
        return false;
    }

    @PostMapping(" /{id}/submit ")
    @ResponseBody boolean submit
            (
                    @RequestParam int id,
                    @RequestParam String receipt
            )
    {
        return false;
    }

    private static boolean timekeeper(Payment payment){
        return false;
    }
}