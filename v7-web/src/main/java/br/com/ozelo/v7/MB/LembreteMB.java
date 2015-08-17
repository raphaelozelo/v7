package br.com.ozelo.v7.MB;

import br.com.ozelo.v7.entidades.Lembrete;
import br.com.ozelo.v7.servico.LembreteService;
import java.util.List;
import javax.ejb.EJB;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class LembreteMB extends BaseMB{
    
    private static final String LEMBRETE_SITE = "/v7/adm/lembrete.faces?faces-redirect=true";
    
    @EJB
    private LembreteService lembreteService;
    
    @Inject
    private OperadorMB operadorMB;
 
    private List<Lembrete> lembretes; 
    private Lembrete lembreteSelecionado;
    private Integer lembreteCashNivel;
    private String lembreteCashDesc;

    public LembreteMB() {
        
    }

    public void cleanCash(){
    lembreteSelecionado = null;
    lembretes = null;
    }
    
public void novoLembrete(){
    lembreteSelecionado = new Lembrete();
    lembreteSelecionado.setCorCss("#FDF701");
    lembreteSelecionado.setNivel(3);
    lembreteSelecionado.setDataEvento(new Date());
    lembreteSelecionado.setDescricao("");
    lembreteSelecionado.setOperador(operadorMB.getOperadorLogado());
    lembreteSelecionado.setOperadorIndicou(operadorMB.getOperadorLogado());
}

public void addLembrete(){
    lembreteService.novoLembrete(lembreteSelecionado);
    cleanCash(); 
}

public void changeNivel(){
    Integer i = lembreteSelecionado.getNivel();
    i = i-1;
    if (i==0) {i=3;}
    lembreteSelecionado.setNivel(i);  
}
public void cashLembrete(){
    lembreteCashNivel = lembreteSelecionado.getNivel();
    lembreteCashDesc = lembreteSelecionado.getDescricao();
}

public void deleteLembrete(){
    lembreteService.removeLembrete(lembreteSelecionado);
}
    public void okLembrete(){
       if ((lembreteCashNivel.equals(lembreteSelecionado.getNivel()))||(lembreteCashDesc.equals(lembreteSelecionado.getDescricao()))){
        lembreteService.atualizaLembrete(lembreteSelecionado);
    }        
    }
    
    public List<Lembrete> getLembretes() {
        if (lembretes == null){
            setLembretes(lembreteService.getListLembrete());
//           setLembretes(lembreteService.getListLembreteByOperador(operadorMB.getOperadorLogado().getId()));
        }
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public Lembrete getLembreteSelecionado() {
        return lembreteSelecionado;
    }

    public void setLembreteSelecionado(Lembrete lembreteSelecionado) {
        this.lembreteSelecionado = lembreteSelecionado;
    }

    public OperadorMB getOperadorMB() {
        return operadorMB;
    }

    public void setOperadorMB(OperadorMB operadorMB) {
        this.operadorMB = operadorMB;
    }
}
