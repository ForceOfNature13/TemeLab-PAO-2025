package Ex1Lab7;
//a)
public class DoubleCalculator implements Calculator {

    @Override
    public double add(Double a, Double b)
            throws NullParameterException, OverflowException, UnderflowException {

        if (a == null || b == null)
            throw new NullParameterException("null param in add");
        double sum = a + b;
        if (sum == Double.POSITIVE_INFINITY)
            throw new OverflowException("overflow");
        if (sum == Double.NEGATIVE_INFINITY)
            throw new UnderflowException("underflow");
        return sum;
    }

    @Override
    public double divide(Double a, Double b)
            throws NullParameterException, MyArithmeticException {

        if (a == null || b == null)
            throw new NullParameterException("null param in divide");
        if (b == 0.0)
            throw new MyArithmeticException("divide by zero");
        return a / b;
    }

    @Override
    public double average(Double[] values)
            throws NullParameterException, FileProcessingException,
            OverflowException, UnderflowException, MyArithmeticException {

        if (values == null)
            throw new NullParameterException("values array null");
        if (values.length == 0)
            throw new FileProcessingException("empty array", null);

        double sum = 0.0;
        for (Double v : values) {
            if (v == null)
                throw new NullParameterException("null element in array");
            sum = add(sum, v);
        }
        return divide(sum, (double) values.length);
    }
}
