package java.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.609 -0400", hash_original_method = "898E1AC4CE228AED7FA804DCD29D86E1", hash_generated_method = "BA28E44BB32CE28A4E02FA17DE6E4457")
    protected  AbstractQueue() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.610 -0400", hash_original_method = "1A50CFE77F83A9D61A2F23666507E72F", hash_generated_method = "8A7D2A49128B01AD95ECF6EE5E932A99")
    public boolean add(E e) {
        addTaint(e.getTaint());
        if(offer(e))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1231764325 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474949399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474949399;
        }
        else
        {
        IllegalStateException varA33CF04882B88437ABCEE84817862B41_196899717 = new IllegalStateException("Queue full");
        varA33CF04882B88437ABCEE84817862B41_196899717.addTaint(taint);
        throw varA33CF04882B88437ABCEE84817862B41_196899717;
        }
        // ---------- Original Method ----------
        //if (offer(e))
            //return true;
        //else
            //throw new IllegalStateException("Queue full");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.611 -0400", hash_original_method = "9DCDFDCD4BD0DA1BA6AE29C07F6D5161", hash_generated_method = "BF88ADAC9864474B3E0540FC0FA30265")
    public E remove() {
        E x = poll();
        if(x != null)        
        {
E varEA5659DA512DECF23E6D37EE8060D074_1340916515 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1340916515.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1340916515;
        }
        else
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1080256793 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1080256793.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1080256793;
        }
        // ---------- Original Method ----------
        //E x = poll();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.611 -0400", hash_original_method = "25B2B6020E0E758714C2C5A3E37A85D5", hash_generated_method = "101748E0AB0A30FFF426DFD8E62A35D0")
    public E element() {
        E x = peek();
        if(x != null)        
        {
E varEA5659DA512DECF23E6D37EE8060D074_1771001728 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1771001728.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1771001728;
        }
        else
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_198373345 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_198373345.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_198373345;
        }
        // ---------- Original Method ----------
        //E x = peek();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.612 -0400", hash_original_method = "01DAFC6C5F0E6FF4922B6201FE3DA7B9", hash_generated_method = "80F296E9F7E3230003391D844A959F3A")
    public void clear() {
        while
(poll() != null)        
        ;
        // ---------- Original Method ----------
        //while (poll() != null)
            //;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.613 -0400", hash_original_method = "E3DD503D765939306C71AF759AB54F6B", hash_generated_method = "F5BE6833F9DBDED5ED11D965842FB80D")
    public boolean addAll(Collection<? extends E> c) {
        addTaint(c.getTaint());
        if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_217685602 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_217685602.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_217685602;
        }
        if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_485293970 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_485293970.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_485293970;
        }
        boolean modified = false;
for(E e : c)
        if(add(e))        
        modified = true;
        boolean var9AE73C65F418E6F79CEB4F0E4A4B98D5_1281318790 = (modified);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_871401788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_871401788;
        // ---------- Original Method ----------
        //if (c == null)
            //throw new NullPointerException();
        //if (c == this)
            //throw new IllegalArgumentException();
        //boolean modified = false;
        //for (E e : c)
            //if (add(e))
                //modified = true;
        //return modified;
    }

    
}

