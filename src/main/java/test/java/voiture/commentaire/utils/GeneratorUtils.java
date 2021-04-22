package test.java.voiture.commentaire.utils;


import java.util.UUID;

/**
 * Utility class for generating values.
 */
public final class GeneratorUtils {
    /**
     * Generates a unique identifier.
     *
     * @return the UUID.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

}
