package br.com.ozelo.v7.entidades;

import java.security.MessageDigest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import java.text.SimpleDateFormat;


@Entity
//@br.com.ozelo.v4.validadores.OperadorApelidoUnico
public class Operador implements java.io.Serializable  {
 private static final long serialVersionUID = 2L;   
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
@NotNull
@Length(min=3, max = 255,message = "O Nome deve ter no mínimo 3 caracteres!")
private String nome;
@Column (nullable=false, unique=true)
@Length(min=3, max = 20,message = "O Apelido deve ter entre 3 a 20 caracteres!")
private String apelido;
@Column (length= 1)
@NotNull (message="Sexo do Operador Deve Ser Informado!")
private String sexo;
@Column (length = 15)
@NotNull (message="Função do Operador Deve Ser Informado!")
private String funcao;
@Column
private String email;
@Column 
@NotNull (message="Senha Deve Ser Informada!")
private String senha;
@Column
@NotNull (message="Nível de Atividade Deve Ser Informado!")
private boolean ativo;
@Column
@Temporal(javax.persistence.TemporalType.DATE)
@NotNull (message = "Data de Admissão Deve Ser Informada!")
private Date dtAdmissao;
@Column
@Past (message="Data de Nascimento Inválida!")
@Temporal(javax.persistence.TemporalType.DATE)
private Date dtNasc;
@Column 
@NotNull (message="Nível de Acesso Deve Ser Informado!")
private Integer nivel;
@Column
private Integer nrAcessos;
@Column
@Temporal(javax.persistence.TemporalType.TIMESTAMP)
private Date dtUltAcesso;
@Column
@Temporal(javax.persistence.TemporalType.TIMESTAMP)
private Date dtAcessoAtual;
@Column
@Temporal(javax.persistence.TemporalType.DATE)
private Date dtDesativacao;
@Column (nullable=false)
private boolean demitido;
@Column 
@NotNull
private boolean viewPendenciaVeic;
@Column
@NotNull
private boolean viewContasPagar;
@Column
@NotNull
private boolean viewContasReceber;





    public Operador() {
    }
    
@PostConstruct
public void iniciar (){
  this.setSexo("M");
  this.setAtivo(true);
  this.setDemitido(false);
  this.setViewContasPagar(false);
  this.setViewContasReceber(false);
  this.setViewPendenciaVeic(false);
  this.setDtAdmissao(new Date());
  this.setNivel(1);
  this.setSenha(getMd5("123456"));
  this.setNrAcessos(0);
}

public void gerarNovaSenha(){
   this.setSenha(getMd5("123456")); 
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
    
    public String getDtUltAcessoPTBR() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");  
        return sdf.format(dtUltAcesso);
    }
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getNrAcessos() {
        return nrAcessos;
    }

    public void setNrAcessos(Integer nrAcessos) {
        this.nrAcessos = nrAcessos;
    }

    public Date getDtUltAcesso() {
        return dtUltAcesso;
    }

    public void setDtUltAcesso(Date dtUltAcesso) {
        this.dtUltAcesso = dtUltAcesso;
    }

    public Date getDtAcessoAtual() {
        return dtAcessoAtual;
    }

    public void setDtAcessoAtual(Date dtAcessoAtual) {
        this.dtAcessoAtual = dtAcessoAtual;
    }

    public Date getDtDesativacao() {
        return dtDesativacao;
    }

    public void setDtDesativacao(Date dtDesativacao) {
        this.dtDesativacao = dtDesativacao;
    }

    public boolean isDemitido() {
        return demitido;
    }

    public void setDemitido(boolean demitido) {
        this.demitido = demitido;
    }

    public boolean isViewPendenciaVeic() {
        return viewPendenciaVeic;
    }

    public void setViewPendenciaVeic(boolean viewPendenciaVeic) {
        this.viewPendenciaVeic = viewPendenciaVeic;
    }

    public boolean isViewContasPagar() {
        return viewContasPagar;
    }

    public void setViewContasPagar(boolean viewContasPagar) {
        this.viewContasPagar = viewContasPagar;
    }

    public boolean isViewContasReceber() {
        return viewContasReceber;
    }

    public void setViewContasReceber(boolean viewContasReceber) {
        this.viewContasReceber = viewContasReceber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
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
        final Operador other = (Operador) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return apelido;
    }



}