/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.eclipse.plugin.core.view.indicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import droidsafe.analyses.value.VAUtils;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.utils.SourceLocationTag;

/**
 * Class to store general utility methods for indicators.
 * 
 * @author gilham
 *
 */
public class Utils {
    
    /** The name of the children property. */
    public static final String CHILDREN_PROP = "contents";
    
    /** The name of the source location property. */
    public static final String SOURCE_LOCATION_PROP = "src-loc";

    /** The fields for a Json object representing a method signature. */
    public static final List<String> SIGNATURE_FIELDS;

    static {
        String[] sigFields = {"class", "method-name"};
        SIGNATURE_FIELDS = Arrays.asList(sigFields);
    }

    /**
     * Returns the value of the 'type' property for the given Json element.
     * 
     * @param jsonElement - a Json element
     * @return the type
     */
    public static String getObjectType(JsonElement jsonElement) {
        return getFieldValueAsString(jsonElement, "type");
    }
    
    /**
     * Returns the value of the children property for the given Json element.
     * 
     * @param jsonElement - a Json element
     * @return the Json array of the children elements
     */
    public static JsonArray getChildrenArray(JsonElement jsonElement) {
        if (jsonElement.isJsonObject()) {
            JsonElement value = ((JsonObject) jsonElement).get(CHILDREN_PROP);
            if (value != null && value.isJsonArray())
                return (JsonArray) value;
        }
        return null;
    }
    
    /**
     * Returns the field value of the given Json element and the given field as a string.
     * 
     * @param jsonElement - a Json element
     * @param field - a field
     * @return the field value as a string
     */
    public static String getFieldValueAsString(JsonElement jsonElement, String field) {
        JsonElement value = getFieldValue(jsonElement, field);
        if (value != null) {
            return value.getAsString();
        } else if (SIGNATURE_FIELDS.contains(field)){
            return getSignatureFieldValueAsString(jsonElement, field);
        }
        return null;
    }

    /**
     * Returns the field value of the given Json element and the given field as a Json object.
     * 
     * @param jsonElement - a Json element
     * @param field - a field
     * @return the field value as a Json object
     */
    public static JsonObject getFieldValueAsObject(JsonElement jsonElement, String field) {
        JsonElement value = getFieldValue(jsonElement, field);
        if (value != null && value.isJsonObject()) {
            return value.getAsJsonObject();
        }
        return null;
    }

    /**
     * Returns the field value of the given Json element and the given field as a Json array.
     * 
     * @param jsonElement - a Json element
     * @param field - a field
     * @return the field value as a Json array
     */
    public static JsonArray getFieldValueAsArray(JsonElement jsonElement, String field) {
        JsonElement value = getFieldValue(jsonElement, field);
        if (value != null && value.isJsonArray()) {
            return value.getAsJsonArray();
        }
        return null;
    }

