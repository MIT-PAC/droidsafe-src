package droidsafe.analyses.value;

/**
 * Base class for value analysis object models.
 *
 * @author dpetters
 */
public abstract class VAModel {
    
    public static final String INVALIDATED = "INV";

    /**
     * An object may be invalidated if we cannot soundly resolve it.
     */
    protected boolean invalidated = false;

    /**
     * Invalidate the model - we couldn't soundly resolve everything.
     */
    public void  invalidate(){
        this.invalidated = true;
    }

    /**
     * @returns whether this model was fully resolved
     */
    public boolean invalidated() {
        return this.invalidated;
    }
    
    public abstract String toString();
}
