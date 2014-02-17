package droidsafe.analyses.value;

/**
 * Class whose instance should represent unknown values.
 *
 * @author dpetters
 */
public class UnknownVAModel extends VAModel {
    
    @Override
    public String toStringSimple() {
        return this.toStringDetailed().replace("\"", "");
    }

    @Override
    public String toStringDetailed() {
        return "\"" + ValueAnalysis.UNKNOWN_VALUES_STRING + "\"";
    }

    @Override
    public String toStringPretty(int level) {
        return ValueAnalysis.UNKNOWN_VALUES_STRING;
    }
}
