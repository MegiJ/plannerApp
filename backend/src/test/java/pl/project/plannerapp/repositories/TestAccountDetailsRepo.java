package pl.project.plannerapp.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import pl.project.plannerapp.domain.AccountDetailsEntity;
import pl.project.plannerapp.repo.AccountDetailsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TestAccountDetailsRepo implements AccountDetailsRepo {


    @Override
    public Optional<AccountDetailsEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<AccountDetailsEntity> findAllExpiredAccount() {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends AccountDetailsEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AccountDetailsEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<AccountDetailsEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AccountDetailsEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public AccountDetailsEntity getById(Long aLong) {
        return null;
    }

    @Override
    public AccountDetailsEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AccountDetailsEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AccountDetailsEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AccountDetailsEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AccountDetailsEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AccountDetailsEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AccountDetailsEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AccountDetailsEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AccountDetailsEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AccountDetailsEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<AccountDetailsEntity> findAll() {
        List<AccountDetailsEntity> accountDetailsEntityList = new ArrayList<>();
        accountDetailsEntityList.add(AccountDetailsEntity.builder()
                .id(1L)
                .role("unicorn")
                .isExpired(false)
                .isLocked(false)
                .isCredentialsExpired(false)
                .isDisabled(false)
                .build());
        return accountDetailsEntityList;
    }


    @Override
    public List<AccountDetailsEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(AccountDetailsEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AccountDetailsEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AccountDetailsEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AccountDetailsEntity> findAll(Pageable pageable) {
        return null;
    }
}
