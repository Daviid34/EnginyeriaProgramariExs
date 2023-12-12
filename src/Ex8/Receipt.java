package Ex8;

import Ex3.IsClosedException;
import Ex5.DoesNotExistException;
import Ex8.ProductsDB;

import java.math.BigDecimal;
import java.util.HashMap;

public class Receipt extends ReceiptPrinter {
    private ProductsDB central;
    private HashMap<String, Ex8.ProductsDB.ProductDTO> receipt;
    private BigDecimal total;
    private boolean closed;
    public ReceiptPrinter printer;

    Receipt(ProductsDB central) {
        printer = new ReceiptPrinter();
        receipt = new HashMap<>();
        this.central = central;
        total = BigDecimal.valueOf(0);
        closed = false;
    }

    public void addLine(String productID, int numUnits) throws IsClosedException, DoesNotExistException {
        if (closed) throw new IsClosedException("Error");
        BigDecimal price = central.getPrice(productID);
        if (price == null) throw new DoesNotExistException("Error");
        Ex8.ProductsDB.ProductDTO product = new Ex8.ProductsDB.ProductDTO();
        product.setProductID(productID);
        product.setPrice(price);
        product.setDescription(receipt.get(productID).getDescription());
        printer.addProduct(product.getDescription(), numUnits, central.getPrice(productID));
        receipt.put(productID, product);
        total = total.add(price.multiply(BigDecimal.valueOf(numUnits)));
    }

    public void addTaxes(BigDecimal percent) throws  IsClosedException{
        if (closed) throw new IsClosedException("Error");
        total = total.multiply(percent);
        printer.addTaxes(percent);
        closed = true;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
