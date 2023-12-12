package Ex5;

import java.math.BigDecimal;
import java.util.HashMap;

public class ProductsDB {
    private HashMap<String, BigDecimal> hash;
    public ProductsDB() {
        hash = new HashMap<>();
    }
    public BigDecimal getPrice(String productID) throws DoesNotExistException {
        return hash.get(productID);
    }

    public void add(String productID, BigDecimal price){
        hash.put(productID, price);
    }
}
