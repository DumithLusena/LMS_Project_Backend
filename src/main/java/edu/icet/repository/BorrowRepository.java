package edu.icet.repository;

import edu.icet.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Integer> {

    @Query("SELECT b FROM Borrow b WHERE b.book.isbn = :isbn AND b.returnedAt IS NULL")
    List<Borrow> findActiveBookBorrows(@Param("isbn") String isbn);

    @Query("SELECT b FROM Borrow b WHERE b.user.userId = :userId AND b.returnedAt IS NULL")
    List<Borrow> findActiveUserBorrows(@Param("userId") Integer userId);

    @Query("SELECT b FROM Borrow b WHERE b.user.userId = :userId AND b.book.isbn = :isbn AND b.returnedAt IS NULL")
    Optional<Borrow> findActiveUserBookBorrow(@Param("userId") Integer userId, @Param("isbn") String isbn);

}
