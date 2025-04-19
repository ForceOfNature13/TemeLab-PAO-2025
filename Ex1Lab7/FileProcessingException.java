package Ex1Lab7;

import java.io.IOException;
//a)
public class FileProcessingException extends IOException {
    public FileProcessingException(String msg, Throwable cause) { super(msg, cause); }
}
