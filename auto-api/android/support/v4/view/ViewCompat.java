package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ViewCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.072 -0400", hash_original_method = "2D3AD98427119C7C46265965AF02446D", hash_generated_method = "2D3AD98427119C7C46265965AF02446D")
    public ViewCompat ()
    {
        
    }


    public static boolean canScrollHorizontally(View v, int direction) {
        return IMPL.canScrollHorizontally(v, direction);
    }

    
    public static boolean canScrollVertically(View v, int direction) {
        return IMPL.canScrollVertically(v, direction);
    }

    
    public static int getOverScrollMode(View v) {
        return IMPL.getOverScrollMode(v);
    }

    
    public static void setOverScrollMode(View v, int overScrollMode) {
        IMPL.setOverScrollMode(v, overScrollMode);
    }

    
    public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        
        IMPL.onPopulateAccessibilityEvent(v, event);
    }

    
    public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        
        IMPL.onInitializeAccessibilityEvent(v, event);
    }

    
    public static void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
        
        IMPL.onInitializeAccessibilityNodeInfo(v, info);
    }

    
    public static void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
        IMPL.setAccessibilityDelegate(v, delegate);
    }

    
    static class BaseViewCompatImpl implements ViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.074 -0400", hash_original_method = "41ADABC234167BF75948986C00D7164F", hash_generated_method = "41ADABC234167BF75948986C00D7164F")
        public BaseViewCompatImpl ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.075 -0400", hash_original_method = "B6398682E53A0553C234AF7A57520A50", hash_generated_method = "1BFEB47F5D7B48436F6EF4006655398E")
        public boolean canScrollHorizontally(View v, int direction) {
            addTaint(v.getTaint());
            addTaint(direction);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271542488 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_271542488;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.076 -0400", hash_original_method = "503E40CFCA77F79E3DB90A02CF27CB11", hash_generated_method = "88F0F5DA54A23A02AFF95A17EA827577")
        public boolean canScrollVertically(View v, int direction) {
            addTaint(v.getTaint());
            addTaint(direction);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602001226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_602001226;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.077 -0400", hash_original_method = "FE606A273B3E1C6F88C42FF299410004", hash_generated_method = "5120BB9B1516C85E291EB555456F5951")
        public int getOverScrollMode(View v) {
            addTaint(v.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500470788 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500470788;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.094 -0400", hash_original_method = "6EF0161350C522C30619CD84403B6E93", hash_generated_method = "2D02E8B290DEC2CDF2F2DB0722B517FB")
        public void setOverScrollMode(View v, int mode) {
            addTaint(v.getTaint());
            addTaint(mode);
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.096 -0400", hash_original_method = "122EA5B596C8B5B38E62AE02215B1570", hash_generated_method = "2E96D59A9F0F49C19106593E853399E2")
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            addTaint(v.getTaint());
            addTaint(delegate.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.097 -0400", hash_original_method = "702F7E45C5537D15A13A9B08A18B3D2B", hash_generated_method = "3FE22AACD73F1DAACF65AADBC6F00B9B")
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.098 -0400", hash_original_method = "9137ED0A1BFDD4FC8792E5A61DC6F04E", hash_generated_method = "52AAFF06B3F65DCB34F9396FD974B22F")
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
            
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.103 -0400", hash_original_method = "E0BDF5AA116BC42106585B9B041EC074", hash_generated_method = "8A4948A59C9913A2E51572DBD040132E")
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            
            addTaint(v.getTaint());
            addTaint(info.getTaint());
            
        }

        
    }


    
    static class GBViewCompatImpl extends BaseViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.104 -0400", hash_original_method = "B29ABB75D45C38E68F6507295346B5B9", hash_generated_method = "B29ABB75D45C38E68F6507295346B5B9")
        public GBViewCompatImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.105 -0400", hash_original_method = "6AE192D9CDFE24BE71EEBB7861AC5739", hash_generated_method = "812B6066CC93722750E5DBABCEAA2ED6")
        @Override
        public int getOverScrollMode(View v) {
            int var8FFCB1A71C95FAD75E4CCDA1B58D93F2_1042973671 = (ViewCompatGingerbread.getOverScrollMode(v));
            addTaint(v.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863417854 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863417854;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.106 -0400", hash_original_method = "652BCFC6DB6C20C8D62EA02A6E673E41", hash_generated_method = "A425C9081A6B7B1AF8FC5803148E0A61")
        @Override
        public void setOverScrollMode(View v, int mode) {
            ViewCompatGingerbread.setOverScrollMode(v, mode);
            addTaint(v.getTaint());
            addTaint(mode);
            
            
        }

        
    }


    
    static class ICSViewCompatImpl extends GBViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.107 -0400", hash_original_method = "F82CC7286340E827BB3F02C5F17E58C8", hash_generated_method = "F82CC7286340E827BB3F02C5F17E58C8")
        public ICSViewCompatImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.109 -0400", hash_original_method = "C9BAAD76CDA8C75C5F08B6168D212799", hash_generated_method = "631BB9DCEF06DC42FDF4638B8014883F")
        @Override
        public boolean canScrollHorizontally(View v, int direction) {
            boolean var985BD512FB88B698FF2B717FE9AC5708_31207448 = (ViewCompatICS.canScrollHorizontally(v, direction));
            addTaint(v.getTaint());
            addTaint(direction);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194512855 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194512855;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.111 -0400", hash_original_method = "C0DBA3C69AA17D8232DF13575A7B0094", hash_generated_method = "C6F8AA4DC76CE83844CD3B8F37D0692A")
        @Override
        public boolean canScrollVertically(View v, int direction) {
            boolean varC2FE1F2AAAD5A34D8DC1A0ACD52676AC_1957964559 = (ViewCompatICS.canScrollVertically(v, direction));
            addTaint(v.getTaint());
            addTaint(direction);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379968824 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_379968824;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.113 -0400", hash_original_method = "30706FC93A804D8A8DC1FCFB98D98BAD", hash_generated_method = "8DB84EEB990332D88F50500299C445D4")
        @Override
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            
            ViewCompatICS.onPopulateAccessibilityEvent(v, event);
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.114 -0400", hash_original_method = "D787101BC5F3E4F3C49A8D686CC81288", hash_generated_method = "D977879FF619BD3871C0755EC4291CF7")
        @Override
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
            
            ViewCompatICS.onInitializeAccessibilityEvent(v, event);
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.117 -0400", hash_original_method = "766209C343FE76A0076A6D65E22F224A", hash_generated_method = "F9BF19959595663FE62B35DE243E0A55")
        @Override
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            
            ViewCompatICS.onInitializeAccessibilityNodeInfo(v, info.getImpl());
            addTaint(v.getTaint());
            addTaint(info.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.119 -0400", hash_original_method = "256253E870D0A3AB828902545E88A8B8", hash_generated_method = "8EE7934C9B123A96C70200B8978D98E2")
        @Override
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            ViewCompatICS.setAccessibilityDelegate(v, delegate.getBridge());
            addTaint(v.getTaint());
            addTaint(delegate.getTaint());
            
            
        }

        
    }


    
    interface ViewCompatImpl {
        public boolean canScrollHorizontally(View v, int direction);
        public boolean canScrollVertically(View v, int direction);
        public int getOverScrollMode(View v);
        public void setOverScrollMode(View v, int mode);
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event);
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event);
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info);
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.120 -0400", hash_original_field = "7EB0B2502005C4CB40D46FF10A6B736D", hash_generated_field = "8F276B4C86F06142AEDE0C97A7FE2F68")

    public static final int OVER_SCROLL_ALWAYS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.120 -0400", hash_original_field = "67D34493973359A97A217AD3B17DA6CF", hash_generated_field = "218BFE0FF46A804B55589DCE0FFD7D0A")

    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.121 -0400", hash_original_field = "E1779A27D7E8D7DB9FBA34E6E8D0F4A8", hash_generated_field = "009B55485034BF3BF55F8691DA9788F7")

    public static final int OVER_SCROLL_NEVER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.121 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "BBDF66702D3CCA930AA785B97237B8E4")

    static ViewCompatImpl IMPL;
    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 14) {
            IMPL = new ICSViewCompatImpl();
        } else if (version >= 9) {
            IMPL = new GBViewCompatImpl();
        } else {
            IMPL = new BaseViewCompatImpl();
        }
    }
    
}

