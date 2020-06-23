package calculator;

class MalformedOperationException extends RuntimeException {
    public MalformedOperationException(String errorMsg) {
        super(errorMsg);
    }
}