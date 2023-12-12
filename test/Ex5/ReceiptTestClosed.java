package Ex5;

import Ex3.IsClosedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTestClosed {
    private ProductsDB central;
    private Receipt receipt;

    @BeforeEach
    void initClosedReceipt() throws IsClosedException {
        central = new ProductsDB();
        receipt = new Receipt(central);
        receipt.addTaxes(BigDecimal.valueOf(0.0));
    }

    @Test
    void addLineClosed() {
        assertThrows(IsClosedException.class, () -> {receipt.addLine("Pollo", 1);});
    }

    @Test
    void addTaxesClosed() {
        assertThrows(IsClosedException.class, () -> {receipt.addTaxes(BigDecimal.valueOf(0.1));});
    }

    @Test
    void getTotalClosed() {
        assertEquals(BigDecimal.valueOf(0.0), receipt.getTotal());
    }

}