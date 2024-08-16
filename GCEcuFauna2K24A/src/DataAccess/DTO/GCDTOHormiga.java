package DataAccess.DTO;

public class GCDTOHormiga {
    private Integer GCIdHormiga;
    private String  GCTipoHormiga;
    private Integer GCIdIngestaNativa;
    private Integer GCIdGenoAlimento;
    private Integer GCIdSexo;
    private Integer GCIdUbicacion;
    private String  GCEstado;
    private String  GCFechaCreacion;
    private String  GCFechaModifica;

    public Integer getGCIdHormiga() {
        return GCIdHormiga;
    }
    public void setGCIdHormiga(Integer gcIdHormiga) {
        GCIdHormiga = gcIdHormiga;
    }

    public String getGCTipoHormiga() {
        return GCTipoHormiga;
    }
    public void setGCTipoHormiga(String gcTipoHormiga) {
        GCTipoHormiga = gcTipoHormiga;
    }
    public Integer getGCIdIngestaNativa() {
        return GCIdIngestaNativa;
    }
    public void setGCIdIngestaNativa(Integer gcIdIngestaNativa) {
        GCIdIngestaNativa = gcIdIngestaNativa;
    }
    public Integer getGCIdGenoAlimento() {
        return GCIdGenoAlimento;
    }
    public void setGCIdGenoAlimento(Integer gcIdGenoAlimento) {
        GCIdGenoAlimento = gcIdGenoAlimento;
    }
    public Integer getGCIdSexo() {
        return GCIdSexo;
    }
    public void setGCIdSexo(Integer gcIdSexo) {
        GCIdSexo = gcIdSexo;
    }
    public Integer getGCIdUbicacion() {
        return GCIdUbicacion;
    }
    public void setGCIdUbicacion(Integer gcIdUbicacion) {
        GCIdUbicacion = gcIdUbicacion;
    }
    public String getgcEstado() {
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


    public GCDTOHormiga(){}
    
    public GCDTOHormiga(String gcTipoHormiga){
        this.GCTipoHormiga = gcTipoHormiga;
    }
    
    public GCDTOHormiga(int gcIdHormiga, String gcTipoHormiga, int gcIdIngestaNativa, int gcIdGenoAlimento, int gcIdSexo, int gcIdUbicacion, String gcEstado,   String gcFechaCreacion,
    String gcFechaModifica ){
        this.GCIdHormiga = gcIdHormiga;
        this.GCTipoHormiga = gcTipoHormiga;
        this.GCIdIngestaNativa = gcIdIngestaNativa;
        this.GCIdGenoAlimento = gcIdGenoAlimento;
        this.GCIdSexo = gcIdSexo;
        this.GCIdUbicacion = gcIdUbicacion;
        this.GCEstado = gcEstado;
        this.GCFechaCreacion = gcFechaCreacion;
        this.GCFechaModifica = gcFechaModifica;
    }



}