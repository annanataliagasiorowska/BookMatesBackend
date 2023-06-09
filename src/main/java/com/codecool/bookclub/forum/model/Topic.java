package com.codecool.bookclub.forum.model;

import com.codecool.bookclub.book.model.Book;
import com.codecool.bookclub.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 1000)
    private String message;
    @CreationTimestamp
    private LocalDateTime creationTime;
    @ManyToOne
    private Book book;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private List<Comment> comments;
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
    @Column(columnDefinition = "smallint default 0")
    private Status status;

}
