package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.MotionEvent;

public class MotionEventCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.620 -0400", hash_original_method = "5A13315CB97E0E2867AD42FF281F6179", hash_generated_method = "5A13315CB97E0E2867AD42FF281F6179")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.623 -0400", hash_original_method = "1452E4140DDA36A9AA18888B766DC89D", hash_generated_method = "1452E4140DDA36A9AA18888B766DC89D")
        public BaseMotionEventVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.623 -0400", hash_original_method = "915485589CA18931BFA6184EB5D82CE0", hash_generated_method = "857B20795BEBF166AB14C2F45CD18149")
        @Override
        public int findPointerIndex(MotionEvent event, int pointerId) {
            addTaint(event.getTaint());
            addTaint(pointerId);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906339751 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906339751;
            // ---------- Original Method ----------
            //if (pointerId == 0) {
                //return 0;
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.624 -0400", hash_original_method = "9E7B122BF9BB453BF7E85C1115C02518", hash_generated_method = "E404D80D219D180CDCD1767BE9085C5C")
        @Override
        public int getPointerId(MotionEvent event, int pointerIndex) {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086837653 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086837653;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return 0;
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.625 -0400", hash_original_method = "46B436EF23A4E7BD3E33198488E751EA", hash_generated_method = "0ABBE81CF4F62918E0346CB682D1F199")
        @Override
        public float getX(MotionEvent event, int pointerIndex) {
            {
                float var4F6AE2AFF11B86B2C3641212C8C2EBAF_783648862 = (event.getX());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            float var546ADE640B6EDFBC8A086EF31347E768_969990910 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_969990910;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return event.getX();
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.626 -0400", hash_original_method = "71D40AC5F4F710155978216341C47632", hash_generated_method = "5024194F452B11880540280256E657CB")
        @Override
        public float getY(MotionEvent event, int pointerIndex) {
            {
                float var64A0A7BC57B75ADF90B3D1D036BDB1B3_1750437185 = (event.getY());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            float var546ADE640B6EDFBC8A086EF31347E768_1868195395 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1868195395;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return event.getY();
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.626 -0400", hash_original_method = "F1B2637001FBFFCBD7AA64840D270091", hash_generated_method = "F05618609C69593AE4893E42D6E260D4")
        @Override
        public int getPointerCount(MotionEvent event) {
            addTaint(event.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357357555 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357357555;
            // ---------- Original Method ----------
            //return 1;
        }

        
    }


    
    static class EclairMotionEventVersionImpl implements MotionEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.626 -0400", hash_original_method = "042D39F66E91ADDA4B8AD5816FDB91A1", hash_generated_method = "042D39F66E91ADDA4B8AD5816FDB91A1")
        public EclairMotionEventVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.627 -0400", hash_original_method = "1F125219ECB51BDA24372EEEA6E62AC1", hash_generated_method = "8116BEDB62E08DCBA2D797FF07DAB1F4")
        @Override
        public int findPointerIndex(MotionEvent event, int pointerId) {
            int var74697131C73A550DA3FD39D232589E68_219714472 = (MotionEventCompatEclair.findPointerIndex(event, pointerId));
            addTaint(event.getTaint());
            addTaint(pointerId);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025061689 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025061689;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.findPointerIndex(event, pointerId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.627 -0400", hash_original_method = "CB6B0C0269880E57D0AAF045A3B12252", hash_generated_method = "3328E927E58D618A58E3846354CC23A2")
        @Override
        public int getPointerId(MotionEvent event, int pointerIndex) {
            int var00030AD40F576F98902733219308D66F_713473270 = (MotionEventCompatEclair.getPointerId(event, pointerIndex));
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229361526 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229361526;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getPointerId(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.627 -0400", hash_original_method = "CC9227E21CD6D287D30FF5F6779E2A13", hash_generated_method = "95876C4ED672EA64252A026458BCD20D")
        @Override
        public float getX(MotionEvent event, int pointerIndex) {
            float varC9E880D3FEDC669C755AD1439729DBFB_615659155 = (MotionEventCompatEclair.getX(event, pointerIndex));
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            float var546ADE640B6EDFBC8A086EF31347E768_1433917558 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1433917558;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getX(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_method = "F1D4241FA671175201C1D58741E0B6B9", hash_generated_method = "46ED9570DDEF489C8451EC034DEC5691")
        @Override
        public float getY(MotionEvent event, int pointerIndex) {
            float var3BF9CA1F6B6DA8FDD15439C92A6F3189_686999691 = (MotionEventCompatEclair.getY(event, pointerIndex));
            addTaint(event.getTaint());
            addTaint(pointerIndex);
            float var546ADE640B6EDFBC8A086EF31347E768_614700252 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_614700252;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getY(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_method = "9E092C63409B479B27716D0F10009856", hash_generated_method = "CA6517DE4E9EC5BD55858550A9FF049A")
        @Override
        public int getPointerCount(MotionEvent event) {
            int varB6EFAB7EDD4C67469681CF88471FD9FF_1285685874 = (MotionEventCompatEclair.getPointerCount(event));
            addTaint(event.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428248051 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428248051;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "F0C04F9075773F238646F09F10EC5686")

    static MotionEventVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 5) {
            IMPL = new EclairMotionEventVersionImpl();
        } else {
            IMPL = new BaseMotionEventVersionImpl();
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "034E2BCD80D0FE32BEE35A26F527AB82", hash_generated_field = "464488178905DF6887AEEC102D03F9BB")

    public static final int ACTION_MASK = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "596B10C23830633246B5FE119303CA31", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "1CD52FBA3CE6A637AE86BF305E1727A2", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "A117FB885030C87F8035EE8197E01274", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "EDD00CD16649F89FF44DD9C0E161B238", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "F94A33E7C5ACFBEFDFBB09F0FB9B278A", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "DAB0332B2F0024984DE4DD67C040BC0F", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "E6889A317885B7F3FCFCB516DDE1B506", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.628 -0400", hash_original_field = "5A019C5D2F9BBBECE84DA46559873CDE", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT = 10;
}

