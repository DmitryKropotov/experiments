package chat;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyPrintWriter extends PrintWriter {
    public AtomicBoolean connectionClosed;

    public MyPrintWriter(OutputStream out, AtomicBoolean connectionClosed) {
        super(out, true);
        this.connectionClosed = connectionClosed;
    }
}
