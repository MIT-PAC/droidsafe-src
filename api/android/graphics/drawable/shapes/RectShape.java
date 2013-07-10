package android.graphics.drawable.shapes;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class RectShape extends Shape {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.670 -0400", hash_original_field = "995C0FB7B00A0A1E82DD4C30778697FC", hash_generated_field = "E080B89EC7A364FFC5B71FB812B38393")

    private RectF mRect = new RectF();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.671 -0400", hash_original_method = "86D7394A029CE4FDE438585868C447F4", hash_generated_method = "296628B3E8AE7C2CA6ACF988628F6E64")
    public  RectShape() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.671 -0400", hash_original_method = "6BDD25C71E92DEE23AC033397583FF85", hash_generated_method = "702C02DD7015D2D4903DB0AA90E2AB2A")
    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(mRect, paint);
        addTaint(canvas.getTaint());
        addTaint(paint.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.672 -0400", hash_original_method = "62B0D2225FCA5D4099BD1D1E514DF479", hash_generated_method = "E45B1C9ED31B762BE19323D4076FB769")
    @Override
    protected void onResize(float width, float height) {
        
        mRect.set(0, 0, width, height);
        addTaint(width);
        addTaint(height);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.673 -0400", hash_original_method = "B472369E445B34AFDD84E5B389A9601D", hash_generated_method = "B6A0AD94568E52D75358B5C6CBD55ADC")
    protected final RectF rect() {
        RectF varB4EAC82CA7396A68D541C85D26508E83_1622463825 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1622463825 = mRect;
        varB4EAC82CA7396A68D541C85D26508E83_1622463825.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1622463825;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.674 -0400", hash_original_method = "F35F96D345FDD22204E61750D42DDCE2", hash_generated_method = "56CD7FF8983FAB0053DC68573FB23449")
    @Override
    public RectShape clone() throws CloneNotSupportedException {
        RectShape varB4EAC82CA7396A68D541C85D26508E83_1430485226 = null; 
        final RectShape shape = (RectShape) super.clone();
        shape.mRect = new RectF(mRect);
        varB4EAC82CA7396A68D541C85D26508E83_1430485226 = shape;
        varB4EAC82CA7396A68D541C85D26508E83_1430485226.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1430485226;
        
        
        
        
    }

    
}

