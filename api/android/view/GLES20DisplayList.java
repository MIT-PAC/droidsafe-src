package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import java.util.ArrayList;

class GLES20DisplayList extends DisplayList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.972 -0400", hash_original_field = "D40867AE35FD7434138AD06437D816AD", hash_generated_field = "43DF9227571FB6A174765DA4CC1A8056")

    final ArrayList<Bitmap> mBitmaps = new ArrayList<Bitmap>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.972 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "B2F7DA6F3E4A8F7E7A9EA569E557EA23")

    private GLES20RecordingCanvas mCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.972 -0400", hash_original_field = "AB06C0B5FE02AF09E4F911D76AAEE4B2", hash_generated_field = "EA21572F663EFE15B9390D06509A48DD")

    private boolean mValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.972 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "CE668A6A9F47BC4EB8C56E4B4F351717")

    private DisplayListFinalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.972 -0400", hash_original_method = "AE604D63277D457D456549CB93FF76C1", hash_generated_method = "AE604D63277D457D456549CB93FF76C1")
    public GLES20DisplayList ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.972 -0400", hash_original_method = "95D7EAA4B043B28D3D04F5E259ED8AAD", hash_generated_method = "837276E931CE6637F3EF4F80E7005DFA")
     int getNativeDisplayList() {
    if(!mValid || mFinalizer == null)        
        {
            IllegalStateException var06213F52B8ACA3D2AEADB12DC5DE2AD4_811767725 = new IllegalStateException("The display list is not valid.");
            var06213F52B8ACA3D2AEADB12DC5DE2AD4_811767725.addTaint(taint);
            throw var06213F52B8ACA3D2AEADB12DC5DE2AD4_811767725;
        } 
        int varDBB802A0B6A30849748EBD456BC6D92D_667640923 = (mFinalizer.mNativeDisplayList);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471240859 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471240859;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.973 -0400", hash_original_method = "E5C596CBDCD8BE3EF1855673907A59B8", hash_generated_method = "B88138000F754DA7A1D16F5FD3D9B171")
    @Override
     HardwareCanvas start() {
    if(mCanvas != null)        
        {
            IllegalStateException varE1235A2E7A59005DC28786550630B7BD_1549295213 = new IllegalStateException("Recording has already started");
            varE1235A2E7A59005DC28786550630B7BD_1549295213.addTaint(taint);
            throw varE1235A2E7A59005DC28786550630B7BD_1549295213;
        } 
        mValid = false;
        mCanvas = GLES20RecordingCanvas.obtain(this);
        mCanvas.start();
HardwareCanvas var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_2002352752 =         mCanvas;
        var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_2002352752.addTaint(taint);
        return var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_2002352752;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.973 -0400", hash_original_method = "247D3D8A3D31E91BE5C013DB24963870", hash_generated_method = "5324511ABE521DB3D2590643621BE97D")
    @Override
     void invalidate() {
    if(mCanvas != null)        
        {
            mCanvas.recycle();
            mCanvas = null;
        } 
        mValid = false;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.974 -0400", hash_original_method = "3D6474677C8929AA6741081CA86616E2", hash_generated_method = "C3A5BD67E95404BFBF8AA35F264E0438")
    @Override
     boolean isValid() {
        boolean varAB06C0B5FE02AF09E4F911D76AAEE4B2_1665200837 = (mValid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221967848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221967848;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.975 -0400", hash_original_method = "96CA5C3852449FF9B74309A832926627", hash_generated_method = "233B6BDCB06001155F9BF184EA762713")
    @Override
     void end() {
    if(mCanvas != null)        
        {
    if(mFinalizer != null)            
            {
                mCanvas.end(mFinalizer.mNativeDisplayList);
            } 
            else
            {
                mFinalizer = new DisplayListFinalizer(mCanvas.end(0));
            } 
            mCanvas.recycle();
            mCanvas = null;
            mValid = true;
        } 
        
        
            
                
            
                
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.975 -0400", hash_original_method = "3E7FC40C3EA5DE4EA51EEDE8E80652F9", hash_generated_method = "2C21EF78868DD02A6CBAAC250E8BE573")
    @Override
     int getSize() {
    if(mFinalizer == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1278658815 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818258854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818258854;
        }
        int varEE53FC709F4FAB92B6A4D13DAC062304_389604388 = (GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800030626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800030626;
        
        
        
    }

    
    private static class DisplayListFinalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.976 -0400", hash_original_field = "18F4097D685B19CE7DD654C13CA0EBEA", hash_generated_field = "79CD38F4DEF89D187CA539E02ADB2412")

        int mNativeDisplayList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.976 -0400", hash_original_method = "0B1B093880262044EED2D5421EB7C8E9", hash_generated_method = "DAAE4ADD86F9B0F97F318309228FD8AA")
        public  DisplayListFinalizer(int nativeDisplayList) {
            mNativeDisplayList = nativeDisplayList;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.976 -0400", hash_original_method = "FB7FF5339A61C1A66F37CCF40E62B9AC", hash_generated_method = "E7681B50DE99CA561B64705CC62CB068")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                GLES20Canvas.destroyDisplayList(mNativeDisplayList);
            } 
            finally 
            {
                super.finalize();
            } 
            
            
                
            
                
            
        }

        
    }


    
}

