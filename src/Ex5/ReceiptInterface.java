package Ex5;

import Ex3.IsClosedException;

import java.math.BigDecimal;

public interface ReceiptInterface {
    void addLine(String productID, int numUnits) throws IsClosedException, DoesNotExistException;
    void addTaxes(BigDecimal percent) throws IsClosedException;
    BigDecimal getTotal();
}
