package droidsafe.eclipse.plugin.core.view.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Utils {

    public static JsonArray getChildrenArray(JsonElement jsonElement, String childrenProp) {
        if (jsonElement.isJsonObject()) {
            JsonElement value = ((JsonObject) jsonElement).get(childrenProp);
            if (value != null && value.isJsonArray())
                return (JsonArray) value;
        }
        return null;
    }
    
    public static String signatureShortLabel(JsonElement jsonElement) {
        return signatureLabel(jsonElement, true);
    }

    public static String signatureLabel(JsonElement jsonElement) {
        return signatureLabel(jsonElement, false);
    }

    public static String signatureLabel(JsonElement jsonElement, boolean shortLabel) {
        if (jsonElement.isJsonObject()) {
            JsonObject sig = (JsonObject) jsonElement;
            String className = signatureClass(sig);
            if (shortLabel) {
                className = droidsafe.utils.Utils.extractClassname(className);
            }
            String methodName = signatureMethodName(sig);
            String returnType = signatureReturnType(sig);
            JsonArray argTypes = signatureArgumentTypes(sig);
            StringBuffer buf = new StringBuffer();
            buf.append(className);
            buf.append(": ");
            buf.append(returnType);
            buf.append(" ");
            buf.append(methodName);
            buf.append("(");
            for (int i = 0; i < argTypes.size(); i++) {
                if (i > 0)
                    buf.append(",");
                String argType = argTypes.get(i).getAsString();
                if (shortLabel) {
                    argType = droidsafe.utils.Utils.extractClassname(argType);
                }
                buf.append(argType);
            }
            buf.append(")");
            return buf.toString();
        }
        return null;
    }
    
    public static String signatureClass(JsonObject sig) {
        return sig.get("class").getAsString();
    }

    public static String signatureMethodName(JsonObject sig) {
        return sig.get("method-name").getAsString();
    }

    public static String signatureReturnType(JsonObject sig) {
        return sig.get("return-type").getAsString();
    }

    public static JsonArray signatureArgumentTypes(JsonObject sig) {
        return sig.get("arguments").getAsJsonArray();
    }

}
