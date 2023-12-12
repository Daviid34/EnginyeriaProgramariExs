package Ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTestEmpty {
    Receipt receta;

    @BeforeEach
    void initReceipt() {
        receta = new Receipt();
    }

    @Test
    void getTotalEmpty() {
        assertEquals(BigDecimal.valueOf(0), receta.getTotal());
    }

    @Test
    void addTaxesEmpty() throws IsClosedException {
        receta.addTaxes(BigDecimal.valueOf(0.21));
        BigDecimal expected = BigDecimal.valueOf(0).multiply(BigDecimal.valueOf(0.21));
        assertEquals(expected, receta.getTotal());
    }
}