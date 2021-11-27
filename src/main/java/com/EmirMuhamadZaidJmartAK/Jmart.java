package com.EmirMuhamadZaidJmartAK;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EmirMuhamadZaidJmartAK.dbjson.JsonDBEngine;

@SpringBootApplication
public class Jmart {
	
    public static long DELIVERED_LIMIT_MS = 10;
    public static long ON_DELIVERY_LIMIT_MS = 10;
    public static long ON_PROGRESS_LIMIT_MS = 20;
    public static long WAITING_CONF_LIMIT_MS = 10;


    public static void main (String[] args) {
    	
    	JsonDBEngine.Run(Jmart.class);
    	SpringApplication.run(Jmart.class, args);
    	Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    	
    	
    	
    	/*try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class,"C:/Users/zocom/OneDrive/UI-DESKTOP-6NJSBHG/Data UI/Semester 3/OOP/praktikum/jmartintellij/json/randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", jmart::paymentTimekeeper);
            paymentPool.start();
            table.forEach(payment -> paymentPool.add(payment));
            while (paymentPool.size() != 0);
            paymentPool.exit();
            while (paymentPool.isAlive());
            System.out.println("Thread exit successfully");
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment.history);
                System.out.println(history);
            });
        }
        catch (Throwable t) {
            t.printStackTrace();
        }*/
    }
    public static boolean paymentTimekeeper(Payment payment){
        long startTime = System.currentTimeMillis();
        if((System.currentTimeMillis() - startTime > WAITING_CONF_LIMIT_MS) && payment.history.equals(Status.WAITING_CONFIRMATION)){
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "ERROR"));
        }
        else if(System.currentTimeMillis() - startTime > ON_PROGRESS_LIMIT_MS && payment.history.equals(Status.ON_PROGRESS)) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(System.currentTimeMillis() - startTime > ON_DELIVERY_LIMIT_MS && payment.history.equals(Status.ON_DELIVERY)) {
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
        }
        else if(System.currentTimeMillis() - startTime > DELIVERED_LIMIT_MS && payment.history.equals(Status.DELIVERED)) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "DELIVERED"));
            return true;
        }
        return false;
    }
}









//public class jmart {

/*
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

            String filepath = "/a/b/c/account.json";

            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name","email","password",0));
            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString()));
            /*List<Product> list = read("./json/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 14000.0, 15000.0);
            filtered.forEach(Product -> System.out.println(Product.price));

            List<Product> filteredByName = filterByName(list, "gtx", 1, 5);
            filteredByName.forEach(product -> System.out.println(product.name));
            List<Product> filteredById = filterByAccountId(list, 1, 0, 5);
            filteredById.forEach(product -> System.out.println(product.name));*/
  //      }

        /*
        catch (Throwable t){
            t.printStackTrace();
        }
    }*/

/*
    public static List<Product> read(String filepath) throws FileNotFoundException {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Product>>() {
        }.  getType();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        List<Product> returnList = gson.fromJson(br, userListType);
        return returnList;
    }
*/


/*
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
    }*/

    //private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
    //    return list.stream().filter(i -> pred.predicate(i)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    //}
    /*
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
    }*/
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
/*
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
        }*/


//}
