package android.graphics.drawable.shapes;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class RectShape extends Shape {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.830 -0400", hash_original_field = "995C0FB7B00A0A1E82DD4C30778697FC", hash_generated_field = "E080B89EC7A364FFC5B71FB812B38393")

    private RectF mRect = new RectF();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.831 -0400", hash_original_method = "86D7394A029CE4FDE438585868C447F4", hash_generated_method = "296628B3E8AE7C2CA6ACF988628F6E64")
    public  RectShape() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.831 -0400", hash_original_method = "6BDD25C71E92DEE23AC033397583FF85", hash_generated_method = "702C02DD7015D2D4903DB0AA90E2AB2A")
    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(mRect, paint);
        addTaint(canvas.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //canvas.drawRect(mRect, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.834 -0400", hash_original_method = "62B0D2225FCA5D4099BD1D1E514DF479", hash_generated_method = "E45B1C9ED31B762BE19323D4076FB769")
    @Override
    protected void onResize(float width, float height) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mRect.set(0, 0, width, height);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //mRect.set(0, 0, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.835 -0400", hash_original_method = "B472369E445B34AFDD84E5B389A9601D", hash_generated_method = "73265032E3FE780F61A35EB3935935AE")
    protected final RectF rect() {
        RectF varB4EAC82CA7396A68D541C85D26508E83_52771691 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_52771691 = mRect;
        varB4EAC82CA7396A68D541C85D26508E83_52771691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_52771691;
        // ---------- Original Method ----------
        //return mRect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.837 -0400", hash_original_method = "F35F96D345FDD22204E61750D42DDCE2", hash_generated_method = "AD247F0A1399C18D4F5EBDD23F61FD83")
    @Override
    public RectShape clone() throws CloneNotSupportedException {
        RectShape varB4EAC82CA7396A68D541C85D26508E83_1366587306 = null; //Variable for return #1
        RectShape shape;
        shape = (RectShape) super.clone();
        shape.mRect = new RectF(mRect);
        varB4EAC82CA7396A68D541C85D26508E83_1366587306 = shape;
        varB4EAC82CA7396A68D541C85D26508E83_1366587306.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1366587306;
        // ---------- Original Method ----------
        //final RectShape shape = (RectShape) super.clone();
        //shape.mRect = new RectF(mRect);
        //return shape;
    }

    
}

