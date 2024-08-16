package BusinessLogic;


import java.util.List;

import DataAccess.DAO.GCDAOHormiga;
import DataAccess.DTO.GCDTOHormiga;

public class GCBLHormiga {
    private GCDTOHormiga mjSexo;
    private GCDAOHormiga mjSDAO = new GCDAOHormiga();

    public GCBLHormiga(){}

    public List<GCDTOHormiga> getAll() throws Exception{
        List<GCDTOHormiga> lst = mjSDAO.readAll();
        for (GCDTOHormiga mjSDTO : lst) 
            mjSDTO.setGCIdHormiga(mjSDTO.getGCIdHormiga());
        return lst;
    }
    public GCDTOHormiga getBy(int mjIdReg) throws Exception{
        mjSexo = mjSDAO.readBy(mjIdReg);
        return mjSexo;
    }
    public boolean add(GCDTOHormiga mjRegDTO) throws Exception{   
        return mjSDAO.create(mjRegDTO);
    }
    public boolean update(GCDTOHormiga mjRegDTO) throws Exception{
        return mjSDAO.update(mjRegDTO);
    }
    public boolean delete(int mjIdReg) throws Exception{
        return mjSDAO.delete(mjIdReg);
    }

}