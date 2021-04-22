package test.java.voiture.commentaire.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AppNotFoundException extends Exception{

    public static final long serialVersionUID = 1L;

    public AppNotFoundException(String message){
        super(message);
    }
}
