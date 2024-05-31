package chat;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyBufferedReader extends BufferedReader {
    public AtomicBoolean connectionClosed;

    public MyBufferedReader(Reader in, AtomicBoolean connectionClosed) {
        super(in);
        this.connectionClosed = connectionClosed;
    }
}
