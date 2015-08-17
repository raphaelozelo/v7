package br.com.ozelo.v7.DAO;


import br.com.ozelo.v7.entidades.Lembrete;
import br.com.ozelo.v7.entidades.Operador;
import java.util.List;
import javax.persistence.EntityManager;

public class LembreteDao extends BasicDao {
    
    private static final long serialVersionUID = 2L;

    public LembreteDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Lembrete  getLembreteById(Integer id) {
        return getEntity(Lembrete.class,id);
    }
    
    public Lembrete atualizaLembrete(Lembrete lembrete) {
        return setEntity(Lembrete.class, lembrete);
    }
    
    public void removeLembrete(Lembrete lembrete) {
        removeEntity(lembrete);
    }
    
    public Lembrete novoLembrete(Lembrete lembrete) {
          addEntity(Lembrete.class, lembrete);
        return lembrete;
    }
    public List<Lembrete> getListLembrete() {
        return getPureList(Lembrete.class, "select l from Lembrete l order by l.nivel,l.dataEvento");
    }
    
    public List<Lembrete> getListLembreteByOperador(Integer operador_id) {
        return getPureList(Lembrete.class, "select l from Lembrete l where l.operador_id = ?1 order by l.nivel,l.dataEvento", operador_id);
    }
    
    
}
