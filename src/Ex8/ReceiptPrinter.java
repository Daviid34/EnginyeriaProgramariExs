package Ex8;

import Ex3.IsClosedException;

import java.math.BigDecimal;
import java.util.HashMap;

public class ReceiptPrinter implements ReceiptPrinterInterface {
    private String receipt = "";
    private HashMap<String, ProductsDB.ProductDTO> hashMap;
    private BigDecimal total = BigDecimal.valueOf(0);

    public void init() {
        receipt += "Acme S.A.\n";
    }

    public void addProduct(String description, int quantity, BigDecimal price) {
        String product = "";
        product += description + "  " + String.valueOf(quantity) + "    " + String.valueOf(price);
        receipt += product +"\n";
        total = total.add(price.multiply(BigDecimal.valueOf(quantity)));
    }

    @Override
    public void addTaxes(BigDecimal taxes) throws IsClosedException {
        BigDecimal taxesValue = taxes.multiply(total);
        total = total.add(taxesValue);
        receipt +=  "TAXES  " + String.valueOf(taxesValue) + "\n";
    }

    public void print() {
        receipt += "-------------------------------------------\n" + "TOTAL " + String.valueOf(total);
    }

    public String getOutput() {
        return receipt;
    }
}
