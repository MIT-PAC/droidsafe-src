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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.790 -0400", hash_original_method = "997C1BE7C30077BC0332DB617608ABA5", hash_generated_method = "997C1BE7C30077BC0332DB617608ABA5")
    public ScrollingMovementMethod ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.791 -0400", hash_original_method = "4575BF452832A0D7CE335FE2D333B9A8", hash_generated_method = "3B8F2F8883FB542DEFFAFE40E5EC5A17")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        boolean var33B7ACE480C77A700716B2E4D11304F7_590412309 = (scrollLeft(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607607727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607607727;
        // ---------- Original Method ----------
        //return scrollLeft(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.791 -0400", hash_original_method = "E8486D1C2D56FFC371988279D1AD8571", hash_generated_method = "9598D68902FB246566A8891A6379AEC7")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        boolean varE1D164EAA3BBD6DAC0EDB22052E395D7_1852863841 = (scrollRight(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190215528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_190215528;
        // ---------- Original Method ----------
        //return scrollRight(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.792 -0400", hash_original_method = "1155FFC79CCA2014F7E16D97983A80B8", hash_generated_method = "3B3117AB3152716AD7DB2D994A82967C")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        boolean var8B1B9F2914F64ADA6386961AFCACC38D_1842828377 = (scrollUp(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684211625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684211625;
        // ---------- Original Method ----------
        //return scrollUp(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.792 -0400", hash_original_method = "FCF9DD7A394B565166B77EC48277B9BE", hash_generated_method = "D99D01119F025583D2618FD6359F82B4")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        boolean var4EA49CAFFD28F72BF4E2B96A50702DA7_798800041 = (scrollDown(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143228833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143228833;
        // ---------- Original Method ----------
        //return scrollDown(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.792 -0400", hash_original_method = "6AC637482165D29C2C4109F9D569279C", hash_generated_method = "A107CACF417677CAF4E90DF4F961FF73")
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        boolean varD68CABB3ABF597D3A9CDC8242400A4AF_1682103045 = (scrollPageUp(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237877506 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237877506;
        // ---------- Original Method ----------
        //return scrollPageUp(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.793 -0400", hash_original_method = "290A98973A36AD8EEE0D3D32B5DA2AC3", hash_generated_method = "7E22D51833D916B11E9504B8E873266A")
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        boolean varDEB8C9495633FD1759B45D6D4BC616D0_1732656239 = (scrollPageDown(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519204829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519204829;
        // ---------- Original Method ----------
        //return scrollPageDown(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.793 -0400", hash_original_method = "96FE67A8B27885C4870A2D965DD698B2", hash_generated_method = "21577E167AFA31B81D8E7B21356CFD12")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        boolean var09D4CC674B9B25C42786B2BD09436687_116491367 = (scrollTop(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_85772207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_85772207;
        // ---------- Original Method ----------
        //return scrollTop(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.793 -0400", hash_original_method = "6D879379D7CBA6045850AECFB8A1C165", hash_generated_method = "45B26B1F34EAE115CCECC43DA74933F1")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        boolean var8CF401AD75277A91F7439065D19329C9_1646424497 = (scrollBottom(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129663779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129663779;
        // ---------- Original Method ----------
        //return scrollBottom(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.808 -0400", hash_original_method = "28541DE829E7071F01F9CFB8222A0CA3", hash_generated_method = "01689F4FEC10F1633F4542062C16615F")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        boolean var00DC23B02FAAA5310455616695EEAA24_1573447057 = (scrollLineStart(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400674780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400674780;
        // ---------- Original Method ----------
        //return scrollLineStart(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.808 -0400", hash_original_method = "633692CF531080A659FB64ED1AA4A5F4", hash_generated_method = "099BD477BE087CB81CA95076B4A78F2E")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        boolean var640C9BF40B1D9E08234A06AD44C16FD2_1400959160 = (scrollLineEnd(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130903342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130903342;
        // ---------- Original Method ----------
        //return scrollLineEnd(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.809 -0400", hash_original_method = "C15EA31EA0FD3AAF4D2911A25A30C355", hash_generated_method = "F3E7D894AB5F09A386D7B713BFAEA397")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        boolean var767342C75A810412664CF2E23A770122_488788336 = (top(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_831860220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_831860220;
        // ---------- Original Method ----------
        //return top(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.810 -0400", hash_original_method = "8A16106DF26D61EEC58C1723A12C8B5F", hash_generated_method = "CBACD9774F746DB79385A263973EDB85")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        boolean var6997D4CB8C95F6286B4D0B8EE7F0F568_1616741641 = (bottom(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286713679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286713679;
        // ---------- Original Method ----------
        //return bottom(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.810 -0400", hash_original_method = "A7480C6BC5D883E26DF36990823FBEAF", hash_generated_method = "1A1BBA0B709081A675911E19EBF7E302")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varB37B808A72FCB6E7C71502911DC802B1_1097771747 = (Touch.onTouchEvent(widget, buffer, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024846696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024846696;
        // ---------- Original Method ----------
        //return Touch.onTouchEvent(widget, buffer, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.811 -0400", hash_original_method = "171EBC702B28CBB8F3E97F4458472A3A", hash_generated_method = "6D6EC40BF2AFCC801F4242C559E3BD1F")
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int dir) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(dir);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:42.843 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "E3F2C749F87B458DFC8C00803F37AFF0")

    private static ScrollingMovementMethod sInstance;
}

