package edu.mum.cs544.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import edu.mum.cs544.common.domain.base.DefaultPrimaryKeyEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book extends DefaultPrimaryKeyEntity {

	@JsonProperty("loan_duration")
	private int loanDuration;

	@ManyToMany
	private List<Author> authorList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="book")
	private List<BookCopy> bookCopies = new ArrayList<>();

	@Column(unique=true)
	private String isbn;

	private String title;


//    book_id:String,
//    title:String,
//    isbn:String,
//    des:String,
//    price: Number,
//    image:String,
//    number_of_copies: Number,
//    loan_duration: Number,
//    book_copies:[{
//        note: String,
//        created_date: Date,
//        copies:[{
//            copy_id: String
//         }]
//    }],
//    book_checkouts:[{
//        copy_id: String,
//        status:String,
//        borrower_id: String,
//        borrower_name: String,
//        due_date: Date,
//        borrow_date: Date,
//        return_date: Date
//    }],
//    history:[{copy_id: String,
//        borrower:{}}
//    ],
//    tag:[],
//    author: [],
//    created_date:Date,
//    modified_date: Date,

}
