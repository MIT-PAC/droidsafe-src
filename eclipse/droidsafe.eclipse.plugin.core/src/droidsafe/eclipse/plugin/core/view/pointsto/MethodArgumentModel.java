package droidsafe.eclipse.plugin.core.view.pointsto;

import java.util.List;

import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.MethodModel;

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
        return (isReceiver()) ? method.getReceiverAllocSources() : method.getArgumentAllocSources(argumentIndex);
    }

    @Override
    public String toString() {
        String val = (isReceiver()) ? method.getReceiver() : method.getArgumentValue(argumentIndex);
        return getShortDesc() + " - " + val;
    }
    
    /**
     * Return a short description for this method receiver/argument.
     */
    public String getShortDesc() {
        return (isReceiver()) ? "receiver" : "argument " + (argumentIndex + 1);
    }

}
