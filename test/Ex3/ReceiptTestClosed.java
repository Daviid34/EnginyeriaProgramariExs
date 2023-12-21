package Ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReceiptTestClosed {
    Receipt receipt;
    //usted es un mamahuevo mamahuevaso

    @BeforeEach
    void initReceipt() throws IsClosedException {
        receipt = new Receipt();
        receipt.addTaxes(BigDecimal.valueOf(0.1));
    }

    @Test
    void addLineClosed() throws IsClosedException {
        assertThrows(IsClosedException.class, () -> {receipt.addLine(BigDecimal.valueOf(1.1), 2);});
    }

    @Test
    void addTaxClosed() throws IsClosedException {
        assertThrows(IsClosedException.class, () -> {receipt.addTaxes(BigDecimal.valueOf(0.1));});
    }

    @Test
    void getTotalClosed() {
        assertEquals(BigDecimal.valueOf(0.0), receipt.getTotal());
    }
}