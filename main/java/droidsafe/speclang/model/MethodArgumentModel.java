package droidsafe.speclang.model;

import java.util.List;

/**
 * Representation of the receiver or an argument of a method call.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class MethodArgumentModel {

    /**
     * The target method of the underlying method call.
     */
    private MethodModel method;

    /**
     * The index for the method argument. -1 indicates that this is the receiver
     * of the underlying method call.
     */
    private int argumentIndex;
    

    /**
     * Create a method argument model for the given method and argument index.
     */
    public MethodArgumentModel(MethodModel method, int argumentIndex) {
        this.method = method;
        this.argumentIndex = argumentIndex;
    }
    
    /**
     * Return true if this is the receiver for the underlying method call.
     */
    public boolean isReceiver() {
        return argumentIndex == -1;
    }

    /**
     * Return the method for the underlying method call.
     */
    public MethodModel getMethod() {
        return this.method;
    }

    /**
     * Return the argument index; -1 if this is the receiver of the underlying method call.
     */
    public int getArgumentIndex() {
        return this.argumentIndex;
    }

    /**
     * Return the lines for new expressions that could reach this method receiver/argument.
     */
    public List<AllocLocationModel> getAllocSources() {
        return method.getArgumentAllocSources(argumentIndex);
    }

    /**
     * Return the the list of high level information kinds that the receiver/argument could possibly 
     * be tainted with.
     */
    public List<String> getInfoKinds() {
        return method.getArgumentInfoKinds(argumentIndex);
    }

    /**
     * Return the the list of all api calls in user code that could reach the receiver/argument.
     */
    public List<CallLocationModel> getSourceInfoUnits() {
        return method.getArgumentSourceInfoUnits(argumentIndex);
    }

    @Override
    public String toString() {
        String type = (isReceiver()) ? method.getReceiverType() : method.getMethodArguments().get(argumentIndex);
        return getShortDesc() + ": " + type;
    }
    
    /**
     * Return a short description for this method receiver/argument.
     */
    public String getShortDesc() {
        return (isReceiver()) ? "receiver" : "argument " + (argumentIndex + 1);
    }

}
