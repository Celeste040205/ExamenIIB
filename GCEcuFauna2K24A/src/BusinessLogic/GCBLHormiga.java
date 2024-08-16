package BusinessLogic;

import java.util.List;

import DataAccess.DAO.GCDAOHormiga;
import DataAccess.DTO.GCDTOHormiga;

public class GCBLHormiga {
    private GCDTOHormiga gcSexo;
    private GCDAOHormiga gcSDAO = new GCDAOHormiga();

    public GCBLHormiga(){}

    public List<GCDTOHormiga> getAll() throws Exception{
        List<GCDTOHormiga> lst = gcSDAO.readAll();
        for (GCDTOHormiga gcSDTO : lst) 
            gcSDTO.setGCIdHormiga(gcSDTO.getGCIdHormiga());
        return lst;
    }
    public GCDTOHormiga getBy(int gcIdReg) throws Exception{
        gcSexo = gcSDAO.readBy(gcIdReg);
        return gcSexo;
    }
    public boolean add(GCDTOHormiga gcRegDTO) throws Exception{   
        return gcSDAO.create(gcRegDTO);
    }
    public boolean update(GCDTOHormiga gcRegDTO) throws Exception{
        return gcSDAO.update(gcRegDTO);
    }
    public boolean delete(int gcIdReg) throws Exception{
        return gcSDAO.delete(gcIdReg);
    }

}