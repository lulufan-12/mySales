package mysales.database.dao;

import mysales.database.entities.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory EMF;
    protected EntityManager EM;
    protected Class<E> classe;
    static {
        try{
            EMF = Persistence.createEntityManagerFactory("mysales");
        }catch (Exception e){
            e.getStackTrace();
            System.out.println("Nao encontrou a persistence unit");
        }
    }
    public DAO(Class<E> classe){
        this.classe = classe;
        EM = EMF.createEntityManager();
    };

    public void inserir(E entidade){
        EM.getTransaction().begin();
        EM.persist(entidade);
        EM.getTransaction().commit();
    }
    public void remover(E entidade){
        EM.getTransaction().begin();
        EM.remove(EM.contains(entidade) ? entidade : EM.merge(entidade));
        EM.getTransaction().commit();
    }
    public void atualizar(E entidade){
        EM.getTransaction().begin();
        EM.merge(entidade);
        EM.getTransaction().commit();
    }
    public E obterPorIndice(int codigo){
        if(classe == null){
            throw new UnsupportedOperationException("Classe nula.");
        }
        String jpql = "SELECT c FROM " + classe.getName() + " AS c WHERE c.codigo LIKE :codigo";
        TypedQuery<E> query = EM.createQuery(jpql, classe);
        return query.setParameter("codigo", codigo).getSingleResult();
    }
    public List<E> obterTodos(){
        if(classe == null){
            throw new UnsupportedOperationException("Classe nula.");
        }
        String jpql = "SELECT u FROM " + classe.getName() + " AS u";
        TypedQuery<E> query = EM.createQuery(jpql, classe);
        return query.getResultList();
    }

    public List<E> obterTodos(int quantidade, int deslocamento){
        if(classe == null){
            throw new UnsupportedOperationException("Classe nula.");
        }
        String jpql = "SELECT u from " + classe.getName() + " AS u";
        TypedQuery<E> query = EM.createQuery(jpql, classe);
        query.setMaxResults(quantidade);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }
}
