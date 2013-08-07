package android.support.v4.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;





public class AccessibilityDelegateCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.185 -0400", hash_original_field = "CED5B47A41B625766CF001EFABC0528E", hash_generated_field = "FB4910AEBDA35C6A7EDDEEAAF16AFC5E")

    Object mBridge;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.185 -0400", hash_original_method = "97DB5C1E35BD81C1D800183C23794857", hash_generated_method = "F78BE570E201B647D3E12D3E6CF191F8")
    public  AccessibilityDelegateCompat() {
        mBridge = IMPL.newAccessiblityDelegateBridge(this);
        // ---------- Original Method ----------
        //mBridge = IMPL.newAccessiblityDelegateBridge(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.186 -0400", hash_original_method = "29194344028099349300BA7E9C8229CD", hash_generated_method = "E4DDAD35E3926F68B5AA27548BAAAFAD")
     Object getBridge() {
Object var24F833124FC4728CF66CDDC6D3B2FC56_2038921256 =         mBridge;
        var24F833124FC4728CF66CDDC6D3B2FC56_2038921256.addTaint(taint);
        return var24F833124FC4728CF66CDDC6D3B2FC56_2038921256;
        // ---------- Original Method ----------
        //return mBridge;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.187 -0400", hash_original_method = "AF292CC2C422FC35BC5B564D13D2EFD0", hash_generated_method = "553D6D41756A101D19AE3F7123D66C8D")
    public void sendAccessibilityEvent(View host, int eventType) {
        addTaint(eventType);
        addTaint(host.getTaint());
        IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, host, eventType);
        // ---------- Original Method ----------
        //IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, host, eventType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.187 -0400", hash_original_method = "B8A02114F1FBE7409787CB3469B3FB8D", hash_generated_method = "9EEC046EF17478BA56077BEC5B83389D")
    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        addTaint(event.getTaint());
        addTaint(host.getTaint());
        IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, host, event);
        // ---------- Original Method ----------
        //IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, host, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.188 -0400", hash_original_method = "1C87274B198DB8C027DD7E3DED431EEE", hash_generated_method = "80789AE56607839628008DD768752BC6")
    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        addTaint(event.getTaint());
        addTaint(host.getTaint());
        boolean var8D5B6D12D8864DC11DF32FC9991C2F77_60509693 = (IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1581891395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1581891395;
        // ---------- Original Method ----------
        //return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.188 -0400", hash_original_method = "DE3AA9FE26B29E02F70EE9289C022DB2", hash_generated_method = "401EF6D8A63497649D223EC5B0678EA7")
    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(host.getTaint());
        IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event);
        // ---------- Original Method ----------
        //IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.189 -0400", hash_original_method = "6FCF19A166005C43B6A9E9FED7E7775A", hash_generated_method = "185061DB0E5895ADF477BEB8B6F68228")
    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(host.getTaint());
        IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, host, event);
        // ---------- Original Method ----------
        //IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, host, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.189 -0400", hash_original_method = "702CF486436EF7CB7E261126510CB2C4", hash_generated_method = "5D28842E8EF867A3FAB62A8A56E448C4")
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        addTaint(host.getTaint());
        IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, host, info);
        // ---------- Original Method ----------
        //IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, host, info);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.190 -0400", hash_original_method = "73CE2F858DC24998E108FD42EF6CF922", hash_generated_method = "B729155747E67FC7DAF50D5400ABAD4D")
    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
            AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(child.getTaint());
        addTaint(host.getTaint());
        boolean varDAA804C29817B347637B18F7C3BE3AC7_2106895031 = (IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, host, child, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650427469 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650427469;
        // ---------- Original Method ----------
        //return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, host, child, event);
    }

    
    static class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.190 -0400", hash_original_method = "DD5FA6B7DB30F302274C6D21593F2A63", hash_generated_method = "DD5FA6B7DB30F302274C6D21593F2A63")
        public AccessibilityDelegateStubImpl ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.190 -0400", hash_original_method = "5A07CEDF6000B635EBB3282D6BCEC4C0", hash_generated_method = "F447356F8C1699130BBD0B1AE8505778")
        public Object newAccessiblityDelegateDefaultImpl() {
Object var540C13E9E156B687226421B24F2DF178_1404797293 =             null;
            var540C13E9E156B687226421B24F2DF178_1404797293.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1404797293;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.190 -0400", hash_original_method = "CA4708336A662876B1C4E973563DF8C7", hash_generated_method = "ED658B9BEE8FA7953567C9C45B36D69E")
        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat listener) {
            addTaint(listener.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1598583326 =             null;
            var540C13E9E156B687226421B24F2DF178_1598583326.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1598583326;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.191 -0400", hash_original_method = "9EE5CAEDF307AFCEB241BA171EF39C83", hash_generated_method = "38AF12930998F9F6CC964FDA7EC5B91F")
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_486762637 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371219895 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371219895;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.191 -0400", hash_original_method = "1447397CED667B971B04D5F82ACD0B6D", hash_generated_method = "225086B214F75BDCA170C89E0ADB2C57")
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.191 -0400", hash_original_method = "99C4DEE76C5B6F4A70F08ECD66D4CBFF", hash_generated_method = "3D77FE40A1AADA4203C92B860EDAFFFF")
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(info.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.192 -0400", hash_original_method = "01D49E3547E9C548CD307570029DA5C4", hash_generated_method = "868C8882B6E6BD958654FB038CB0DAC1")
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.193 -0400", hash_original_method = "389DE28FC8C0CFCD072BB38D30CE111B", hash_generated_method = "00C02339756633AF965A7574719B9C84")
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(child.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            boolean varB326B5062B2F0E69046810717534CB09_1395342948 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_843935001 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_843935001;
            // ---------- Original Method ----------
            //return true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.194 -0400", hash_original_method = "62BC6D1148E35F68F64E7D17E3EF0845", hash_generated_method = "593BBEE4952D85452CC23527030EF887")
        public void sendAccessibilityEvent(Object delegate, View host, int eventType) {
            addTaint(eventType);
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.195 -0400", hash_original_method = "B229E2592A12C5FBAB6E11834FD34BE2", hash_generated_method = "955305F28D84EC1BFDC9E23FE39048F8")
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event) {
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    static class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.196 -0400", hash_original_method = "001B0205D9FC59E8AC4A7BF341AF74E0", hash_generated_method = "001B0205D9FC59E8AC4A7BF341AF74E0")
        public AccessibilityDelegateIcsImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.196 -0400", hash_original_method = "ADAF22ACD619CA057B205743038B9CB6", hash_generated_method = "C100AE14AE2A98D59BC29825D5963EB5")
        @Override
        public Object newAccessiblityDelegateDefaultImpl() {
Object var1F18FF75956054871BF6E0AF38CEB1F5_694812039 =             AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
            var1F18FF75956054871BF6E0AF38CEB1F5_694812039.addTaint(taint);
            return var1F18FF75956054871BF6E0AF38CEB1F5_694812039;
            // ---------- Original Method ----------
            //return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.199 -0400", hash_original_method = "EF6EEE52340F95386564E9C57AF7030E", hash_generated_method = "39833598DD9DF76C6C70E7BE68903BCD")
        @Override
        public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat compat) {
            addTaint(compat.getTaint());
Object varA7267C588A08581F1A4C65938C8DD2C2_1578545931 =             AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(
                    new AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.197 -0400", hash_original_method = "9395E77EA1FD8AFEADB2DB8B279E2A67", hash_generated_method = "50219FDA3CF851B2E35CD601A0FC7117")
            @Override
            public boolean dispatchPopulateAccessibilityEvent(View host,
                        AccessibilityEvent event) {
                addTaint(event.getTaint());
                addTaint(host.getTaint());
                boolean var894E37CCC59D9400C53F46D4295AEBE5_1341586794 = (compat.dispatchPopulateAccessibilityEvent(host, event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638974468 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_638974468;
                // ---------- Original Method ----------
                //return compat.dispatchPopulateAccessibilityEvent(host, event);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.197 -0400", hash_original_method = "D7ED4F87557CED496737993AB37F4B3F", hash_generated_method = "1061728B2696EC05AB2BA831B9B9FE7B")
            @Override
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(event.getTaint());
                addTaint(host.getTaint());
                compat.onInitializeAccessibilityEvent(host, event);
                // ---------- Original Method ----------
                //compat.onInitializeAccessibilityEvent(host, event);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.197 -0400", hash_original_method = "BCC479229D07763EE1ADFC3B5966A67E", hash_generated_method = "90C86DABAB725079DBFEF3C6192749D9")
            @Override
            public void onInitializeAccessibilityNodeInfo(View host, Object info) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(info.getTaint());
                addTaint(host.getTaint());
                compat.onInitializeAccessibilityNodeInfo(host,
                            new AccessibilityNodeInfoCompat(info));
                // ---------- Original Method ----------
                //compat.onInitializeAccessibilityNodeInfo(host,
                            //new AccessibilityNodeInfoCompat(info));
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.198 -0400", hash_original_method = "CCB1C95876DA6951777EF2568060C667", hash_generated_method = "58A67F5F584279E682CF492C950112D9")
            @Override
            public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(event.getTaint());
                addTaint(host.getTaint());
                compat.onPopulateAccessibilityEvent(host, event);
                // ---------- Original Method ----------
                //compat.onPopulateAccessibilityEvent(host, event);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.198 -0400", hash_original_method = "8B3EFAFCC5F82FF08E5816A5D75668A2", hash_generated_method = "8C897E342FC3BA6B753F693216C9E7A5")
            @Override
            public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                        AccessibilityEvent event) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(event.getTaint());
                addTaint(child.getTaint());
                addTaint(host.getTaint());
                boolean varA6058C66519A0E1935166E7EA3942A8C_1515574381 = (compat.onRequestSendAccessibilityEvent(host, child, event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513761595 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_513761595;
                // ---------- Original Method ----------
                //return compat.onRequestSendAccessibilityEvent(host, child, event);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.198 -0400", hash_original_method = "70D63C2BFF8EC6B97AB4FDD168BE56A7", hash_generated_method = "988FD5385B23802462076B7C7DFE173C")
            @Override
            public void sendAccessibilityEvent(View host, int eventType) {
                addTaint(eventType);
                addTaint(host.getTaint());
                compat.sendAccessibilityEvent(host, eventType);
                // ---------- Original Method ----------
                //compat.sendAccessibilityEvent(host, eventType);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.199 -0400", hash_original_method = "DD5EF61DAD976C4E444C1B00AA4D994D", hash_generated_method = "CB4F2E97997279FA3E639DDD474F0204")
            @Override
            public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                addTaint(event.getTaint());
                addTaint(host.getTaint());
                compat.sendAccessibilityEventUnchecked(host, event);
                // ---------- Original Method ----------
                //compat.sendAccessibilityEventUnchecked(host, event);
            }
});
            varA7267C588A08581F1A4C65938C8DD2C2_1578545931.addTaint(taint);
            return varA7267C588A08581F1A4C65938C8DD2C2_1578545931;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.200 -0400", hash_original_method = "A1518D561F40DF26E37D569D02982E76", hash_generated_method = "9FA99F9A7050116D94F7336C2CB4AE17")
        @Override
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            boolean var3129535EECAFF38A4C6BFFED724DDAB1_1266658794 = (AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(delegate,
                    host, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388651456 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388651456;
            // ---------- Original Method ----------
            //return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(delegate,
                    //host, event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.200 -0400", hash_original_method = "A0E50F9243C79B4834000935E8855FFE", hash_generated_method = "97194941F6127C0E85C2B487E61BE113")
        @Override
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(delegate, host, event);
            // ---------- Original Method ----------
            //AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(delegate, host, event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.200 -0400", hash_original_method = "D0ED71D45ACAEF3BA7B6BDF8CF8F5C95", hash_generated_method = "3BAD91ABD3C33EB011F9EDC86E49790F")
        @Override
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(info.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(delegate, host,
                    info.getImpl());
            // ---------- Original Method ----------
            //AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(delegate, host,
                    //info.getImpl());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.200 -0400", hash_original_method = "1624D34A4650739EE18F8E9A67254A81", hash_generated_method = "D736AD498AB1333EA40E45EA9350FE09")
        @Override
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(delegate, host, event);
            // ---------- Original Method ----------
            //AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(delegate, host, event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.201 -0400", hash_original_method = "EF218248BAE86D6D59789C66485E274F", hash_generated_method = "563D7365A0B8EBD8E70F3018FA1D4019")
        @Override
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(child.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            boolean varC1FF9AF1C1398485AB0E342360A9F1A6_1256237130 = (AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(delegate, host,
                    child, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696649349 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_696649349;
            // ---------- Original Method ----------
            //return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(delegate, host,
                    //child, event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.201 -0400", hash_original_method = "C594616778EB2064149441C8178D2CA3", hash_generated_method = "4023702C6FCBB8731D32B1E53E5818A5")
        @Override
        public void sendAccessibilityEvent(Object delegate, View host, int eventType) {
            addTaint(eventType);
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            AccessibilityDelegateCompatIcs.sendAccessibilityEvent(delegate, host, eventType);
            // ---------- Original Method ----------
            //AccessibilityDelegateCompatIcs.sendAccessibilityEvent(delegate, host, eventType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.201 -0400", hash_original_method = "BF4ECD99B5AA5C3F0A34771E612A54CE", hash_generated_method = "2A2EEEFCDCEA56564A2790A6D5E0A312")
        @Override
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event) {
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            addTaint(delegate.getTaint());
            AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(delegate, host, event);
            // ---------- Original Method ----------
            //AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(delegate, host, event);
        }

        
    }


    
    static interface AccessibilityDelegateImpl {
        public Object newAccessiblityDelegateDefaultImpl();
        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat listener);
        public boolean dispatchPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public void onInitializeAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public void onInitializeAccessibilityNodeInfo(Object delegate, View host,
                AccessibilityNodeInfoCompat info);
        public void onPopulateAccessibilityEvent(Object delegate, View host,
                AccessibilityEvent event);
        public boolean onRequestSendAccessibilityEvent(Object delegate, ViewGroup host, View child,
                AccessibilityEvent event);
        public void sendAccessibilityEvent(Object delegate, View host, int eventType);
        public void sendAccessibilityEventUnchecked(Object delegate, View host,
                AccessibilityEvent event);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.201 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "69637AEE9A0A7BCD1114720A430081E5")

    private static AccessibilityDelegateImpl IMPL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.201 -0400", hash_original_field = "2AE65CAD5482162AD1E3215D63E295AF", hash_generated_field = "2FAA9D9F17162833D2EDFD9409B491F8")

    private static Object DEFAULT_DELEGATE;
    static {
        if (Build.VERSION.SDK_INT >= 14) { 
            IMPL = new AccessibilityDelegateIcsImpl();
        } else {
            IMPL = new AccessibilityDelegateStubImpl();
        }
        DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
    }
    
}

