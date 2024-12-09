package exception;

public class IllegalInputException extends OnCallException{
    public IllegalInputException() {
        super("유효하지 않은 입력 값입니다. 다시 입력해주세요.");
    }
}
