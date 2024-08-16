package BusinessLogic;

import java.util.List;

import DataAccess.DAO.GCDAOGenoAlimento;
import DataAccess.DTO.GCDTOGenoAlimento;

public class GCBLGenoAlimento {
    private GCDTOGenoAlimento gcSexo;
    private GCDAOGenoAlimento gcSDAO = new GCDAOGenoAlimento();

    public GCBLGenoAlimento(){}

    public List<GCDTOGenoAlimento> getAll() throws Exception{
        List<GCDTOGenoAlimento> lst = gcSDAO.readAll();
        for (GCDTOGenoAlimento gcSDTO : lst) 
            gcSDTO.setGCNombre(gcSDTO.getGCNombre().toUpperCase());
        return lst;
    }
    public GCDTOGenoAlimento getBy(int gcIdReg) throws Exception{
        gcSexo = gcSDAO.readBy(gcIdReg);
        return gcSexo;
    }
    public boolean add(GCDTOGenoAlimento gcRegDTO) throws Exception{   
        return gcSDAO.create(gcRegDTO);
    }
    public boolean update(GCDTOGenoAlimento gcRegDTO) throws Exception{
        return gcSDAO.update(gcRegDTO);
    }
    public boolean delete(int gcIdReg) throws Exception{
        return gcSDAO.delete(gcIdReg);
    }
    public Integer getRowCount() throws Exception{
        return gcSDAO.getRowCount();
    }
}