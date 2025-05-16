package edu.icet.repository;

import edu.icet.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
    List<Borrow> findActiveBookBorrows(String isbn);
}
