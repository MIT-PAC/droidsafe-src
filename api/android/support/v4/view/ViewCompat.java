package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ViewCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.862 -0400", hash_original_method = "2D3AD98427119C7C46265965AF02446D", hash_generated_method = "2D3AD98427119C7C46265965AF02446D")
    public ViewCompat ()
    {
        //Synthesized constructor
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
        //DSFIXME:  CODE0009: Possible callback target function detected
        IMPL.onPopulateAccessibilityEvent(v, event);
    }

    
        public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        IMPL.onInitializeAccessibilityEvent(v, event);
    }

    
        public static void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        IMPL.onInitializeAccessibilityNodeInfo(v, info);
    }

    
        public static void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
        IMPL.setAccessibilityDelegate(v, delegate);
    }

    
    static class BaseViewCompatImpl implements ViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.865 -0400", hash_original_method = "41ADABC234167BF75948986C00D7164F", hash_generated_method = "41ADABC234167BF75948986C00D7164F")
        public BaseViewCompatImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.865 -0400", hash_original_method = "B6398682E53A0553C234AF7A57520A50", hash_generated_method = "35632FE336CBBC45CC1F3343BAFC9D26")
        public boolean canScrollHorizontally(View v, int direction) {
            addTaint(direction);
            addTaint(v.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1107458033 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1653083954 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1653083954;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.866 -0400", hash_original_method = "503E40CFCA77F79E3DB90A02CF27CB11", hash_generated_method = "3B766DC1DCB4C18D2F1BBB0DBD66D6AA")
        public boolean canScrollVertically(View v, int direction) {
            addTaint(direction);
            addTaint(v.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1799847488 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240599577 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240599577;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.866 -0400", hash_original_method = "FE606A273B3E1C6F88C42FF299410004", hash_generated_method = "6DA4B8DFC96504F97EBC06EBF7BA2B8A")
        public int getOverScrollMode(View v) {
            addTaint(v.getTaint());
            int varF8F81262CFC5E473A7FD3DD66929CFED_192773340 = (OVER_SCROLL_NEVER);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316691621 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316691621;
            // ---------- Original Method ----------
            //return OVER_SCROLL_NEVER;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.866 -0400", hash_original_method = "6EF0161350C522C30619CD84403B6E93", hash_generated_method = "47368EF486862CDAD685FAE36B62B2CD")
        public void setOverScrollMode(View v, int mode) {
            addTaint(mode);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.866 -0400", hash_original_method = "122EA5B596C8B5B38E62AE02215B1570", hash_generated_method = "ADBD257C2311028DEB10D245F70FFBAA")
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            addTaint(delegate.getTaint());
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.867 -0400", hash_original_method = "702F7E45C5537D15A13A9B08A18B3D2B", hash_generated_method = "3879B1CED5D68370806D828AF1589C6E")
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.867 -0400", hash_original_method = "9137ED0A1BFDD4FC8792E5A61DC6F04E", hash_generated_method = "F36CCDCE190207103C315CD3A7CCB0D3")
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.867 -0400", hash_original_method = "E0BDF5AA116BC42106585B9B041EC074", hash_generated_method = "87FD8464EAFE5F95715E8EE7346E2350")
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(info.getTaint());
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    static class GBViewCompatImpl extends BaseViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.867 -0400", hash_original_method = "B29ABB75D45C38E68F6507295346B5B9", hash_generated_method = "B29ABB75D45C38E68F6507295346B5B9")
        public GBViewCompatImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.868 -0400", hash_original_method = "6AE192D9CDFE24BE71EEBB7861AC5739", hash_generated_method = "E0F576943ADAE14CDC862D7675D01231")
        @Override
        public int getOverScrollMode(View v) {
            addTaint(v.getTaint());
            int var4368ED817A657CC4AAC44185C01DC794_117828442 = (ViewCompatGingerbread.getOverScrollMode(v));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1944617813 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1944617813;
            // ---------- Original Method ----------
            //return ViewCompatGingerbread.getOverScrollMode(v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.868 -0400", hash_original_method = "652BCFC6DB6C20C8D62EA02A6E673E41", hash_generated_method = "D7AD0C980F07759587894F7C808A582F")
        @Override
        public void setOverScrollMode(View v, int mode) {
            addTaint(mode);
            addTaint(v.getTaint());
            ViewCompatGingerbread.setOverScrollMode(v, mode);
            // ---------- Original Method ----------
            //ViewCompatGingerbread.setOverScrollMode(v, mode);
        }

        
    }


    
    static class ICSViewCompatImpl extends GBViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.868 -0400", hash_original_method = "F82CC7286340E827BB3F02C5F17E58C8", hash_generated_method = "F82CC7286340E827BB3F02C5F17E58C8")
        public ICSViewCompatImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.868 -0400", hash_original_method = "C9BAAD76CDA8C75C5F08B6168D212799", hash_generated_method = "8F04B741B8415AF8C26BBC5AF9051695")
        @Override
        public boolean canScrollHorizontally(View v, int direction) {
            addTaint(direction);
            addTaint(v.getTaint());
            boolean var3CA785CD0B32CEE60D15328144C057A1_1895835882 = (ViewCompatICS.canScrollHorizontally(v, direction));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1215666214 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1215666214;
            // ---------- Original Method ----------
            //return ViewCompatICS.canScrollHorizontally(v, direction);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.869 -0400", hash_original_method = "C0DBA3C69AA17D8232DF13575A7B0094", hash_generated_method = "A5ADD051C8081A696EB07C369C38A6BF")
        @Override
        public boolean canScrollVertically(View v, int direction) {
            addTaint(direction);
            addTaint(v.getTaint());
            boolean var78CAFD1239B0F625499148A422B217FB_324434338 = (ViewCompatICS.canScrollVertically(v, direction));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890000579 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_890000579;
            // ---------- Original Method ----------
            //return ViewCompatICS.canScrollVertically(v, direction);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.869 -0400", hash_original_method = "30706FC93A804D8A8DC1FCFB98D98BAD", hash_generated_method = "96E57ADB07FA8BBF109D72DC89B44FD9")
        @Override
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(v.getTaint());
            ViewCompatICS.onPopulateAccessibilityEvent(v, event);
            // ---------- Original Method ----------
            //ViewCompatICS.onPopulateAccessibilityEvent(v, event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.869 -0400", hash_original_method = "D787101BC5F3E4F3C49A8D686CC81288", hash_generated_method = "20E184001A20C845EF36CC534E925C14")
        @Override
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(v.getTaint());
            ViewCompatICS.onInitializeAccessibilityEvent(v, event);
            // ---------- Original Method ----------
            //ViewCompatICS.onInitializeAccessibilityEvent(v, event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.870 -0400", hash_original_method = "766209C343FE76A0076A6D65E22F224A", hash_generated_method = "B7C90F2CA71FCD73FC870525BEE6851A")
        @Override
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(info.getTaint());
            addTaint(v.getTaint());
            ViewCompatICS.onInitializeAccessibilityNodeInfo(v, info.getImpl());
            // ---------- Original Method ----------
            //ViewCompatICS.onInitializeAccessibilityNodeInfo(v, info.getImpl());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.870 -0400", hash_original_method = "256253E870D0A3AB828902545E88A8B8", hash_generated_method = "AC2E7F3EC8149C9A4903447DF08BBD62")
        @Override
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            addTaint(delegate.getTaint());
            addTaint(v.getTaint());
            ViewCompatICS.setAccessibilityDelegate(v, delegate.getBridge());
            // ---------- Original Method ----------
            //ViewCompatICS.setAccessibilityDelegate(v, delegate.getBridge());
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.870 -0400", hash_original_field = "7EB0B2502005C4CB40D46FF10A6B736D", hash_generated_field = "8F276B4C86F06142AEDE0C97A7FE2F68")

    public static final int OVER_SCROLL_ALWAYS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.870 -0400", hash_original_field = "67D34493973359A97A217AD3B17DA6CF", hash_generated_field = "218BFE0FF46A804B55589DCE0FFD7D0A")

    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.870 -0400", hash_original_field = "E1779A27D7E8D7DB9FBA34E6E8D0F4A8", hash_generated_field = "009B55485034BF3BF55F8691DA9788F7")

    public static final int OVER_SCROLL_NEVER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.870 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "BBDF66702D3CCA930AA785B97237B8E4")

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

