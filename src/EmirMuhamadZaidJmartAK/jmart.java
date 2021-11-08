package EmirMuhamadZaidJmartAK;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class jmart {

    class Country {
    public String name;
        public int population;
        public List<String> listOfStates;
    }



    public static void main (String[] args) {
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);

        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);


        try{
            List<Product> list = read("./json/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 14000.0, 15000.0);
            filtered.forEach(Product -> System.out.println(Product.price));

            List<Product> filteredByName = filterByName(list, "gtx", 1, 5);
            filteredByName.forEach(product -> System.out.println(product.name));
            List<Product> filteredById = filterByAccountId(list, 1, 0, 5);
            filteredById.forEach(product -> System.out.println(product.name));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Product>>() {
        }.  getType();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        List<Product> returnList = gson.fromJson(br, userListType);
        return returnList;
    }




    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        if (minPrice <= 0) {
            return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice);
        }
        else if (maxPrice <= 0) {
            return Algorithm.<Product>collect(list, prod -> prod.price >= minPrice);
        }
        return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice && prod.price >= minPrice);
    }

    public static List<Product> filterByCategory (List<Product>list, ProductCategory category){
        List<Product> tempHasil = new ArrayList<Product>();

        for(Product temp : list){
            if(temp.category == category){
                tempHasil.add(temp);
            }
        }
        return tempHasil;
    }

    //private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
    //    return list.stream().filter(i -> pred.predicate(i)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    //}
    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        int iteration = 0;
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<Product> pageList = new ArrayList<>(pageSize);

        for (; iteration < list.size() && occurences < startingIdx; ++iteration) {
            if (pred.predicate(list.get(iteration))) {
                ++occurences;
            }
        }
        for (int i = iteration; i < list.size() && pageList.size() < pageSize; ++i) {
            if (pred.predicate(list.get(i))) {
                pageList.add(list.get(i));
            }
        }
        return pageList;
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = i -> (i.name.toLowerCase().contains(search.toLowerCase()));
    return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = i -> (i.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }
            /* System.out.println("Hello world");
            String filepath = "./json/city.json";
            Gson gson = new Gson();
            try {
                BufferedReader br = new BufferedReader(new FileReader(filepath));
                Country input = gson.fromJson(br, Country.class);
                System.out.println("name " + input.name);
                System.out.println("population: " + input.population);
                System.out.println("states:");
                input.listOfStates.forEach(state -> System.out.println(state));
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        */

        public static Product createProduct()
        {
            return null;
        }

        public static Shipment createShipmentDuration(){
            return null;
        }

        public static Coupon createCoupun()
        {
            return null;
        }


}
