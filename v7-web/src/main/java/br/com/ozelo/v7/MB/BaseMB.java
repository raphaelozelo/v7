package br.com.ozelo.v7.MB;

import br.com.ozelo.v7.entidades.Log4Ozelo;
import br.com.ozelo.v7.entidades.Operador;
import br.com.ozelo.v7.servico.Log4OzeloService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class BaseMB implements java.io.Serializable {
    
    public static final String INDEX_PAGE = "/adm/index.faces?faces-redirect=true";
    
    private static final long serialVersionUID = 1L;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    @EJB
    private Log4OzeloService log4OzeloService;
    
    protected void createFacesErrorMessage(String titulo, String msg) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, msg);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    protected Set<ConstraintViolation<Serializable>> getViolations(Serializable entidade) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Serializable>> toReturn = validator.validate(entidade);
        return toReturn;
    }
    
    protected boolean existsViolationsForJSF(Serializable entidade) {
        Set<ConstraintViolation<Serializable>> toReturn = getViolations(entidade);
        if (toReturn.isEmpty()) return false;
        for (ConstraintViolation<Serializable> constraintViolation : toReturn) {
            createFacesErrorMessage(constraintViolation.getMessage(),null);
        }
        return true;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }
    
    public SimpleDateFormat getSdtF(){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm");
    } 

//    public void fabricarLog (Integer nivel, String descricao, Veiculo veiculo, Cliente cliente, Operador operadorAfetado){
    public void fabricarLog (Operador operadorLogado, Integer nivel, String descricao, Operador operadorAfetado){
        if ((nivel == null)&&(descricao == null)) return;
            Log4Ozelo log = new Log4Ozelo ();
            log.setOperador(operadorLogado);
            log.setNivel(nivel);
            log.setDescricao(descricao);
            log.setHorario(new Date());
            log.setOperadorAfetado(operadorAfetado);
        log4OzeloService.novolog4Ozelo(log);
    }
}