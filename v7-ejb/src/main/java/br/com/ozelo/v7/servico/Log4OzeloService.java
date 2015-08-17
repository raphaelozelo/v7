package br.com.ozelo.v7.servico;
import br.com.ozelo.v7.DAO.Log4OzeloDao;
import br.com.ozelo.v7.entidades.Log4Ozelo;
import java.util.Date;
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
public class Log4OzeloService extends BasicService{
    
    private static final long serialVersionUID = 2L;

    @PersistenceContext (unitName = "admCarPU")
    private EntityManager em;
    private Log4OzeloDao log4OzeloDao;
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        log4OzeloDao = new Log4OzeloDao(em);
    }

    public Log4OzeloService() {
    
    }
    
    public Log4Ozelo getLog4OzeloById(long id) {
        return log4OzeloDao.getLog4OzeloById(id);
    }
    
    public Log4Ozelo atualizaOperador(Log4Ozelo log4Ozelo) {
        return log4OzeloDao.atualizaLog4Ozelo(log4Ozelo);
    }
    
    public void removeLog4Ozelo(Log4Ozelo log4Ozelo) {
        log4OzeloDao.removeLog4Ozelo(log4Ozelo);
    }
    
    public Log4Ozelo novolog4Ozelo(Log4Ozelo log4Ozelo) {
        return log4OzeloDao.novoLog4Ozelo(log4Ozelo);
    }
   
    public void removerLogsAntigos (Integer dias){
        Date agora = new Date();
        Date diaExcluir = new Date( agora.getTime() - (1000 * 60 * 60 * (24 * dias)));
      log4OzeloDao.removeLogsAntigos (diaExcluir);
    }
   
}