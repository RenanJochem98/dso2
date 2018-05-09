package controladores;

import entidades.Clientes;
import entidades.Livros;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelos.LivrosFacade;


@Named(value = "livroControle")
@SessionScoped
public class LivroControle implements Serializable {

 
    @EJB
    private LivrosFacade livroFacade;
    private Livros livro = new Livros();
    
    private LoginControle loginControle = new LoginControle();
    
    public LivroControle() {
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }
    
    public List <Livros> getListaLivros(){
        return this.livroFacade.findAll();
    }
    
   
    
    public void trocar(Livros livro){
       try{
        livroFacade.efetuarTroca(livro, this.loginControle.getUserBO());
       getLivrosDisponiveis();
       }catch(Exception e){
           
       }
    }
        
    
    public List <Livros> getLivrosDisponiveis(){
        return livroFacade.listarLivrosDisponiveis();
    }
    
    public List <Livros> getTrocas(){
        Clientes cliente = this.loginControle.getUserBO();   
        return livroFacade.listarTrocas(cliente);
    }
    
    
   
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
        
}
