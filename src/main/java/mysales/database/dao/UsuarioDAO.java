package mysales.database.dao;

import mysales.database.entities.Usuario;

import javax.persistence.TypedQuery;

public class UsuarioDAO extends DAO<Usuario> {
    public UsuarioDAO() {
        super(Usuario.class);
    }
    public Usuario obterPorUsuarioSenha(String usuario, String senha){
        String jpql = "SELECT u FROM Usuario AS u WHERE u.login LIKE :usuario AND u.senha LIKE :senha";
        TypedQuery<Usuario> query = EM.createQuery(jpql, Usuario.class);
        query.setParameter("usuario", usuario);
        query.setParameter("senha", senha);
        return query.getSingleResult();
    }
}
