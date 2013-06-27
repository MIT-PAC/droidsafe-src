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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.345 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "16226695B3E75E1B75AD8C16FE7698DB")

    Scroller mScroller;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.345 -0400", hash_original_method = "FA1A2D0DAD3F764AAD83BFC7CD2D5247", hash_generated_method = "ADFE7BCE01A0CE5B768A2B42419AC5CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.346 -0400", hash_original_method = "08E3AC245A369E97AD27AAF8D6409619", hash_generated_method = "D2A4D1B79C08A0F0EF7619F8FE360C45")
    public boolean isFinished() {
        boolean var676DA283781DC0662718E855940C19BD_1525744735 = (mScroller.isFinished());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513757458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_513757458;
        // ---------- Original Method ----------
        //return mScroller.isFinished();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.357 -0400", hash_original_method = "366441F0E9218C10049321570A6B0EEE", hash_generated_method = "EBBF10CDEEA7109E04EFC8B1F1A062E0")
    public int getDuration() {
        int var7B474CACB59A96696A86E2CF7DA48604_1306412477 = (mScroller.getDuration());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233474850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233474850;
        // ---------- Original Method ----------
        //return mScroller.getDuration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.358 -0400", hash_original_method = "35378E6889E84DC24B962EF341786646", hash_generated_method = "9AD3B25297376586B2440E5C00F4CD43")
    public int getCurrX() {
        int var9CB2FA3253EAB90ECE4C8224203A4C62_1472530298 = (mScroller.getCurrX());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821609747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821609747;
        // ---------- Original Method ----------
        //return mScroller.getCurrX();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.369 -0400", hash_original_method = "88F1303EFC32E6128287766990FA2843", hash_generated_method = "1A7802E1B7DCB2EE596A7C9324491FFE")
    public int getCurrY() {
        int varB7026D7B298059F6800282D22A09F1A1_561340642 = (mScroller.getCurrY());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122972162 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122972162;
        // ---------- Original Method ----------
        //return mScroller.getCurrY();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.370 -0400", hash_original_method = "7F4E33B7B0F7490B30E97B0B0A01E6E1", hash_generated_method = "FFB4B3113C2A54AD069C2F62E234A43C")
    public float getCurrVelocity() {
        float var546ADE640B6EDFBC8A086EF31347E768_351961909 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_351961909;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.371 -0400", hash_original_method = "A0C0DE015B6558CE9DF1FB944A356241", hash_generated_method = "B8D1161FAAB50FFB742208A75C17977F")
    public boolean computeScrollOffset() {
        boolean var94A055CA54A316D8E7E7C5D5D1B3257F_516706983 = (mScroller.computeScrollOffset());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844741612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844741612;
        // ---------- Original Method ----------
        //return mScroller.computeScrollOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.383 -0400", hash_original_method = "B37994C7256BD0AE82424571EBE03373", hash_generated_method = "46FDD692279024DD82A4A4D727CCE810")
    public void startScroll(int startX, int startY, int dx, int dy) {
        mScroller.startScroll(startX, startY, dx, dy);
        addTaint(startX);
        addTaint(startY);
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        //mScroller.startScroll(startX, startY, dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.394 -0400", hash_original_method = "AD5D18790E0603EF4AC905740DD66097", hash_generated_method = "DEF10DD88CC79AC02C8184460102CB0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.395 -0400", hash_original_method = "7C081E82C785E2E194103B9AE1A28412", hash_generated_method = "009E446605B65B6133B72F3A87D4E9AA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.395 -0400", hash_original_method = "C4C8DA6FAA392191BEE38D271B2F867F", hash_generated_method = "AB5BE5E1DC8EEE9600D7B4EC6B589008")
    public void abortAnimation() {
        mScroller.abortAnimation();
        // ---------- Original Method ----------
        //mScroller.abortAnimation();
    }

    
    static class ScrollerCompatImplIcs extends ScrollerCompat {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.396 -0400", hash_original_method = "A457AA7689BFE7024C2FB76B15B39CB7", hash_generated_method = "99CF699D33A7CD437D4A420F5944C49C")
        public  ScrollerCompatImplIcs(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.396 -0400", hash_original_method = "3DB200182B4DEC93AD6432958A4646FE", hash_generated_method = "0788A3B08273B4CB06B6C1963E256823")
        @Override
        public float getCurrVelocity() {
            float var086BB9226977B37C03BFB0638BB3790D_753263954 = (ScrollerCompatIcs.getCurrVelocity(mScroller));
            float var546ADE640B6EDFBC8A086EF31347E768_1459079572 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1459079572;
            // ---------- Original Method ----------
            //return ScrollerCompatIcs.getCurrVelocity(mScroller);
        }

        
    }


    
}

