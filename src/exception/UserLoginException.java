package exception;

/**
 * Created by captaincode on 12/29/16.
 */
public class UserLoginException extends Exception{
    public UserLoginException(){
        super();
    }

    public UserLoginException(String message){
        super(message);
    }
}
