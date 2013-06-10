package droidsafe.analyses.attr;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

/**
 * Base class for every Attribute Modeling model class.
 *
 * @author dpetters
 */
public abstract class ModeledClass {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Some models have an associated AllocNode.
     */
    protected AllocNode allocNode;
    
    /**
     * Determines whether the model object is invalidated or not.
     */
    protected boolean invalidated;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Basic constructor. Model objects are not invalidated by default.
     */
    public ModeledClass(){
        this.invalidated = false;
    }

    /**
     * Constructor for model objects that have an associated allocNode
     */
    public ModeledClass(AllocNode allocNodeParam){
        this();
        this.allocNode = allocNodeParam;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Invalidates the model object by setting the "invalidated" attribute to true.
     */
    public void invalidate() {
        this.invalidated = true;
    }

    /**
     * Checks whether a model object is invalidated, as determined by the "invalidated" attribute.
     * @returns value of the "invalidated" attribute
     */
    public boolean invalidated() {
        return this.invalidated;
    }

    /**
     * @returns String of the id of the associated AllocNode, if the model object has one
     */
    public String getId() {
        String id = "";
        if (this.allocNode != null) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(this.allocNode.toString());
            if(m.find()) {
                id += " #" + m.group();
            }
        }
        return id;
    }

    /**
     * @returns AllocNode associated with this model object or null if there isn't one
     */
    public AllocNode getAllocNode(){
        return this.allocNode;
    }

    /**
     * @returns user-friendly representation of the model object as a String
     */
    public abstract String dsDisplay();
}
