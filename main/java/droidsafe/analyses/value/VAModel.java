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
    protected boolean __ds__invalidated = false;

    /**
     * Invalidate the model - we couldn't soundly resolve everything.
     */
    public void  __ds__invalidate(){
        this.__ds__invalidated = true;
    }

    /**
     * @returns whether this model was fully resolved
     */
    public boolean __ds__invalidated() {
        return this.__ds__invalidated;
    }
    
    public abstract String __ds__toString();
}
