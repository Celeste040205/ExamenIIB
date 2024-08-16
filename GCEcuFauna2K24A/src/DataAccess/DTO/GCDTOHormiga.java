package DataAccess.DTO;
public class GCDTOHormiga {
    
    private Integer gcIdHormiga;
    private Integer gcIdClgTipoHormiga;
    private Integer gcIdClgIngestaNativa;
    private Integer gcIdClgGenoAlimento;
    private Integer gcIdClgSexo;
    private Integer gcIdUbicacion;
    private String  gcEstado;
    private String  gcFechaCreacion;
    private String  gcFechaModifica;

    public GCDTOHormiga(){}


    public GCDTOHormiga(Integer gcIdHormiga, Integer gcIdClgTipoHormiga, Integer gcIdClgIngestaNativa,
            Integer gcIdClgGenoAlimento, Integer gcIdClgSexo, Integer gcIdUbicacion, String gcEstado,
            String gcFechaCreacion, String gcFechaModifica) {
        this.gcIdHormiga            = gcIdHormiga;
        this.gcIdClgTipoHormiga     = gcIdClgTipoHormiga;
        this.gcIdClgIngestaNativa   = gcIdClgIngestaNativa;
        this.gcIdClgGenoAlimento    = gcIdClgGenoAlimento;
        this.gcIdClgSexo            = gcIdClgSexo;
        this.gcIdUbicacion          = gcIdUbicacion;
        this.gcEstado               = gcEstado;
        this.gcFechaCreacion        = gcFechaCreacion;
        this.gcFechaModifica        = gcFechaModifica;
    }



    public Integer getGCIdHormiga() {
        return gcIdHormiga;
    }



    public void setGCIdHormiga(Integer gcIdHormiga) {
        this.gcIdHormiga = gcIdHormiga;
    }



    public Integer getGCIdClgTipoHormiga() {
        return gcIdClgTipoHormiga;
    }



    public void setGCIdClgTipoHormiga(Integer gcIdClgTipoHormiga) {
        this.gcIdClgTipoHormiga = gcIdClgTipoHormiga;
    }



    public Integer getGCIdClgIngestaNativa() {
        return gcIdClgIngestaNativa;
    }



    public void setGCIdClgIngestaNativa(Integer gcIdClgIngestaNativa) {
        this.gcIdClgIngestaNativa = gcIdClgIngestaNativa;
    }



    public Integer getGCIdClgGenoAlimento() {
        return gcIdClgGenoAlimento;
    }



    public void setGCIdClgGenoAlimento(Integer gcIdClgGenoAlimento) {
        this.gcIdClgGenoAlimento = gcIdClgGenoAlimento;
    }



    public Integer getGCIdClgSexo() {
        return gcIdClgSexo;
    }



    public void setGCIdClgSexo(Integer gcIdClgSexo) {
        this.gcIdClgSexo = gcIdClgSexo;
    }



    public Integer getGCIdUbicacion() {
        return gcIdUbicacion;
    }



    public void setGCIdUbicacion(Integer gcIdUbicacion) {
        this.gcIdUbicacion = gcIdUbicacion;
    }



    public String getGCEstado() {
        return gcEstado;
    }



    public void setGCEstado(String gcEstado) {
        this.gcEstado = gcEstado;
    }



    public String getGCFechaCreacion() {
        return gcFechaCreacion;
    }



    public void setGCFechaCreacion(String gcFechaCreacion) {
        this.gcFechaCreacion = gcFechaCreacion;
    }



    public String getGCFechaModifica() {
        return gcFechaModifica;
    }



    public void setGCFechaModifica(String gcFechaModifica) {
        this.gcFechaModifica = gcFechaModifica;
    }



    @Override
    public String toString() {
        return getClass().getName()
                + "\n IdHormiga           " + getGCIdHormiga()
                + "\n TipoHormiga         " + getGCIdClgTipoHormiga()
                + "\n IdIngestaNativa     " + getGCIdClgIngestaNativa()
                + "\n IdGenoAlimento      " + getGCIdClgGenoAlimento()
                + "\n IdSexo              " + getGCIdClgSexo()
                + "\n IdUbicacion         " + getGCIdUbicacion()
                + "\n Estado              " + getGCEstado()
                + "\n fechaCreacion       " + getGCFechaCreacion()
                + "\n fechaModifica       " + getGCFechaModifica();

    }

    

}