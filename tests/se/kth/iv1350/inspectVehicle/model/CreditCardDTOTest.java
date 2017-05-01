package se.kth.iv1350.inspectVehicle.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 01/05/17.
 */
class CreditCardDTOTest {
    private CreditCardDTO creditCardDTO;

    @BeforeEach
    void setUp() {
        creditCardDTO = new CreditCardDTO("101", "4524424456765434", "0518");
    }

    @AfterEach
    void tearDown() {
        creditCardDTO = null;
    }

    @Test
    void getCvc() {
        assertEquals("101", creditCardDTO.getCvc());
    }

    @Test
    void getCardNumber() {
        assertEquals("4524424456765434", creditCardDTO.getCardNumber());
    }

    @Test
    void getExpiryDate() {
        assertEquals("0518", creditCardDTO.getExpiryDate());
    }

}