package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public enum RoundingMode {
    UP(BigDecimal.ROUND_UP),
    DOWN(BigDecimal.ROUND_DOWN),
    CEILING(BigDecimal.ROUND_CEILING),
    FLOOR(BigDecimal.ROUND_FLOOR),
    HALF_UP(BigDecimal.ROUND_HALF_UP),
    HALF_DOWN(BigDecimal.ROUND_HALF_DOWN),
    HALF_EVEN(BigDecimal.ROUND_HALF_EVEN),
    UNNECESSARY(BigDecimal.ROUND_UNNECESSARY);
    private final int bigDecimalRM;
    RoundingMode(int rm) {
        bigDecimalRM = rm;
    }
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

