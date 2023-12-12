package Ex3;

import java.math.BigDecimal;

public class Receipt implements ReceiptInterface {
    BigDecimal total;
    boolean closed;
    public Receipt() {
        total = BigDecimal.valueOf(0);
        closed = false;
    }

    public void addLine(BigDecimal pricePerUnit, int numUnits) throws IsClosedException {
        if (closed) throw new IsClosedException("Error");
        BigDecimal quantity = pricePerUnit.multiply(BigDecimal.valueOf(numUnits));
        total = total.add(quantity);
    }

    public void addTaxes(BigDecimal percent) throws IsClosedException {
        if (closed) throw new IsClosedException("Error");
        BigDecimal tax = total.multiply(percent);
        total = total.add(tax);
        closed = true;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
