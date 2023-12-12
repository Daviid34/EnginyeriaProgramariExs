package Ex3;

import java.math.BigDecimal;

public interface ReceiptInterface {
    void addLine (BigDecimal pricePerUnit, int numUnits) throws IsClosedException;
    void addTaxes (BigDecimal percent) throws IsClosedException;
    BigDecimal getTotal();
}
