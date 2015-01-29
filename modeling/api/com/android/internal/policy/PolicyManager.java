package com.android.internal.policy;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.view.FallbackEventHandler;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowImpl;
import android.view.WindowManagerPolicy;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSComment;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.annotations.DSSpec;

public final class PolicyManager {
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public static Window makeNewWindow(Context context) {
    	return new WindowImpl(context);
    	//return new PhoneWindow(context);
        //return sPolicy.makeNewWindow(context);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public static LayoutInflater makeNewLayoutInflater(Context context) {
        return new MyLayoutInflater(context);
        /*
        return sPolicy.makeNewLayoutInflater(context);
        */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.936 -0500", hash_original_method = "8ED2BEB4D404F0707648CE3290A7E37D", hash_generated_method = "3C28F6E0D0FB0BE09724EEF78AE3FC28")
    
public static WindowManagerPolicy makeNewWindowManager() {
        return sPolicy.makeNewWindowManager();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.940 -0500", hash_original_method = "2FC59449732FB8F4271558BE9548F773", hash_generated_method = "2F685FEDCD500870706279D01512C43E")
    
public static FallbackEventHandler makeNewFallbackEventHandler(Context context) {
        return sPolicy.makeNewFallbackEventHandler(context);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.918 -0500", hash_original_field = "2F01B66073B64B1A11ABACB2CA0436B1", hash_generated_field = "F2EC3626690C6C0CDE9F04BA5A37D39E")

    private static final String POLICY_IMPL_CLASS_NAME =
        "com.android.internal.policy.impl.Policy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.921 -0500", hash_original_field = "A3CC4162A3CE5448C65A9A659D94B53C", hash_generated_field = "100BB36640E39269E598568BB8ACACA8")

    private static  IPolicy sPolicy;

    // Cannot instantiate this class
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.924 -0500", hash_original_method = "8280FBDEA727C0869187AB3F61DD27B1", hash_generated_method = "D10607CEED0D4A5C5218027895A483A6")
    
private PolicyManager() {}
    static {
        try {
            Class policyClass = Class.forName(POLICY_IMPL_CLASS_NAME);
            sPolicy = (IPolicy)policyClass.newInstance();
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(
                    POLICY_IMPL_CLASS_NAME + " could not be loaded", ex);
        } catch (InstantiationException ex) {
            throw new RuntimeException(
                    POLICY_IMPL_CLASS_NAME + " could not be instantiated", ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(
                    POLICY_IMPL_CLASS_NAME + " could not be instantiated", ex);
        }
    }
    
    private static class MyLayoutInflater extends LayoutInflater {
        
        public MyLayoutInflater(Context context){
            super(context);
        }

        @Override
        
        public LayoutInflater cloneInContext(Context newContext) {
            MyLayoutInflater newCopy = new MyLayoutInflater(newContext);
            newCopy.addTaint(getTaint());
            // TODO Auto-generated method stub
            return newCopy;
        }
        
    }
    
    private static class MyPolicy implements IPolicy {

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public Window makeNewWindow(Context context) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public LayoutInflater makeNewLayoutInflater(Context context) {
            // TODO Auto-generated method stub
            return new MyLayoutInflater(context);
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public WindowManagerPolicy makeNewWindowManager() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public FallbackEventHandler makeNewFallbackEventHandler(Context context) {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
    
}

