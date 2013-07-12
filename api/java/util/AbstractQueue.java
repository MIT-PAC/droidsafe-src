package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.262 -0400", hash_original_method = "898E1AC4CE228AED7FA804DCD29D86E1", hash_generated_method = "BA28E44BB32CE28A4E02FA17DE6E4457")
    protected  AbstractQueue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.263 -0400", hash_original_method = "1A50CFE77F83A9D61A2F23666507E72F", hash_generated_method = "AB7A870D43E654CE3ABE67FEFC8D0B94")
    public boolean add(E e) {
        addTaint(e.getTaint());
    if(offer(e))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1748839661 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348744991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_348744991;
        }
        else
        {
        IllegalStateException varA33CF04882B88437ABCEE84817862B41_684251516 = new IllegalStateException("Queue full");
        varA33CF04882B88437ABCEE84817862B41_684251516.addTaint(taint);
        throw varA33CF04882B88437ABCEE84817862B41_684251516;
        }
        // ---------- Original Method ----------
        //if (offer(e))
            //return true;
        //else
            //throw new IllegalStateException("Queue full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.263 -0400", hash_original_method = "9DCDFDCD4BD0DA1BA6AE29C07F6D5161", hash_generated_method = "8A6167182D7C08B2CA5D3DDA9791AAE5")
    public E remove() {
        E x = poll();
    if(x != null)        
        {
E varEA5659DA512DECF23E6D37EE8060D074_1680548635 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1680548635.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1680548635;
        }
        else
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1361394719 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1361394719.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1361394719;
        }
        // ---------- Original Method ----------
        //E x = poll();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.264 -0400", hash_original_method = "25B2B6020E0E758714C2C5A3E37A85D5", hash_generated_method = "64A9B877D6A67F269E78D4EE5A8B02ED")
    public E element() {
        E x = peek();
    if(x != null)        
        {
E varEA5659DA512DECF23E6D37EE8060D074_1529907421 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1529907421.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1529907421;
        }
        else
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1974619464 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1974619464.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1974619464;
        }
        // ---------- Original Method ----------
        //E x = peek();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.264 -0400", hash_original_method = "01DAFC6C5F0E6FF4922B6201FE3DA7B9", hash_generated_method = "80F296E9F7E3230003391D844A959F3A")
    public void clear() {
        while
(poll() != null)        
        ;
        // ---------- Original Method ----------
        //while (poll() != null)
            //;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.265 -0400", hash_original_method = "E3DD503D765939306C71AF759AB54F6B", hash_generated_method = "E266A636826088568552BDA3D1544D0E")
    public boolean addAll(Collection<? extends E> c) {
        addTaint(c.getTaint());
    if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_467158377 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_467158377.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_467158377;
        }
    if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_993839155 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_993839155.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_993839155;
        }
        boolean modified = false;
for(E e : c)
    if(add(e))        
        modified = true;
        boolean var9AE73C65F418E6F79CEB4F0E4A4B98D5_548001205 = (modified);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750517312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_750517312;
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

