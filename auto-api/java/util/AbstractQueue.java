package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import droidsafe.runtime.DroidSafeAndroidRuntime;


public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.300 -0400", hash_original_method = "898E1AC4CE228AED7FA804DCD29D86E1", hash_generated_method = "99BCC6EA786EAAD452865E3190DBE44F")
	@DSModeled(DSC.SAFE)
	protected AbstractQueue() {
		// ---------- Original Method ----------
	}


	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.300 -0400", hash_original_method = "1A50CFE77F83A9D61A2F23666507E72F", hash_generated_method = "8129BC8CBDEFBE39DAC75162B5065CAA")
	//DSFIXME:  CODE0002: Requires DSC value to be set
	public boolean add(E e) {
		dsTaint.addTaint(e.dsTaint);
		{
			boolean varE46C21D833DB059BB8F6E49CAFEACF2D_1369445949 = (offer(e));
			if (DroidSafeAndroidRuntime.control) {
				throw new IllegalStateException("Queue full");
			}
		} //End collapsed parenthetic
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		//if (offer(e))
		//return true;
		//else
		//throw new IllegalStateException("Queue full");
	}


	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.300 -0400", hash_original_method = "9DCDFDCD4BD0DA1BA6AE29C07F6D5161", hash_generated_method = "C01AAA398664DDE54224D3F923688957")
	@DSModeled(DSC.SAFE)
	public E remove() {
		E x;
		x = poll();
		if (DroidSafeAndroidRuntime.control) {
			throw new NoSuchElementException();
		}
		return (E)dsTaint.getTaint();
		// ---------- Original Method ----------
		//E x = poll();
		//if (x != null)
		//return x;
		//else
		//throw new NoSuchElementException();
	}


	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.300 -0400", hash_original_method = "25B2B6020E0E758714C2C5A3E37A85D5", hash_generated_method = "936819CA7010FE817CC8F531195A7D45")
	@DSModeled(DSC.SAFE)
	public E element() {
		E x;
		x = peek();
		if (DroidSafeAndroidRuntime.control) {
			throw new NoSuchElementException();
		}
		return (E)dsTaint.getTaint();
		// ---------- Original Method ----------
		//E x = peek();
		//if (x != null)
		//return x;
		//else
		//throw new NoSuchElementException();
	}


	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.300 -0400", hash_original_method = "01DAFC6C5F0E6FF4922B6201FE3DA7B9", hash_generated_method = "B385A5BBF5F908A2E42263DA5AB63505")
	//DSFIXME:  CODE0002: Requires DSC value to be set
	public void clear() {
		{
			boolean var007FB331E0C46D4AB9B8C49B89596626_1053215631 = (poll() != null);
			;
		} //End collapsed parenthetic
		// ---------- Original Method ----------
		//while (poll() != null)
		//;
	}


	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.300 -0400", hash_original_method = "E3DD503D765939306C71AF759AB54F6B", hash_generated_method = "06173F06BE415353A52BE90B9215D307")
	//DSFIXME:  CODE0002: Requires DSC value to be set
	public boolean addAll(Collection<? extends E> c) {
		dsTaint.addTaint(c.dsTaint);
		if (DroidSafeAndroidRuntime.control) {
			throw new NullPointerException();
		}
		if (DroidSafeAndroidRuntime.control) {
			throw new IllegalArgumentException();
		}
		boolean modified;
		modified = false;
		{
			Iterator<? extends E> seatecAstronomy42 = c.iterator();
			seatecAstronomy42.hasNext();
			E e = seatecAstronomy42.next();
			{
				boolean var1194B013A262CF6972087B946B7624B7_2072272777 = (add(e));
				modified = true;
			} //End collapsed parenthetic
		} //End collapsed parenthetic
		return dsTaint.getTaintBoolean();
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


