package BusinessLogic;

import java.util.List;

import DataAccess.DAO.GCDAOUbicacion;
import DataAccess.DTO.GCDTOUbicacion;

public class GCBLUbicacion {
    private GCDTOUbicacion gcSexo;
    private GCDAOUbicacion gcSDAO = new GCDAOUbicacion();

    public GCBLUbicacion(){}

    public List<GCDTOUbicacion> getAll() throws Exception{
        List<GCDTOUbicacion> lst = gcSDAO.readAll();
        for (GCDTOUbicacion gcSDTO : lst) 
            gcSDTO.setGCProvincia(gcSDTO.getGCProvincia().toUpperCase());
        return lst;
    }
    public GCDTOUbicacion getBy(int gcIdReg) throws Exception{
        gcSexo = gcSDAO.readBy(gcIdReg);
        return gcSexo;
    }
    public boolean add(GCDTOUbicacion gcRegDTO) throws Exception{   
        return gcSDAO.create(gcRegDTO);
    }
    public boolean update(GCDTOUbicacion gcRegDTO) throws Exception{
        return gcSDAO.update(gcRegDTO);
    }
    public boolean delete(int gcIdReg) throws Exception{
        return gcSDAO.delete(gcIdReg);
    }

}