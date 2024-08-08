package chat;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyBufferedReader extends BufferedReader {
    public AtomicBoolean chatOpened;
    public AtomicBoolean connectionClosed;

    public MyBufferedReader(Reader in, AtomicBoolean chatOpened, AtomicBoolean connectionClosed) {
        super(in);
        this.chatOpened = chatOpened;
        this.connectionClosed = connectionClosed;
    }
}
