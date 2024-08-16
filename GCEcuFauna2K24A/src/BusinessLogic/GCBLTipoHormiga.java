package BusinessLogic;

import java.util.List;

import DataAccess.DAO.GCDAOTipoHormiga;
import DataAccess.DTO.GCDTOTipoHormiga;

public class GCBLTipoHormiga {
    private GCDTOTipoHormiga gcSexo;
    private GCDAOTipoHormiga gcSDAO = new GCDAOTipoHormiga();

    public GCBLTipoHormiga(){}

    public List<GCDTOTipoHormiga> getAll() throws Exception{
        List<GCDTOTipoHormiga> lst = gcSDAO.readAll();
        for (GCDTOTipoHormiga gcSDTO : lst) 
            gcSDTO.setGCNombre(gcSDTO.getGCNombre().toUpperCase());
        return lst;
    }
    public GCDTOTipoHormiga getBy(int gcIdReg) throws Exception{
        gcSexo = gcSDAO.readBy(gcIdReg);
        return gcSexo;
    }
    public boolean add(GCDTOTipoHormiga gcRegDTO) throws Exception{   
        return gcSDAO.create(gcRegDTO);
    }
    public boolean update(GCDTOTipoHormiga gcRegDTO) throws Exception{
        return gcSDAO.update(gcRegDTO);
    }
    public boolean delete(int gcIdReg) throws Exception{
        return gcSDAO.delete(gcIdReg);
    }
    public Integer getRowCount() throws Exception{
        return gcSDAO.getRowCount();
    }
}