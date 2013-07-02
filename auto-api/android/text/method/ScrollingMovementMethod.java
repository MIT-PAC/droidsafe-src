package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.MotionEvent;
import android.text.*;
import android.widget.TextView;
import android.view.View;

public class ScrollingMovementMethod extends BaseMovementMethod implements MovementMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.533 -0400", hash_original_method = "997C1BE7C30077BC0332DB617608ABA5", hash_generated_method = "997C1BE7C30077BC0332DB617608ABA5")
    public ScrollingMovementMethod ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.534 -0400", hash_original_method = "4575BF452832A0D7CE335FE2D333B9A8", hash_generated_method = "C3BBCD48E31A4778B60583F4D26F7183")
    @Override
    protected boolean left(TextView widget, Spannable buffer) {
        boolean var33B7ACE480C77A700716B2E4D11304F7_208705867 = (scrollLeft(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1599158394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1599158394;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.534 -0400", hash_original_method = "E8486D1C2D56FFC371988279D1AD8571", hash_generated_method = "662AE86C6C1CA6ACB4AB9ACC3DD66726")
    @Override
    protected boolean right(TextView widget, Spannable buffer) {
        boolean varE1D164EAA3BBD6DAC0EDB22052E395D7_827161967 = (scrollRight(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074570305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074570305;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.535 -0400", hash_original_method = "1155FFC79CCA2014F7E16D97983A80B8", hash_generated_method = "93498422E01A0222C2F430CA8E6004B8")
    @Override
    protected boolean up(TextView widget, Spannable buffer) {
        boolean var8B1B9F2914F64ADA6386961AFCACC38D_1528145730 = (scrollUp(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015685767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015685767;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.535 -0400", hash_original_method = "FCF9DD7A394B565166B77EC48277B9BE", hash_generated_method = "A3127207E1F8D7343FD204B5E0D8F56E")
    @Override
    protected boolean down(TextView widget, Spannable buffer) {
        boolean var4EA49CAFFD28F72BF4E2B96A50702DA7_234912111 = (scrollDown(widget, buffer, 1));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977682868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_977682868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.536 -0400", hash_original_method = "6AC637482165D29C2C4109F9D569279C", hash_generated_method = "67CD29C1CA50FB0F85C43F155F8DAFB8")
    @Override
    protected boolean pageUp(TextView widget, Spannable buffer) {
        boolean varD68CABB3ABF597D3A9CDC8242400A4AF_1751584058 = (scrollPageUp(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914977365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914977365;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.536 -0400", hash_original_method = "290A98973A36AD8EEE0D3D32B5DA2AC3", hash_generated_method = "4B7172222F8AA9EB2801AA0391A9073D")
    @Override
    protected boolean pageDown(TextView widget, Spannable buffer) {
        boolean varDEB8C9495633FD1759B45D6D4BC616D0_1926600826 = (scrollPageDown(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591397647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591397647;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.537 -0400", hash_original_method = "96FE67A8B27885C4870A2D965DD698B2", hash_generated_method = "DDE2541D2B0552A59A18F560D9856CDE")
    @Override
    protected boolean top(TextView widget, Spannable buffer) {
        boolean var09D4CC674B9B25C42786B2BD09436687_629272657 = (scrollTop(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453950048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453950048;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.538 -0400", hash_original_method = "6D879379D7CBA6045850AECFB8A1C165", hash_generated_method = "5D00322E1A01A6F92C471AE5B6C74993")
    @Override
    protected boolean bottom(TextView widget, Spannable buffer) {
        boolean var8CF401AD75277A91F7439065D19329C9_260937139 = (scrollBottom(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019288940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019288940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.539 -0400", hash_original_method = "28541DE829E7071F01F9CFB8222A0CA3", hash_generated_method = "A02C10F035642367DE04EAD3914C3EFB")
    @Override
    protected boolean lineStart(TextView widget, Spannable buffer) {
        boolean var00DC23B02FAAA5310455616695EEAA24_765206595 = (scrollLineStart(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_700522898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_700522898;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.539 -0400", hash_original_method = "633692CF531080A659FB64ED1AA4A5F4", hash_generated_method = "253F415E36DB905C259752687976EDF5")
    @Override
    protected boolean lineEnd(TextView widget, Spannable buffer) {
        boolean var640C9BF40B1D9E08234A06AD44C16FD2_764778956 = (scrollLineEnd(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329945332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_329945332;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.540 -0400", hash_original_method = "C15EA31EA0FD3AAF4D2911A25A30C355", hash_generated_method = "949FE9F4EF6914CA2FFE4DA6E72CAB4C")
    @Override
    protected boolean home(TextView widget, Spannable buffer) {
        boolean var767342C75A810412664CF2E23A770122_1687488939 = (top(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026420540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026420540;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.540 -0400", hash_original_method = "8A16106DF26D61EEC58C1723A12C8B5F", hash_generated_method = "BABAA9249F32E72E23EBD5B37C715A60")
    @Override
    protected boolean end(TextView widget, Spannable buffer) {
        boolean var6997D4CB8C95F6286B4D0B8EE7F0F568_176837641 = (bottom(widget, buffer));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383935514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_383935514;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.540 -0400", hash_original_method = "A7480C6BC5D883E26DF36990823FBEAF", hash_generated_method = "BBE0DC8206EBE20C37BE97AE56EBDE94")
    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        
        boolean varB37B808A72FCB6E7C71502911DC802B1_825618439 = (Touch.onTouchEvent(widget, buffer, event));
        addTaint(widget.getTaint());
        addTaint(buffer.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_871290765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_871290765;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.541 -0400", hash_original_method = "171EBC702B28CBB8F3E97F4458472A3A", hash_generated_method = "DBB2CFD5EB94E12FACCAF7D684CFAA8A")
    @Override
    public void onTakeFocus(TextView widget, Spannable text, int dir) {
        
        Layout layout = widget.getLayout();
        {
            widget.scrollTo(widget.getScrollX(),
                            layout.getLineTop(0));
        } 
        {
            int padding = widget.getTotalPaddingTop() +
                          widget.getTotalPaddingBottom();
            int line = layout.getLineCount() - 1;
            widget.scrollTo(widget.getScrollX(),
                            layout.getLineTop(line+1) -
                            (widget.getHeight() - padding));
        } 
        addTaint(widget.getTaint());
        addTaint(text.getTaint());
        addTaint(dir);
        
        
        
            
                            
        
        
            
                          
            
            
                            
                            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new ScrollingMovementMethod();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.541 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "E3F2C749F87B458DFC8C00803F37AFF0")

    private static ScrollingMovementMethod sInstance;
}

