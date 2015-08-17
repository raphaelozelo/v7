package br.com.ozelo.v7.servico;

import br.com.ozelo.v7.DAO.LembreteDao;
import br.com.ozelo.v7.entidades.Lembrete;
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
public class LembreteService extends BasicService{
    
    private static final long serialVersionUID = 2L;

    @PersistenceContext (unitName = "admCarPU")
    private EntityManager em;
    private LembreteDao lembreteDao;
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        lembreteDao = new LembreteDao(em);
    }

    public LembreteService() {
      }
    
    public Lembrete getLembreteById(Integer id) {
        return lembreteDao.getLembreteById(id);
    }   
    public Lembrete atualizaLembrete(Lembrete lembrete) {
        return lembreteDao.atualizaLembrete(lembrete);
    }
    
    public void removeLembrete(Lembrete lembrete) {
        lembreteDao.removeLembrete(lembrete);
    }
    
    public Lembrete novoLembrete(Lembrete lembrete) {
        return lembreteDao.novoLembrete(lembrete);
    }
   
    public List<Lembrete> getListLembrete() {
        return lembreteDao.getListLembrete();
    }
    
    public List<Lembrete> getListLembreteByOperador(Integer operador_id) {
        return lembreteDao.getListLembreteByOperador(operador_id);
    }
    
}