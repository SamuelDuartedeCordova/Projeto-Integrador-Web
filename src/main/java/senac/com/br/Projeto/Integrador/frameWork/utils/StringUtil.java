package senac.com.br.Projeto.Integrador.frameWork.utils;

public class StringUtil {
    public static boolean validarString(String input){
        if(input == null || input == ""){
            return true;
        }

        return false;
    }
}
