package spittr.db;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spittr.domain.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * <p>Title: JpaSpitterRepository</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-30
 **/
@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {
    // @PersistenceUnit
    // private EntityManagerFactory emf; // 注入 EntityManagerFactory

    @PersistenceContext
    private EntityManager em;  // 区别上上一种注入方式，这种不用每次使用时来创建一个entityManager。并且绑定在当前事物中，是线程安全的
    @Override
    public Spitter findByUsername(String username) {
        return em.find(Spitter.class, username); // 创建并使用
    }

    @Override
    public List<Spitter> findByUsernameOrFullNameLike(String username, String fullName) {
        return null;
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }

    @Override
    public List<Spitter> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Spitter> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public <S extends Spitter> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Spitter findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Page<Spitter> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Spitter spitter) {

    }

    @Override
    public void delete(Iterable<? extends Spitter> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Spitter> S save(S s) {
        return em.merge(s);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Spitter> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Spitter> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Spitter getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Spitter> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Spitter> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Spitter> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Spitter> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Spitter> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Spitter> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public int eliteSweep() {
        return 0;
    }
}