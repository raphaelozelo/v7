package br.com.ozelo.v7.DAO;

import br.com.ozelo.v7.entidades.Log4Ozelo;
import br.com.ozelo.v7.entidades.Operador;
import java.util.Date;
import javax.persistence.EntityManager;
import java.util.List;

public class Log4OzeloDao extends BasicDao {
    
    private static final long serialVersionUID = 1L;

    public Log4OzeloDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Log4Ozelo getLog4OzeloById(Long id) {
        return getEntity(Log4Ozelo.class,id);
    }
    
    public Log4Ozelo atualizaLog4Ozelo(Log4Ozelo log4Ozelo) {
        return setEntity(Log4Ozelo.class, log4Ozelo);
    }
    
    public void removeLog4Ozelo(Log4Ozelo log4Ozelo) {
        removeEntity(log4Ozelo);
    }
    
    public Log4Ozelo  novoLog4Ozelo(Log4Ozelo log4Ozelo) {
        addEntity(Log4Ozelo.class, log4Ozelo);
        return log4Ozelo;
    }

    public List<Log4Ozelo> getListLog4Ozelo() {
        return getPureList(Log4Ozelo.class, "select l from Log4Ozelo l order by l.horario desc");
    }
    
    public List<Log4Ozelo> getListLog4OzeloByOperador(Operador operador) {
        return getPureList(Log4Ozelo.class, "select l from Log4Ozelo l where l.operador = ?1 order by l.horario", operador);
    }
    
//    public List<Log4Ozelo> getListLog4OzeloByVeiculo(Veiculo veiculo) {
//        return getPureList(Log4Ozelo.class, "select l from Log4Ozelo l where l.veiculo = ?1 order by l.horario", veiculo);
//    }
    
//     public List<Log4Ozelo> getListLog4OzeloByCliente(Cliente cliente) {
//        return getPureList(Log4Ozelo.class, "select l from Log4Ozelo l where l.cliente = ?1 order by l.horario", cliente);
//    }
     
    public List<Log4Ozelo> getListLog4OzeloByOperadorAfetado(Operador operador) {
        return getPureList(Log4Ozelo.class, "select l from Log4Ozelo l where l.operadorAfetado = ?1 order by l.horario", operador);
    }

    public int removeLogsAntigos(Date diaExcluir) {
      return executeCommand("delete from Log4Ozelo l where l.horario < ?1", diaExcluir);
    }
    
}