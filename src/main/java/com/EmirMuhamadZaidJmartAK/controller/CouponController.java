package com.EmirMuhamadZaidJmartAK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmirMuhamadZaidJmartAK.Algorithm;
import com.EmirMuhamadZaidJmartAK.Coupon;
import com.EmirMuhamadZaidJmartAK.Product;
import com.EmirMuhamadZaidJmartAK.dbjson.JsonAutowired;
import com.EmirMuhamadZaidJmartAK.dbjson.JsonTable;

/**
 * CouponController class
 * GET and POST request is handled here for /coupon
 */

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>
{
    @JsonAutowired(value = Coupon.class,filepath = "Coupon.json")
    public static JsonTable<Coupon> couponTable;

    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

    @GetMapping("/{id}/canApply")
    @ResponseBody
    boolean canApply
            (
                    @RequestParam int id,
                    @RequestParam double price,
                    @RequestParam double discount
            )
    {
        for(Coupon each : couponTable)
        {
            if (each.id == id) {
                return each.canApply(price, discount);
            }
        }
        return false;
    }

    @GetMapping("/{id}/isUsed")
    @ResponseBody
    boolean isUsed
            (
                    @RequestParam int id
            )
    {
        for(Coupon each : couponTable)
        {
            if (each.id == id) {
                return each.isUsed();
            }
        }
        return false;
    }

    @GetMapping("/getAvailable")
    @ResponseBody
    List<Coupon> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(couponTable, page, pageSize, pred-> !pred.isUsed());
    }

}