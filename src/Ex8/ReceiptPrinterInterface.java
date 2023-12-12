package Ex8;

import Ex3.IsClosedException;

import java.math.BigDecimal;

public interface ReceiptPrinterInterface {
    void init();
    void addProduct(String description, int quantity, BigDecimal price);
    void addTaxes(BigDecimal taxes) throws IsClosedException;
    void print();
    String getOutput();
}
