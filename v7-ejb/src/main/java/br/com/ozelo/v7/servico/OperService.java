package br.com.ozelo.v7.servico;

import br.com.ozelo.v7.DAO.OperadorDao;
import br.com.ozelo.v7.entidades.Operador;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OperService extends BasicService{
    
    private static final long serialVersionUID = 2L;

    @PersistenceContext (unitName = "admCarPU")
    private EntityManager em;
    private OperadorDao operadorDao;
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        operadorDao = new OperadorDao(em);
    }

    public OperService() {
    
    }
    
    public Operador getOperadorById(Integer id) {
        return operadorDao.getOperadorById(id);
    }
    
    public Operador atualizaOperador(Operador operador) {
        return operadorDao.atualizaOperador(operador);
    }
    
    public void removeOperador(Operador operador) {
        operadorDao.removeOperador(operador);
    }
    
    public void setPassword(int ifOfOperador,String password) {
        operadorDao.setPassword(password, ifOfOperador);
    }
    
    public Operador novoOperador(Operador operador) {
        return operadorDao.novoOperador(operador);
    }
        
    public List<Operador> getApelidos(){
        return operadorDao.getListApelidos();
    }
    
    public List<Operador> getOperadoresAtivos() {
        return operadorDao.getListOperadoresAtivos();
    }
    
    public List<Operador> getOperadoresInativos() {
        return operadorDao.getListOperadoresInativos();
    }
    
    public Operador getOperadorByLoginPassword(String apelido,String password) {
        try {
            return operadorDao.getOperadorByLoginPassword(apelido, password);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Operador> getListOperadoresTodosbyApelido(String apelido){
        return operadorDao.getListOperadoresTodosbyApelido(apelido);
    }
    
    public Operador getOperadorByApelido (String apelido){
return operadorDao.getOperadorByApelido(apelido);
    }
}