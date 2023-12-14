package Ex5;

import Ex3.IsClosedException;

import java.math.BigDecimal;

public class Receipt implements ReceiptInterface{
    private ProductsDB central;
    private BigDecimal total;
    private boolean closed;

    Receipt(ProductsDB central) {
        this.central = central;
        total = BigDecimal.valueOf(0);
        closed = false;
    }

    public void addLine(String productID, int numUnits) throws IsClosedException, DoesNotExistException {
        if (closed) throw new IsClosedException("Error");
        BigDecimal price = central.getPrice(productID);
        if (price == null) throw new DoesNotExistException("Error");
        total = total.add(price.multiply(BigDecimal.valueOf(numUnits)));
    }

    public void addTaxes(BigDecimal percent) throws IsClosedException {
        if (closed) throw new IsClosedException("Error");
        total = total.multiply(percent);
        closed = true;
    }
}

