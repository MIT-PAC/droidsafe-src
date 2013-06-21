package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.MotionEvent;
import android.text.*;
import android.widget.TextView;
import android.view.View;

public class ScrollingMovementMethod extends BaseMovementMethod implements MovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.683 -0400", hash_original_method = "FBDD51DD5CD0066E676E4B541339351C", hash_generated_method = "FBDD51DD5CD0066E676E4B541339351C")
        public ScrollingMovementMethod ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.684 -0400", hash_original_method = "4575BF452832A0D7CE335FE2D333B9A8", hash_generated_method = "FFAFD100EF7031D879BD2F2E1E20654B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var33B7ACE480C77A700716B2E4D11304F7_2102095760 = (scrollLeft(widget, buffer, 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollLeft(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.690 -0400", hash_original_method = "E8486D1C2D56FFC371988279D1AD8571", hash_generated_method = "5308E44F54AE7DA8142CF6339708901D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean varE1D164EAA3BBD6DAC0EDB22052E395D7_395561491 = (scrollRight(widget, buffer, 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollRight(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.690 -0400", hash_original_method = "1155FFC79CCA2014F7E16D97983A80B8", hash_generated_method = "C77635EC4F8DC9B39599DAB30A34F2C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var8B1B9F2914F64ADA6386961AFCACC38D_1415443578 = (scrollUp(widget, buffer, 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollUp(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.691 -0400", hash_original_method = "FCF9DD7A394B565166B77EC48277B9BE", hash_generated_method = "164B23717E6CAF7DDF5B9443D67FD4D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var4EA49CAFFD28F72BF4E2B96A50702DA7_2114256212 = (scrollDown(widget, buffer, 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollDown(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.691 -0400", hash_original_method = "6AC637482165D29C2C4109F9D569279C", hash_generated_method = "D9EAB845A426049FF4A01DECA3C95514")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean varD68CABB3ABF597D3A9CDC8242400A4AF_276491325 = (scrollPageUp(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollPageUp(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.691 -0400", hash_original_method = "290A98973A36AD8EEE0D3D32B5DA2AC3", hash_generated_method = "5887C0079FA41D2432A6D0C9E1612FE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean varDEB8C9495633FD1759B45D6D4BC616D0_65646958 = (scrollPageDown(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollPageDown(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.691 -0400", hash_original_method = "96FE67A8B27885C4870A2D965DD698B2", hash_generated_method = "D43DBA2E169F1418980D5ADC6C2EA323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var09D4CC674B9B25C42786B2BD09436687_238198145 = (scrollTop(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollTop(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.692 -0400", hash_original_method = "6D879379D7CBA6045850AECFB8A1C165", hash_generated_method = "D722D8563E2B94939922A3A4B9F2175F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var8CF401AD75277A91F7439065D19329C9_941120793 = (scrollBottom(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollBottom(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.692 -0400", hash_original_method = "28541DE829E7071F01F9CFB8222A0CA3", hash_generated_method = "B5A818A572BD9BD321B6CA482C57781F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var00DC23B02FAAA5310455616695EEAA24_1708247049 = (scrollLineStart(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollLineStart(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.692 -0400", hash_original_method = "633692CF531080A659FB64ED1AA4A5F4", hash_generated_method = "B19DDBA2E3DDAE9E7EAD167C0060144D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var640C9BF40B1D9E08234A06AD44C16FD2_2136207214 = (scrollLineEnd(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollLineEnd(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.692 -0400", hash_original_method = "C15EA31EA0FD3AAF4D2911A25A30C355", hash_generated_method = "02E43E8790194ECDDE563E0E9868F736")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var767342C75A810412664CF2E23A770122_2130980470 = (top(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return top(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.693 -0400", hash_original_method = "8A16106DF26D61EEC58C1723A12C8B5F", hash_generated_method = "3497F48846E4D6D638F871E4C93EE973")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean var6997D4CB8C95F6286B4D0B8EE7F0F568_1800852989 = (bottom(widget, buffer));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return bottom(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.693 -0400", hash_original_method = "A7480C6BC5D883E26DF36990823FBEAF", hash_generated_method = "1DBDF3BD554544E2C73315D0F293ECA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(widget.dsTaint);
        boolean varB37B808A72FCB6E7C71502911DC802B1_1771304314 = (Touch.onTouchEvent(widget, buffer, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Touch.onTouchEvent(widget, buffer, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.693 -0400", hash_original_method = "171EBC702B28CBB8F3E97F4458472A3A", hash_generated_method = "AB5E0BF6D55C5D3CFFC6494CE9EAEB0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(widget.dsTaint);
        Layout layout;
        layout = widget.getLayout();
        {
            widget.scrollTo(widget.getScrollX(),
                            layout.getLineTop(0));
        } //End block
        {
            int padding;
            padding = widget.getTotalPaddingTop() +
                          widget.getTotalPaddingBottom();
            int line;
            line = layout.getLineCount() - 1;
            widget.scrollTo(widget.getScrollX(),
                            layout.getLineTop(line+1) -
                            (widget.getHeight() - padding));
        } //End block
        // ---------- Original Method ----------
        //Layout layout = widget.getLayout();
        //if (layout != null && (dir & View.FOCUS_FORWARD) != 0) {
            //widget.scrollTo(widget.getScrollX(),
                            //layout.getLineTop(0));
        //}
        //if (layout != null && (dir & View.FOCUS_BACKWARD) != 0) {
            //int padding = widget.getTotalPaddingTop() +
                          //widget.getTotalPaddingBottom();
            //int line = layout.getLineCount() - 1;
            //widget.scrollTo(widget.getScrollX(),
                            //layout.getLineTop(line+1) -
                            //(widget.getHeight() - padding));
        //}
    }

    
        public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new ScrollingMovementMethod();
        return sInstance;
    }

    
    private static ScrollingMovementMethod sInstance;
}

