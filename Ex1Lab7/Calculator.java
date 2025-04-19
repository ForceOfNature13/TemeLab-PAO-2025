package Ex1Lab7;
//a)
public interface Calculator {

    class NullParameterException extends IllegalArgumentException {
        public NullParameterException(String msg) { super(msg); }
    }
    class OverflowException extends ArithmeticException {
        public OverflowException(String msg) { super(msg); }
    }
    class UnderflowException extends ArithmeticException {
        public UnderflowException(String msg) { super(msg); }
    }

    double add(Double a, Double b)
            throws NullParameterException, OverflowException, UnderflowException;

    double divide(Double a, Double b)
            throws NullParameterException, MyArithmeticException;

    double average(Double[] values)
            throws NullParameterException, FileProcessingException,
            OverflowException, UnderflowException, MyArithmeticException;
}
