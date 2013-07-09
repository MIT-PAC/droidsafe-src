package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ScrollBarDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "547048FD5F31D56228887526190F55C7", hash_generated_field = "E04A3D9DD9EF3A7F912E815C6BFCA25E")

    private Drawable mVerticalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "1D4D30ED27A9B00A259A256890EC0242", hash_generated_field = "14177887DA33DECB5E35DF1A209CFD6B")

    private Drawable mHorizontalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "9EEF20285C26D58E98CBF4DECBA5ED36", hash_generated_field = "D4785478D95BE31369EF8D658342B38B")

    private Drawable mVerticalThumb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "5E48039B59AA35A0B8CAF4DF71B3A98A", hash_generated_field = "A6C9AC87745812562596B1EB0E194CD2")

    private Drawable mHorizontalThumb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "5D4A81308B9054CB82785212636789DE", hash_generated_field = "EB6C39DC231EAF3B33208BD8796BA2F1")

    private int mRange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "E8439EB32866F13AD7ABD06DB4A15343", hash_generated_field = "F358652CEEA6BACE7E593752AA27CBE6")

    private int mOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "ED217E69B01A255AFFB3AEBD35455C1D", hash_generated_field = "D7D4E6D21EA2FE73F01CE81D6CC81FA1")

    private int mExtent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "151A20A8D7084F60EB7F7A4B44844050", hash_generated_field = "69CBC6FC9EE367E3A738852DD60DDD6D")

    private boolean mVertical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "E441004F88853A62D62B487B13AF6154", hash_generated_field = "F1F17F4E3280622D0A9B77B123769A5C")

    private boolean mChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "CDD7B56C3280846F16CD5BBA46EEAC5D", hash_generated_field = "4F6E0C8B4F81EFED7C3C83FC67B47487")

    private boolean mRangeChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "E3FB88F1170F920ECFA15D83AA99D025", hash_generated_field = "9DBB084DD0568D939B76BF72796B166A")

    private final Rect mTempBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.286 -0400", hash_original_field = "2B9368BA3124C9DDA5EF7E10AC8580EB", hash_generated_field = "73D3FAACDDA42D621076D0307124BA72")

    private boolean mAlwaysDrawHorizontalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.301 -0400", hash_original_field = "E1BAE08AA8010857DCC5896DD966EC0A", hash_generated_field = "BDCE388B565752F7D96B5F7F9F3DDA9A")

    private boolean mAlwaysDrawVerticalTrack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.301 -0400", hash_original_method = "F6C29E547BD302257DEE1C67DCEB3680", hash_generated_method = "5558BCE67B8081D2BE7E25243209DB1F")
    public  ScrollBarDrawable() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.301 -0400", hash_original_method = "338EA256BE1472C967D04B115E1F5FA4", hash_generated_method = "8FE1A7911C19092C119347D7A13DD9D1")
    public void setAlwaysDrawHorizontalTrack(boolean alwaysDrawTrack) {
        mAlwaysDrawHorizontalTrack = alwaysDrawTrack;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.301 -0400", hash_original_method = "901AC7B8EB84A9D2458B7938E8E4C73B", hash_generated_method = "C66686FBF2DCE14707F1068103458953")
    public void setAlwaysDrawVerticalTrack(boolean alwaysDrawTrack) {
        mAlwaysDrawVerticalTrack = alwaysDrawTrack;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.302 -0400", hash_original_method = "0A81522E62255950E42918FC464ECE8D", hash_generated_method = "1A41ABE0D9BD33785F669E3D232AF25D")
    public boolean getAlwaysDrawVerticalTrack() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1181010635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1181010635;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.302 -0400", hash_original_method = "58B8563B0AE3601908934E7BD6ECE0D9", hash_generated_method = "9FF9D03A95F14558F8A9DF00C4D69DCE")
    public boolean getAlwaysDrawHorizontalTrack() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664472675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664472675;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.302 -0400", hash_original_method = "0CC6554F6E9383DBFFA4FCF818E81542", hash_generated_method = "E33F78764B92F7E5FB9253C18544F676")
    public void setParameters(int range, int offset, int extent, boolean vertical) {
        {
            mChanged = true;
        } 
        {
            mRangeChanged = true;
        } 
        mRange = range;
        mOffset = offset;
        mExtent = extent;
        mVertical = vertical;
        
        
            
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.303 -0400", hash_original_method = "1E3ED238DD8B93FF3896611B5226DF40", hash_generated_method = "03143E17567E245B4D3EE0BF58AE02A9")
    @Override
    public void draw(Canvas canvas) {
        final boolean vertical = mVertical;
        final int extent = mExtent;
        final int range = mRange;
        boolean drawTrack = true;
        boolean drawThumb = true;
        {
            drawTrack = vertical ? mAlwaysDrawVerticalTrack : mAlwaysDrawHorizontalTrack;
            drawThumb = false;
        } 
        Rect r = getBounds();
        {
            boolean varD76EA641DE25B667522D35D8A7259174_396744419 = (canvas.quickReject(r.left, r.top, r.right, r.bottom, Canvas.EdgeType.AA));
        } 
        {
            drawTrack(canvas, r, vertical);
        } 
        {
            int size;
            size = r.height();
            size = r.width();
            int thickness;
            thickness = r.width();
            thickness = r.height();
            int length = Math.round((float) size * extent / range);
            int offset = Math.round((float) (size - length) * mOffset / (range - extent));
            int minLength = thickness * 2;
            {
                length = minLength;
            } 
            {
                offset = size - length;
            } 
            drawThumb(canvas, r, offset, length, vertical);
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.303 -0400", hash_original_method = "44DF7C7CE3C6FB97927067DC59DBEDA2", hash_generated_method = "28762268825B8EB65D2AAA6D0ADF6E1D")
    @Override
    protected void onBoundsChange(Rect bounds) {
        
        super.onBoundsChange(bounds);
        mChanged = true;
        addTaint(bounds.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.304 -0400", hash_original_method = "FBC32EDDC9C94F2A507C4B078AFDC706", hash_generated_method = "D8142E2D5A950CCDC92ECEDB5AA80D7F")
    protected void drawTrack(Canvas canvas, Rect bounds, boolean vertical) {
        Drawable track;
        {
            track = mVerticalTrack;
        } 
        {
            track = mHorizontalTrack;
        } 
        {
            {
                track.setBounds(bounds);
            } 
            track.draw(canvas);
        } 
        addTaint(canvas.getTaint());
        addTaint(bounds.getTaint());
        addTaint(vertical);
        
        
        
            
        
            
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.305 -0400", hash_original_method = "272AE2AAF08C3293C4192CBFA02ABB41", hash_generated_method = "2D04774F77EB365428AE297486A1F2C7")
    protected void drawThumb(Canvas canvas, Rect bounds, int offset, int length, boolean vertical) {
        final Rect thumbRect = mTempBounds;
        final boolean changed = mRangeChanged || mChanged;
        {
            {
                thumbRect.set(bounds.left,  bounds.top + offset,
                        bounds.right, bounds.top + offset + length);
            } 
            {
                thumbRect.set(bounds.left + offset, bounds.top,
                        bounds.left + offset + length, bounds.bottom);
            } 
        } 
        {
            final Drawable thumb = mVerticalThumb;
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } 
        {
            final Drawable thumb = mHorizontalThumb;
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } 
        addTaint(canvas.getTaint());
        addTaint(bounds.getTaint());
        addTaint(offset);
        addTaint(length);
        addTaint(vertical);
        
        
        
        
            
                
                        
            
                
                        
            
        
        
            
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.305 -0400", hash_original_method = "CF1FA0D3674C65E82EB702858CBA2EA8", hash_generated_method = "2B667190D5006483E403D42799B93BD6")
    public void setVerticalThumbDrawable(Drawable thumb) {
        {
            mVerticalThumb = thumb;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.305 -0400", hash_original_method = "95A534FB494475ED343603B1A863AD99", hash_generated_method = "76278313A4578813333311F1F2E2440F")
    public void setVerticalTrackDrawable(Drawable track) {
        mVerticalTrack = track;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.306 -0400", hash_original_method = "D314A45F62304CCC7D305EC252A7898A", hash_generated_method = "A3A96DB685AE8A936F884E081AF0EE0C")
    public void setHorizontalThumbDrawable(Drawable thumb) {
        {
            mHorizontalThumb = thumb;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.306 -0400", hash_original_method = "AA2EFF46594CC873B99869053CAE3587", hash_generated_method = "DDECC2F11A8C08406C0CA76FF56AFC51")
    public void setHorizontalTrackDrawable(Drawable track) {
        mHorizontalTrack = track;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.306 -0400", hash_original_method = "7E286D23B763C72717353421EFF3C480", hash_generated_method = "FCFDA370D4C4EEAADD1308E0A2CBB52A")
    public int getSize(boolean vertical) {
        {
            int var57087549A55D8A830EECC66A97BBD029_2145432226 = ((mVerticalTrack != null ?
                    mVerticalTrack : mVerticalThumb).getIntrinsicWidth()); 
        } 
        {
            int var96DC261A22A8F5D18162BD604E7B7C4D_119662434 = ((mHorizontalTrack != null ?
                    mHorizontalTrack : mHorizontalThumb).getIntrinsicHeight()); 
        } 
        addTaint(vertical);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867398695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867398695;
        
        
            
                    
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.307 -0400", hash_original_method = "B18AEA250E30640B8B376B842AF0FDF6", hash_generated_method = "5D92375401EF324A280FFF98E2C2FE5D")
    @Override
    public void setAlpha(int alpha) {
        {
            mVerticalTrack.setAlpha(alpha);
        } 
        mVerticalThumb.setAlpha(alpha);
        {
            mHorizontalTrack.setAlpha(alpha);
        } 
        mHorizontalThumb.setAlpha(alpha);
        addTaint(alpha);
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.307 -0400", hash_original_method = "CBF97912C9C8F01704D565D3AA800300", hash_generated_method = "EE8246BF4225DD67CA46C15529B6354A")
    @Override
    public void setColorFilter(ColorFilter cf) {
        {
            mVerticalTrack.setColorFilter(cf);
        } 
        mVerticalThumb.setColorFilter(cf);
        {
            mHorizontalTrack.setColorFilter(cf);
        } 
        mHorizontalThumb.setColorFilter(cf);
        addTaint(cf.getTaint());
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.307 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "A5F308F091CA6C332942A6F4D8A0F948")
    @Override
    public int getOpacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291345357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291345357;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.308 -0400", hash_original_method = "C5352C5923C905107C68A18CC8B889AA", hash_generated_method = "66740F31B4283EDEEDFE07E4F8BBFD3A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1776003897 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1776003897 = "ScrollBarDrawable: range=" + mRange + " offset=" + mOffset +
               " extent=" + mExtent + (mVertical ? " V" : " H");
        varB4EAC82CA7396A68D541C85D26508E83_1776003897.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1776003897;
        
        
               
    }

    
}

