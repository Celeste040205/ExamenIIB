package DataAccess.DTO;

public class GCDTOSexo {
    private Integer   gcRowNum         ;
    private Integer   gcIdCatalogo     ;           
    private Integer   gcIdCatalogoTipo ;           
    private String    gcNombre         ;           
    private String    gcDescripcion    ;          
    private String    gcEstado         ;           
    private String    gcFechaCreacion  ;            
    private String    gcFechaModifica  ;  

    public GCDTOSexo(){}


    public GCDTOSexo(Integer gcRowNum, Integer gcIdCatalogo, Integer gcIdCatalogoTipo, String gcNombre,
            String gcDescripcion, String gcEstado, String gcFechaCreacion, String gcFechaModifica) {
        this.gcRowNum           = gcRowNum;
        this.gcIdCatalogo       = gcIdCatalogo;
        this.gcIdCatalogoTipo   = gcIdCatalogoTipo;
        this.gcNombre           = gcNombre;
        this.gcDescripcion      = gcDescripcion;
        this.gcEstado           = gcEstado;
        this.gcFechaCreacion    = gcFechaCreacion;
        this.gcFechaModifica    = gcFechaModifica;
    }


    public Integer getGCRowNum() {
        return gcRowNum;
    }


    public void setGCRowNum(Integer gcRowNum) {
        this.gcRowNum = gcRowNum;
    }


    public Integer getGCIdCatalogo() {
        return gcIdCatalogo;
    }


    public void setGCIdCatalogo(Integer gcIdCatalogo) {
        this.gcIdCatalogo = gcIdCatalogo;
    }


    public Integer getGCIdCatalogoTipo() {
        return gcIdCatalogoTipo;
    }


    public void setGCIdCatalogoTipo(Integer gcIdCatalogoTipo) {
        this.gcIdCatalogoTipo = gcIdCatalogoTipo;
    }


    public String getGCNombre() {
        return gcNombre;
    }


    public void setGCNombre(String gcNombre) {
        this.gcNombre = gcNombre;
    }


    public String getGCDescripcion() {
        return gcDescripcion;
    }


    public void setGCDescripcion(String gcDescripcion) {
        this.gcDescripcion = gcDescripcion;
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
                + "\n RowNum    :         " + getGCRowNum()
                + "\n IdCatalogo:         " + getGCIdCatalogo()
                + "\n IdCatalogotipo:     " + getGCIdCatalogoTipo()
                + "\n Nommbre             " + getGCNombre()
                + "\n Descripcion         " + getGCDescripcion()
                + "\n estado              " + getGCEstado()
                + "\n fechaCreacion       " + getGCFechaCreacion()
                + "\n fechaModifica       " + getGCFechaModifica();

    }

}