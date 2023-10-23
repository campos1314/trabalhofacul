package Repository.GrupoDeEstudos;

import Domains.Admin.Admin;

import javax.persistence.EntityManager;
import java.util.List;

public class AdminRepository implements IAdminRepository{
    private final EntityManager em;
    public AdminRepository(EntityManager em){
        this.em = em;  
    }
    @Override
    public Admin findById(int id) {
        return this.em.find(Admin.class, id);
    }

    @Override
    public Admin findByCodigo(String codigo) {
        return null;
    }

    @Override
    public Admin findByPessoaNome(String nome) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public boolean insert(Admin admin) {
        return false;
    }

    @Override
    public boolean update(Admin admin) {
        return false;
    }
}
