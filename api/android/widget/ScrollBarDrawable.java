package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ScrollBarDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "547048FD5F31D56228887526190F55C7", hash_generated_field = "E04A3D9DD9EF3A7F912E815C6BFCA25E")

    private Drawable mVerticalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "1D4D30ED27A9B00A259A256890EC0242", hash_generated_field = "14177887DA33DECB5E35DF1A209CFD6B")

    private Drawable mHorizontalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "9EEF20285C26D58E98CBF4DECBA5ED36", hash_generated_field = "D4785478D95BE31369EF8D658342B38B")

    private Drawable mVerticalThumb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "5E48039B59AA35A0B8CAF4DF71B3A98A", hash_generated_field = "A6C9AC87745812562596B1EB0E194CD2")

    private Drawable mHorizontalThumb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "5D4A81308B9054CB82785212636789DE", hash_generated_field = "EB6C39DC231EAF3B33208BD8796BA2F1")

    private int mRange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "E8439EB32866F13AD7ABD06DB4A15343", hash_generated_field = "F358652CEEA6BACE7E593752AA27CBE6")

    private int mOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "ED217E69B01A255AFFB3AEBD35455C1D", hash_generated_field = "D7D4E6D21EA2FE73F01CE81D6CC81FA1")

    private int mExtent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "151A20A8D7084F60EB7F7A4B44844050", hash_generated_field = "69CBC6FC9EE367E3A738852DD60DDD6D")

    private boolean mVertical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "E441004F88853A62D62B487B13AF6154", hash_generated_field = "F1F17F4E3280622D0A9B77B123769A5C")

    private boolean mChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "CDD7B56C3280846F16CD5BBA46EEAC5D", hash_generated_field = "4F6E0C8B4F81EFED7C3C83FC67B47487")

    private boolean mRangeChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "E3FB88F1170F920ECFA15D83AA99D025", hash_generated_field = "9DBB084DD0568D939B76BF72796B166A")

    private final Rect mTempBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "2B9368BA3124C9DDA5EF7E10AC8580EB", hash_generated_field = "73D3FAACDDA42D621076D0307124BA72")

    private boolean mAlwaysDrawHorizontalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.883 -0400", hash_original_field = "E1BAE08AA8010857DCC5896DD966EC0A", hash_generated_field = "BDCE388B565752F7D96B5F7F9F3DDA9A")

    private boolean mAlwaysDrawVerticalTrack;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.884 -0400", hash_original_method = "F6C29E547BD302257DEE1C67DCEB3680", hash_generated_method = "5558BCE67B8081D2BE7E25243209DB1F")
    public  ScrollBarDrawable() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.884 -0400", hash_original_method = "338EA256BE1472C967D04B115E1F5FA4", hash_generated_method = "8FE1A7911C19092C119347D7A13DD9D1")
    public void setAlwaysDrawHorizontalTrack(boolean alwaysDrawTrack) {
        mAlwaysDrawHorizontalTrack = alwaysDrawTrack;
        // ---------- Original Method ----------
        //mAlwaysDrawHorizontalTrack = alwaysDrawTrack;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.884 -0400", hash_original_method = "901AC7B8EB84A9D2458B7938E8E4C73B", hash_generated_method = "C66686FBF2DCE14707F1068103458953")
    public void setAlwaysDrawVerticalTrack(boolean alwaysDrawTrack) {
        mAlwaysDrawVerticalTrack = alwaysDrawTrack;
        // ---------- Original Method ----------
        //mAlwaysDrawVerticalTrack = alwaysDrawTrack;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.885 -0400", hash_original_method = "0A81522E62255950E42918FC464ECE8D", hash_generated_method = "2AE145DB8EFF75BBD544721B6BC3B9AF")
    public boolean getAlwaysDrawVerticalTrack() {
        boolean varE1BAE08AA8010857DCC5896DD966EC0A_1979812167 = (mAlwaysDrawVerticalTrack);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131631102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131631102;
        // ---------- Original Method ----------
        //return mAlwaysDrawVerticalTrack;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.885 -0400", hash_original_method = "58B8563B0AE3601908934E7BD6ECE0D9", hash_generated_method = "2E2B2E850814DEC2300252E23F0117FE")
    public boolean getAlwaysDrawHorizontalTrack() {
        boolean var2B9368BA3124C9DDA5EF7E10AC8580EB_1892733740 = (mAlwaysDrawHorizontalTrack);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934872547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_934872547;
        // ---------- Original Method ----------
        //return mAlwaysDrawHorizontalTrack;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.886 -0400", hash_original_method = "0CC6554F6E9383DBFFA4FCF818E81542", hash_generated_method = "41E7271BD5B051A39FF389843213AD06")
    public void setParameters(int range, int offset, int extent, boolean vertical) {
    if(mVertical != vertical)        
        {
            mChanged = true;
        } //End block
    if(mRange != range || mOffset != offset || mExtent != extent)        
        {
            mRangeChanged = true;
        } //End block
        mRange = range;
        mOffset = offset;
        mExtent = extent;
        mVertical = vertical;
        // ---------- Original Method ----------
        //if (mVertical != vertical) {
            //mChanged = true;
        //}
        //if (mRange != range || mOffset != offset || mExtent != extent) {
            //mRangeChanged = true;
        //}
        //mRange = range;
        //mOffset = offset;
        //mExtent = extent;
        //mVertical = vertical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.887 -0400", hash_original_method = "1E3ED238DD8B93FF3896611B5226DF40", hash_generated_method = "7FC42AA310962CD54762D96DDE90EB04")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        final boolean vertical = mVertical;
        final int extent = mExtent;
        final int range = mRange;
        boolean drawTrack = true;
        boolean drawThumb = true;
    if(extent <= 0 || range <= extent)        
        {
            drawTrack = vertical ? mAlwaysDrawVerticalTrack : mAlwaysDrawHorizontalTrack;
            drawThumb = false;
        } //End block
        Rect r = getBounds();
    if(canvas.quickReject(r.left, r.top, r.right, r.bottom, Canvas.EdgeType.AA))        
        {
            return;
        } //End block
    if(drawTrack)        
        {
            drawTrack(canvas, r, vertical);
        } //End block
    if(drawThumb)        
        {
            int size = vertical ? r.height() : r.width();
            int thickness = vertical ? r.width() : r.height();
            int length = Math.round((float) size * extent / range);
            int offset = Math.round((float) (size - length) * mOffset / (range - extent));
            int minLength = thickness * 2;
    if(length < minLength)            
            {
                length = minLength;
            } //End block
    if(offset + length > size)            
            {
                offset = size - length;
            } //End block
            drawThumb(canvas, r, offset, length, vertical);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.888 -0400", hash_original_method = "44DF7C7CE3C6FB97927067DC59DBEDA2", hash_generated_method = "234F873EEFF541E8F76F6444E7967C0E")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        super.onBoundsChange(bounds);
        mChanged = true;
        // ---------- Original Method ----------
        //super.onBoundsChange(bounds);
        //mChanged = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.888 -0400", hash_original_method = "FBC32EDDC9C94F2A507C4B078AFDC706", hash_generated_method = "8F23B2C5D7EAA33844EA210CE890B3DD")
    protected void drawTrack(Canvas canvas, Rect bounds, boolean vertical) {
        addTaint(vertical);
        addTaint(bounds.getTaint());
        addTaint(canvas.getTaint());
        Drawable track;
    if(vertical)        
        {
            track = mVerticalTrack;
        } //End block
        else
        {
            track = mHorizontalTrack;
        } //End block
    if(track != null)        
        {
    if(mChanged)            
            {
                track.setBounds(bounds);
            } //End block
            track.draw(canvas);
        } //End block
        // ---------- Original Method ----------
        //Drawable track;
        //if (vertical) {
            //track = mVerticalTrack;
        //} else {
            //track = mHorizontalTrack;
        //}
        //if (track != null) {
            //if (mChanged) {
                //track.setBounds(bounds);
            //}
            //track.draw(canvas);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.889 -0400", hash_original_method = "272AE2AAF08C3293C4192CBFA02ABB41", hash_generated_method = "2F496C3C0C2136F7CAD89B8B6715F7C6")
    protected void drawThumb(Canvas canvas, Rect bounds, int offset, int length, boolean vertical) {
        addTaint(vertical);
        addTaint(length);
        addTaint(offset);
        addTaint(bounds.getTaint());
        addTaint(canvas.getTaint());
        final Rect thumbRect = mTempBounds;
        final boolean changed = mRangeChanged || mChanged;
    if(changed)        
        {
    if(vertical)            
            {
                thumbRect.set(bounds.left,  bounds.top + offset,
                        bounds.right, bounds.top + offset + length);
            } //End block
            else
            {
                thumbRect.set(bounds.left + offset, bounds.top,
                        bounds.left + offset + length, bounds.bottom);
            } //End block
        } //End block
    if(vertical)        
        {
            final Drawable thumb = mVerticalThumb;
    if(changed)            
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } //End block
        else
        {
            final Drawable thumb = mHorizontalThumb;
    if(changed)            
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } //End block
        // ---------- Original Method ----------
        //final Rect thumbRect = mTempBounds;
        //final boolean changed = mRangeChanged || mChanged;
        //if (changed) {
            //if (vertical) {
                //thumbRect.set(bounds.left,  bounds.top + offset,
                        //bounds.right, bounds.top + offset + length);
            //} else {
                //thumbRect.set(bounds.left + offset, bounds.top,
                        //bounds.left + offset + length, bounds.bottom);
            //}
        //}
        //if (vertical) {
            //final Drawable thumb = mVerticalThumb;
            //if (changed) thumb.setBounds(thumbRect);
            //thumb.draw(canvas);
        //} else {
            //final Drawable thumb = mHorizontalThumb;
            //if (changed) thumb.setBounds(thumbRect);
            //thumb.draw(canvas);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.890 -0400", hash_original_method = "CF1FA0D3674C65E82EB702858CBA2EA8", hash_generated_method = "16FF5E5F308F4AEFD4C2E5B5A381D3D2")
    public void setVerticalThumbDrawable(Drawable thumb) {
    if(thumb != null)        
        {
            mVerticalThumb = thumb;
        } //End block
        // ---------- Original Method ----------
        //if (thumb != null) {
            //mVerticalThumb = thumb;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.890 -0400", hash_original_method = "95A534FB494475ED343603B1A863AD99", hash_generated_method = "76278313A4578813333311F1F2E2440F")
    public void setVerticalTrackDrawable(Drawable track) {
        mVerticalTrack = track;
        // ---------- Original Method ----------
        //mVerticalTrack = track;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.890 -0400", hash_original_method = "D314A45F62304CCC7D305EC252A7898A", hash_generated_method = "6FBE6B2D1E55F3C23288C88417E20532")
    public void setHorizontalThumbDrawable(Drawable thumb) {
    if(thumb != null)        
        {
            mHorizontalThumb = thumb;
        } //End block
        // ---------- Original Method ----------
        //if (thumb != null) {
            //mHorizontalThumb = thumb;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.891 -0400", hash_original_method = "AA2EFF46594CC873B99869053CAE3587", hash_generated_method = "DDECC2F11A8C08406C0CA76FF56AFC51")
    public void setHorizontalTrackDrawable(Drawable track) {
        mHorizontalTrack = track;
        // ---------- Original Method ----------
        //mHorizontalTrack = track;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.891 -0400", hash_original_method = "7E286D23B763C72717353421EFF3C480", hash_generated_method = "1FC2A6C5C2EFAA487EAF9EC025E49989")
    public int getSize(boolean vertical) {
        addTaint(vertical);
    if(vertical)        
        {
            int var2755B6C7879B2D6D371904BB73968A04_572547592 = ((mVerticalTrack != null ?
                    mVerticalTrack : mVerticalThumb).getIntrinsicWidth());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_180846246 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_180846246;
        } //End block
        else
        {
            int var785A622AC6AB2482FD5D0B9A588C7011_805239022 = ((mHorizontalTrack != null ?
                    mHorizontalTrack : mHorizontalThumb).getIntrinsicHeight());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823060577 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823060577;
        } //End block
        // ---------- Original Method ----------
        //if (vertical) {
            //return (mVerticalTrack != null ?
                    //mVerticalTrack : mVerticalThumb).getIntrinsicWidth();
        //} else {
            //return (mHorizontalTrack != null ?
                    //mHorizontalTrack : mHorizontalThumb).getIntrinsicHeight();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.891 -0400", hash_original_method = "B18AEA250E30640B8B376B842AF0FDF6", hash_generated_method = "8073E0D2CAE830A2A68A79A3A02B026A")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
    if(mVerticalTrack != null)        
        {
            mVerticalTrack.setAlpha(alpha);
        } //End block
        mVerticalThumb.setAlpha(alpha);
    if(mHorizontalTrack != null)        
        {
            mHorizontalTrack.setAlpha(alpha);
        } //End block
        mHorizontalThumb.setAlpha(alpha);
        // ---------- Original Method ----------
        //if (mVerticalTrack != null) {
            //mVerticalTrack.setAlpha(alpha);
        //}
        //mVerticalThumb.setAlpha(alpha);
        //if (mHorizontalTrack != null) {
            //mHorizontalTrack.setAlpha(alpha);
        //}
        //mHorizontalThumb.setAlpha(alpha);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.892 -0400", hash_original_method = "CBF97912C9C8F01704D565D3AA800300", hash_generated_method = "C099314E8C22F5EC481D2F3BC41570FD")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
    if(mVerticalTrack != null)        
        {
            mVerticalTrack.setColorFilter(cf);
        } //End block
        mVerticalThumb.setColorFilter(cf);
    if(mHorizontalTrack != null)        
        {
            mHorizontalTrack.setColorFilter(cf);
        } //End block
        mHorizontalThumb.setColorFilter(cf);
        // ---------- Original Method ----------
        //if (mVerticalTrack != null) {
            //mVerticalTrack.setColorFilter(cf);
        //}
        //mVerticalThumb.setColorFilter(cf);
        //if (mHorizontalTrack != null) {
            //mHorizontalTrack.setColorFilter(cf);
        //}
        //mHorizontalThumb.setColorFilter(cf);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.892 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "6A069166BE6604666032098B557172D3")
    @Override
    public int getOpacity() {
        int var26C79996E92FCFBDC98A49C80BC91AD0_368132617 = (PixelFormat.TRANSLUCENT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023961786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023961786;
        // ---------- Original Method ----------
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.892 -0400", hash_original_method = "C5352C5923C905107C68A18CC8B889AA", hash_generated_method = "AC4154AE99966D2DF9998053CC1C3F8A")
    @Override
    public String toString() {
String var7087EA442133FF0F138E2C3F13FFC9E5_1739658314 =         "ScrollBarDrawable: range=" + mRange + " offset=" + mOffset +
               " extent=" + mExtent + (mVertical ? " V" : " H");
        var7087EA442133FF0F138E2C3F13FFC9E5_1739658314.addTaint(taint);
        return var7087EA442133FF0F138E2C3F13FFC9E5_1739658314;
        // ---------- Original Method ----------
        //return "ScrollBarDrawable: range=" + mRange + " offset=" + mOffset +
               //" extent=" + mExtent + (mVertical ? " V" : " H");
    }

    
}

