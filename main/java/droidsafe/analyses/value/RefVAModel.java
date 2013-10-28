package droidsafe.analyses.value;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.analyses.value.UnknownVAModel;

import droidsafe.utils.SootUtils;

import java.lang.reflect.Field;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.StringConstantNode;

import soot.RefType;

import soot.SootClass;

import soot.SootField;

import soot.Type;

/**
 * Base class for value analysis object models.
 *
 * @author dpetters
 */
public abstract class RefVAModel extends VAModel {

    /**
     * Every model is tied to an allocNode (one-to-one). 
     */
    protected Object newExpr;

    private static final Logger logger = LoggerFactory.getLogger(RefVAModel.class);

    private static final UnknownVAModel unknownValue = new UnknownVAModel();

    public RefVAModel(Object newExpr){
        this.newExpr = newExpr;
    }

    /**
     * @returns null if the value of the field could be anything
     *          set of VAModels for the values of the field otherwise
     */
    public Set<VAModel> getFieldVAModels(SootField sootField) {
        String errorMsg = this.getAllocNode() + "'s field " + sootField + " got assigned the value 'unknown' because ";
        Set<VAModel> fieldVAModels = new HashSet<VAModel>();
        Type fieldType = sootField.getType();
        if(fieldType instanceof RefType && !SootUtils.isStringOrSimilarType(fieldType)) {
            RefType fieldRefType = (RefType)fieldType;
            Set<AllocNode> allocNodes = GeoPTA.v().getPTSetContextIns(this.getAllocNode(), sootField);
            if(allocNodes.size() > 0){
                String fieldClassName = fieldRefType.getSootClass().getName();
                //took out string code here!
                for(AllocNode allocNode : allocNodes) {
                    VAModel vaModel = ValueAnalysis.v().getResult(allocNode);
                    if(vaModel != null) {
                        fieldVAModels.add(vaModel);
                    } else {
                        ValueAnalysis.logError(errorMsg + 
                            " its class isn't marked as security-sensitive (annotated with DSVAModeled).");
                        fieldVAModels.add(unknownValue);
                    }

                }
            }
        } else {
            Class<?> c = this.getClass();
            try {
                Field field = c.getDeclaredField(sootField.getName());
                try {
                    Object fieldObject = field.get(this);
                    PrimVAModel fieldObjectPrimVAModel = (PrimVAModel)fieldObject;
                    if(fieldObjectPrimVAModel.invalidated() || fieldObjectPrimVAModel.values.size() > 0) {
                        fieldVAModels.add(fieldObjectPrimVAModel); 
                    }
                } catch(IllegalAccessException e) {
                    ValueAnalysis.logError(errorMsg + " its values couldn't be retrieved: " + e.toString());
                    fieldVAModels.add(unknownValue);
                }
            } catch(NoSuchFieldException e) {
                ValueAnalysis.logError(errorMsg + " its values couldn't be retrieved: " + e.toString());
                fieldVAModels.add(unknownValue);
            }
        }
        return fieldVAModels;
    }

    /**
     * Returns the id of the AllocNode if the model has one.
     * @returns id as String
     */
    public String getId() {
        String id = "";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(this.getAllocNode().toString());
        if(m.find()) {
            id += m.group();
        }
        return "#" + id;
    }

    /**
     * @returns AllocNode that corresponds to this model.
     */
    public AllocNode getAllocNode(){
        return GeoPTA.v().getAllocNode(this.newExpr);
    }

    /**
     * @returns a string representation of this object model.
     */
    @Override
    public String toStringSimple() {
        String str = "{\"";
        str += this.getClass().getName().substring(ValueAnalysis.MODEL_PACKAGE_PREFIX.length());
        str += "\":";
        str += "{" + this.fieldsString(false) + "}";
        str += "}";
        return str.replace("\"", "");
    }

    /**
     * @returns a string representation of this object model.
     */
    @Override
    public String toStringDetailed() {
        String str = "{\"va-modeled-";
        str += this.getClass().getName().substring(ValueAnalysis.MODEL_PACKAGE_PREFIX.length());
        str += " " + this.getId() + "\": ";
        str += "{" + this.fieldsString(true) + "}";
        return str + "}";
    }

    /**
     * @returns the SootClass for this object model.
     */ 
    private SootClass getSootClass() {
        // We only model objects, so the type should always be RefType
        return ((RefType)this.getAllocNode().getType()).getSootClass();
    }

    /**
     * Return a string of the resolved field values for this modeled object.
     */
    private String fieldsString(boolean detailed) {
        String fieldsString = "";
        List<String> fieldStrings = new ArrayList<String>();
        if (this.invalidated) {
            fieldsString += INVALIDATED;
        } else {
            for(SootField sootField : getFieldsToDisplay(this.getSootClass())) {
                Set<VAModel> vaModels = this.getFieldVAModels(sootField);
                if(vaModels == null) {
                    String fieldString = "\"" + sootField.getName() + "\":" + INVALIDATED;
                    fieldStrings.add(fieldString);
                } else if(vaModels.size() > 0){
                    // using which we call getFieldVAModels to get a list of of object models
                    String fieldString = "\"" + sootField.getName() + "\":";
                    if(vaModels.size() > 1) fieldString += "[";
                    List<String> objectModelStrings = new ArrayList<String>();
                    for(VAModel vaModel : vaModels){
                        // TODO: figure out why this can be null
                        if(vaModel != null) {
                            // for each field object model, we call its toString, unless the object model is the same
                            // one we are trying to print out (to avoid a toString infinite loop)
                            if(this==vaModel) {                                                                           
                                objectModelStrings.add("\"itself\"");
                            } else {
                                // for each object model we call its tostring method
                                String str = "";
                                if(detailed) {
                                    str += vaModel.toStringDetailed();
                                } else {
                                    str += vaModel.toStringSimple();
                                }
                                objectModelStrings.add(str);
                            }
                        }
                    }
                    fieldString += StringUtils.join(objectModelStrings.toArray(), ". ");
                    if(vaModels.size() > 1) fieldString += "]";
                    fieldStrings.add(fieldString);
                }
            }
            fieldsString += StringUtils.join(fieldStrings.toArray(), ", ");
        }
        return fieldsString;
    }

    private Set<SootField> getFieldsToDisplay(SootClass sootClassParam) {
        // the result
        Set<SootField> fieldsToDisplay = new HashSet<SootField>();

        // we want to display not only values of fields from this class, but also any parent class in the hierarchy
        Set<SootClass> classesInHierarchy = new HashSet<SootClass>();
        classesInHierarchy.add(sootClassParam);
        classesInHierarchy.addAll(SootUtils.getParents(sootClassParam));

        // we will filter classes and fields by what is annotated as security sensitive in the api model
        Map<SootClass, Set<SootField>> classesAndFieldsVAShouldModel = ValueAnalysis.v().getClassesAndFieldsToModel();
        // go through all fields in the hierarchy, filtering down to only those that should get displayed 
        for(SootClass sootClass : classesInHierarchy) {
            if(classesAndFieldsVAShouldModel.containsKey(sootClass)) {
                Set<SootField> fieldsVAShouldModel = classesAndFieldsVAShouldModel.get(sootClass);
                for(SootField sootField : sootClass.getFields()) {
                    if(fieldsVAShouldModel.contains(sootField))
                        fieldsToDisplay.add(sootField);
                }
            }
        }
        return fieldsToDisplay;
    }
}