    /**
     * Returns the field value for the given Json element and the given field.
     * 
     * @param jsonElement - a Json element
     * @param field - a field
     * @return the field value
     */
    public static JsonElement getFieldValue(JsonElement jsonElement, String field) {
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = (JsonObject) jsonElement;
            JsonElement value = jsonObject.get(field);
            return value;
        }
        return null;
    }
    /**
     * Returns the field value for the given Json element and the given signature
     * field as a string.
     * 
     * @param jsonElement - a Json element
     * @param field - a field
     * @return the signature field value as a string
     */
    public static String getSignatureFieldValueAsString(JsonElement jsonElement, String field) {
        String sig = getFieldValueAsString(jsonElement, "signature");
        if (sig != null) {
            if (field.equals("class"))
                return signatureClass(sig);
            if (field.equals("method-name"))
                return signatureMethodName(sig);
        }
        return null;
    }

    /**
     * Return a short version of the given method signature, with the angle brackets
     * and the package qualifiers removed.
     * 
     * @param sig - a method signature
     * @return the short version of the signature
     */
    public static String shortSignature(String sig) {
        // remove the angle brackets
        sig = sig.substring(1,  sig.length() - 1);
        // remove the package qualifiers
        return sig.replaceAll("[a-zA-Z._]*[.]", "");
    }

    /**
     * Given a method signature, returns a substring denoting the class name.
     * 
     * @param sig - a method signature
     * @return the class name
     */
    public static String signatureClass(String sig) {
        int pos = sig.indexOf(": ");
        return sig.substring(1, pos);
    }

    /**
     * Given a method signature, returns a substring denoting the method name.
     * 
     * @param sig - a method signature
     * @return the method name
     */
    public static String signatureMethodName(String sig) {
        int pos1 = sig.indexOf(": ") + 2;
        int pos2 = sig.indexOf("(", pos1);
        pos1 = sig.lastIndexOf(" ", pos2) + 1;
        return sig.substring(pos1, pos2);
    }

    /**
     * Given a method signature, returns a substring denoting the parameter types.
     * 
     * @param sig - a method signature
     * @return the parameter types
     */
    public static String[] signatureParameterTypes(String sig) {
    	int pos1 = sig.indexOf("(");
    	int pos2 = sig.indexOf(",", pos1 + 1);
    	int pos3 = sig.lastIndexOf(")");
    	String paramType;
    	List<String> paramTypes = new ArrayList<String>();
    	while (pos2 > 0) {
    		paramType = sig.substring(pos1 + 1, pos2);
    		paramTypes.add(paramType);
    		pos1 = pos2;
    		// TODO: handle ',' in array dimensions
    		pos2 = sig.indexOf(",", pos1 + 1);
    	}
		paramType = sig.substring(pos1 + 1, pos3);
		if (!paramType.isEmpty())
			paramTypes.add(paramType);
    	return paramTypes.toArray(new String[0]);
    }

    /**
     * Given a Json object, returns the set of fields that can be used
     * to filter the indicator display.  The filter fields contain signature
     * fields and primitive fields.   
     * 
     * @param jsonObj - a Json object
     * @return the filter fields for the object
     */
    public static Set<String> getFilterFields(JsonObject jsonObj) {
        Set<String> fields = new TreeSet<String>();
        for (Map.Entry<String, JsonElement> entry: jsonObj.entrySet()) {
            String field = entry.getKey();
            if (field.equals("signature")) {
                fields.add(field);
                fields.addAll(SIGNATURE_FIELDS);
            } else {
                JsonElement value = entry.getValue();
                if (value.isJsonPrimitive()) 
                    fields.add(field);
            }
        }
        return fields;
    }

    /**
     * Given a top-level Json object, returns the set of fields collected 
     * from the object and its descendants that can be used to filter the  
     * indicator display.  
     * 
     * @param jsonObj - a Json object
     */
    public static Set<String> getAllFilterFields(JsonObject jsonObj) {
        Set<String> filterFields = new TreeSet<String>();
        getAllFilterFields(jsonObj, filterFields, true);
        return filterFields;
    }

    /**
     * Given a Json object, collects fields that can be used to filter the  
     * indicator display from the object and its descendants and adds the
     * fields to the accumulated filter fields. 
     * 
     * @param jsonObj - a Json object
     * @param filterFields - filterFields collected so far
     * @param topLevel - true if this is the top-level call, not a recursive call
     */
    private static void getAllFilterFields(JsonObject jsonObj, Set<String> filterFields, boolean topLevel) {
        if (!topLevel) {
            filterFields.addAll(getFilterFields(jsonObj));
        }
        JsonArray childrenArray = Utils.getChildrenArray(jsonObj);
        if (childrenArray != null) {
            for (int i = 0; i < childrenArray.size(); i++) {
                JsonElement child = childrenArray.get(i);
                if (child.isJsonObject()) {
                    getAllFilterFields((JsonObject)child, filterFields, false);
                }
            }
        }
    }

    /**
     * Given a Json object, returns the set of fields that can be used to sort the  
     * indicator display.  The fields include the signature fields and primitive
     * fields excluding the 'type' field.
     * 
     * @param jsonObj - a Json object
     * @return the sort-by fields
     */
    public static Set<String> getSortByFields(JsonObject jsonObj) {
        Set<String> fields = new TreeSet<String>();
        fields.add("label");
        JsonArray childrenArray = Utils.getChildrenArray(jsonObj);
        if (childrenArray != null && childrenArray.size() > 0) {
            jsonObj = (JsonObject) childrenArray.get(0);
            for (Map.Entry<String, JsonElement> entry: jsonObj.entrySet()) {
                String field = entry.getKey();
                if (field.equals("signature")) {
                    fields.addAll(SIGNATURE_FIELDS);
                } else if (!field.equals("type")) {
                    JsonElement value = entry.getValue();
                    if (value.isJsonPrimitive()) 
                        fields.add(field);
                }
            }
        }
        return fields;
    }

    /**
     * Returns true if the given Json element is an empty Json object, i.e.
     * with no properties.
     */
    public static boolean isEmptyJsonObject(JsonElement jsonElt) {
        return jsonElt.isJsonObject() && ((JsonObject)jsonElt).entrySet().isEmpty();
    }
    
    /**
     * Returns a pretty printed string of the given Json element.
     */
    public static String toStringPretty(JsonElement jsonElt) {
        return toStringPretty(jsonElt, 0);
    }
    
    /**
     * Returns a pretty printed string of the given Json element, indented
     * at the given level.
     */
    public static String toStringPretty(JsonElement jsonElt, int level) {
        if (jsonElt.isJsonObject())
            return toStringPretty((JsonObject)jsonElt, level);
        if (jsonElt.isJsonArray())
            return toStringPretty((JsonArray)jsonElt, level);
        return jsonElt.toString();
    }
    
    /**
     * Returns a pretty printed string of the given Json object, indented
     * at the given level.
     */
    public static String toStringPretty(JsonObject jsonObj, int level) {
        StringBuffer buf = new StringBuffer();
        buf.append("{");
        buf.append(fieldsToStringPretty(jsonObj, level + 1));
        buf.append("}");
        return buf.toString();
    }

    /**
     * Returns a pretty printed string of the field values for the given 
     * Json object, indented at the given level.
     */
    private static String fieldsToStringPretty(JsonObject jsonObj, int level) {
        StringBuffer buf = new StringBuffer();
        String indent = "\n" + VAUtils.indent(level);
        boolean firstField = true;
        for (Map.Entry<String, JsonElement> entry: jsonObj.entrySet()) {
            String field = entry.getKey();
            if (!field.equals(CHILDREN_PROP) && !field.equals("src-loc")) {
                if (!firstField)
                    buf.append(",");
                if (level == 1 && firstField)
                    buf.append(" ");
                else
                    buf.append(indent);
                firstField = false;
                buf.append(field);
                buf.append(": ");
                JsonElement value = entry.getValue();
                buf.append(toStringPretty(value, level + 1));
            }
        }
        return buf.toString();
    }

    /**
     * Returns a pretty printed string of the given Json array, indented
     * at the given level.
     */
    private static String toStringPretty(JsonArray jsonArray, int level) {
        StringBuffer buf = new StringBuffer();
        buf.append("[");
        String indent = "\n" + VAUtils.indent(level);
        boolean firstElt = true;
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement elt = jsonArray.get(i);
            if (firstElt)
                firstElt = false;
            else
                buf.append(",");
            buf.append(indent);
            buf.append(toStringPretty(elt, level + 1));
        }
        buf.append("]");
        return buf.toString();
    }
    
    /**
     * Given two Json objects, compares the values of the given field and returns
     *   - a negative integer if the first field value is less than the second
     *   - a positive integer if the first field value is greater than the second
     *   - zero if the first field value is equal to the second
     *   
     * @param jsonObj1 - the first Json object
     * @param jsonObj2 - the second Json object
     * @param field - a field
     * @return the comparison result
     */
    public static int compareField(JsonObject jsonObj1, JsonObject jsonObj2, String field) {
        if (SIGNATURE_FIELDS.contains(field)) {
            String val1 = getSignatureFieldValueAsString(jsonObj1, field);
            String val2 = getSignatureFieldValueAsString(jsonObj2, field);
            if (val1 != null && val2 != null)
                return val1.compareTo(val2);
            return 0;
        }
        JsonElement val1 = jsonObj1.get(field);
        JsonElement val2 = jsonObj2.get(field);
        if (val1 != null && val2 != null) {
            if (val1.isJsonPrimitive() && val2.isJsonPrimitive()) {
                JsonPrimitive primVal1 = (JsonPrimitive) val1;
                JsonPrimitive primVal2 = (JsonPrimitive) val2;
                if (primVal1.isNumber() && primVal2.isNumber()) {
                    // TODO: handle long, float, double
                    int int1 = primVal1.getAsInt();
                    int int2 = primVal2.getAsInt();
                    return int2 - int1;
                }
            }
            String str1 = val1.getAsString();
            String str2 = val2.getAsString();
            return str1.compareTo(str2);
        }
        return 0;
    }

    /**
     * Given a Json element, returns its signature value if it has a 
     * 'signature' field. Otherwise returns null.
     * 
     * @param jsonObj - a Json object
     * @return the signature
     */
    public static String getSignature(JsonElement jsonObj) {
        String sig = getFieldValueAsString(jsonObj, "signature");
        if (sig != null && sig.startsWith("<"))
            sig = sig.substring(1, sig.length() - 1);
        return sig;
    }

    /**
     * Given a Json element, returns the source location value as a Json object
     * if the element has a 'src-loc' field. Otherwise returns null.
     * 
     * @param jsonObj - a Json object
     * @return the signature
     */
    public static JsonObject getSourceLoc(JsonElement jsonObject) {
        return Utils.getFieldValueAsObject(jsonObject, SOURCE_LOCATION_PROP);
    }
    
    /**
     * Given a Json element, returns the source class string
     * if the element has a 'src-loc' field. Otherwise returns null.
     * 
     * @param jsonObj - a Json object
     * @return the source class string
     */
    public static String getSourceClass(JsonElement jsonObject) {
        JsonObject sourceLoc = getSourceLoc(jsonObject);
        if (sourceLoc != null)
            return Utils.getFieldValueAsString(sourceLoc, "class");
        return null;
    }

    /**
     * Given a Json element, returns the source line number
     * if the element has a 'src-loc' field. Otherwise returns -1.
     * 
     * @param jsonObj - a Json object
     * @return the source line number
     */
    public static int getSourceLine(JsonElement jsonObject) {
        JsonObject sourceLoc = getSourceLoc(jsonObject);
        if (sourceLoc != null)
            return sourceLoc.get("line").getAsInt();
        return -1;
    }

    /**
     * Looks for method models in the given security spec model that match the given 
     * Json object. Returns the method models if found, otherwise returns the empty set.
     * 
     * @param spec - a security spec model
     * @param jsonObj - a Json object representing a method or method call
     * @return the method models
     */
    public static Set<MethodModel> getMethodModels(SecuritySpecModel spec, JsonElement jsonObj) {
    	if (spec != null && jsonObj != null) {
    		String link = Utils.getFieldValueAsString(jsonObj, "link");
    		String sig = Utils.getSignature(jsonObj);
    		String srcClass = Utils.getSourceClass(jsonObj);
    		int srcLine = Utils.getSourceLine(jsonObj);
    		return getMethodModels(spec, sig, srcClass, srcLine, link);
    	}
    	return Collections.EMPTY_SET;
    }

    /**
     * Looks for method models in the given security spec model that match the given
     * field values from a Json object. Returns the method models if found, otherwise 
     * returns the empty set.
     * 
     * @param spec - a security spec model
     * @param sig - the method signature
     * @param srcClass - the source class name
     * @param srcLine - the source line number
     * @param link - the link to method models
     * @return the method models
     */
    public static Set<MethodModel> getMethodModels(SecuritySpecModel spec, String sig, String srcClass,
            int srcLine, String link) {
        Set<MethodModel> result = new TreeSet<MethodModel>();
        if (sig != null) {
            if (link != null) {
                if (link.equals("as_entry_point")) {
                    for (MethodModel entryPoint: spec.getInputEventBlocks().keySet()) {
                        if (sig.equals(entryPoint.getSignature()))
                            result.add(entryPoint);
                    }
                } else if (link.equals("as_call") && srcClass != null && srcLine >= 0) {
                    for (MethodModel call: spec.getOutputEventBlocks().keySet()) {
                    	String callSig = call.getSignature();
                        if (sig.equals(callSig)) {
                            SourceLocationTag line = DroidsafePluginUtilities.getLine(call);
                            if (line != null && line.getClz().equals(srcClass) && line.getLine() == srcLine) {
                                result.add(call);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns the active indicator outline view. Returns null if the active view isn't 
     * an IndicatorViewPart.
     */
    public static IndicatorViewPart getIndicatorView() {
        IWorkbenchWindow active = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow();
        if (active == null)
            return null;
        IWorkbenchPage page = active.getActivePage();
        if (page == null)
            return null;
        IWorkbenchPart part = page.getActivePart();
        if (!(part instanceof IndicatorViewPart))
            return null;

        return (IndicatorViewPart) part;
    }

}
