package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.MotionEvent;

public class MotionEventCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.507 -0400", hash_original_method = "5A13315CB97E0E2867AD42FF281F6179", hash_generated_method = "5A13315CB97E0E2867AD42FF281F6179")
    public MotionEventCompat ()
    {
        //Synthesized constructor
    }


    public static int getActionMasked(MotionEvent event) {
        return event.getAction() & ACTION_MASK;
    }

    
    public static int getActionIndex(MotionEvent event) {
        return (event.getAction() & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT;
    }

    
    public static int findPointerIndex(MotionEvent event, int pointerId) {
        return IMPL.findPointerIndex(event, pointerId);
    }

    
    public static int getPointerId(MotionEvent event, int pointerIndex) {
        return IMPL.getPointerId(event, pointerIndex);
    }

    
    public static float getX(MotionEvent event, int pointerIndex) {
        return IMPL.getX(event, pointerIndex);
    }

    
    public static float getY(MotionEvent event, int pointerIndex) {
        return IMPL.getY(event, pointerIndex);
    }

    
    public static int getPointerCount(MotionEvent event) {
        return IMPL.getPointerCount(event);
    }

    
    static class BaseMotionEventVersionImpl implements MotionEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.510 -0400", hash_original_method = "1452E4140DDA36A9AA18888B766DC89D", hash_generated_method = "1452E4140DDA36A9AA18888B766DC89D")
        public BaseMotionEventVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.513 -0400", hash_original_method = "915485589CA18931BFA6184EB5D82CE0", hash_generated_method = "7D3C8D8554FD262D21653C31C1FDF796")
        @Override
        public int findPointerIndex(MotionEvent event, int pointerId) {
            addTaint(event.getTaint());
            addTaint(pointerId);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422685793 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422685793;
            // ---------- Original Method ----------
            //if (pointerId == 0) {
                //return 0;
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.515 -0400", hash_original_method = "9E7B122BF9BB453BF7E85C1115C02518", hash_generated_method = "BC7787C9278AEFCE23DD1EA49353D8E8")
        @Override
        public int getPointerId(MotionEvent event, int pointerIndex) {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079784454 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079784454;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return 0;
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.516 -0400", hash_original_method = "46B436EF23A4E7BD3E33198488E751EA", hash_generated_method = "461F956A59ACF393E5837F97C6B8BA8F")
        @Override
        public float getX(MotionEvent event, int pointerIndex) {
            {
                float var4F6AE2AFF11B86B2C3641212C8C2EBAF_946212295 = (event.getX());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            float var546ADE640B6EDFBC8A086EF31347E768_362457639 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_362457639;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return event.getX();
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.518 -0400", hash_original_method = "71D40AC5F4F710155978216341C47632", hash_generated_method = "AE62252C5870F9FA71E06EFF9ECF7AAD")
        @Override
        public float getY(MotionEvent event, int pointerIndex) {
            {
                float var64A0A7BC57B75ADF90B3D1D036BDB1B3_958697264 = (event.getY());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            float var546ADE640B6EDFBC8A086EF31347E768_1813218434 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1813218434;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return event.getY();
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.519 -0400", hash_original_method = "F1B2637001FBFFCBD7AA64840D270091", hash_generated_method = "06A29B3B926DAD2BB22B48D8F37DF195")
        @Override
        public int getPointerCount(MotionEvent event) {
            addTaint(event.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068521641 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068521641;
            // ---------- Original Method ----------
            //return 1;
        }

        
    }


    
    static class EclairMotionEventVersionImpl implements MotionEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.520 -0400", hash_original_method = "042D39F66E91ADDA4B8AD5816FDB91A1", hash_generated_method = "042D39F66E91ADDA4B8AD5816FDB91A1")
        public EclairMotionEventVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.521 -0400", hash_original_method = "1F125219ECB51BDA24372EEEA6E62AC1", hash_generated_method = "02467E4F010E3D0409894D8E216EFEB3")
        @Override
        public int findPointerIndex(MotionEvent event, int pointerId) {
            int var74697131C73A550DA3FD39D232589E68_1686217097 = (MotionEventCompatEclair.findPointerIndex(event, pointerId));
            addTaint(event.getTaint());
            addTaint(pointerId);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404877641 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404877641;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.findPointerIndex(event, pointerId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.522 -0400", hash_original_method = "CB6B0C0269880E57D0AAF045A3B12252", hash_generated_method = "BF46FF9BB8DED3BFFEC48ACF39F2F621")
        @Override
        public int getPointerId(MotionEvent event, int pointerIndex) {
            int var00030AD40F576F98902733219308D66F_1286410625 = (MotionEventCompatEclair.getPointerId(event, pointerIndex));
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922732394 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922732394;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getPointerId(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.523 -0400", hash_original_method = "CC9227E21CD6D287D30FF5F6779E2A13", hash_generated_method = "CC8D0B6EC8DB778C8AD0B52AAFAFB5FE")
        @Override
        public float getX(MotionEvent event, int pointerIndex) {
            float varC9E880D3FEDC669C755AD1439729DBFB_576651586 = (MotionEventCompatEclair.getX(event, pointerIndex));
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            float var546ADE640B6EDFBC8A086EF31347E768_1768394587 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1768394587;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getX(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.524 -0400", hash_original_method = "F1D4241FA671175201C1D58741E0B6B9", hash_generated_method = "D5ADA0AB97E817E28AC6253830F738D2")
        @Override
        public float getY(MotionEvent event, int pointerIndex) {
            float var3BF9CA1F6B6DA8FDD15439C92A6F3189_970608008 = (MotionEventCompatEclair.getY(event, pointerIndex));
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            float var546ADE640B6EDFBC8A086EF31347E768_450019383 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_450019383;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getY(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.525 -0400", hash_original_method = "9E092C63409B479B27716D0F10009856", hash_generated_method = "E28654D242CE909C863FFE1A9AADDB56")
        @Override
        public int getPointerCount(MotionEvent event) {
            int varB6EFAB7EDD4C67469681CF88471FD9FF_502903262 = (MotionEventCompatEclair.getPointerCount(event));
            addTaint(event.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487832545 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487832545;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getPointerCount(event);
        }

        
    }


    
    interface MotionEventVersionImpl {
        public int findPointerIndex(MotionEvent event, int pointerId);
        public int getPointerId(MotionEvent event, int pointerIndex);
        public float getX(MotionEvent event, int pointerIndex);
        public float getY(MotionEvent event, int pointerIndex);
        public int getPointerCount(MotionEvent event);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.526 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "F0C04F9075773F238646F09F10EC5686")

    static MotionEventVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 5) {
            IMPL = new EclairMotionEventVersionImpl();
        } else {
            IMPL = new BaseMotionEventVersionImpl();
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.527 -0400", hash_original_field = "034E2BCD80D0FE32BEE35A26F527AB82", hash_generated_field = "464488178905DF6887AEEC102D03F9BB")

    public static final int ACTION_MASK = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.527 -0400", hash_original_field = "596B10C23830633246B5FE119303CA31", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.527 -0400", hash_original_field = "1CD52FBA3CE6A637AE86BF305E1727A2", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.528 -0400", hash_original_field = "A117FB885030C87F8035EE8197E01274", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.528 -0400", hash_original_field = "EDD00CD16649F89FF44DD9C0E161B238", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.529 -0400", hash_original_field = "F94A33E7C5ACFBEFDFBB09F0FB9B278A", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.529 -0400", hash_original_field = "DAB0332B2F0024984DE4DD67C040BC0F", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.530 -0400", hash_original_field = "E6889A317885B7F3FCFCB516DDE1B506", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.530 -0400", hash_original_field = "5A019C5D2F9BBBECE84DA46559873CDE", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT = 10;
}

