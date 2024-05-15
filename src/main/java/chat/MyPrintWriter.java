package chat;

import java.io.OutputStream;
import java.io.PrintWriter;

public class MyPrintWriter extends PrintWriter {
    public boolean connectionClosed = false;

    public MyPrintWriter(OutputStream out, boolean connectionClosed) {
        super(out, true);
        this.connectionClosed = connectionClosed;
    }
}
