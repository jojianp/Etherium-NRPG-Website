package org.etherium.ethsite;

import java.lang.reflect.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EthsiteApplicationTest {
    @Test
    void testMainMethod() {
        String[] args = {};
        
        assertThrows(IllegalArgumentException.class, () -> {
            EthsiteApplication.main(args);
        });
    }

    @Test
    void testPrivateConstructorThrowsException() throws NoSuchMethodException, ReflectiveOperationException {
        Constructor<EthsiteApplication> constructor = EthsiteApplication.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            constructor.newInstance();
        });

        assertTrue(exception.getCause() instanceof UnsupportedOperationException);
    }
}
