package com.EmirMuhamadZaidJmartAK.controller;

import com.EmirMuhamadZaidJmartAK.Algorithm;
import com.EmirMuhamadZaidJmartAK.Product;
import com.EmirMuhamadZaidJmartAK.dbjson.JsonAutowired;
import com.EmirMuhamadZaidJmartAK.dbjson.JsonTable;
import com.EmirMuhamadZaidJmartAK.ProductCategory;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * ProductController Class
 * GET and POST request is handled here for /product
 */

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>
{
    @JsonAutowired(value = Product.class,filepath = "Product.json")
    public static JsonTable<Product> productTable;

    @Override
    public JsonTable<Product> getJsonTable() {
        return productTable;
    }


    /**
     * getProductByStore
     * @param id
     * @param page
     * @param pageSize
     * @return
     */

    @GetMapping("/{id}/store")
    @ResponseBody
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }

    /**
     * create a product with the provided parameters
     * @param accountId
     * @param name
     * @param weight
     * @param conditionUsed
     * @param price
     * @param discount
     * @param category
     * @param shipmentPlans
     * @return
     */

    @PostMapping("/create")
    @ResponseBody
    Product create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans
            )
    {
        for(Product each : productTable) {
            if (each.accountId == accountId){
                Product product =  new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
    }

    /**
     * filter products with the provided parameters
     * @param page
     * @param pageSize
     * @param accountId
     * @param search
     * @param minPrice
     * @param maxPrice
     * @param category
     * @return
     */
    @GetMapping("/getFiltered")
    @ResponseBody
    List<Product> getProductByFilter
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @RequestParam int accountId,
                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category
            )
    {
        List<Product> tempProduct = null;
        for (Product each : productTable) {
            if (each.accountId == accountId)
                if (each.name.contains(search))
                    if (minPrice <= each.price)
                        if (maxPrice >= each.price)
                            if (each.category == category)
                                tempProduct.add(each);
        }
        return tempProduct;
    }
}