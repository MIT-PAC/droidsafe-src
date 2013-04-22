package java.lang;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import droidsafe.annotations.*;
import droidsafe.helpers.*;
import libcore.util.EmptyArray;

public class Throwable implements java.io.Serializable {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	public String getMessage() {
        return dsTaint.getTaintString();
    }
	
	@DSModeled(DSC.SAFE)
	public Throwable() {
		//Class into native methods to fill in the stack state (see below)s
        //fillInStackTrace();
    }
	
	/*
	public Throwable fillInStackTrace() {
        // Fill in the intermediate representation
        stackState = nativeFillInStackTrace();
        // Mark the full representation as empty
        stackTrace = null;
        return this;
    }
    */
	
	@DSModeled(DSC.SAFE)
	public Throwable(String detailMessage) {
        this();
        dsTaint.addTaint(detailMessage);
        //this.detailMessage = detailMessage;
    }
	
	@DSModeled(DSC.SAFE)
	public Throwable(String detailMessage, Throwable throwable) {
        this();
        dsTaint.addTaints(detailMessage, throwable);
        //this.detailMessage = detailMessage;
        //cause = throwable;
    }
}
