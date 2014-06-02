package droidsafe.analyses.value;

/**
 * Class whose instance should represent unknown values.
 *
 * @author dpetters
 */
public class UnknownVAModel extends VAModel {
    /** string to represent sets of unknown values */
    public static final String UNKNOWN_VALUES = "<ANYTHING>";
    
    @Override
    public String toStringSimple() {
        return this.toStringDetailed().replace("\"", "");
    }

    @Override
    public String toStringDetailed() {
        return "\"" + UNKNOWN_VALUES + "\"";
    }

    @Override
    public String toStringPretty(int level) {
        return UNKNOWN_VALUES;
    }
}
