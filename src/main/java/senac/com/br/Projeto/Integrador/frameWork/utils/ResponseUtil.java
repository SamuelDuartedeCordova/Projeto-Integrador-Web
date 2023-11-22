package senac.com.br.Projeto.Integrador.frameWork.utils;
import java.util.Map;
import java.util.HashMap;

public class ResponseUtil {

    public static Map<String, Object> responseMapper(Object messages){
        Map<String, Object> out = new HashMap<>();
        out.put("messages", messages);

        return out;
    }
}
