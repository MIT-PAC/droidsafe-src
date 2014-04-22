package droidsafe.instrumentation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import android.util.Log;

/*
 * Checkpoint classs used to assist with dynamic instrumentation  
 * We will use checkpoint to inspect callStack of a given method
 * 
 */
public class CheckPoint {

    
    private static CheckPoint instance = new CheckPoint();
    
    private Set<String> systemPackageSet = new HashSet<String>();
    
    private Class ObjectClass = null;
    
    private String tag = "DSI";
    
    private static String PREINVOKE_SYMBOL    = "+";
    private static String POSTINVOKE_SYMBOL   = "-";
    private static String INSIDEMETHOD_SYMBOL = "=";
    
    private Map<String, Stack<String>> callStacks = new HashMap<String, Stack<String>>();
    
    public CheckPoint v() { return instance; }
    
    private CheckPoint() {
        systemPackageSet.add("android.*");
        systemPackageSet.add("java.*");
        systemPackageSet.add("com.android.*");
        systemPackageSet.add("com.google.*");
        systemPackageSet.add("libcore.*");
        systemPackageSet.add("dalvik.*");
        systemPackageSet.add("org.apache.*");
        systemPackageSet.add("org.bouncycastle.*");
        systemPackageSet.add("org.json.*");
        systemPackageSet.add("org.xml.*");
        systemPackageSet.add("org.xmlpull.*");
        systemPackageSet.add("sun.misc.*");
        systemPackageSet.add("java.*");
        systemPackageSet.add("javax.*");

        try {
            ObjectClass = Class.forName("java.lang.Object");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    static public void beforeMethodInvoke(Object obj, String fullSig) {
        beforeMethodInvoke(obj, fullSig, null);
    }

    static public void beforeMethodInvoke(Object obj, String fullSig, ListWrapper argList) {
        List<Object> list = null;
        if (argList != null)
            list = argList.getList();
        
        instance.checkpointTag(PREINVOKE_SYMBOL, obj, fullSig, list);
    }
    
    static public void afterMethodInvoke(Object obj, String fullSig) {
        afterMethodInvoke(obj, fullSig, null);
    }

    static public void afterMethodInvoke(Object obj, String fullSig, ListWrapper argList) {
        List<Object> list = null;
        if (argList != null)
            list = argList.getList();
        instance.checkpointTag(POSTINVOKE_SYMBOL, obj, fullSig, list);
    }
        
    
    static public void insideMethod(Object obj, String fullSig, ListWrapper argList) {
        List<Object> list = null;
        if (argList != null)
            list = argList.getList();
        instance.checkpointTag(INSIDEMETHOD_SYMBOL, obj, fullSig, list);
    }
        
    private void checkpointTag(String dirTag, Object obj, String fullSig, List<Object> argList) {
        
        try {
            String className = "";
            if (obj != null)
                className = obj.getClass().getCanonicalName();

            StringBuilder sb = new StringBuilder();
            if (argList != null) {
                for (Object argObj: argList) {
                    String limited = argObj.toString();
                    if (limited.length() > 100)
                        limited = limited.substring(0, 100);
                    if (sb.length() != 0)
                        sb.append(", ");
                    sb.append(limited);
                }
            }

            String msg = String.format("%s[%d] %s [%s] [%s]", dirTag,
                    (int)Thread.currentThread().getId(),
                    fullSig, className, sb.toString()); 

            Log.w(tag, msg);
        }
        catch  (Exception ex) {
            System.out.printf("Exception %s \n", ex.toString());
        }
    }
    
    
    
    Stack<String> getCurrentStack() {
        String key = Long.toString(Thread.currentThread().getId());
        
        if (!callStacks.containsKey(key)) {
            callStacks.put(key,  new Stack<String>());
        }
        
        return callStacks.get(key);
    }
    
    
    private boolean isSystemClass(Class clazz) {
        String className = clazz.getCanonicalName();
        for (String pattern: systemPackageSet) {
            if (className.matches(pattern))
                return true;
        }
        return false;
    }
    
    private boolean isObjectClass(Class clazz) {
        return (clazz.equals(ObjectClass));
    }

    private boolean isSystemSubclass(Class clazz) {
        if (isObjectClass(clazz))
            return false;
        
        Class parent = clazz.getSuperclass();
        
        while(parent.equals(ObjectClass)) {
            if (isSystemClass(parent))
                return true;
            parent = parent.getSuperclass();
        }
        return false;
    }
    
    private boolean testPresent(String str) {
        return (str != null);
    }
}
