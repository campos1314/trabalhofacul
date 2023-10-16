package Utils;
import javax.persistence.*;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("batatinhas");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
