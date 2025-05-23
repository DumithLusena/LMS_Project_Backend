package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;
}
