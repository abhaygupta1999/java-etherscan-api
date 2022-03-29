package io.api.etherscan.statistic;

import io.api.ApiRunner;
import io.api.etherscan.error.InvalidAddressException;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 03.11.2018
 */
class StatisticTokenSupplyApiTest extends ApiRunner {

    @Test
    void correct() {
        BigInteger supply = getApi().stats().supply("0x57d90b64a1a57749b0f932f1a3395792e12e7055");
        assertNotNull(supply);
        assertNotEquals(BigInteger.ZERO, supply);
    }

    @Test
    void invalidParamWithError() {
        assertThrows(InvalidAddressException.class, () -> getApi().stats().supply("0x7d90b64a1a57749b0f932f1a3395792e12e7055"));
    }

    @Test
    void correctParamWithEmptyExpectedResult() {
        BigInteger supply = getApi().stats().supply("0x51d90b64a1a57749b0f932f1a3395792e12e7055");
        assertNotNull(supply);
        assertEquals(0, supply.intValue());
    }
}
