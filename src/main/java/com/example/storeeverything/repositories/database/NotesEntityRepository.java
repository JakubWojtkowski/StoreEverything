package com.example.storeeverything.repositories.database;

import com.example.storeeverything.data.database.CategoriesEntity;
import com.example.storeeverything.data.database.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotesEntityRepository extends JpaRepository<NotesEntity, Integer> {
    @Transactional
    @Modifying

    List<NotesEntity> findByUser_LoginAndCategoryName_CategoryName(String login, String name);
    List<NotesEntity> findByUser_LoginOrderByTitleAsc(String login);
    List<NotesEntity> findByUser_LoginOrderByTitleDesc(String login);
    List<NotesEntity> findByUser_LoginOrderByCategoryName_CategoryNameAsc(String login);
    List<NotesEntity> findByUser_LoginOrderByCategoryName_CategoryNameDesc(String login);
    List<NotesEntity> findByUser_LoginOrderByAddDateAsc(String login);
    List<NotesEntity> findByUser_LoginOrderByAddDateDesc(String login);
    List<NotesEntity> findByUser_LoginOrderByReminderDateAsc(String login);
    List<NotesEntity> findByUser_LoginOrderByReminderDateDesc(String login);
    List<NotesEntity> findByUser_Login(String login);
    List<NotesEntity> findByUser_LoginAndReminderDate(String login,Date date);

    /*@Query("""
        select n from NotesEntity n
        where n.categoryName.categoryName = ?1
        order by n.title asc""")
    List<NotesEntity> findByCategoryName_CategoryName(String categoryName);*/
    @Query("""
            select n from NotesEntity n
            join n.categoryName c
            group by c.categoryName
            order by count(n) asc""")
    List<NotesEntity> sortByPopularCategoriesAsc();

    @Query("""
            select n from NotesEntity n
            join n.categoryName c
            group by c.categoryName
            order by count(n) desc""")
    List<NotesEntity> sortByPopularCategoriesDesc();

    @Override
    Optional<NotesEntity> findById(Integer integer);


}