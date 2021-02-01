package mysales.database;

import javafx.beans.value.ObservableValue;
import mysales.database.entities.Usuario;
import java.util.Date;

public class Sessao {
    private static Usuario usuario;
    private static Date inicio;
    public static ObservableValue<String> nome;
    private Sessao(){

    }
    public static void iniciarSessao(Usuario usuario){
        Sessao.usuario = usuario;
        inicio = new Date();
    }
    private static boolean estaIniciada(){
        return (usuario != null);
    }
    public static boolean ehSuperUsuario(){
        if(!estaIniciada())
            throw new NullPointerException("Sessão não foi iniciada.");
        return usuario.isSuper_usuario();
    }
    public static Usuario getUsuario(){
        if(!estaIniciada())
            throw new NullPointerException("Sessão não foi iniciada.");
        return usuario;
    }
    public static void finalizarSessao(){
        Sessao.usuario = null;
        Sessao.inicio = null;
    }
}
