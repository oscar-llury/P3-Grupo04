package reddit.mpurjc;

import java.util.HashMap;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.SubForo;

public class Foro {
    
    private HashMap <String, SubForo> listaSubforos;
    private HashMap <String, Usuario> listaUsuarios;
    private SubForo subForoActual;
    private Entrada entradaActual;
    private Usuario usuarioActual;
    private Administrador usuarioAdministrador;
    
    public Foro(){
        this.listaSubforos = new HashMap();
        this.listaUsuarios = new HashMap();
    }
    
    public Foro(Entrada entrada, SubForo subForo, Usuario usuario){
        this.entradaActual = entrada;
        this.subForoActual = subForo;
        this.usuarioActual = usuario;
    }
   
    public boolean contieneUsuario(String nick){
        return listaUsuarios.containsKey(nick);
    }

    public boolean contieneSubForo (String nombre){
        return listaSubforos.containsKey(nombre);
    }
   
    public void insertarSubForo(SubForo subForo){
        this.listaSubforos.put(subForo.getNombre() , subForo);
    }
    
    public void insertarUsuario(Usuario usuario){
        this.listaUsuarios.put(usuario.getNick(),usuario);
    }

/*------------------------SETTERS------------------------*/
    public void setSubForoActual(SubForo subForoActual) {
        this.subForoActual = subForoActual;
    }

    public void setEntradaActual(Entrada entradaActual) {
        this.entradaActual = entradaActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    
    public void setAdministrador(Administrador admin){
        this.usuarioAdministrador = admin;
    }
    
    public void addEntradaPendiente(Entrada entrada){
        this.usuarioAdministrador.addPendientes(entrada);
    }
/*------------------------GETTERS------------------------*/
    public boolean sinSubForos(){
        return this.listaSubforos.isEmpty();
    }
    
    public boolean sinUsuarios(){
        boolean a = this.listaUsuarios.isEmpty();
        return a;
    }
    
    public SubForo getSubForoActual() {
        return subForoActual;
    }
    
    public SubForo getSubForo(String s){
        SubForo subforo= new SubForo(s);
       return subforo;
    }

    public Entrada getEntradaActual() {
        return entradaActual;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    public Administrador getAdministrador(){
        return this.usuarioAdministrador;
    }
}