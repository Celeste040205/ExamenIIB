package Framework;

public class GCException extends Exception {

    public GCException(String e, String clase, String metodo) {
        //grabar el log
        System.out.println("[ERROR APP --> LOG] " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "UPs..! se presento un error..";
    }    
}