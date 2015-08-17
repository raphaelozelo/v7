package br.com.ozelo.v7.entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Log4Ozelo implements Serializable {
     private static final long serialVersionUID = 2L;   
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
@ManyToOne
@JoinColumn(name="OPERADOR_ID", referencedColumnName = "id")
private Operador operador;
//@Column
//private Veiculo veiculo;
//@Column
//private Cliente cliente;
@ManyToOne
@JoinColumn(name="OPERADORAFETADO_ID", referencedColumnName = "id")
private Operador operadorAfetado;
@Column 
@NotNull
@Temporal(javax.persistence.TemporalType.TIMESTAMP)
private Date horario;
@Column
@NotNull
private String descricao;
@Column
@NotNull
private Integer nivel;
// Nivel 1 = 30 dias, 2 = 90 dias, 3 = 180 dias para apagar do banco de dados

    public Log4Ozelo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Operador getOperadorAfetado() {
        return operadorAfetado;
    }

    public void setOperadorAfetado(Operador operadorAfetado) {
        this.operadorAfetado = operadorAfetado;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.horario);
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
        final Log4Ozelo other = (Log4Ozelo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + horario + "] " + descricao;
    }

}
