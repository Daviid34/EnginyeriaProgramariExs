package Ex5;

import Ex3.IsClosedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTestBasic {
    private ProductsDB central;
    private Receipt receipt;
    private BigDecimal price;
    private BigDecimal units;
    private BigDecimal total;

    @BeforeEach
    void initDataBase() throws DoesNotExistException, IsClosedException {
        central = new ProductsDB();
        central.add("Pollo", BigDecimal.valueOf(8.6));
        central.add("KangreBurguer", BigDecimal.valueOf(1.0));
        receipt = new Receipt(central);
        receipt.addLine("Pollo", 23);
        BigDecimal price = BigDecimal.valueOf(8.6);
        BigDecimal units = BigDecimal.valueOf(23);
        total = price.multiply(units);
    }


    @Test
    void addLineAndGetTotalTest() throws IsClosedException, DoesNotExistException {
        assertEquals(total, receipt.getTotal());
    }

    @Test
    void addLineDoesNotExistException() throws IsClosedException, DoesNotExistException {
        assertThrows(DoesNotExistException.class, () -> {receipt.addLine("Patata Brava", 1);});
    }

    @Test
    void addTaxes() throws IsClosedException {
        BigDecimal tax = BigDecimal.valueOf(0.2);
        receipt.addTaxes(tax);
        assertEquals(total.multiply(tax),receipt.getTotal());
    }
}