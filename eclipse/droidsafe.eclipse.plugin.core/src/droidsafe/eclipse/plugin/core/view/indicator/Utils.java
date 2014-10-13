package droidsafe.eclipse.plugin.core.view.indicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import droidsafe.analyses.value.VAUtils;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.utils.SourceLocationTag;

public class Utils {
    
    public static final String CHILDREN_PROP = "contents";
    
    public static final List<String> SIGNATURE_FIELDS;

    public static final String SOURCE_LOCATION_PROP = "src-loc";

    static {
        String[] sigFields = {"class", "method-name"};
        SIGNATURE_FIELDS = Arrays.asList(sigFields);
    }

    public static String getObjectType(JsonElement jsonElement) {
        return getFieldValueAsString(jsonElement, "type");
    }
    
    public static JsonArray getChildrenArray(JsonElement jsonElement) {
        if (jsonElement.isJsonObject()) {
            JsonElement value = ((JsonObject) jsonElement).get(CHILDREN_PROP);
            if (value != null && value.isJsonArray())
                return (JsonArray) value;
        }
        return null;
    }
    
    public static String getFieldValueAsString(JsonElement jsonElement, String field) {
        JsonElement value = getFieldValue(jsonElement, field);
        if (value != null) {
            return value.getAsString();
        } else if (SIGNATURE_FIELDS.contains(field)){
            return getSignatureFieldValueAsString(jsonElement, field);
        }
        return null;
    }

    public static JsonObject getFieldValueAsObject(JsonElement jsonElement, String field) {
        JsonElement value = getFieldValue(jsonElement, field);
        if (value != null && value.isJsonObject()) {
            return value.getAsJsonObject();
        }
        return null;
    }

    public static JsonArray getFieldValueAsArray(JsonElement jsonElement, String field) {
        JsonElement value = getFieldValue(jsonElement, field);
        if (value != null && value.isJsonArray()) {
            return value.getAsJsonArray();
        }
        return null;
    }

    public static JsonElement getFieldValue(JsonElement jsonElement, String field) {
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = (JsonObject) jsonElement;
            JsonElement value = jsonObject.get(field);
            return value;
        }
        return null;
    }
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

    public static String shortSignature(String sig) {
        // remove the angle brackets
        sig = sig.substring(1,  sig.length() - 1);
        // remove the package qualifiers
        return sig.replaceAll("[a-zA-Z._]*[.]", "");
    }

    public static String signatureClass(String sig) {
        int pos = sig.indexOf(": ");
        return sig.substring(1, pos);
    }

    public static String signatureMethodName(String sig) {
        int pos1 = sig.indexOf(": ") + 2;
        int pos2 = sig.indexOf("(", pos1);
        pos1 = sig.lastIndexOf(" ", pos2) + 1;
        return sig.substring(pos1, pos2);
    }

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

    public static Set<String> getAllFilterFields(JsonObject jsonObj) {
        Set<String> fields = new TreeSet<String>();
        getAllFilterFields(jsonObj, fields, true);
        return fields;
    }

    private static void getAllFilterFields(JsonObject jsonObj, Set<String> fields, boolean topLevel) {
        if (!topLevel) {
            fields.addAll(getFilterFields(jsonObj));
        }
        JsonArray childrenArray = Utils.getChildrenArray(jsonObj);
        if (childrenArray != null) {
            for (int i = 0; i < childrenArray.size(); i++) {
                JsonElement child = childrenArray.get(i);
                if (child.isJsonObject()) {
                    getAllFilterFields((JsonObject)child, fields, false);
                }
            }
        }
    }

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

    public static boolean isEmptyJsonObject(JsonElement jsonElt) {
        return jsonElt.isJsonObject() && ((JsonObject)jsonElt).entrySet().isEmpty();
    }
    
    public static String toStringPretty(JsonElement jsonElt) {
        return toStringPretty(jsonElt, 0);
    }
    
    public static String toStringPretty(JsonElement jsonElt, int level) {
        if (jsonElt.isJsonObject())
            return toStringPretty((JsonObject)jsonElt, level);
        if (jsonElt.isJsonArray())
            return toStringPretty((JsonArray)jsonElt, level);
        return jsonElt.toString();
    }
    
    public static String toStringPretty(JsonObject jsonObj, int level) {
        StringBuffer buf = new StringBuffer();
        buf.append("{");
        buf.append(fieldsToStringPretty(jsonObj, level + 1));
        buf.append("}");
        return buf.toString();
    }

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

    public static String getSignature(JsonElement jsonObj) {
        String sig = getFieldValueAsString(jsonObj, "signature");
        if (sig != null && sig.startsWith("<"))
            sig = sig.substring(1, sig.length() - 1);
        return sig;
    }

    public static JsonObject getSourceLoc(JsonElement jsonObject) {
        return Utils.getFieldValueAsObject(jsonObject, SOURCE_LOCATION_PROP);
    }
    
    public static String getSourceClass(JsonElement jsonObject) {
        JsonObject sourceLoc = getSourceLoc(jsonObject);
        if (sourceLoc != null)
            return Utils.getFieldValueAsString(sourceLoc, "class");
        return null;
    }

    public static int getSourceLine(JsonElement jsonObject) {
        JsonObject sourceLoc = getSourceLoc(jsonObject);
        if (sourceLoc != null)
            return sourceLoc.get("line").getAsInt();
        return -1;
    }

    public static List<MethodModel> getMethodModels(SecuritySpecModel spec, JsonObject jsonObj) {
    	if (spec != null && jsonObj != null) {
    		String link = Utils.getFieldValueAsString(jsonObj, "link");
    		String sig = Utils.getSignature(jsonObj);
    		String srcClass = Utils.getSourceClass(jsonObj);
    		int srcLine = Utils.getSourceLine(jsonObj);
    		return getMethodModels(spec, sig, srcClass, srcLine, link);
    	}
    	return Collections.EMPTY_LIST;
    }

    public static  List<MethodModel> getMethodModels(SecuritySpecModel spec, String sig, String srcClass,
            int srcLine, String link) {
        List<MethodModel> result = new ArrayList<MethodModel>();
        if (sig != null && srcClass != null && srcLine >= 0) {
            if (link != null) {
                if (link.equals("as_entry_point")) {
                    for (MethodModel entryPoint: spec.getInputEventBlocks().keySet()) {
                        if (sig.equals(entryPoint.getSignature()))
                            result.add(entryPoint);
                    }
                } else if (link.equals("as_call")) {
                    for (MethodModel call: spec.getOutputEventBlocks().keySet()) {
                        if (sig.equals(call.getSignature())) {
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

	public static List<MethodModel> getMethodModels(JsonObject data) {
    	SecuritySpecModel spec = DroidsafePluginUtilities.getSecuritySpec();
		return getMethodModels(spec, data);
	}

}
