package Ex8;

import Ex3.IsClosedException;
import Ex5.DoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptPrinterTestBasic {
    private ReceiptPrinter printer;
    @BeforeEach
    void init(){
        printer = new ReceiptPrinter();
    }

    @Test
    void basicLinePrint() throws DoesNotExistException, IsClosedException {
        printer.init();
        printer.addProduct("Pollo", 10, BigDecimal.valueOf(2.4));
        printer.addProduct("Leche", 2, BigDecimal.valueOf(1.25));
        printer.addTaxes(BigDecimal.valueOf(0.21));
        printer.print();
        String result = printer.getOutput();
        System.out.print(result);
    }

}