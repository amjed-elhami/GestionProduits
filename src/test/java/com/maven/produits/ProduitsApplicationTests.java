package com.maven.produits;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.maven.produits.entities.Produit;
import com.maven.produits.repos.ProduitRepository;
import com.maven.produits.service.ProduitService;

import java.util.List;


@SpringBootTest
class ProduitsApplicationTests {

		@Autowired
		private ProduitRepository produitRepository;
		
		@Autowired
		private ProduitService produitService;
		
		@Test
		public void testCreateProduit() {
		Produit prod = new Produit("PC HP",3200.000,new Date());
		produitRepository.save(prod);
		}

		 @Test
		 public void testFindProduit()
		 {
		 Produit p = produitRepository.findById(2L).get();
		 System.out.println(p);
		 }
		 
		// @Test
		 public void testUpdateProduit()
		 {
		 Produit p = produitRepository.findById(1L).get();
		 p.setPrixProduit(1000.0);
		 produitRepository.save(p);
		 }
		 
		 // @Test
		 public void testDeleteProduit()
		 {
			 produitRepository.deleteById(1L);
		 }

       
		 // @Test
		 public void testListerTousProduits()
		 {
		 List<Produit> prods = produitRepository.findAll();
		 for (Produit p : prods)
		 {
		 System.out.println(p);
		 }
		 }

		 @Test
		 public void testFindByNomProduitContains()
		 {
		    Page<Produit> prods = produitService.getAllProduitsParPage(0,2);
		    System.out.println(prods.getSize());
		    System.out.println(prods.getTotalElements());
		    System.out.println(prods.getTotalPages());
		    prods.getContent().forEach(p -> {System.out.println(p.toString());
		     });
		    /*ou bien
		    for (Produit p : prods)
		    {
		    System.out.println(p);
		    } */
		 }
		 
		 
		 @Test
		 public void testFindByNomProduit()
		 {
		 /*List<Produit> prods = produitRepository.findByNomProduit("iphone X");
		 for (Produit p : prods)
		 {
		 System.out.println(p);
		 } */
		 }
}
