package exception;

public class IllegalRosterSizeException extends OnCallException{
    public IllegalRosterSizeException() {
        super("잘못된 로스터 사이즈입니다.");
    }
}
