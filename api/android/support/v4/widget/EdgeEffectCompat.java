package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;





public class EdgeEffectCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.018 -0400", hash_original_field = "57A7CF27A845892EEEA09B7BE13F185E", hash_generated_field = "8B86712DCA30565AC003C93F8A9D023C")

    private Object mEdgeEffect;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.019 -0400", hash_original_method = "D753748532B85BCF2954D7C221C91401", hash_generated_method = "A1ADE811356594F2DB256EED3B0F5EB3")
    public  EdgeEffectCompat(Context context) {
        mEdgeEffect = IMPL.newEdgeEffect(context);
        // ---------- Original Method ----------
        //mEdgeEffect = IMPL.newEdgeEffect(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.019 -0400", hash_original_method = "D4DAEE1A405642168AB096E0B8E2EAD2", hash_generated_method = "240AA4F8BD9ABD18CD1A0499424F0844")
    public void setSize(int width, int height) {
        addTaint(height);
        addTaint(width);
        IMPL.setSize(mEdgeEffect, width, height);
        // ---------- Original Method ----------
        //IMPL.setSize(mEdgeEffect, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.019 -0400", hash_original_method = "EFAA81473E99AA681742723D4D62AB38", hash_generated_method = "38ABFC346B20BE6918C044BDF79CE727")
    public boolean isFinished() {
        boolean var91CBA944E1EEFFC10C5B4EC5AD2A116F_1132956024 = (IMPL.isFinished(mEdgeEffect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035371880 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035371880;
        // ---------- Original Method ----------
        //return IMPL.isFinished(mEdgeEffect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.019 -0400", hash_original_method = "9C12A7C81A14CC06F079C8FA3122B4B4", hash_generated_method = "4D27A3E0F74451F4D051768EA9080087")
    public void finish() {
        IMPL.finish(mEdgeEffect);
        // ---------- Original Method ----------
        //IMPL.finish(mEdgeEffect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.019 -0400", hash_original_method = "1908B5EE653AB1B5A5CE65E81F6BDB7A", hash_generated_method = "DE39912AC238380CCE0988EE98E9A52D")
    public boolean onPull(float deltaDistance) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(deltaDistance);
        boolean var87D3B912AB81F6B0ED810819C8B9289A_330449037 = (IMPL.onPull(mEdgeEffect, deltaDistance));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182515556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182515556;
        // ---------- Original Method ----------
        //return IMPL.onPull(mEdgeEffect, deltaDistance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.019 -0400", hash_original_method = "45F767B8769552AFBFA0E978EE8933FD", hash_generated_method = "1EDF84B80CB909C0607F813BD1E3835B")
    public boolean onRelease() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varBD281C09CAB305420A5A3F00F68B1524_1867039144 = (IMPL.onRelease(mEdgeEffect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1581546031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1581546031;
        // ---------- Original Method ----------
        //return IMPL.onRelease(mEdgeEffect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "F0B0848CCB34A5B04946FEDCFE4DC62C", hash_generated_method = "6F5F0E6F542EC78DB6EFE9F036F83688")
    public boolean onAbsorb(int velocity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(velocity);
        boolean var09F4919033B1740B5A86B93DE6226338_1326735885 = (IMPL.onAbsorb(mEdgeEffect, velocity));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057257381 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057257381;
        // ---------- Original Method ----------
        //return IMPL.onAbsorb(mEdgeEffect, velocity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "F27D97BEDCE0E3BB57468FC6E19E8F78", hash_generated_method = "8C66598C1A88B792BE4E1859657688CC")
    public boolean draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        boolean var7558089B12F3331782B632A559048AD5_1671283573 = (IMPL.draw(mEdgeEffect, canvas));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372077025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_372077025;
        // ---------- Original Method ----------
        //return IMPL.draw(mEdgeEffect, canvas);
    }

    
    static class BaseEdgeEffectImpl implements EdgeEffectImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "E93AF950D68741CBF25DC67984C27D7B", hash_generated_method = "E93AF950D68741CBF25DC67984C27D7B")
        public BaseEdgeEffectImpl ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "598F7EE7163BC02F940E7AE457E81E71", hash_generated_method = "91A7D50BC6F52289739A29D844A97643")
        public Object newEdgeEffect(Context context) {
            addTaint(context.getTaint());
Object var540C13E9E156B687226421B24F2DF178_243645892 =             null;
            var540C13E9E156B687226421B24F2DF178_243645892.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_243645892;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "7AB0823D4C5E0A56EB104E764A6EE643", hash_generated_method = "0B1661D5ED0F1FBFDC5E65673765E666")
        public void setSize(Object edgeEffect, int width, int height) {
            addTaint(height);
            addTaint(width);
            addTaint(edgeEffect.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "18A3B4E50EAF82FBFB3F783FB1724270", hash_generated_method = "5C617032117C65CB244ADD422ECDD37A")
        public boolean isFinished(Object edgeEffect) {
            addTaint(edgeEffect.getTaint());
            boolean varB326B5062B2F0E69046810717534CB09_407984455 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977143410 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_977143410;
            // ---------- Original Method ----------
            //return true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "4537DDA1058A07DD12C2683C46DAE0A0", hash_generated_method = "214222B178933FED02E3E3C1CFC2ED00")
        public void finish(Object edgeEffect) {
            addTaint(edgeEffect.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "6D6767FA0A7FD096DC5FAE330C25B4EB", hash_generated_method = "B67620DFD15D71E19256D5944B708F23")
        public boolean onPull(Object edgeEffect, float deltaDistance) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(deltaDistance);
            addTaint(edgeEffect.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_804167539 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266816976 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_266816976;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "4CCDA82CBCC611597E463B09D91011D3", hash_generated_method = "E67EBC4FCC66B331F67BA8CF28AE05F4")
        public boolean onRelease(Object edgeEffect) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(edgeEffect.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_441945824 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224943948 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224943948;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "E4A19D3F19F8749DFC3F77D5467C90AC", hash_generated_method = "A8C35AC4988C60DBF6A3BCC474886F41")
        public boolean onAbsorb(Object edgeEffect, int velocity) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(velocity);
            addTaint(edgeEffect.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_639471520 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1002066689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1002066689;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.020 -0400", hash_original_method = "014795F812E9F03FFB958DEDF8F6EEBD", hash_generated_method = "2D2517D0FBC67E344B306DFE44CE8144")
        public boolean draw(Object edgeEffect, Canvas canvas) {
            addTaint(canvas.getTaint());
            addTaint(edgeEffect.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1698458331 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633872903 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633872903;
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    static class EdgeEffectIcsImpl implements EdgeEffectImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.021 -0400", hash_original_method = "722DC077141274393C35BB912CA199C0", hash_generated_method = "722DC077141274393C35BB912CA199C0")
        public EdgeEffectIcsImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.021 -0400", hash_original_method = "4DBA645CACC3049A11EF7913FF866293", hash_generated_method = "70C6074B256AA0057121434FC202738D")
        public Object newEdgeEffect(Context context) {
            addTaint(context.getTaint());
Object var9BD86E69F7DEF719FFA5C79E588AE7F0_1205532975 =             EdgeEffectCompatIcs.newEdgeEffect(context);
            var9BD86E69F7DEF719FFA5C79E588AE7F0_1205532975.addTaint(taint);
            return var9BD86E69F7DEF719FFA5C79E588AE7F0_1205532975;
            // ---------- Original Method ----------
            //return EdgeEffectCompatIcs.newEdgeEffect(context);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.021 -0400", hash_original_method = "7828FC66149E7A8F26ACE38B475CC37B", hash_generated_method = "E42CB41E0F190DA452E315A1245FBC04")
        public void setSize(Object edgeEffect, int width, int height) {
            addTaint(height);
            addTaint(width);
            addTaint(edgeEffect.getTaint());
            EdgeEffectCompatIcs.setSize(edgeEffect, width, height);
            // ---------- Original Method ----------
            //EdgeEffectCompatIcs.setSize(edgeEffect, width, height);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.021 -0400", hash_original_method = "C615DC1E8C401B6C07B9EA0C459CE8A5", hash_generated_method = "D1C842F8498915BD6277198B089D7EE3")
        public boolean isFinished(Object edgeEffect) {
            addTaint(edgeEffect.getTaint());
            boolean var911C1262D62877CE72AC66CDFAD8EFB3_1722426234 = (EdgeEffectCompatIcs.isFinished(edgeEffect));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045782083 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045782083;
            // ---------- Original Method ----------
            //return EdgeEffectCompatIcs.isFinished(edgeEffect);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.021 -0400", hash_original_method = "AD76F4504BEBAE253EF4AD4435BC2FB9", hash_generated_method = "399AC5A0F44BD2AFD07EC25F173C3B84")
        public void finish(Object edgeEffect) {
            addTaint(edgeEffect.getTaint());
            EdgeEffectCompatIcs.finish(edgeEffect);
            // ---------- Original Method ----------
            //EdgeEffectCompatIcs.finish(edgeEffect);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.022 -0400", hash_original_method = "A82E9A0A10EC720EFD1907409B81ECC2", hash_generated_method = "DE0B42EF4642840A24EE1312F5CBBF07")
        public boolean onPull(Object edgeEffect, float deltaDistance) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(deltaDistance);
            addTaint(edgeEffect.getTaint());
            boolean var99C01C46EE6ED7F83E3AB03DB39BD88D_221910619 = (EdgeEffectCompatIcs.onPull(edgeEffect, deltaDistance));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1642274929 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1642274929;
            // ---------- Original Method ----------
            //return EdgeEffectCompatIcs.onPull(edgeEffect, deltaDistance);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.022 -0400", hash_original_method = "D85EB1006C2B11862110869EE99A2168", hash_generated_method = "6A260FC9F8CB1F9C5C1A3CF9AEBE50F5")
        public boolean onRelease(Object edgeEffect) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(edgeEffect.getTaint());
            boolean varFFCBCEAFF29ED7CF6324559C130BE26A_1454105852 = (EdgeEffectCompatIcs.onRelease(edgeEffect));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159061859 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_159061859;
            // ---------- Original Method ----------
            //return EdgeEffectCompatIcs.onRelease(edgeEffect);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.022 -0400", hash_original_method = "DA1A282FCCAC2CD96B6A4C969DDDC50D", hash_generated_method = "8AE828DD67CAB64DA56BB06F707293E6")
        public boolean onAbsorb(Object edgeEffect, int velocity) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(velocity);
            addTaint(edgeEffect.getTaint());
            boolean var70C196C8761BC2B11C439F2594887939_1464051827 = (EdgeEffectCompatIcs.onAbsorb(edgeEffect, velocity));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394960272 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_394960272;
            // ---------- Original Method ----------
            //return EdgeEffectCompatIcs.onAbsorb(edgeEffect, velocity);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.022 -0400", hash_original_method = "C724F7B236835D74B44177C7968204E4", hash_generated_method = "7685AF3241EAC42367C27FE0D7C2C6C8")
        public boolean draw(Object edgeEffect, Canvas canvas) {
            addTaint(canvas.getTaint());
            addTaint(edgeEffect.getTaint());
            boolean var7B6BC264AAD1C23407C0DCB84BB9D3C8_1292380520 = (EdgeEffectCompatIcs.draw(edgeEffect, canvas));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1403430111 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1403430111;
            // ---------- Original Method ----------
            //return EdgeEffectCompatIcs.draw(edgeEffect, canvas);
        }

        
    }


    
    interface EdgeEffectImpl {
        public Object newEdgeEffect(Context context);
        public void setSize(Object edgeEffect, int width, int height);
        public boolean isFinished(Object edgeEffect);
        public void finish(Object edgeEffect);
        public boolean onPull(Object edgeEffect, float deltaDistance);
        public boolean onRelease(Object edgeEffect);
        public boolean onAbsorb(Object edgeEffect, int velocity);
        public boolean draw(Object edgeEffect, Canvas canvas);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.022 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "C39368587D934C727CBBE97C813A7339")

    private static EdgeEffectImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 14) { 
            IMPL = new EdgeEffectIcsImpl();
        } else {
            IMPL = new BaseEdgeEffectImpl();
        }
    }
    
}

