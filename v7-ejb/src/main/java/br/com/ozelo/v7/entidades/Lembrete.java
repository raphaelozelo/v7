package br.com.ozelo.v7.entidades;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Lembrete implements Serializable {
    private static final long serialVersionUID = 1L;  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Lob @Column
    @NotNull
    private String descricao;
    @NotNull
    @ManyToOne
    @JoinColumn(name="OPERADOR_ID", referencedColumnName = "id")
    private Operador operador;
    @ManyToOne
    @JoinColumn(name="OPERADORINDICOU_ID", referencedColumnName = "id")
    private Operador operadorIndicou;
    @Column
    @NotNull
    private Integer nivel;
    @Column
    @Temporal (javax.persistence.TemporalType.DATE)
    private Date dataEvento;
    @Column (length = 7)
    private String corCss;

    public Lembrete() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Operador getOperadorIndicou() {
        return operadorIndicou;
    }

    public void setOperadorIndicou(Operador operadorIndicou) {
        this.operadorIndicou = operadorIndicou;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
 public String getDataEventoPTBR() {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
        return sdf.format(dataEvento);  
    }
 public String getDataEventoPTBRSmall() {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");  
        return sdf.format(dataEvento);  
    }
    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lembrete other = (Lembrete) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getCorCss() {
        return corCss;
    }

    public void setCorCss(String corCss) {
        this.corCss = corCss;
    }


}
