package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public enum RoundingMode {
    UP(BigDecimal.ROUND_UP),
    DOWN(BigDecimal.ROUND_DOWN),
    CEILING(BigDecimal.ROUND_CEILING),
    FLOOR(BigDecimal.ROUND_FLOOR),
    HALF_UP(BigDecimal.ROUND_HALF_UP),
    HALF_DOWN(BigDecimal.ROUND_HALF_DOWN),
    HALF_EVEN(BigDecimal.ROUND_HALF_EVEN),
    UNNECESSARY(BigDecimal.ROUND_UNNECESSARY);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.074 -0500", hash_original_field = "A6B6D476E01E26AAC9526DF3BA3C0145", hash_generated_field = "DC361F915E73849FAA9FE6709DAC24FB")

    private  int bigDecimalRM;

    /** It sets the old constant. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.076 -0500", hash_original_method = "6D45D2DEFFB808AEDEAB8E27F1390543", hash_generated_method = "6D45D2DEFFB808AEDEAB8E27F1390543")
        RoundingMode(int rm) {
        bigDecimalRM = rm;
    }

    /**
     * Converts rounding mode constants from class {@code BigDecimal} into
     * {@code RoundingMode} values.
     *
     * @param mode
     *            rounding mode constant as defined in class {@code BigDecimal}
     * @return corresponding rounding mode object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.077 -0500", hash_original_method = "8AF09B5D366A401DF81A235731D1CF87", hash_generated_method = "EE63D446A942918C26C550E4D9CD88D0")
        public static RoundingMode valueOf(int mode) {
        switch (mode) {
            case BigDecimal.ROUND_CEILING:
                return CEILING;
            case BigDecimal.ROUND_DOWN:
                return DOWN;
            case BigDecimal.ROUND_FLOOR:
                return FLOOR;
            case BigDecimal.ROUND_HALF_DOWN:
                return HALF_DOWN;
            case BigDecimal.ROUND_HALF_EVEN:
                return HALF_EVEN;
            case BigDecimal.ROUND_HALF_UP:
                return HALF_UP;
            case BigDecimal.ROUND_UNNECESSARY:
                return UNNECESSARY;
            case BigDecimal.ROUND_UP:
                return UP;
            default:
                throw new IllegalArgumentException("Invalid rounding mode");
        }
    }
}
