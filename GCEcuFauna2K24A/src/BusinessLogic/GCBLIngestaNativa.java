package BusinessLogic;

import java.util.List;

import DataAccess.DAO.GCDAOIngestaNativa;
import DataAccess.DTO.GCDTOIngestaNativa;

public class GCBLIngestaNativa {
    private GCDTOIngestaNativa gcSexo;
    private GCDAOIngestaNativa gcSDAO = new GCDAOIngestaNativa();

    public GCBLIngestaNativa(){}

    public List<GCDTOIngestaNativa> getAll() throws Exception{
        List<GCDTOIngestaNativa> lst = gcSDAO.readAll();
        for (GCDTOIngestaNativa gcSDTO : lst) 
            gcSDTO.setGCNombre(gcSDTO.getGCNombre().toUpperCase());
        return lst;
    }
    public GCDTOIngestaNativa getBy(int gcIdReg) throws Exception{
        gcSexo = gcSDAO.readBy(gcIdReg);
        return gcSexo;
    }
    public boolean add(GCDTOIngestaNativa gcRegDTO) throws Exception{   
        return gcSDAO.create(gcRegDTO);
    }
    public boolean update(GCDTOIngestaNativa gcRegDTO) throws Exception{
        return gcSDAO.update(gcRegDTO);
    }
    public boolean delete(int gcIdReg) throws Exception{
        return gcSDAO.delete(gcIdReg);
    }
    public Integer getRowCount() throws Exception{
        return gcSDAO.getRowCount();
    }
}