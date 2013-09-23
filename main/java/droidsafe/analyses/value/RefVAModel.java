package droidsafe.analyses.value;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.value.models.droidsafe.primitives.StringVAModel;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.StringConstantNode;

import soot.RefLikeType;

import soot.RefType;

import soot.SootClass;

import soot.SootField;

/**
 * Base class for value analysis object models.
 *
 * @author dpetters
 */
public abstract class RefVAModel extends VAModel {
    
    /**
     * Every model is tied to an allocNode (one-to-one). 
     */
    protected AllocNode __ds__allocNode;

    public RefVAModel(AllocNode allocNode){
        this.__ds__allocNode = allocNode;
    }

    /**
     * @returns the set of VAModels for the field
     */
    public Set<VAModel> __ds__getFieldVAModels(SootField sootField) {
        Set<VAModel> fieldVAModels = new HashSet<VAModel>();
        if (sootField.getType() instanceof RefType) {
            Set<AllocNode> allocNodes = new HashSet<AllocNode>();//TODO: GeoPTA.v().getPTSetContextIns(this.__ds__getAllocNode(), sootField);
            for(AllocNode allocNode : allocNodes) {
                if(allocNode instanceof StringConstantNode) {
                    fieldVAModels.add(new StringVAModel(((StringConstantNode)allocNode).getString()));    
                } else {
                    fieldVAModels.add(ValueAnalysis.v().getResults().get(allocNode));
                }
            }
        }
        return fieldVAModels;
    }

    /**
     * Returns the id of the AllocNode if the model has one.
     * @returns id as String
     */
    public String __ds__getId() {
        String id = "";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(this.__ds__allocNode.toString());
        if(m.find()) {
            id += m.group();
        }
        return " #" + id;
    }

    /**
     * @returns AllocNode that corresponds to this model.
     */
    public AllocNode __ds__getAllocNode(){
        return this.__ds__allocNode;
    }

    /**
     * @returns a string representation of this object model.
     */
    public String __ds__toString() {
        String str = "<va-modeled ";
        str += this.getClass().getName().substring(ValueAnalysis.MODEL_PACKAGE_PREFIX.length());
        str += " " + this.__ds__getId() + ": ";
        str += "{" + this.__ds__fieldsString() + "}";
        return str + ">";
    }
   
    /**
     * @returns the SootClass for this object model.
     */ 
    private SootClass getSootClass() {
        // We only model objects, so the type should always be RefType
        return ((RefType)this.__ds__getAllocNode().getType()).getSootClass();
    }

    /**
     * TODO: this needs to be made recursive now. A field's value is multiple object models now
     * Return a string of just the resolved field values for this modeled object.
     */
    private String __ds__fieldsString() {
        String fieldsString = "";
        List<String> fieldStrings = new ArrayList<String>();
        if (this.__ds__invalidated) {
            fieldsString += INVALIDATED;
        } else {
            // for each field we have a reference
            for(SootField sootField : this.getSootClass().getFields()) {
                Set<VAModel> vaModels = this.__ds__getFieldVAModels(sootField);
                if(vaModels.size() > 0){
                    // using which we call getFieldVAModels to get a list of of object models
                    String fieldString = sootField.getName() + ":[";
                    List<String> objectModelStrings = new ArrayList<String>();
                    for(VAModel objectModel : vaModels){
                        // TODO: figure out why this can be null
                        if(objectModel != null ) {
                            // for each object model we call its toString method
                            objectModelStrings.add(objectModel.__ds__toString());
                        }
                    }
                    fieldString += StringUtils.join(objectModelStrings.toArray(), ". ") + "]";
                    fieldStrings.add(fieldString);
                }
            }
            fieldsString += StringUtils.join(fieldStrings.toArray(), ", ");
        }
        return fieldsString;
    }
}
