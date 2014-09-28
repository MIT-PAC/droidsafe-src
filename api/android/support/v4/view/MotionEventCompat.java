package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.MotionEvent;

public class MotionEventCompat {

    /**
     * Call {@link MotionEvent#getAction}, returning only the {@link #ACTION_MASK}
     * portion.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.128 -0500", hash_original_method = "CEB0F6E9A644FE5457EF6DDC68D66AE8", hash_generated_method = "5BE1F4103ACB423FCC073C9D6F258C22")
    
public static int getActionMasked(MotionEvent event) {
        return event.getAction() & ACTION_MASK;
    }

    /**
     * Call {@link MotionEvent#getAction}, returning only the pointer index
     * portion
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.131 -0500", hash_original_method = "78466E0DF0FE78667216774839ACB2D1", hash_generated_method = "30BB8E3E501C2C944F9121D10C447A7C")
    
public static int getActionIndex(MotionEvent event) {
        return (event.getAction() & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT;
    }

    /**
     * Call {@link MotionEvent#findPointerIndex(int)}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#ECLAIR} device,
     * does nothing and returns -1.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.133 -0500", hash_original_method = "578781200794E634D734CB09A568D710", hash_generated_method = "602F0B9592F408EC78E78F9080D2DD3D")
    
public static int findPointerIndex(MotionEvent event, int pointerId) {
        return IMPL.findPointerIndex(event, pointerId);
    }

    /**
     * Call {@link MotionEvent#getPointerId(int)}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#ECLAIR} device,
     * {@link IndexOutOfBoundsException} is thrown.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.137 -0500", hash_original_method = "B1540D1BC1A1FC10A324E41A4C3A2405", hash_generated_method = "382EB163A990682DFAB09CD958D65566")
    
public static int getPointerId(MotionEvent event, int pointerIndex) {
        return IMPL.getPointerId(event, pointerIndex);
    }

    /**
     * Call {@link MotionEvent#getX(int)}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#ECLAIR} device,
     * {@link IndexOutOfBoundsException} is thrown.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSOR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.139 -0500", hash_original_method = "1C14F481F0BFBC3447CC457FAD37D977", hash_generated_method = "55EFB08BBE706DCE92C726173C6752EE")
    
public static float getX(MotionEvent event, int pointerIndex) {
        return IMPL.getX(event, pointerIndex);
    }

    /**
     * Call {@link MotionEvent#getY(int)}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#ECLAIR} device,
     * {@link IndexOutOfBoundsException} is thrown.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSOR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.142 -0500", hash_original_method = "1E91C7B0F2EEFBADAE6B674321FBDEE0", hash_generated_method = "23F58386A7E2C4F6F13B47C0C6EEADE2")
    
public static float getY(MotionEvent event, int pointerIndex) {
        return IMPL.getY(event, pointerIndex);
    }

    /**
     * The number of pointers of data contained in this event.  Always
     * >= 1.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.144 -0500", hash_original_method = "A9B2A5B4740C128E6AAD1EC58C9079ED", hash_generated_method = "F73457934A29BBFED6EBA081EB6DBF0E")
    
public static int getPointerCount(MotionEvent event) {
        return IMPL.getPointerCount(event);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.103 -0500", hash_original_field = "5FE5861F8F7B4FBDED72C34227E6EC0C", hash_generated_field = "F0C04F9075773F238646F09F10EC5686")

    static  MotionEventVersionImpl IMPL;
    
    static class BaseMotionEventVersionImpl implements MotionEventVersionImpl {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.289 -0400", hash_original_method = "1452E4140DDA36A9AA18888B766DC89D", hash_generated_method = "1452E4140DDA36A9AA18888B766DC89D")
        public BaseMotionEventVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.074 -0500", hash_original_method = "915485589CA18931BFA6184EB5D82CE0", hash_generated_method = "FF53067342017ECEFB88A2761B9C2579")
        
@Override
        public int findPointerIndex(MotionEvent event, int pointerId) {
            if (pointerId == 0) {
                // id 0 == index 0 and vice versa.
                return 0;
            }
            return -1;
        }
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.077 -0500", hash_original_method = "9E7B122BF9BB453BF7E85C1115C02518", hash_generated_method = "F152F02751C2E7D7863B3B04B3FDBE31")
        
@Override
        public int getPointerId(MotionEvent event, int pointerIndex) {
            if (pointerIndex == 0) {
                // index 0 == id 0 and vice versa.
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSOR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.079 -0500", hash_original_method = "46B436EF23A4E7BD3E33198488E751EA", hash_generated_method = "0A2573A4B1DE5086E58AE54C66458173")
        
@Override
        public float getX(MotionEvent event, int pointerIndex) {
            if (pointerIndex == 0) {
                return event.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSOR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.082 -0500", hash_original_method = "71D40AC5F4F710155978216341C47632", hash_generated_method = "D45EA97749AE8F1AC4EDA839E7CB9729")
        
@Override
        public float getY(MotionEvent event, int pointerIndex) {
            if (pointerIndex == 0) {
                return event.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.084 -0500", hash_original_method = "F1B2637001FBFFCBD7AA64840D270091", hash_generated_method = "A877E8BC25517DB8FF994556EB2F4D41")
        
@Override
        public int getPointerCount(MotionEvent event) {
            return 1;
        }
        
    }
    
    static class EclairMotionEventVersionImpl implements MotionEventVersionImpl {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.294 -0400", hash_original_method = "042D39F66E91ADDA4B8AD5816FDB91A1", hash_generated_method = "042D39F66E91ADDA4B8AD5816FDB91A1")
        public EclairMotionEventVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.089 -0500", hash_original_method = "1F125219ECB51BDA24372EEEA6E62AC1", hash_generated_method = "AE6A01B8C36EC035A5C113FE444D84E1")
        
@Override
        public int findPointerIndex(MotionEvent event, int pointerId) {
            return MotionEventCompatEclair.findPointerIndex(event, pointerId);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.092 -0500", hash_original_method = "CB6B0C0269880E57D0AAF045A3B12252", hash_generated_method = "B6BE71A9C417A78A5A6EFAE265396E48")
        
@Override
        public int getPointerId(MotionEvent event, int pointerIndex) {
            return MotionEventCompatEclair.getPointerId(event, pointerIndex);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSOR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.094 -0500", hash_original_method = "CC9227E21CD6D287D30FF5F6779E2A13", hash_generated_method = "6390123E90E7ED3C9C419A6E139ADC53")
        
@Override
        public float getX(MotionEvent event, int pointerIndex) {
            return MotionEventCompatEclair.getX(event, pointerIndex);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSOR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.097 -0500", hash_original_method = "F1D4241FA671175201C1D58741E0B6B9", hash_generated_method = "84FD1ED546F874D63C449DD2DCE71C97")
        
@Override
        public float getY(MotionEvent event, int pointerIndex) {
            return MotionEventCompatEclair.getY(event, pointerIndex);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.099 -0500", hash_original_method = "9E092C63409B479B27716D0F10009856", hash_generated_method = "A78D3EC0ED2D1F7D0A0D72B24D8309AD")
        
@Override
        public int getPointerCount(MotionEvent event) {
            return MotionEventCompatEclair.getPointerCount(event);
        }
        
    }
    
    interface MotionEventVersionImpl {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int findPointerIndex(MotionEvent event, int pointerId);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int getPointerId(MotionEvent event, int pointerIndex);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public float getX(MotionEvent event, int pointerIndex);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public float getY(MotionEvent event, int pointerIndex);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int getPointerCount(MotionEvent event);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.106 -0500", hash_original_field = "FC4C290B75F77C9110197620363F9111", hash_generated_field = "CA4F36A588CFE36A93CA952406390368")

    /**
     * Synonym for {@link MotionEvent#ACTION_MASK}.
     */
    public static final int ACTION_MASK = 0xff;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 5) {
            IMPL = new EclairMotionEventVersionImpl();
        } else {
            IMPL = new BaseMotionEventVersionImpl();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.109 -0500", hash_original_field = "6B8026AE673197DC4509FD1C52E85893", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.112 -0500", hash_original_field = "918CC644F8F3853E02E49713894DFC96", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.114 -0500", hash_original_field = "C216C2D482483B9B30C7BB2675C50F3F", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.116 -0500", hash_original_field = "ABED2ED2557F7CC3CCDED7CE69B5434B", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.119 -0500", hash_original_field = "B84AC1CDEB7CB6E7A2AD3AF6ED95FD6D", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.122 -0500", hash_original_field = "B386A1CE3358CBFE4E59C73CCCF8B604", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.124 -0500", hash_original_field = "6DFA606950D7B0DEC8419F9FB95C2C3C", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.126 -0500", hash_original_field = "82CE12F47ED4177C0200CD4F439C144D", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT = 10;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.277 -0400", hash_original_method = "5A13315CB97E0E2867AD42FF281F6179", hash_generated_method = "5A13315CB97E0E2867AD42FF281F6179")
    public MotionEventCompat ()
    {
        //Synthesized constructor
    }
}

