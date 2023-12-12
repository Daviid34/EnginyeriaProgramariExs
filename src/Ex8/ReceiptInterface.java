package Ex8;

import Ex3.IsClosedException;
import Ex5.DoesNotExistException;

import java.math.BigDecimal;

public interface ReceiptInterface {
    void addLine(String productID, int numUnits) throws IsClosedException, DoesNotExistException;
    void addTaxes(BigDecimal percent) throws IsClosedException;
    BigDecimal getTotal();
}
