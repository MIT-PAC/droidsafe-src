package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ViewGroupCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.157 -0400", hash_original_method = "C9E473FFFB3F968718996597E8C1665E", hash_generated_method = "AD03CB4E24CAEDAB62910801DCD3D179")
    private  ViewGroupCompat() {
        // ---------- Original Method ----------
    }

    
    public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child,
            AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return IMPL.onRequestSendAccessibilityEvent(group, child, event);
    }

    
    static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.157 -0400", hash_original_method = "96224DCACFD79825327274209A8311E4", hash_generated_method = "96224DCACFD79825327274209A8311E4")
        public ViewGroupCompatStubImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.158 -0400", hash_original_method = "63663A61AE72F4EA1BE6069DE9E21D17", hash_generated_method = "5ADD5DD5A4C48727FE558C8924279478")
        public boolean onRequestSendAccessibilityEvent(
                ViewGroup group, View child, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(group.getTaint());
            addTaint(child.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251137693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251137693;
            // ---------- Original Method ----------
            //return true;
        }

        
    }


    
    static class ViewGroupCompatIcsImpl extends ViewGroupCompatStubImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.159 -0400", hash_original_method = "0D4FCFA2216E2F1B44C50F37B99B287D", hash_generated_method = "0D4FCFA2216E2F1B44C50F37B99B287D")
        public ViewGroupCompatIcsImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.160 -0400", hash_original_method = "4FD501F6AEC18CEA66F6672447D649B5", hash_generated_method = "A3FBF7E0F182A46A6631F4C4A951D256")
        @Override
        public boolean onRequestSendAccessibilityEvent(
                ViewGroup group, View child, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean var4AD480AAD54703DFC3F2CC38F2C4E18B_730138212 = (ViewGroupCompatIcs.onRequestSendAccessibilityEvent(group, child, event));
            addTaint(group.getTaint());
            addTaint(child.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1934866330 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1934866330;
            // ---------- Original Method ----------
            //return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(group, child, event);
        }

        
    }


    
    interface ViewGroupCompatImpl {
        public boolean onRequestSendAccessibilityEvent(ViewGroup group, View child,
                AccessibilityEvent event);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.161 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "E257834CBFA3D612BE0D9147AAF7AA2F")

    static ViewGroupCompatImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ViewGroupCompatIcsImpl();
        } else {
            IMPL = new ViewGroupCompatStubImpl();
        }
    }
    
}

