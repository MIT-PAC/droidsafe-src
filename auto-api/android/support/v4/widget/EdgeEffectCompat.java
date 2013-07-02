package android.support.v4.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;

public class EdgeEffectCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.310 -0400", hash_original_field = "57A7CF27A845892EEEA09B7BE13F185E", hash_generated_field = "8B86712DCA30565AC003C93F8A9D023C")

    private Object mEdgeEffect;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.311 -0400", hash_original_method = "D753748532B85BCF2954D7C221C91401", hash_generated_method = "A1ADE811356594F2DB256EED3B0F5EB3")
    public  EdgeEffectCompat(Context context) {
        mEdgeEffect = IMPL.newEdgeEffect(context);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.311 -0400", hash_original_method = "D4DAEE1A405642168AB096E0B8E2EAD2", hash_generated_method = "10759A7DC67983439FBE95C72E5D0608")
    public void setSize(int width, int height) {
        IMPL.setSize(mEdgeEffect, width, height);
        addTaint(width);
        addTaint(height);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.312 -0400", hash_original_method = "EFAA81473E99AA681742723D4D62AB38", hash_generated_method = "748FCFB190E5CC8DEE1B368455477D64")
    public boolean isFinished() {
        boolean var3EA09ADF94E351308B7D2F9F554CE5C6_1992267097 = (IMPL.isFinished(mEdgeEffect));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496735297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_496735297;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.312 -0400", hash_original_method = "9C12A7C81A14CC06F079C8FA3122B4B4", hash_generated_method = "4D27A3E0F74451F4D051768EA9080087")
    public void finish() {
        IMPL.finish(mEdgeEffect);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.313 -0400", hash_original_method = "1908B5EE653AB1B5A5CE65E81F6BDB7A", hash_generated_method = "103457749EFCA0230A4D5F937EEEBCAF")
    public boolean onPull(float deltaDistance) {
        
        boolean var49F6B611416CEB99433E1723B9963436_1382661942 = (IMPL.onPull(mEdgeEffect, deltaDistance));
        addTaint(deltaDistance);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821304818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821304818;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.313 -0400", hash_original_method = "45F767B8769552AFBFA0E978EE8933FD", hash_generated_method = "B0A354B638626F579340D104DCDCCB9D")
    public boolean onRelease() {
        
        boolean var845123BA855AFA627A6BFC6DB66C1464_1190195589 = (IMPL.onRelease(mEdgeEffect));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4221266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_4221266;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.313 -0400", hash_original_method = "F0B0848CCB34A5B04946FEDCFE4DC62C", hash_generated_method = "D2F31BEBE85EA1468845509F9C2A4F83")
    public boolean onAbsorb(int velocity) {
        
        boolean var7983AD964AD2959367886FA4B6FF2BC1_928231716 = (IMPL.onAbsorb(mEdgeEffect, velocity));
        addTaint(velocity);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623125258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_623125258;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.314 -0400", hash_original_method = "F27D97BEDCE0E3BB57468FC6E19E8F78", hash_generated_method = "8C1707A314FF40788F4E617E52630D54")
    public boolean draw(Canvas canvas) {
        boolean var0887A156A0CBF102BD39403A4700F946_449869881 = (IMPL.draw(mEdgeEffect, canvas));
        addTaint(canvas.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475159759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475159759;
        
        
    }

    
    static class BaseEdgeEffectImpl implements EdgeEffectImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.314 -0400", hash_original_method = "E93AF950D68741CBF25DC67984C27D7B", hash_generated_method = "E93AF950D68741CBF25DC67984C27D7B")
        public BaseEdgeEffectImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.314 -0400", hash_original_method = "598F7EE7163BC02F940E7AE457E81E71", hash_generated_method = "04BB62EAF6A30E672B87E2FF05E23790")
        public Object newEdgeEffect(Context context) {
            Object varB4EAC82CA7396A68D541C85D26508E83_442929234 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_442929234 = null;
            addTaint(context.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_442929234.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_442929234;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.315 -0400", hash_original_method = "7AB0823D4C5E0A56EB104E764A6EE643", hash_generated_method = "49B2AA1843748C607BB1606128254A22")
        public void setSize(Object edgeEffect, int width, int height) {
            addTaint(edgeEffect.getTaint());
            addTaint(width);
            addTaint(height);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.315 -0400", hash_original_method = "18A3B4E50EAF82FBFB3F783FB1724270", hash_generated_method = "9091B19E0029EC4B4824BA6FDDE5E3F5")
        public boolean isFinished(Object edgeEffect) {
            addTaint(edgeEffect.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546295224 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_546295224;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.316 -0400", hash_original_method = "4537DDA1058A07DD12C2683C46DAE0A0", hash_generated_method = "214222B178933FED02E3E3C1CFC2ED00")
        public void finish(Object edgeEffect) {
            addTaint(edgeEffect.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.316 -0400", hash_original_method = "6D6767FA0A7FD096DC5FAE330C25B4EB", hash_generated_method = "3E738DDF48FF5A79F0B1A3E7D01E767B")
        public boolean onPull(Object edgeEffect, float deltaDistance) {
            
            addTaint(edgeEffect.getTaint());
            addTaint(deltaDistance);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115260013 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115260013;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.317 -0400", hash_original_method = "4CCDA82CBCC611597E463B09D91011D3", hash_generated_method = "4D414B3AB7831C2C504EA14C72EAFA0A")
        public boolean onRelease(Object edgeEffect) {
            
            addTaint(edgeEffect.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392553248 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392553248;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.317 -0400", hash_original_method = "E4A19D3F19F8749DFC3F77D5467C90AC", hash_generated_method = "7FA39F5884BE376CF7D3C0CF1EC86945")
        public boolean onAbsorb(Object edgeEffect, int velocity) {
            
            addTaint(edgeEffect.getTaint());
            addTaint(velocity);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631848905 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631848905;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.318 -0400", hash_original_method = "014795F812E9F03FFB958DEDF8F6EEBD", hash_generated_method = "07CEBA38868EC0492FB606538E200922")
        public boolean draw(Object edgeEffect, Canvas canvas) {
            addTaint(edgeEffect.getTaint());
            addTaint(canvas.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1948307614 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1948307614;
            
            
        }

        
    }


    
    static class EdgeEffectIcsImpl implements EdgeEffectImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.318 -0400", hash_original_method = "722DC077141274393C35BB912CA199C0", hash_generated_method = "722DC077141274393C35BB912CA199C0")
        public EdgeEffectIcsImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.319 -0400", hash_original_method = "4DBA645CACC3049A11EF7913FF866293", hash_generated_method = "B510A2264F07F4D20694EF562746BC80")
        public Object newEdgeEffect(Context context) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1759512460 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1759512460 = EdgeEffectCompatIcs.newEdgeEffect(context);
            addTaint(context.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1759512460.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1759512460;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.320 -0400", hash_original_method = "7828FC66149E7A8F26ACE38B475CC37B", hash_generated_method = "340CA08827D52565611E8128FDC6E8D6")
        public void setSize(Object edgeEffect, int width, int height) {
            EdgeEffectCompatIcs.setSize(edgeEffect, width, height);
            addTaint(edgeEffect.getTaint());
            addTaint(width);
            addTaint(height);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.320 -0400", hash_original_method = "C615DC1E8C401B6C07B9EA0C459CE8A5", hash_generated_method = "14E2342EC31E7B826CED0253DD8FDBD5")
        public boolean isFinished(Object edgeEffect) {
            boolean var92021B66B6C455FA9C98D7EC13E0FB75_286126130 = (EdgeEffectCompatIcs.isFinished(edgeEffect));
            addTaint(edgeEffect.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714177798 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714177798;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.320 -0400", hash_original_method = "AD76F4504BEBAE253EF4AD4435BC2FB9", hash_generated_method = "A0452D7327A084395392B10AF3A17D31")
        public void finish(Object edgeEffect) {
            EdgeEffectCompatIcs.finish(edgeEffect);
            addTaint(edgeEffect.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.321 -0400", hash_original_method = "A82E9A0A10EC720EFD1907409B81ECC2", hash_generated_method = "F62F21BA73BDE5AFD559B4D6EEB94FD1")
        public boolean onPull(Object edgeEffect, float deltaDistance) {
            
            boolean var433561664B1B1C44BB28414376EF2187_1976931543 = (EdgeEffectCompatIcs.onPull(edgeEffect, deltaDistance));
            addTaint(edgeEffect.getTaint());
            addTaint(deltaDistance);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988221789 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_988221789;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.321 -0400", hash_original_method = "D85EB1006C2B11862110869EE99A2168", hash_generated_method = "FD731E103E94157975B65647E5D4D08D")
        public boolean onRelease(Object edgeEffect) {
            
            boolean var96599794B2E390224525D270AB981239_878601707 = (EdgeEffectCompatIcs.onRelease(edgeEffect));
            addTaint(edgeEffect.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_90958651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_90958651;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.321 -0400", hash_original_method = "DA1A282FCCAC2CD96B6A4C969DDDC50D", hash_generated_method = "28F90D600F11C2A0420A3BD5339B9040")
        public boolean onAbsorb(Object edgeEffect, int velocity) {
            
            boolean var16606BECCBEA8DCDC86980EE1AE84F47_1244219581 = (EdgeEffectCompatIcs.onAbsorb(edgeEffect, velocity));
            addTaint(edgeEffect.getTaint());
            addTaint(velocity);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555804398 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_555804398;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.322 -0400", hash_original_method = "C724F7B236835D74B44177C7968204E4", hash_generated_method = "F03FF8670132B1409134397793BC740A")
        public boolean draw(Object edgeEffect, Canvas canvas) {
            boolean varBE7C46C8462B47BE2D7A6E5E2437CD79_137471395 = (EdgeEffectCompatIcs.draw(edgeEffect, canvas));
            addTaint(edgeEffect.getTaint());
            addTaint(canvas.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_30601118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_30601118;
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.322 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "C39368587D934C727CBBE97C813A7339")

    private static EdgeEffectImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 14) { 
            IMPL = new EdgeEffectIcsImpl();
        } else {
            IMPL = new BaseEdgeEffectImpl();
        }
    }
    
}

