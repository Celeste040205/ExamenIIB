package DataAccess.DTO;

public class GCDTOUbicacion {

    private Integer GCIdUbicacion;
    private String  GCPais;
    private String  GCRegion;
    private String  GCProvincia;
    private String  GCEstado;
    private String  GCFechaCrea;
    private String  GCFechaModifica;


    public GCDTOUbicacion(){}

    public GCDTOUbicacion(String gcPais){
        this.GCPais = gcPais;
    }

    public GCDTOUbicacion(int gcIdUbicacion, String gcPais, String gcRegion, String gcProvincia, String gcEstado, String gcFechaCrea, String gcFechaModifica ){
        this.GCIdUbicacion   = gcIdUbicacion;
        this.GCPais          = gcPais;
        this.GCRegion        = gcRegion;
        this.GCProvincia     = gcProvincia;
        this.GCEstado        = gcEstado;
        this.GCFechaCrea     = gcFechaCrea;
        this.GCFechaModifica = gcFechaModifica;

    }


    public Integer getGCIdUbicacion() {
        return GCIdUbicacion;
    }
    public void setGCIdUbicacion(Integer gcIdUbicacion) {
        GCIdUbicacion = gcIdUbicacion;
    }
    public String getGCPais() {
        return GCPais;
    }
    public void setGCPais(String gcPais) {
        GCPais = gcPais;
    }
    public String getGCRegion() {
        return GCRegion;
    }
    public void setGCRegion(String gcRegion) {
        GCRegion = gcRegion;
    }
    public String getGCProvincia() {
        return GCProvincia;
    }
    public void setGCProvincia(String gcProvincia) {
        GCProvincia = gcProvincia;
    }
    public String getGCEstado() {
        return GCEstado;
    }
    public void setGCEstado(String gcEstado) {
        GCEstado = gcEstado;
    }
    public String getGCFechaCrea() {
        return GCFechaCrea;
    }
    public void setGCFechaCrea(String gcFechaCrea) {
        GCFechaCrea = gcFechaCrea;
    }
    public String getGCFechaModifica() {
        return GCFechaModifica;
    }
    public void setGCFechaModifica(String gcFechaModifica) {
        GCFechaModifica = gcFechaModifica;
    }


    @Override
    public String toString(){
        return  getClass().getName()
                + "\n idUbicacion       "+ getGCIdUbicacion()
                + "\n Pais              "+ getGCPais()
                + "\n Region            "+ getGCRegion()
                + "\n Provincia         "+ getGCProvincia()
                + "\n estado            "+ getGCEstado()
                + "\n fechaCreacion     "+ getGCFechaCrea()
                + "\n fechaModifica     "+ getGCFechaModifica();
    }


}
