package EmirMuhamadZaidJmartAK;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

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
        }

        public static List<Product> filterByPrice(List<Product> list, double minPrice,double maxPrice){
            List<Product> result = new ArrayList<Product>();

            for(Product product : list){
                if (minPrice != 0.0 && product.price < minPrice){
                    continue;
                }
                if (minPrice != 0.0 && product.price > maxPrice){
                    continue;
                }

            }
            return result;
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
