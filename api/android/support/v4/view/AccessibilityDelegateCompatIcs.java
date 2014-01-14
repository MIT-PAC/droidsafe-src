package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityDelegateCompatIcs {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.520 -0500", hash_original_method = "0BF56F5CCF17BE32C048833B45062308", hash_generated_method = "1A92348F7C81313FDF77DB294C42542D")
    
public static Object newAccessibilityDelegateDefaultImpl() {
        return new AccessibilityDelegate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.552 -0500", hash_original_method = "49528E628E09F0ACBC9F2F1441CA40F4", hash_generated_method = "AAAC385529BA13E3AED9FAE186D52F49")
    
public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridge bridge) {
        return new AccessibilityDelegate() {
            @Override
            public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                return bridge.dispatchPopulateAccessibilityEvent(host, event);
            }

            @Override
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                bridge.onInitializeAccessibilityEvent(host, event);
            }

            @Override
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                bridge.onInitializeAccessibilityNodeInfo(host, info);
            }

            @Override
            public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                bridge.onPopulateAccessibilityEvent(host, event);
            }

            @Override
            public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                    AccessibilityEvent event) {
                return bridge.onRequestSendAccessibilityEvent(host, child, event);
            }

            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @Override
            public void sendAccessibilityEvent(View host, int eventType) {
                bridge.sendAccessibilityEvent(host, eventType);
            }

            @Override
            public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                bridge.sendAccessibilityEventUnchecked(host, event);
            }
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.557 -0500", hash_original_method = "6ACE51EA58811389F963855EDE91500A", hash_generated_method = "6709091DC317E6D55671708F35B14F8A")
    
public static boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
            AccessibilityEvent event) {
        return ((AccessibilityDelegate) delegate).dispatchPopulateAccessibilityEvent(host, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.560 -0500", hash_original_method = "85CA2CA899B97332E007EA6F9B53E710", hash_generated_method = "D65589C31F3EC7021C4E10325B12E146")
    
public static void onInitializeAccessibilityEvent(Object delegate, View host,
            AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).onInitializeAccessibilityEvent(host, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.564 -0500", hash_original_method = "1F8FACA0119C91F655C96295793323CF", hash_generated_method = "D3239850F59C5F767E60AC67AFF1AC10")
    
public static void onInitializeAccessibilityNodeInfo(Object delegate, View host, Object info) {
        ((AccessibilityDelegate) delegate).onInitializeAccessibilityNodeInfo(host,
                (AccessibilityNodeInfo) info);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.568 -0500", hash_original_method = "0843CB9D4B6841EC057F5B77887CA203", hash_generated_method = "9DF209BA8F6B6843B287C7F17B10F14D")
    
public static void onPopulateAccessibilityEvent(Object delegate, View host,
            AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).onPopulateAccessibilityEvent(host, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.573 -0500", hash_original_method = "7204DA13B3C3F023142E8E66ADA65AF6", hash_generated_method = "C4F68DFBC6BA459161E80F8BE8C9AFD4")
    
public static boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host,
            View child, AccessibilityEvent event) {
        return ((AccessibilityDelegate) delegate).onRequestSendAccessibilityEvent(host, child,
                event);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.577 -0500", hash_original_method = "0E2E4FD873FADD6CC8321BEC0F0E2131", hash_generated_method = "E288C785080EFFAE26BA9A31A63AAA5D")
    
public static void sendAccessibilityEvent(Object delegate, View host, int eventType) {
        ((AccessibilityDelegate) delegate).sendAccessibilityEvent(host, eventType);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.580 -0500", hash_original_method = "E3BFE62BC8A651C1280DE3E362953B84", hash_generated_method = "1FB6409CB33356FA4859B470C498B48B")
    
public static void sendAccessibilityEventUnchecked(Object delegate, View host,
            AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).sendAccessibilityEventUnchecked(host, event);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.210 -0400", hash_original_method = "879A5ED94FFF8E2596509D34ABD5C8D4", hash_generated_method = "879A5ED94FFF8E2596509D34ABD5C8D4")
    public AccessibilityDelegateCompatIcs ()
    {
        //Synthesized constructor
    }
    
    public interface AccessibilityDelegateBridge {
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event);
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event);
        public void onInitializeAccessibilityNodeInfo(View host, Object info);
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event);
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
            AccessibilityEvent event);
        public void sendAccessibilityEvent(View host, int eventType);
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event);
    }
    
}

