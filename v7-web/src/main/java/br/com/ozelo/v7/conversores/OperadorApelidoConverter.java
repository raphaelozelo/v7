package br.com.ozelo.v7.conversores;
import br.com.ozelo.v7.entidades.Operador;
import br.com.ozelo.v7.servico.OperService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter (value = "OperadorApelidoConverter" )
public class OperadorApelidoConverter implements Converter {
   private static final long serialVersionUID = 1L;
   
    private OperService operadorService;

    public OperadorApelidoConverter() {
        operadorService = CDIServiceLocator.getBean(OperService.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) return null;
        return operadorService.getOperadorByApelido(value);
}

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
            if (arg2 == null) {
            return null;
        }
        String input = ((Operador)arg2).getApelido();
        return input.substring(0, 1).toUpperCase() + input.substring(1);
}
}