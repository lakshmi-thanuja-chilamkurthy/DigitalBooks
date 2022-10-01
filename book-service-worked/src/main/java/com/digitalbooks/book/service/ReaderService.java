package com.digitalbooks.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.book.entity.BuyBook;
import com.digitalbooks.book.repository.BuyRepository;
import com.digitalbooks.book.repository.ReaderRepository;

@Service

public class ReaderService {
	
	@Autowired
	private BuyRepository buyRepo;
	
	@Autowired
	private ReaderRepository readerRepo;
	
	public List<BuyBook> getAllPurchasedBooks(String emailId){
		return buyRepo.findByEmail(emailId);
	}
	 
	public String getByEmailandId(String emailId, int bookId) {
		
		 return buyRepo.filterByBookId(emailId,bookId);
	}

	public String getPurchasedBookByPid(String emailId, int generatedId)
    {
        return buyRepo.findByPid(emailId,generatedId);
    }

		
	

//	public BuyBook getPurchasedBookById(String emailId,int generatedId) {
//		
//		return buyRepo.purchasedBookById(generatedId);
//	}
	

	
//	public List<BuyBook> getAllPurchasedBooks1(String emailId)
//    {
//        List<BuyBook> purchasedBooks=buyRepo.findAll();
//        
//        System.out.println("All books" +purchasedBooks  + "size  "+ purchasedBooks.size());
//        if(emailId !=null)
//        {
//            System.out.println("inside if block");
//            purchasedBooks=purchasedBooks.stream()
//                        .filter(pb ->pb.getEmailId().equals(emailId)).collect(Collectors.toList());
//        }
//        return purchasedBooks;
//        
//    }
	

}

