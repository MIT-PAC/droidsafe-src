package droidsafe.analyses.value;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import soot.jimple.spark.pag.AllocNode;



/**
 * Base class for Attribute Modeling model classes
 *
 * @author dpetters
 */
public abstract class ValueAnalysisModeledObject {
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Attributes
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * We create a model for every allocNode of the Android classes we model. 
     * These models have a one-to-one correspondence with the allocNodes.
     * Some models may not have an allocNode.
     */
    protected AllocNode __ds__allocNode;

    /**
     * Attribute that determines whether we know the values of the attributes of a partucular object of a modeled
     * Android class. Whenever we are unable to simulate a method that may modify an object, the corresponding model
     * is invalidated.
     */
    protected boolean __ds__invalidated;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * All models are not invalidated by default.
     */  
    public ValueAnalysisModeledObject(){
        this.__ds__invalidated = false;
    }

    /**
     * Constructor for models that correspond to an allocNode. 
     */
    public ValueAnalysisModeledObject(AllocNode allocNodeParam){
        this();
        this.__ds__allocNode = allocNodeParam;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Invalidates the model by setting this.__ds__invalidated to true.
     */
    public void  __ds__invalidate(){
        this.__ds__invalidated = true;
    }

    /**
     * Method to check whether the model has been invalidated.
     * Determined by the value of the "invalidated" attribute.
     * @returns whether the model is invalidated or not as a boolean
     */
    public boolean __ds__invalidated() {
        return this.__ds__invalidated;
    }

    /**
     * Returns the id of the AllocNode if the model has one.
     * @returns id as String
     */
    public String __ds__getId() {
        String id = "";
        if (this.__ds__allocNode != null) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(this.__ds__allocNode.toString());
            if(m.find()) {
                id += " #" + m.group();
            }
        }
        return id;
    }

    /**
     * Getter for the allocNode attribute.
     * @returns AllocNode that corresponds to this model
     */
    public AllocNode __ds__getAllocNode(){
        return this.__ds__allocNode;
    }

    /**
     * toString is used for printing to the spec.
     */
    public String __ds__toString() {
        Class cls = this.getClass();
        String str = "<va-modeled " + cls.getName().substring(ValueAnalysis.MODEL_PACKAGE_PREFIX.length()) + " " 
                     + this.__ds__getId() + ": "; 
        if (!this.__ds__invalidated())
            str += "{" + this.__ds__fieldsString() + "}";
        else
            str += "INV";
        return str + ">";
    }
    
    /**
     * Return a string of just the resolved field values for this modeled object.
     */
    private String __ds__fieldsString() {
        Class cls = this.getClass();
        
        String str = "";
        if (this.__ds__invalidated) {
            str += "invalidated";
        } else {
            ArrayList<String> attrs = new ArrayList();
            for(Field field : cls.getFields()){
                field.setAccessible(true);
                try {
                    Object value = field.get(this);
                    if(value != null){
                        if(value instanceof Set && ((Set)value).size() == 0) {
                            continue;
                        }
                        String newAttr = field.getName() + ": ";
                        if(value instanceof ValueAnalysisModeledObject) {
                          newAttr += ((ValueAnalysisModeledObject)value).__ds__toString();
                        } else {
                          newAttr += value;
                        }
                        attrs.add(newAttr);
                    }
                } catch (IllegalAccessException e) {
                    // simply don't print out the field value
                }
            }
            str = str + StringUtils.join(attrs.toArray(), ", ");
        }
        return str;
    }
}
