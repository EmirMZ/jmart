
package com.EmirMuhamadZaidJmartAK.controller;
import com.EmirMuhamadZaidJmartAK.dbjson.*;
import com.EmirMuhamadZaidJmartAK.ObjectPoolThread;
import com.EmirMuhamadZaidJmartAK.Payment;
import com.EmirMuhamadZaidJmartAK.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;


/**
 * PaymentController Class
 * GET and POST request is handled here for /payment
 */

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 100;
    public static final long ON_DELIVERY_LIMIT_MS = 100;
    public static final long ON_PROGRESS_LIMIT_MS = 100;
    public static final long WAITING_CONF_LIMIT_MS = 100;
    @JsonAutowired(value = Payment.class, filepath = "Payment.json")
    public static JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    /**
     * create a new payment to purchase a product
     * @param buyerId
     * @param productId
     * @param productCount
     * @param shipmentAddress
     * @param shipmentPlan
     * @return
     */
    @PostMapping("/create")
    @ResponseBody Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmentPlan
            )
    {
        Product product1 = Algorithm.<Product>find(ProductController.productTable,e -> e.id == productId);
        Account account1 = Algorithm.<Account>find(AccountController.accountTable,e -> e.id == buyerId);
        if(product1 != null && account1 != null ){
            Payment payment = new Payment(buyerId,productId,productCount,new Shipment(shipmentAddress,0,shipmentPlan,null));
            if(payment.getTotalPay(product1) > account1.balance){
                return null;
            }else {
                account1.balance -= payment.getTotalPay(product1);
                payment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION," "));
                paymentTable.add(payment);
                return payment;
            }
        }else {
            return null;
        }
    }

    /**
     * accept after requesting a payment to processing and packaging
     *
     * @param id
     * @return
     */
    @PostMapping("/{id}/accept")
    public boolean accept
            (
                    @PathVariable Integer id
            )
    {
        for(Payment each : paymentTable){
            if(each.id == id){
                if(each.history.get(each.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION){
                    each.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, null));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * request a cancellation for a certain payment id
     * @param id
     * @return
     */

    @PostMapping(" /{id}/cancel ")
    public boolean cancel(
            @PathVariable int id
    )
    {
        for (Payment iterate : paymentTable) {
            if (iterate.id == id) {
                if (iterate.history.get(iterate.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION) {
                    iterate.history.add(new Payment.Record(Invoice.Status.CANCELLED, null));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * submit the request for delivery
     * @param id
     * @param receipt
     * @return
     */
    @PostMapping(" /{id}/submit ")
    @ResponseBody boolean submit
            (
                    @RequestParam int id,
                    @RequestParam String receipt
            )
    {
        for(Payment each : paymentTable){
            if(each.id == id){
                if(each.history.get(each.history.size()-1).status == Invoice.Status.ON_PROGRESS){
                    if(!receipt.isBlank()){
                        each.shipment.receipt = receipt;
                        each.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, null));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * method to get Payment from a certain ID
     * @param id
     * @return
     */
    @Override
    public Payment getById(int id) {
        return BasicGetController.super.getById(id);
    }

    /**
     * request an entire page for payments
     * @param page
     * @param pageSize
     * @return
     */

    @Override
    public List<Payment> getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }

}