package charles.lab.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import charles.lab.entities.QUser;
import charles.lab.entities.User;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<User> findUserByUsernameAndEmail(String username, String email) {
    QUser qUser = QUser.user;
    JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
    JPAQuery<User> query = queryFactory.selectFrom(qUser);
    
    
//    JPQLQuery<User> query = new JPAQuery<User>(entityManager).from(qUser);
    if (username != null && !username.isEmpty()) {
      query.where(qUser.username.containsIgnoreCase(username));
    }

    if (email != null && !email.isEmpty()) {
      query.where(qUser.email.containsIgnoreCase(email));
    }
    
    return query.fetch();
  }

}
