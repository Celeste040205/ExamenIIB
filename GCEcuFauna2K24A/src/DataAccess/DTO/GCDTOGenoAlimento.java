package DataAccess.DTO;

public class GCDTOGenoAlimento {
    private Integer GCIdGenoAlimento;
    private String  GCtipoGeno;
    private String  GCEstado;
    private String  GCFechaCreacion;
    private String  GCFechaModifica;


    public Integer getGCIdGenoAlimento() {
        return GCIdGenoAlimento;
    }
    public void setGCIdGenoAlimento(Integer gcIdGenoAlimento) {
        GCIdGenoAlimento = gcIdGenoAlimento;
    }
    public String getGCtipoGeno() {
        return GCtipoGeno;
    }
    public void setGCtipoGeno(String gctipoGeno) {
        GCtipoGeno = gctipoGeno;
    }
    public String getGCEstado() {
        return GCEstado;
    }
    public void setGCEstado(String gcEstado) {
        GCEstado = gcEstado;
    }
    public String getGCFechaCreacion() {
        return GCFechaCreacion;
    }
    public void setGCFechaCreacion(String gcFechaCreacion) {
        GCFechaCreacion = gcFechaCreacion;
    }
    public String getGCFechaModifica() {
        return GCFechaModifica;
    }
    public void setGCFechaModifica(String gcFechaModifica) {
        GCFechaModifica = gcFechaModifica;
    }


    public GCDTOGenoAlimento(){}
    
    public GCDTOGenoAlimento(String gcTipoGeno){
        this.GCtipoGeno = gcTipoGeno;
    }
    
    public GCDTOGenoAlimento(int gcIdGenoAlimento, String gcTipoGeno, String gcEstado, String gcFechaCreacion,
    String gcFechaModifica ){
        this.GCIdGenoAlimento = gcIdGenoAlimento;
        this.GCtipoGeno       = gcTipoGeno;
        this.GCEstado         = gcEstado;
        this.GCFechaCreacion  = gcFechaCreacion;
        this.GCFechaModifica  = gcFechaModifica;
    }


    @Override
    public String toString() {
        return getClass().getName()
                + "\n IdGenoAlimento     " + getGCIdGenoAlimento()
                + "\n GenoAlimento       " + getGCtipoGeno()
                + "\n estado             " + getGCEstado()
                + "\n fechaCreacion      " + getGCFechaCreacion()
                + "\n fechaModifica      " + getGCFechaModifica();
    }


}
