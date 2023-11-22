package senac.com.br.Projeto.Integrador.frameWork.utils;

import java.util.ArrayList;
import java.util.List;

public class ProFutException extends Exception{

    private List<String> messages = new ArrayList<>();

    public ProFutException(String message){
        super(message);
    }
    public ProFutException(List<String> msg){
        this.messages = msg;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
