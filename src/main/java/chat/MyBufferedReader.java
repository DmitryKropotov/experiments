package chat;

import java.io.BufferedReader;
import java.io.Reader;

public class MyBufferedReader extends BufferedReader {
    public boolean connectionClosed = false;

    public MyBufferedReader(Reader in) {
        super(in);
    }
}
