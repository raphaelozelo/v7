package br.com.ozelo.v7.conversores;
 
import br.com.ozelo.v7.MB.OperadorMB;
import br.com.ozelo.v7.entidades.Operador;
import br.com.ozelo.v7.servico.OperService;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;
 
@FacesConverter("OperApelidoConverter")
public class OperApelidoConverter implements Converter {
 
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        OperadorMB operadorMBLocal = new OperadorMB(); 
        OperService operadorService = new OperService();
        Operador operadorRetorno = new Operador(); 
        try {
            System.out.println("122222"+arg2);
            operadorRetorno = operadorService.getOperadorById(1);
            System.out.println("333332"+arg2);
             operadorRetorno = operadorService.getOperadorByApelido(arg2);
 //          operadorRetorno = operadorMBLocal.buscaOperadorApelido(arg2);
            System.out.println("11arg2"+operadorRetorno.toString());
            
        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "NÃ£o foi possÃ­vel converter o Objeto", "Error"));
        }
         return  operadorRetorno;
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {        
        if (arg2 == null) {
            return null;
        }
        Operador operador = (Operador) arg2;
        return operador.getApelido();
    }
}

    
    
  /*  
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        OperadorMB operadorMBLocal = new OperadorMB(); 
        int operadorId;
        System.out.println("1111");
        try {
            operadorId = Integer.parseInt(arg2);
        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "NÃ£o foi possÃ­vel converter o Objeto", "Error"));
        }
        System.out.println("111222222221");
         return  operadorMBLocal.buscaOperadorId(operadorId);
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        System.out.println("1111333333");
        
        if (arg2 == null) {
            return "";
        }
        Operador operador = (Operador) arg2;
        return String.valueOf(operador.getId());
    }
}
*/