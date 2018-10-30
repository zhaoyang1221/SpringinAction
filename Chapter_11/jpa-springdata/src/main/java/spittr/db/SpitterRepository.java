package spittr.db;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.domain.Spitter;

import java.util.List;

/**
 * <p>Title: SpitterRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-30
 **/
public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {

    Spitter findByUsername(String username);

    List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);
}