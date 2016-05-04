package droidsafe.concrete;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSSink;
import droidsafe.annotations.DSSinkKind;
import droidsafe.annotations.DSSpec;

public class DroidSafeFileOutputStream extends FileOutputStream {

	public static int TAINT;
	
	public DroidSafeFileOutputStream(String path) throws FileNotFoundException {
		super(path);
	}

	public DroidSafeFileOutputStream(String path, int mode) throws FileNotFoundException {
		super(path, mode);
	}
	
	@Override
	@DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
	public void write(int v) {
		TAINT = v;
	}
	
}
