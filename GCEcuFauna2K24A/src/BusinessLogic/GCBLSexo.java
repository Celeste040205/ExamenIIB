package BusinessLogic;

import java.util.List;

import DataAccess.DAO.GCDAOSexo;
import DataAccess.DTO.GCDTOSexo;

public class GCBLSexo {
    private GCDTOSexo gcSexo;
    private GCDAOSexo gcSDAO = new GCDAOSexo();

    public GCBLSexo(){}

    public List<GCDTOSexo> getAll() throws Exception{
        List<GCDTOSexo> lst = gcSDAO.readAll();
        for (GCDTOSexo sexoDTO : lst) 
            sexoDTO.setGCNombre(sexoDTO.getGCNombre().toUpperCase());
        return lst;
    }
    public GCDTOSexo getBy(int idSexo) throws Exception{
        gcSexo = gcSDAO.readBy(idSexo);
        return gcSexo;
    }
    public boolean add(GCDTOSexo sexoDTO) throws Exception{   
        return gcSDAO.create(sexoDTO);
    }
    public boolean update(GCDTOSexo sexoDTO) throws Exception{
        return gcSDAO.update(sexoDTO);
    }
    public boolean delete(int idSexo) throws Exception{
        return gcSDAO.delete(idSexo);
    }
    public Integer getRowCount() throws Exception{
        return gcSDAO.getRowCount();
    }
}