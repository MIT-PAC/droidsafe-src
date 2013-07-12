package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityDelegateCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.688 -0400", hash_original_method = "879A5ED94FFF8E2596509D34ABD5C8D4", hash_generated_method = "879A5ED94FFF8E2596509D34ABD5C8D4")
    public AccessibilityDelegateCompatIcs ()
    {
        
    }


        public static Object newAccessibilityDelegateDefaultImpl() {
        return new AccessibilityDelegate();
    }

    
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

    
        public static boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
            AccessibilityEvent event) {
        return ((AccessibilityDelegate) delegate).dispatchPopulateAccessibilityEvent(host, event);
    }

    
        public static void onInitializeAccessibilityEvent(Object delegate, View host,
            AccessibilityEvent event) {
        
        ((AccessibilityDelegate) delegate).onInitializeAccessibilityEvent(host, event);
    }

    
        public static void onInitializeAccessibilityNodeInfo(Object delegate, View host, Object info) {
        
        ((AccessibilityDelegate) delegate).onInitializeAccessibilityNodeInfo(host,
                (AccessibilityNodeInfo) info);
    }

    
        public static void onPopulateAccessibilityEvent(Object delegate, View host,
            AccessibilityEvent event) {
        
        ((AccessibilityDelegate) delegate).onPopulateAccessibilityEvent(host, event);
    }

    
        public static boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host,
            View child, AccessibilityEvent event) {
        
        return ((AccessibilityDelegate) delegate).onRequestSendAccessibilityEvent(host, child,
                event);
    }

    
        public static void sendAccessibilityEvent(Object delegate, View host, int eventType) {
        ((AccessibilityDelegate) delegate).sendAccessibilityEvent(host, eventType);
    }

    
        public static void sendAccessibilityEventUnchecked(Object delegate, View host,
            AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).sendAccessibilityEventUnchecked(host, event);
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

