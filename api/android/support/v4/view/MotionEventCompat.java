package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.MotionEvent;

public class MotionEventCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.776 -0400", hash_original_method = "5A13315CB97E0E2867AD42FF281F6179", hash_generated_method = "5A13315CB97E0E2867AD42FF281F6179")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.778 -0400", hash_original_method = "1452E4140DDA36A9AA18888B766DC89D", hash_generated_method = "1452E4140DDA36A9AA18888B766DC89D")
        public BaseMotionEventVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.778 -0400", hash_original_method = "915485589CA18931BFA6184EB5D82CE0", hash_generated_method = "5521660517A5CB4B6C3F0A8378E1BF9C")
        @Override
        public int findPointerIndex(MotionEvent event, int pointerId) {
            addTaint(pointerId);
            addTaint(event.getTaint());
    if(pointerId == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_2008659999 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142568255 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142568255;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_746432723 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1380939046 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1380939046;
            // ---------- Original Method ----------
            //if (pointerId == 0) {
                //return 0;
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.780 -0400", hash_original_method = "9E7B122BF9BB453BF7E85C1115C02518", hash_generated_method = "BF48CFAF2BE3E5EEC15D7B6E16687DDE")
        @Override
        public int getPointerId(MotionEvent event, int pointerIndex) {
            addTaint(pointerIndex);
            addTaint(event.getTaint());
    if(pointerIndex == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1763160317 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_772545452 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_772545452;
            } //End block
            IndexOutOfBoundsException varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_863285430 = new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_863285430.addTaint(taint);
            throw varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_863285430;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return 0;
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.781 -0400", hash_original_method = "46B436EF23A4E7BD3E33198488E751EA", hash_generated_method = "1C787D34BB42BFD54AE40D7D1E814FE9")
        @Override
        public float getX(MotionEvent event, int pointerIndex) {
            addTaint(pointerIndex);
            addTaint(event.getTaint());
    if(pointerIndex == 0)            
            {
                float var5A4C8BA8E3F304B8752A45E6A3A6D4FB_1336425280 = (event.getX());
                                float var546ADE640B6EDFBC8A086EF31347E768_252201387 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_252201387;
            } //End block
            IndexOutOfBoundsException varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_363128948 = new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_363128948.addTaint(taint);
            throw varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_363128948;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return event.getX();
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.782 -0400", hash_original_method = "71D40AC5F4F710155978216341C47632", hash_generated_method = "6706724B04D34C3D6E26150613606F7C")
        @Override
        public float getY(MotionEvent event, int pointerIndex) {
            addTaint(pointerIndex);
            addTaint(event.getTaint());
    if(pointerIndex == 0)            
            {
                float varC5AB7FD21957E7EBC0E9A40F08AFB325_1731570432 = (event.getY());
                                float var546ADE640B6EDFBC8A086EF31347E768_61897491 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_61897491;
            } //End block
            IndexOutOfBoundsException varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_956093172 = new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
            varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_956093172.addTaint(taint);
            throw varFB6DBA9FCC1FE2B5EB2CB2CFCA71FA1A_956093172;
            // ---------- Original Method ----------
            //if (pointerIndex == 0) {
                //return event.getY();
            //}
            //throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.783 -0400", hash_original_method = "F1B2637001FBFFCBD7AA64840D270091", hash_generated_method = "E641F34D9D3D4518079F5AF09994BCEC")
        @Override
        public int getPointerCount(MotionEvent event) {
            addTaint(event.getTaint());
            int varC4CA4238A0B923820DCC509A6F75849B_1397795922 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134403165 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134403165;
            // ---------- Original Method ----------
            //return 1;
        }

        
    }


    
    static class EclairMotionEventVersionImpl implements MotionEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.783 -0400", hash_original_method = "042D39F66E91ADDA4B8AD5816FDB91A1", hash_generated_method = "042D39F66E91ADDA4B8AD5816FDB91A1")
        public EclairMotionEventVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.783 -0400", hash_original_method = "1F125219ECB51BDA24372EEEA6E62AC1", hash_generated_method = "CEF2D7CD2F89A6D6D35F39084FE30410")
        @Override
        public int findPointerIndex(MotionEvent event, int pointerId) {
            addTaint(pointerId);
            addTaint(event.getTaint());
            int varE62E7B17F19D8C087D1F6291891581A7_2039451945 = (MotionEventCompatEclair.findPointerIndex(event, pointerId));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906000269 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906000269;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.findPointerIndex(event, pointerId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.784 -0400", hash_original_method = "CB6B0C0269880E57D0AAF045A3B12252", hash_generated_method = "3FD6174D006C2A2CF37683EE12119031")
        @Override
        public int getPointerId(MotionEvent event, int pointerIndex) {
            addTaint(pointerIndex);
            addTaint(event.getTaint());
            int var4C22A572F25F1EC2E523F073F961A1E5_645788644 = (MotionEventCompatEclair.getPointerId(event, pointerIndex));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_947446603 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_947446603;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getPointerId(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.784 -0400", hash_original_method = "CC9227E21CD6D287D30FF5F6779E2A13", hash_generated_method = "3EC8E868791A3D326AD68BCFD1D9621E")
        @Override
        public float getX(MotionEvent event, int pointerIndex) {
            addTaint(pointerIndex);
            addTaint(event.getTaint());
            float varB080E7BF07FE665BD3A6C35AF1F2203D_1988060151 = (MotionEventCompatEclair.getX(event, pointerIndex));
                        float var546ADE640B6EDFBC8A086EF31347E768_304536668 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_304536668;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getX(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.785 -0400", hash_original_method = "F1D4241FA671175201C1D58741E0B6B9", hash_generated_method = "8A9652796A51C218966B3B3A3E252CD9")
        @Override
        public float getY(MotionEvent event, int pointerIndex) {
            addTaint(pointerIndex);
            addTaint(event.getTaint());
            float var697F62025966D984AB3627608CB4FDDC_1204920271 = (MotionEventCompatEclair.getY(event, pointerIndex));
                        float var546ADE640B6EDFBC8A086EF31347E768_1596777676 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1596777676;
            // ---------- Original Method ----------
            //return MotionEventCompatEclair.getY(event, pointerIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.785 -0400", hash_original_method = "9E092C63409B479B27716D0F10009856", hash_generated_method = "1F3AFD7BDC207ABB1A745C7479BC42FA")
        @Override
        public int getPointerCount(MotionEvent event) {
            addTaint(event.getTaint());
            int var28718044D95E132813DF0065AA460AFB_560161189 = (MotionEventCompatEclair.getPointerCount(event));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540709549 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540709549;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.785 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "F0C04F9075773F238646F09F10EC5686")

    static MotionEventVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 5) {
            IMPL = new EclairMotionEventVersionImpl();
        } else {
            IMPL = new BaseMotionEventVersionImpl();
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.785 -0400", hash_original_field = "034E2BCD80D0FE32BEE35A26F527AB82", hash_generated_field = "464488178905DF6887AEEC102D03F9BB")

    public static final int ACTION_MASK = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.785 -0400", hash_original_field = "596B10C23830633246B5FE119303CA31", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.785 -0400", hash_original_field = "1CD52FBA3CE6A637AE86BF305E1727A2", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.785 -0400", hash_original_field = "A117FB885030C87F8035EE8197E01274", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.786 -0400", hash_original_field = "EDD00CD16649F89FF44DD9C0E161B238", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.786 -0400", hash_original_field = "F94A33E7C5ACFBEFDFBB09F0FB9B278A", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.786 -0400", hash_original_field = "DAB0332B2F0024984DE4DD67C040BC0F", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.786 -0400", hash_original_field = "E6889A317885B7F3FCFCB516DDE1B506", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.786 -0400", hash_original_field = "5A019C5D2F9BBBECE84DA46559873CDE", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT = 10;
}

