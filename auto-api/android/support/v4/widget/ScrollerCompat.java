package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.widget.Scroller;

class ScrollerCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.887 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "16226695B3E75E1B75AD8C16FE7698DB")

    Scroller mScroller;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.887 -0400", hash_original_method = "FA1A2D0DAD3F764AAD83BFC7CD2D5247", hash_generated_method = "ADFE7BCE01A0CE5B768A2B42419AC5CF")
      ScrollerCompat(Context context) {
        mScroller = new Scroller(context);
        // ---------- Original Method ----------
        //mScroller = new Scroller(context);
    }

    
        public static ScrollerCompat from(Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            return new ScrollerCompatImplIcs(context);
        }
        return new ScrollerCompat(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.888 -0400", hash_original_method = "08E3AC245A369E97AD27AAF8D6409619", hash_generated_method = "59371D64BA5602A8838583CB4AB9FF95")
    public boolean isFinished() {
        boolean var676DA283781DC0662718E855940C19BD_339624957 = (mScroller.isFinished());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943286976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_943286976;
        // ---------- Original Method ----------
        //return mScroller.isFinished();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.888 -0400", hash_original_method = "366441F0E9218C10049321570A6B0EEE", hash_generated_method = "240883F54D77C7BF16900D6596911177")
    public int getDuration() {
        int var7B474CACB59A96696A86E2CF7DA48604_527276333 = (mScroller.getDuration());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131004216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131004216;
        // ---------- Original Method ----------
        //return mScroller.getDuration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.889 -0400", hash_original_method = "35378E6889E84DC24B962EF341786646", hash_generated_method = "5D78908AB3DF06D1BABB2A12BD32DCC5")
    public int getCurrX() {
        int var9CB2FA3253EAB90ECE4C8224203A4C62_1027387288 = (mScroller.getCurrX());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194779974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194779974;
        // ---------- Original Method ----------
        //return mScroller.getCurrX();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.889 -0400", hash_original_method = "88F1303EFC32E6128287766990FA2843", hash_generated_method = "FC8BCC143D748DCFE0F2D36CDF72D825")
    public int getCurrY() {
        int varB7026D7B298059F6800282D22A09F1A1_1747520110 = (mScroller.getCurrY());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517884943 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517884943;
        // ---------- Original Method ----------
        //return mScroller.getCurrY();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.889 -0400", hash_original_method = "7F4E33B7B0F7490B30E97B0B0A01E6E1", hash_generated_method = "CCA7AF0CB1CF0D9399DFBCA6DF937FD4")
    public float getCurrVelocity() {
        float var546ADE640B6EDFBC8A086EF31347E768_1722927295 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1722927295;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.890 -0400", hash_original_method = "A0C0DE015B6558CE9DF1FB944A356241", hash_generated_method = "5503573254F055DEA74CE3E1052091A4")
    public boolean computeScrollOffset() {
        boolean var94A055CA54A316D8E7E7C5D5D1B3257F_1982956438 = (mScroller.computeScrollOffset());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588561908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_588561908;
        // ---------- Original Method ----------
        //return mScroller.computeScrollOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.890 -0400", hash_original_method = "B37994C7256BD0AE82424571EBE03373", hash_generated_method = "46FDD692279024DD82A4A4D727CCE810")
    public void startScroll(int startX, int startY, int dx, int dy) {
        mScroller.startScroll(startX, startY, dx, dy);
        addTaint(startX);
        addTaint(startY);
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        //mScroller.startScroll(startX, startY, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.910 -0400", hash_original_method = "AD5D18790E0603EF4AC905740DD66097", hash_generated_method = "DEF10DD88CC79AC02C8184460102CB0C")
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        mScroller.startScroll(startX, startY, dx, dy, duration);
        addTaint(startX);
        addTaint(startY);
        addTaint(dx);
        addTaint(dy);
        addTaint(duration);
        // ---------- Original Method ----------
        //mScroller.startScroll(startX, startY, dx, dy, duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.911 -0400", hash_original_method = "7C081E82C785E2E194103B9AE1A28412", hash_generated_method = "009E446605B65B6133B72F3A87D4E9AA")
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        mScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
        addTaint(startX);
        addTaint(startY);
        addTaint(velocityX);
        addTaint(velocityY);
        addTaint(minX);
        addTaint(maxX);
        addTaint(minY);
        addTaint(maxY);
        // ---------- Original Method ----------
        //mScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.912 -0400", hash_original_method = "C4C8DA6FAA392191BEE38D271B2F867F", hash_generated_method = "AB5BE5E1DC8EEE9600D7B4EC6B589008")
    public void abortAnimation() {
        mScroller.abortAnimation();
        // ---------- Original Method ----------
        //mScroller.abortAnimation();
    }

    
    static class ScrollerCompatImplIcs extends ScrollerCompat {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.926 -0400", hash_original_method = "A457AA7689BFE7024C2FB76B15B39CB7", hash_generated_method = "99CF699D33A7CD437D4A420F5944C49C")
        public  ScrollerCompatImplIcs(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.927 -0400", hash_original_method = "3DB200182B4DEC93AD6432958A4646FE", hash_generated_method = "21E44B6B32060B6C0EF9424B4CBDB1DD")
        @Override
        public float getCurrVelocity() {
            float var086BB9226977B37C03BFB0638BB3790D_327120072 = (ScrollerCompatIcs.getCurrVelocity(mScroller));
            float var546ADE640B6EDFBC8A086EF31347E768_1228833042 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1228833042;
            // ---------- Original Method ----------
            //return ScrollerCompatIcs.getCurrVelocity(mScroller);
        }

        
    }


    
}

