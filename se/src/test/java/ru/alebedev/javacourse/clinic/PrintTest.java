package ru.alebedev.javacourse.clinic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final static PrintStream out = System.out;
    private final static PrintStream err = System.err;

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public void cleanUpStreams() {
        System.setOut(out);
        System.setErr(err);
    }

    public ByteArrayOutputStream getOutContent() {
        return outContent;
    }

    public ByteArrayOutputStream getErrContent() {
        return errContent;
    }


}
