package br.com.ozelo.v7.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter ("IntegerConversor")
public class IntegerConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      return Integer.parseInt(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     return String.valueOf(value);
    }
    
}