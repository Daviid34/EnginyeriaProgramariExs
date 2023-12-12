package Ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

class ReceiptTestBasic {
    Receipt recibo;

    @BeforeEach
    void initReceipt() throws IsClosedException {
        recibo = new Receipt();
        recibo.addLine(BigDecimal.valueOf(2.5), 4);
    }

    @Test
    void addLineTest() {
        BigDecimal result = BigDecimal.valueOf(10.0);
        assertEquals(result, recibo.total);
    }

    @Test
    void getTotalTest() {
        assertEquals(BigDecimal.valueOf(10.0), recibo.getTotal());
    }

    @Test
    void addTaxesTest() throws IsClosedException {
        recibo.addTaxes(BigDecimal.valueOf(0.21));
        BigDecimal tax = BigDecimal.valueOf(10.0).multiply(BigDecimal.valueOf(0.21));
        BigDecimal total = tax.add(BigDecimal.valueOf(10.0));
        assertEquals(total, recibo.getTotal());
    }
}