package modelos;

import entidades.Clientes;
import entidades.Livros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class LivrosFacade extends AbstractFacade<Livros> {

    @PersistenceContext(unitName = "Livros-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivrosFacade() {
        super(Livros.class);
    }
    
    
    public void efetuarTroca(Livros livro, Clientes cliente) {
        livro.setFkidCliente(cliente);
        // Definir na passagem existe que ela está reservada
        livro.setDisponibilidadade(0);
        this.em.merge(livro);
    }
        
    
    public List <Livros> listarLivrosDisponiveis(){
        Query query = em.createNamedQuery("Livros.findByDisponibilidadadeTrue");
        return query.getResultList();
    }
    
    public List <Livros> listarTrocas(Clientes cliente){
        Query query = em.createNamedQuery("Livros.findPassagensByCliente");
        query.setParameter("idCliente", cliente.getIdCliente());
        return query.getResultList();
    }    
        
        
    
    
}
