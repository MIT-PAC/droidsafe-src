package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.DragEvent;
import android.view.IWindow;
import android.view.IWindowSession;

public class BaseIWindow extends IWindow.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "223A16F1854300B80614F0CB3E74795C")

    private IWindowSession mSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

    public int mSeq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "FC9DB18371C1F1F6390E84279F9FE89A", hash_generated_method = "FC9DB18371C1F1F6390E84279F9FE89A")
    public BaseIWindow ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "DDDF8BE863F51F4784FBED4F44364C1D", hash_generated_method = "5C18C6F8866A52B959AE5703CF9BE0CA")
    public void setSession(IWindowSession session) {
        mSession = session;
        // ---------- Original Method ----------
        //mSession = session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "B78D43805956C22534D670D6CA75C80F", hash_generated_method = "E3504CC2FAB86F9BCD12A074399509B0")
    public void resized(int w, int h, Rect coveredInsets,
            Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
        addTaint(newConfig.getTaint());
        addTaint(reportDraw);
        addTaint(visibleInsets.getTaint());
        addTaint(coveredInsets.getTaint());
        addTaint(h);
        addTaint(w);
        if(reportDraw)        
        {
            try 
            {
                mSession.finishDrawing(this);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (reportDraw) {
            //try {
                //mSession.finishDrawing(this);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "BE0716F4AD0CF82E07CDF7A02946EA01", hash_generated_method = "8DFBCE56B7B4A7917AC4BEE9870F8E58")
    public void dispatchAppVisibility(boolean visible) {
        addTaint(visible);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "772CEEEC7D5AEF0AF70740664444DBC4", hash_generated_method = "DFC4B13DC642E23ADDFEF747CDDDFBCC")
    public void dispatchGetNewSurface() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "D905966528548D16DAB92D4F551B9EC2", hash_generated_method = "A0965464A69BD49D470E11ACFD31435D")
    public void windowFocusChanged(boolean hasFocus, boolean touchEnabled) {
        addTaint(touchEnabled);
        addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "FFE9D2CBC83B323644FA8C6DFE6F40CA", hash_generated_method = "9E1B88B9F5CFD832DDE372F9EEB87E36")
    public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
        addTaint(out.getTaint());
        addTaint(parameters.getTaint());
        addTaint(command.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "829D6830743782B159BBDA8D0B21AA05", hash_generated_method = "C351D757C39B19E87F3410EB56CC398B")
    public void closeSystemDialogs(String reason) {
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "5012B02F4729E57505C4DA5AF3CD3EF7", hash_generated_method = "ADEB70EEEC9B6B5628AB2DAC02FDA882")
    public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep, boolean sync) {
        addTaint(sync);
        addTaint(yStep);
        addTaint(xStep);
        addTaint(y);
        addTaint(x);
        if(sync)        
        {
            try 
            {
                mSession.wallpaperOffsetsComplete(asBinder());
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (sync) {
            //try {
                //mSession.wallpaperOffsetsComplete(asBinder());
            //} catch (RemoteException e) {
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.099 -0400", hash_original_method = "3961AB29F0B7DEEA47B4CBEA679C2606", hash_generated_method = "C6A1E92761703C898F3F7552B458E17F")
    public void dispatchDragEvent(DragEvent event) {
        addTaint(event.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.100 -0400", hash_original_method = "0828E805F96F67CD22A73377A61D4574", hash_generated_method = "48FF841F6E1713E18BA33753DE06368A")
    public void dispatchSystemUiVisibilityChanged(int seq, int globalUi,
            int localValue, int localChanges) {
        addTaint(localChanges);
        addTaint(localValue);
        addTaint(globalUi);
        mSeq = seq;
        // ---------- Original Method ----------
        //mSeq = seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.100 -0400", hash_original_method = "CCCF2ED340559A471760B73050C6F938", hash_generated_method = "3991F28ACBAEE20A60BACB2F4EFDBDDE")
    public void dispatchWallpaperCommand(String action, int x, int y,
            int z, Bundle extras, boolean sync) {
        addTaint(sync);
        addTaint(extras.getTaint());
        addTaint(z);
        addTaint(y);
        addTaint(x);
        addTaint(action.getTaint());
        if(sync)        
        {
            try 
            {
                mSession.wallpaperCommandComplete(asBinder(), null);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (sync) {
            //try {
                //mSession.wallpaperCommandComplete(asBinder(), null);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
}

