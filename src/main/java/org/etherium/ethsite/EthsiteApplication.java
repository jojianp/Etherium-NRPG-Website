package org.etherium.ethsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Ethsite application.
 */
@SpringBootApplication
public class EthsiteApplication {
    private EthsiteApplication() {
        throw new UnsupportedOperationException(
            "Utility class should not be instantiated"
        );
    }

    /**
     * Main entry point for the Ethsite application.
     * @param args Command-line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(
            EthsiteApplication.class,
            args
        );
    }
}
