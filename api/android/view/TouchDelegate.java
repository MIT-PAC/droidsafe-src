package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class TouchDelegate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.937 -0400", hash_original_field = "A4825BD7697117286DB2E2D9A1861183", hash_generated_field = "667AB02B0815B77F40A4B676D819C645")

    private View mDelegateView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.937 -0400", hash_original_field = "EFABBD000FF848C98F3B412897E1622D", hash_generated_field = "ACA7F56CF4C5BB576D45AFE6705B72F4")

    private Rect mBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.937 -0400", hash_original_field = "BC985B3AEB210CA4A74AE434BFFCD0AF", hash_generated_field = "3CA4A0B9369576539E1F2D69259990C2")

    private Rect mSlopBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.937 -0400", hash_original_field = "E12CC6D2AC025183B513E158A0C1CB3D", hash_generated_field = "5421EC5E0E13ED719B8FAF57C794F01B")

    private boolean mDelegateTargeted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.937 -0400", hash_original_field = "1377F8448B1127FD45A82D089124AC6D", hash_generated_field = "8F552CDA1150C95F5136931C6E8ECB4C")

    private int mSlop;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.938 -0400", hash_original_method = "2AE60462A7E1E4F15EA63DC7A4583FF5", hash_generated_method = "494829CA007B6B574B73E1C77BF886CA")
    public  TouchDelegate(Rect bounds, View delegateView) {
        mBounds = bounds;
        mSlop = ViewConfiguration.get(delegateView.getContext()).getScaledTouchSlop();
        mSlopBounds = new Rect(bounds);
        mSlopBounds.inset(-mSlop, -mSlop);
        mDelegateView = delegateView;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.939 -0400", hash_original_method = "2299D41C6782643B71D7B9FD20834200", hash_generated_method = "983B4445F2A095AE1E172C852DCD76EB")
    public boolean onTouchEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        int x = (int)event.getX();
        int y = (int)event.getY();
        boolean sendToDelegate = false;
        boolean hit = true;
        boolean handled = false;
switch(event.getAction()){
        case MotionEvent.ACTION_DOWN:
        Rect bounds = mBounds;
    if(bounds.contains(x, y))        
        {
            mDelegateTargeted = true;
            sendToDelegate = true;
        } 
        break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_MOVE:
        sendToDelegate = mDelegateTargeted;
    if(sendToDelegate)        
        {
            Rect slopBounds = mSlopBounds;
    if(!slopBounds.contains(x, y))            
            {
                hit = false;
            } 
        } 
        break;
        case MotionEvent.ACTION_CANCEL:
        sendToDelegate = mDelegateTargeted;
        mDelegateTargeted = false;
        break;
}    if(sendToDelegate)        
        {
            final View delegateView = mDelegateView;
    if(hit)            
            {
                event.setLocation(delegateView.getWidth() / 2, delegateView.getHeight() / 2);
            } 
            else
            {
                int slop = mSlop;
                event.setLocation(-(slop * 2), -(slop * 2));
            } 
            handled = delegateView.dispatchTouchEvent(event);
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1378268806 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457106530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457106530;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.940 -0400", hash_original_field = "D1ED922B1C6AEDF8D61E27F030146AE3", hash_generated_field = "EC534F0636A3F6D8330DE66D6EE19BB7")

    public static final int ABOVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.940 -0400", hash_original_field = "446ED570B5A5D2511B123A5FB40C0388", hash_generated_field = "8B3CF69EA678FF029552A7CA7A611E81")

    public static final int BELOW = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.940 -0400", hash_original_field = "ABF168724EAE0509D471DA715DD4F11F", hash_generated_field = "0291C2D8DA8DB1E6E814FD61549F32BA")

    public static final int TO_LEFT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.940 -0400", hash_original_field = "FD51D49E1AAE72EF9BB7935B9C291FCF", hash_generated_field = "58292FF463EC92D00FCAFB3D70F02B81")

    public static final int TO_RIGHT = 8;
}

