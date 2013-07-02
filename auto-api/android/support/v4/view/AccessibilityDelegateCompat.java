package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityDelegateCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.813 -0400", hash_original_field = "CED5B47A41B625766CF001EFABC0528E", hash_generated_field = "FB4910AEBDA35C6A7EDDEEAAF16AFC5E")

    Object mBridge;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.816 -0400", hash_original_method = "97DB5C1E35BD81C1D800183C23794857", hash_generated_method = "F78BE570E201B647D3E12D3E6CF191F8")
    public  AccessibilityDelegateCompat() {
        mBridge = IMPL.newAccessiblityDelegateBridge(this);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.818 -0400", hash_original_method = "29194344028099349300BA7E9C8229CD", hash_generated_method = "D95A343C69B35190E2DC986D56B10747")
     Object getBridge() {
        Object varB4EAC82CA7396A68D541C85D26508E83_823429421 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_823429421 = mBridge;
        varB4EAC82CA7396A68D541C85D26508E83_823429421.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_823429421;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.820 -0400", hash_original_method = "AF292CC2C422FC35BC5B564D13D2EFD0", hash_generated_method = "47B863C06E7D03C0F86F0B2B27A41B9C")
    public void sendAccessibilityEvent(View host, int eventType) {
        IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, host, eventType);
        addTaint(host.getTaint());
        addTaint(eventType);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.821 -0400", hash_original_method = "B8A02114F1FBE7409787CB3469B3FB8D", hash_generated_method = "145D45F8FE228B053288955E38F4015F")
    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, host, event);
        addTaint(host.getTaint());
        addTaint(event.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.823 -0400", hash_original_method = "1C87274B198DB8C027DD7E3DED431EEE", hash_generated_method = "3038C97C1C49DDACC545120CFE9489DF")
    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        boolean var3D22ED8DD9805D7BFEC9AD1FAF78CCC7_150907813 = (IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event));
        addTaint(host.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112399927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_112399927;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.825 -0400", hash_original_method = "DE3AA9FE26B29E02F70EE9289C022DB2", hash_generated_method = "A760082405A2E66FFDAB7090C8FEC821")
    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        
        IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event);
        addTaint(host.getTaint());
        addTaint(event.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.826 -0400", hash_original_method = "6FCF19A166005C43B6A9E9FED7E7775A", hash_generated_method = "4768F875487410886D19D4EFDC0D90A3")
    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        
        IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, host, event);
        addTaint(host.getTaint());
        addTaint(event.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.828 -0400", hash_original_method = "702CF486436EF7CB7E261126510CB2C4", hash_generated_method = "64606EFE5CD378C0E76F1808743547A0")
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        
        IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, host, info);
        addTaint(host.getTaint());
        addTaint(info.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.830 -0400", hash_original_method = "73CE2F858DC24998E108FD42EF6CF922", hash_generated_method = "581236B0A85EA40CB14C124FE9E21848")
    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
            AccessibilityEvent event) {
        
        boolean var69D74D59B550CA311B682F3C47B72B0C_929755318 = (IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, host, child, event));
        addTaint(host.getTaint());
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597848290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597848290;
        
        
    }

    
    static class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.831 -0400", hash_original_method = "DD5FA6B7DB30F302274C6D21593F2A63", hash_generated_method = "DD5FA6B7DB30F302274C6D21593F2A63")
        public AccessibilityDelegateStubImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.832 -0400", hash_original_method = "5A07CEDF6000B635EBB3282D6BCEC4C0", hash_generated_method = "2A6E0A75583D01B9537C18DAA8A99FCF")
        public Object newAccessiblityDelegateDefaultImpl() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1695461801 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1695461801 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1695461801.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1695461801;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.834 -0400", hash_original_method = "CA4708336A662876B1C4E973563DF8C7", hash_generated_method = "DD50278B84067D0C04D6D13247A5683D")
        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat listener) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1658922055 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1658922055 = null;
            addTaint(listener.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1658922055.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1658922055;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.836 -0400", hash_original_method = "9EE5CAEDF307AFCEB241BA171EF39C83", hash_generated_method = "D648D5A783F8975ACD24DE40E1970584")
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97954816 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_97954816;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.837 -0400", hash_original_method = "1447397CED667B971B04D5F82ACD0B6D", hash_generated_method = "4AA540987961F0EBF5084648D65AFC02")
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.839 -0400", hash_original_method = "99C4DEE76C5B6F4A70F08ECD66D4CBFF", hash_generated_method = "9C128D820C3EF4C4A3AC4C05F804E9B6")
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info) {
            
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(info.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.840 -0400", hash_original_method = "01D49E3547E9C548CD307570029DA5C4", hash_generated_method = "B5E0E056B04A078952AD989636C909EC")
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.842 -0400", hash_original_method = "389DE28FC8C0CFCD072BB38D30CE111B", hash_generated_method = "A3A242655E8D34B449F5C1CF81CC0951")
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event) {
            
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(child.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605738945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_605738945;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.843 -0400", hash_original_method = "62BC6D1148E35F68F64E7D17E3EF0845", hash_generated_method = "021E25B476F42F0A67A8C6D8A2722461")
        public void sendAccessibilityEvent(Object delegate, View host, int eventType) {
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(eventType);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.845 -0400", hash_original_method = "B229E2592A12C5FBAB6E11834FD34BE2", hash_generated_method = "6628CE8D8E2CE518FFB3B6E8B3009709")
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event) {
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
        }

        
    }


    
    static class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.846 -0400", hash_original_method = "001B0205D9FC59E8AC4A7BF341AF74E0", hash_generated_method = "001B0205D9FC59E8AC4A7BF341AF74E0")
        public AccessibilityDelegateIcsImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.847 -0400", hash_original_method = "ADAF22ACD619CA057B205743038B9CB6", hash_generated_method = "EA5ED961A97EDB80ECD39A8E2002F20D")
        @Override
        public Object newAccessiblityDelegateDefaultImpl() {
            Object varB4EAC82CA7396A68D541C85D26508E83_868808134 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_868808134 = AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
            varB4EAC82CA7396A68D541C85D26508E83_868808134.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_868808134;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.850 -0400", hash_original_method = "EF6EEE52340F95386564E9C57AF7030E", hash_generated_method = "8628F9D989013DBE3B11E053DBDAC77A")
        @Override
        public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat compat) {
            Object varB4EAC82CA7396A68D541C85D26508E83_2126346931 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2126346931 = AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(
                    new AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() {
                @Override
                public boolean dispatchPopulateAccessibilityEvent(View host,
                        AccessibilityEvent event) {
                    return compat.dispatchPopulateAccessibilityEvent(host, event);
                }
                @Override
                public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                    compat.onInitializeAccessibilityEvent(host, event);
                }
                @Override
                public void onInitializeAccessibilityNodeInfo(View host, Object info) {
                    compat.onInitializeAccessibilityNodeInfo(host,
                            new AccessibilityNodeInfoCompat(info));
                }
                @Override
                public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                    compat.onPopulateAccessibilityEvent(host, event);
                }
                @Override
                public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                        AccessibilityEvent event) {
                    return compat.onRequestSendAccessibilityEvent(host, child, event);
                }
                @Override
                public void sendAccessibilityEvent(View host, int eventType) {
                    compat.sendAccessibilityEvent(host, eventType);
                }
                @Override
                public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                    compat.sendAccessibilityEventUnchecked(host, event);
                }
            });
            addTaint(compat.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2126346931.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2126346931;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.853 -0400", hash_original_method = "A1518D561F40DF26E37D569D02982E76", hash_generated_method = "9ECEE59ADEBA96D39A09E1A216BDA324")
        @Override
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            boolean var10218C74D147568F9EBB22BD4420F383_210733917 = (AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(delegate,
                    host, event));
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747676977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747676977;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.855 -0400", hash_original_method = "A0E50F9243C79B4834000935E8855FFE", hash_generated_method = "B00CAC2D0B53494EBA81765A6078FF8C")
        @Override
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(delegate, host, event);
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.857 -0400", hash_original_method = "D0ED71D45ACAEF3BA7B6BDF8CF8F5C95", hash_generated_method = "0E146CECA18C8BB7DC84E37668B3531D")
        @Override
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info) {
            
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(delegate, host,
                    info.getImpl());
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(info.getTaint());
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.859 -0400", hash_original_method = "1624D34A4650739EE18F8E9A67254A81", hash_generated_method = "73B6BC51CDC88D0421786D28D607D158")
        @Override
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            
            AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(delegate, host, event);
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.862 -0400", hash_original_method = "EF218248BAE86D6D59789C66485E274F", hash_generated_method = "1DFFBFA500C475EAEA61BD2C6B35AACA")
        @Override
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event) {
            
            boolean varBA90A39C9D9605ED248ACFF2D15FCDCB_2027228724 = (AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(delegate, host,
                    child, event));
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(child.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173810763 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173810763;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.864 -0400", hash_original_method = "C594616778EB2064149441C8178D2CA3", hash_generated_method = "4FAB98B567F5467AAD909630DC60283A")
        @Override
        public void sendAccessibilityEvent(Object delegate, View host, int eventType) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEvent(delegate, host, eventType);
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(eventType);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.866 -0400", hash_original_method = "BF4ECD99B5AA5C3F0A34771E612A54CE", hash_generated_method = "8F13C8BFD4EBE2AAA196DE534968EFD8")
        @Override
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(delegate, host, event);
            addTaint(delegate.getTaint());
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
            
        }

        
        
    }


    
    static interface AccessibilityDelegateImpl {
        public Object newAccessiblityDelegateDefaultImpl();
        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat listener);
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info);
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event);
        public void sendAccessibilityEvent(Object delegate, View host, int eventType);
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.867 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "69637AEE9A0A7BCD1114720A430081E5")

    private static AccessibilityDelegateImpl IMPL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:02.867 -0400", hash_original_field = "2AE65CAD5482162AD1E3215D63E295AF", hash_generated_field = "2FAA9D9F17162833D2EDFD9409B491F8")

    private static Object DEFAULT_DELEGATE;
    static {
        if (Build.VERSION.SDK_INT >= 14) { 
            IMPL = new AccessibilityDelegateIcsImpl();
        } else {
            IMPL = new AccessibilityDelegateStubImpl();
        }
        DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
    }
    
}

