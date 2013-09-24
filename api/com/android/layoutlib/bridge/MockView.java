package com.android.layoutlib.bridge;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.view.Gravity;
public class MockView extends TextView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:13:26.548 -0400", hash_original_method = "754CE43714B2EA9ED234F73E3E58D74C", hash_generated_method = "5CFE3FAEDC118A719E210A0683FA312E")
    public  MockView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        setText(this.getClass().getSimpleName());
        setTextColor(0xFF000000);
        setGravity(Gravity.CENTER);
        // ---------- Original Method ----------
        //setText(this.getClass().getSimpleName());
        //setTextColor(0xFF000000);
        //setGravity(Gravity.CENTER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:13:26.557 -0400", hash_original_method = "B0CB306F2707837E390C5BAE5CE6A873", hash_generated_method = "C50138D52D761BDD9A8383C4C936B2E0")
    @Override
    public void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        canvas.drawARGB(0xFF, 0x7F, 0x7F, 0x7F);
        super.onDraw(canvas);
        // ---------- Original Method ----------
        //canvas.drawARGB(0xFF, 0x7F, 0x7F, 0x7F);
        //super.onDraw(canvas);
    }

    
}

