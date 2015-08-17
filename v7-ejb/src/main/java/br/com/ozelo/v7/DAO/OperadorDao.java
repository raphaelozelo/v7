package br.com.ozelo.v7.DAO;
import br.com.ozelo.v7.entidades.Operador;
import javax.persistence.EntityManager;
import java.util.List;
import java.security.MessageDigest;
import java.util.ArrayList;

public class OperadorDao extends BasicDao {
    
    private static final long serialVersionUID = 1L;

    public OperadorDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Operador getOperadorById(Integer id) {
        return getEntity(Operador.class,id);
    }
    
    public Operador atualizaOperador(Operador operador) {
        return setEntity(Operador.class, operador);
    }
    
    public void removeOperador(Operador operador) {
        removeEntity(operador);
    }
    
    public Operador novoOperador(Operador operador) {
        operador.setSenha(getMd5(operador.getSenha()));
        addEntity(Operador.class, operador);
        return operador;
    }

    public Operador getOperadorByLoginPassword(String apelido, String password) {
         if (!"123456".equals(password)){
             password= getMd5(password);
       }
      return getPurePojo(Operador.class, "select o from Operador o where o.ativo = true and o.apelido = ?1 and o.senha = ?2", apelido, password);
      }

    public List<Operador> getListApelidos(){
        return getPureList(Operador.class, "select o from Operador o where o.ativo = true order by o.apelido");
    }
    
    public List<Operador> getListOperadoresAtivos() {
        return getPureList(Operador.class, "select o from Operador o where o.ativo = true order by o.nome");
    }
    
    public List<Operador> getListOperadoresInativos() {
        return getPureList(Operador.class, "select o from Operador o where o.ativo = false order by o.nome");
    }

    public Operador getOperadorByApelido(String apelido) {
        apelido = apelido.toUpperCase();
        List <Operador> listaOperadores = new ArrayList<>();
        System.out.println(listaOperadores.size());
        listaOperadores =  getPureList(Operador.class, "select o from Operador o where UPPER(o.apelido) = ?1",apelido);
        if (listaOperadores.isEmpty()) { return null;}
        return listaOperadores.get(0);
    }
    
    public List<Operador> getListOperadoresTodosbyApelido(String apelido) {
        apelido = apelido.toUpperCase();
        return getPureList(Operador.class, "select o from Operador o where UPPER(o.apelido) =?1 order by o.nome", apelido);
    }
    
    public void setPassword(String newPassword,int idOfOperador) {
        String np = getMd5(newPassword);
        Operador operador = getOperadorById(idOfOperador);
        operador.setSenha(np);
        atualizaOperador(operador);
    }
   public String getMd5(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return digest;
    }   

}