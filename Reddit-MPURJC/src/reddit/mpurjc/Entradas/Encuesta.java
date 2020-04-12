package reddit.mpurjc.Entradas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Encuesta implements TipoEntrada {    
    
    protected String  enunciado;
    protected List<String> respuestas;
   
    public Encuesta(String s){
        
        List<String> respuestas=new ArrayList<String>();
        int separador=s.indexOf(",");
        enunciado=s.substring(1,separador);
        
        s = s.substring(separador,s.length());
        String opcion;
        while(separador != -1){   
            
            separador=s.indexOf(",");
            opcion = s.substring(1, separador);
            respuestas.add(opcion);
            s = s.substring(separador,s.length());
        }
    }
 
    

    @Override
    public boolean verificar() {

        String str = this.enunciado.toLowerCase();
        String[] words = str.split(" ");
        String censurado[]={"idiota","joder","cabron"};
        
        //recorro enunciado
        
        for (String word : words) {
            for (String censura : censurado) {
                if (word.equals(censura)) {
                    //words[i]=words[i].replaceAll("\\B\\w\\B","*");
                    return false;
                }
            }
        }
        
        //recorro soluciones
        
        Iterator<String> it = respuestas.iterator();
        while(it.hasNext()){
            str = it.next().toLowerCase();
            words = str.split(" ");
             
            for (String word : words) {
                for (String censura : censurado) {
                    if (word.equals(censura)) {
                        //words[i]=words[i].replaceAll("\\B\\w\\B","*");
                        return false;
                    }
                }
            }
        }
        
        it.remove();
        
        return true;
    }

    @Override
    public void mostrar() {
        int i=1;
        System.out.println("El enunciado de la ecuesta es: " + enunciado);
        Iterator<String> it = respuestas.iterator();
        
        while(it.hasNext()){
            System.out.println("la opcion " + i +  ":  "+ it.next());
            i++;
        }
        it.remove();
    }
}
