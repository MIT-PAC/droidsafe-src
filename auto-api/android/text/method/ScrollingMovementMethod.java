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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.605 -0400", hash_original_method = "997C1BE7C30077BC0332DB617608ABA5", hash_generated_method = "997C1BE7C30077BC0332DB617608ABA5")
    public ScrollingMovementMethod ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.605 -0400", hash_original_method = "4575BF452832A0D7CE335FE2D333B9A8", hash_generated_method = "03866B765FF654099D998BC64BF0F704")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        boolean var33B7ACE480C77A700716B2E4D11304F7_2026603001 = (scrollLeft(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310698792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310698792;
        // ---------- Original Method ----------
        //return scrollLeft(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.606 -0400", hash_original_method = "E8486D1C2D56FFC371988279D1AD8571", hash_generated_method = "D5CE9A86D38E9B4DD1AD044C7889D932")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        boolean varE1D164EAA3BBD6DAC0EDB22052E395D7_456287754 = (scrollRight(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303984614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303984614;
        // ---------- Original Method ----------
        //return scrollRight(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.606 -0400", hash_original_method = "1155FFC79CCA2014F7E16D97983A80B8", hash_generated_method = "A939A6BA1E7C069B23035762F600AB32")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        boolean var8B1B9F2914F64ADA6386961AFCACC38D_1317528821 = (scrollUp(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739788380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739788380;
        // ---------- Original Method ----------
        //return scrollUp(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.607 -0400", hash_original_method = "FCF9DD7A394B565166B77EC48277B9BE", hash_generated_method = "DF70A0958F2C5BC737B959791AB8E655")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        boolean var4EA49CAFFD28F72BF4E2B96A50702DA7_1652550597 = (scrollDown(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980966734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980966734;
        // ---------- Original Method ----------
        //return scrollDown(widget, buffer, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.621 -0400", hash_original_method = "6AC637482165D29C2C4109F9D569279C", hash_generated_method = "808758E38FE42FAF8334E8513A52E8B3")
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        boolean varD68CABB3ABF597D3A9CDC8242400A4AF_1857062654 = (scrollPageUp(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785683625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785683625;
        // ---------- Original Method ----------
        //return scrollPageUp(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.622 -0400", hash_original_method = "290A98973A36AD8EEE0D3D32B5DA2AC3", hash_generated_method = "43E998614229ED03B929DAD7673777A2")
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        boolean varDEB8C9495633FD1759B45D6D4BC616D0_1259745922 = (scrollPageDown(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174527673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174527673;
        // ---------- Original Method ----------
        //return scrollPageDown(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.622 -0400", hash_original_method = "96FE67A8B27885C4870A2D965DD698B2", hash_generated_method = "AE7657D52CC70A584E43FBAD4A4D0AFB")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        boolean var09D4CC674B9B25C42786B2BD09436687_327279580 = (scrollTop(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295684964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_295684964;
        // ---------- Original Method ----------
        //return scrollTop(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.623 -0400", hash_original_method = "6D879379D7CBA6045850AECFB8A1C165", hash_generated_method = "B6C9DE0FD41C51E672CE465BCDADA64B")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        boolean var8CF401AD75277A91F7439065D19329C9_1454697981 = (scrollBottom(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317057454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317057454;
        // ---------- Original Method ----------
        //return scrollBottom(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.623 -0400", hash_original_method = "28541DE829E7071F01F9CFB8222A0CA3", hash_generated_method = "43CD50053A97CE797F290F9C68C2C594")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        boolean var00DC23B02FAAA5310455616695EEAA24_1669925996 = (scrollLineStart(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1893433827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1893433827;
        // ---------- Original Method ----------
        //return scrollLineStart(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.629 -0400", hash_original_method = "633692CF531080A659FB64ED1AA4A5F4", hash_generated_method = "0483CF284FB0F7CCA8400AC363BA1624")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        boolean var640C9BF40B1D9E08234A06AD44C16FD2_380474327 = (scrollLineEnd(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892492422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892492422;
        // ---------- Original Method ----------
        //return scrollLineEnd(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.630 -0400", hash_original_method = "C15EA31EA0FD3AAF4D2911A25A30C355", hash_generated_method = "59CA4B7AB84C5BEF8F3B8CEA050DC674")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        boolean var767342C75A810412664CF2E23A770122_84720752 = (top(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691045037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691045037;
        // ---------- Original Method ----------
        //return top(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.630 -0400", hash_original_method = "8A16106DF26D61EEC58C1723A12C8B5F", hash_generated_method = "CCECC1C45745877EF5EB7ADF58949F28")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        boolean var6997D4CB8C95F6286B4D0B8EE7F0F568_833275236 = (bottom(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584788000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584788000;
        // ---------- Original Method ----------
        //return bottom(widget, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.646 -0400", hash_original_method = "A7480C6BC5D883E26DF36990823FBEAF", hash_generated_method = "D572B60E64661C05BBF8CE40BBB05C0A")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varB37B808A72FCB6E7C71502911DC802B1_421923870 = (Touch.onTouchEvent(widget, buffer, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586353844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586353844;
        // ---------- Original Method ----------
        //return Touch.onTouchEvent(widget, buffer, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.648 -0400", hash_original_method = "171EBC702B28CBB8F3E97F4458472A3A", hash_generated_method = "6D6EC40BF2AFCC801F4242C559E3BD1F")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.649 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "E3F2C749F87B458DFC8C00803F37AFF0")

    private static ScrollingMovementMethod sInstance;
}

