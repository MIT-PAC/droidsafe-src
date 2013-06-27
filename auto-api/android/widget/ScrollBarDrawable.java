package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ScrollBarDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "547048FD5F31D56228887526190F55C7", hash_generated_field = "E04A3D9DD9EF3A7F912E815C6BFCA25E")

    private Drawable mVerticalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "1D4D30ED27A9B00A259A256890EC0242", hash_generated_field = "14177887DA33DECB5E35DF1A209CFD6B")

    private Drawable mHorizontalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "9EEF20285C26D58E98CBF4DECBA5ED36", hash_generated_field = "D4785478D95BE31369EF8D658342B38B")

    private Drawable mVerticalThumb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "5E48039B59AA35A0B8CAF4DF71B3A98A", hash_generated_field = "A6C9AC87745812562596B1EB0E194CD2")

    private Drawable mHorizontalThumb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "5D4A81308B9054CB82785212636789DE", hash_generated_field = "EB6C39DC231EAF3B33208BD8796BA2F1")

    private int mRange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "E8439EB32866F13AD7ABD06DB4A15343", hash_generated_field = "F358652CEEA6BACE7E593752AA27CBE6")

    private int mOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "ED217E69B01A255AFFB3AEBD35455C1D", hash_generated_field = "D7D4E6D21EA2FE73F01CE81D6CC81FA1")

    private int mExtent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "151A20A8D7084F60EB7F7A4B44844050", hash_generated_field = "69CBC6FC9EE367E3A738852DD60DDD6D")

    private boolean mVertical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "E441004F88853A62D62B487B13AF6154", hash_generated_field = "F1F17F4E3280622D0A9B77B123769A5C")

    private boolean mChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "CDD7B56C3280846F16CD5BBA46EEAC5D", hash_generated_field = "4F6E0C8B4F81EFED7C3C83FC67B47487")

    private boolean mRangeChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "E3FB88F1170F920ECFA15D83AA99D025", hash_generated_field = "90840C3329620D54595BFC88FE5EAEC1")

    private Rect mTempBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "2B9368BA3124C9DDA5EF7E10AC8580EB", hash_generated_field = "73D3FAACDDA42D621076D0307124BA72")

    private boolean mAlwaysDrawHorizontalTrack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_field = "E1BAE08AA8010857DCC5896DD966EC0A", hash_generated_field = "BDCE388B565752F7D96B5F7F9F3DDA9A")

    private boolean mAlwaysDrawVerticalTrack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.302 -0400", hash_original_method = "F6C29E547BD302257DEE1C67DCEB3680", hash_generated_method = "5558BCE67B8081D2BE7E25243209DB1F")
    public  ScrollBarDrawable() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.303 -0400", hash_original_method = "338EA256BE1472C967D04B115E1F5FA4", hash_generated_method = "8FE1A7911C19092C119347D7A13DD9D1")
    public void setAlwaysDrawHorizontalTrack(boolean alwaysDrawTrack) {
        mAlwaysDrawHorizontalTrack = alwaysDrawTrack;
        // ---------- Original Method ----------
        //mAlwaysDrawHorizontalTrack = alwaysDrawTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.303 -0400", hash_original_method = "901AC7B8EB84A9D2458B7938E8E4C73B", hash_generated_method = "C66686FBF2DCE14707F1068103458953")
    public void setAlwaysDrawVerticalTrack(boolean alwaysDrawTrack) {
        mAlwaysDrawVerticalTrack = alwaysDrawTrack;
        // ---------- Original Method ----------
        //mAlwaysDrawVerticalTrack = alwaysDrawTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.303 -0400", hash_original_method = "0A81522E62255950E42918FC464ECE8D", hash_generated_method = "D8A24ACF528D22050A3ED75F9B2AF523")
    public boolean getAlwaysDrawVerticalTrack() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944300542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944300542;
        // ---------- Original Method ----------
        //return mAlwaysDrawVerticalTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.312 -0400", hash_original_method = "58B8563B0AE3601908934E7BD6ECE0D9", hash_generated_method = "0D93B1CD9E7CC3519D34530A2A8EB1D7")
    public boolean getAlwaysDrawHorizontalTrack() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122924234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_122924234;
        // ---------- Original Method ----------
        //return mAlwaysDrawHorizontalTrack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.313 -0400", hash_original_method = "0CC6554F6E9383DBFFA4FCF818E81542", hash_generated_method = "E33F78764B92F7E5FB9253C18544F676")
    public void setParameters(int range, int offset, int extent, boolean vertical) {
        {
            mChanged = true;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.319 -0400", hash_original_method = "1E3ED238DD8B93FF3896611B5226DF40", hash_generated_method = "75C70C7A1349724F48A3F37A94C682D1")
    @Override
    public void draw(Canvas canvas) {
        boolean vertical;
        vertical = mVertical;
        int extent;
        extent = mExtent;
        int range;
        range = mRange;
        boolean drawTrack;
        drawTrack = true;
        boolean drawThumb;
        drawThumb = true;
        {
            drawTrack = vertical ? mAlwaysDrawVerticalTrack : mAlwaysDrawHorizontalTrack;
            drawThumb = false;
        } //End block
        Rect r;
        r = getBounds();
        {
            boolean varD76EA641DE25B667522D35D8A7259174_1789725894 = (canvas.quickReject(r.left, r.top, r.right, r.bottom, Canvas.EdgeType.AA));
        } //End collapsed parenthetic
        {
            drawTrack(canvas, r, vertical);
        } //End block
        {
            int size;
            size = r.height();
            size = r.width();
            int thickness;
            thickness = r.width();
            thickness = r.height();
            int length;
            length = Math.round((float) size * extent / range);
            int offset;
            offset = Math.round((float) (size - length) * mOffset / (range - extent));
            int minLength;
            minLength = thickness * 2;
            {
                length = minLength;
            } //End block
            {
                offset = size - length;
            } //End block
            drawThumb(canvas, r, offset, length, vertical);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.320 -0400", hash_original_method = "44DF7C7CE3C6FB97927067DC59DBEDA2", hash_generated_method = "28762268825B8EB65D2AAA6D0ADF6E1D")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onBoundsChange(bounds);
        mChanged = true;
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //super.onBoundsChange(bounds);
        //mChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.320 -0400", hash_original_method = "FBC32EDDC9C94F2A507C4B078AFDC706", hash_generated_method = "D8142E2D5A950CCDC92ECEDB5AA80D7F")
    protected void drawTrack(Canvas canvas, Rect bounds, boolean vertical) {
        Drawable track;
        {
            track = mVerticalTrack;
        } //End block
        {
            track = mHorizontalTrack;
        } //End block
        {
            {
                track.setBounds(bounds);
            } //End block
            track.draw(canvas);
        } //End block
        addTaint(canvas.getTaint());
        addTaint(bounds.getTaint());
        addTaint(vertical);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.330 -0400", hash_original_method = "272AE2AAF08C3293C4192CBFA02ABB41", hash_generated_method = "5318121BDDDFD6AF966F6DEDF0301E75")
    protected void drawThumb(Canvas canvas, Rect bounds, int offset, int length, boolean vertical) {
        Rect thumbRect;
        thumbRect = mTempBounds;
        boolean changed;
        changed = mRangeChanged || mChanged;
        {
            {
                thumbRect.set(bounds.left,  bounds.top + offset,
                        bounds.right, bounds.top + offset + length);
            } //End block
            {
                thumbRect.set(bounds.left + offset, bounds.top,
                        bounds.left + offset + length, bounds.bottom);
            } //End block
        } //End block
        {
            Drawable thumb;
            thumb = mVerticalThumb;
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } //End block
        {
            Drawable thumb;
            thumb = mHorizontalThumb;
            thumb.setBounds(thumbRect);
            thumb.draw(canvas);
        } //End block
        addTaint(canvas.getTaint());
        addTaint(bounds.getTaint());
        addTaint(offset);
        addTaint(length);
        addTaint(vertical);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.330 -0400", hash_original_method = "CF1FA0D3674C65E82EB702858CBA2EA8", hash_generated_method = "2B667190D5006483E403D42799B93BD6")
    public void setVerticalThumbDrawable(Drawable thumb) {
        {
            mVerticalThumb = thumb;
        } //End block
        // ---------- Original Method ----------
        //if (thumb != null) {
            //mVerticalThumb = thumb;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.331 -0400", hash_original_method = "95A534FB494475ED343603B1A863AD99", hash_generated_method = "76278313A4578813333311F1F2E2440F")
    public void setVerticalTrackDrawable(Drawable track) {
        mVerticalTrack = track;
        // ---------- Original Method ----------
        //mVerticalTrack = track;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.331 -0400", hash_original_method = "D314A45F62304CCC7D305EC252A7898A", hash_generated_method = "A3A96DB685AE8A936F884E081AF0EE0C")
    public void setHorizontalThumbDrawable(Drawable thumb) {
        {
            mHorizontalThumb = thumb;
        } //End block
        // ---------- Original Method ----------
        //if (thumb != null) {
            //mHorizontalThumb = thumb;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.331 -0400", hash_original_method = "AA2EFF46594CC873B99869053CAE3587", hash_generated_method = "DDECC2F11A8C08406C0CA76FF56AFC51")
    public void setHorizontalTrackDrawable(Drawable track) {
        mHorizontalTrack = track;
        // ---------- Original Method ----------
        //mHorizontalTrack = track;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.331 -0400", hash_original_method = "7E286D23B763C72717353421EFF3C480", hash_generated_method = "0769C8741A30CEC61C2BDB01F43AFACE")
    public int getSize(boolean vertical) {
        {
            int var57087549A55D8A830EECC66A97BBD029_239472627 = ((mVerticalTrack != null ?
                    mVerticalTrack : mVerticalThumb).getIntrinsicWidth()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        {
            int var96DC261A22A8F5D18162BD604E7B7C4D_393714535 = ((mHorizontalTrack != null ?
                    mHorizontalTrack : mHorizontalThumb).getIntrinsicHeight()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        addTaint(vertical);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416784868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416784868;
        // ---------- Original Method ----------
        //if (vertical) {
            //return (mVerticalTrack != null ?
                    //mVerticalTrack : mVerticalThumb).getIntrinsicWidth();
        //} else {
            //return (mHorizontalTrack != null ?
                    //mHorizontalTrack : mHorizontalThumb).getIntrinsicHeight();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.332 -0400", hash_original_method = "B18AEA250E30640B8B376B842AF0FDF6", hash_generated_method = "5D92375401EF324A280FFF98E2C2FE5D")
    @Override
    public void setAlpha(int alpha) {
        {
            mVerticalTrack.setAlpha(alpha);
        } //End block
        mVerticalThumb.setAlpha(alpha);
        {
            mHorizontalTrack.setAlpha(alpha);
        } //End block
        mHorizontalThumb.setAlpha(alpha);
        addTaint(alpha);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.332 -0400", hash_original_method = "CBF97912C9C8F01704D565D3AA800300", hash_generated_method = "EE8246BF4225DD67CA46C15529B6354A")
    @Override
    public void setColorFilter(ColorFilter cf) {
        {
            mVerticalTrack.setColorFilter(cf);
        } //End block
        mVerticalThumb.setColorFilter(cf);
        {
            mHorizontalTrack.setColorFilter(cf);
        } //End block
        mHorizontalThumb.setColorFilter(cf);
        addTaint(cf.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.356 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "70E6EEB5AC2E5932EDFE248607C654DB")
    @Override
    public int getOpacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357842079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357842079;
        // ---------- Original Method ----------
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.357 -0400", hash_original_method = "C5352C5923C905107C68A18CC8B889AA", hash_generated_method = "EF246208E36BD0B367B052BA8FD2700D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1668940224 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1668940224 = "ScrollBarDrawable: range=" + mRange + " offset=" + mOffset +
               " extent=" + mExtent + (mVertical ? " V" : " H");
        varB4EAC82CA7396A68D541C85D26508E83_1668940224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1668940224;
        // ---------- Original Method ----------
        //return "ScrollBarDrawable: range=" + mRange + " offset=" + mOffset +
               //" extent=" + mExtent + (mVertical ? " V" : " H");
    }

    
}

