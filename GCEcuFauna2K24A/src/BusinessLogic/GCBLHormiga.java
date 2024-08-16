package BusinessLogic;

import java.util.List;

import DataAccess.DAO.GCDAOHormiga;
import DataAccess.DTO.GCDTOHormiga;

public class GCBLHormiga {
    private GCDTOHormiga gcHormihas;
    private GCDAOHormiga gcSDAO = new GCDAOHormiga();

    public GCBLHormiga(){}

    public List<GCDTOHormiga> getAll() throws Exception{
        List<GCDTOHormiga> lst = gcSDAO.readAll();
        return lst;
    }
    public GCDTOHormiga getBy(int gcIdHormiga) throws Exception{
        gcHormihas = gcSDAO.readBy(gcIdHormiga);
        return gcHormihas;
    }
    public boolean add(GCDTOHormiga GCDTOHormiga) throws Exception{   
        return gcSDAO.create(GCDTOHormiga);
    }
    public boolean update(GCDTOHormiga GCDTOHormiga) throws Exception{
        return gcSDAO.update(GCDTOHormiga);
    }
    public boolean delete(int gcIdHormiga) throws Exception{
        return gcSDAO.delete(gcIdHormiga);
    }
    public Integer getRowCount() throws Exception{
        return gcSDAO.getRowCount();
    }
}