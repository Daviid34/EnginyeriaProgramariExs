package Ex8;

import Ex5.DoesNotExistException;

import java.math.BigDecimal;
import java.util.HashMap;

public class ProductsDB {
    public static class ProductDTO {
        private String productID;
        private String description;
        private BigDecimal price;

        public String getProductID() {return productID;}
        public String getDescription() {return description;}
        public BigDecimal getPrice() {return price;}

        public void setProductID(String id) {productID = id;}
        public void setDescription(String desc) {description = desc;}
        public void setPrice (BigDecimal p) {price = p;}
    }

    private HashMap<String, ProductDTO> hash;
    public ProductsDB() {
        hash = new HashMap<>();
    }
    public BigDecimal getPrice(String productID) throws DoesNotExistException {
        return hash.get(productID).getPrice();
    }

    public void add(String productID, String description,BigDecimal price){
        ProductDTO product = new ProductDTO();
        product.setDescription(description);
        product.setPrice(price);
        product.setProductID(productID);
        hash.put(productID, product);
    }
}