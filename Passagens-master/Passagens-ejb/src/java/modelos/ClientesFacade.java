package modelos;

import entidades.Clientes;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "Livros-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }
    
    
    /*public boolean loginControl(String email, String senha){
        try{
        Clientes cliente = em.createNamedQuery("Clientes.login", Clientes.class).setParameter("email",email).setParameter("senha", senha).getSingleResult();
        if(cliente != null){
            return true;
        }
            return false;
        }catch(Exception e){
            return false;
        }
    }*/
    
    public Clientes verificaUsuario(String email, String senha){
       
        Clientes cliente = em.createNamedQuery("Clientes.login", Clientes.class).setParameter("email",email).setParameter("senha", senha).getSingleResult();
        
        return cliente;

    }
    
}
