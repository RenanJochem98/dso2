package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "LIVROS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livros.findAll", query = "SELECT l FROM Livros l")
    , @NamedQuery(name = "Livros.findByIdLivro", query = "SELECT l FROM Livros l WHERE l.idLivro = :idLivro")
    , @NamedQuery(name = "Livros.findByDisponibilidadade", query = "SELECT l FROM Livros l WHERE l.disponibilidadade = :disponibilidadade")
    , @NamedQuery(name = "Livros.findByDisponibilidadadeTrue", query = "SELECT l FROM Livros l WHERE l.disponibilidadade = 1")
    , @NamedQuery(name = "Livros.findPassagensByCliente", query = "SELECT livro FROM Livros livro JOIN livro.fkidCliente clientes WHERE clientes.idCliente = :idCliente")})
    
public class Livros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LIVRO")
    private Integer idLivro;
    
    @Size(max = 40)
    @Column(name = "TITULO")
    private String titulo;
    
    @Column(name = "DISPONIBILIDADADE")
    private Integer disponibilidadade;
    
    @JoinColumn(name = "FKID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Clientes fkidCliente;


   
    public Clientes getFkidCliente() {
        return fkidCliente;
    }

    public void setFkidCliente(Clientes fkidCliente) {
        this.fkidCliente = fkidCliente;
    }    
    
    public Livros() {
    }

    public Livros(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public Integer getDisponibilidadade() {
        return disponibilidadade;
    }

    public void setDisponibilidadade(Integer disponibilidadade) {
        this.disponibilidadade = disponibilidadade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivro != null ? idLivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livros)) {
            return false;
        }
        Livros other = (Livros) object;
        if ((this.idLivro == null && other.idLivro != null) || (this.idLivro != null && !this.idLivro.equals(other.idLivro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Livros[ idLivro=" + idLivro + " ]";
    }
    
}
