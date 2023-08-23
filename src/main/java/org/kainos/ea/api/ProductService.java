package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.ProductValidator;
import org.kainos.ea.db.OrderDao;
import org.kainos.ea.db.ProductDAO;

import java.sql.SQLException;
import java.util.Collections;
import java.util.*;

public class ProductService {

    private final ProductDAO productDAO = new ProductDAO();
    private ProductValidator productValidator= new ProductValidator();

    public List<Product> getAllProducts() throws FailedToGetProductException {

        List<Product> productList = null;
       try {
            productList = productDAO.getAllProducts();
        } catch (SQLException e) {
            throw new FailedToGetProductException();
        }

        try {
//            Product product = productList.get(10000);
        } catch (IndexOutOfBoundsException e) {
           System.err.println(e.getMessage());
        }

        System.out.println(productList);
        return productList;
    }



     //double totalPriceOfProduct =0;
// for loop
     //for(int i = 0; i< productList.size(); i++){
     //   totalPriceOfProduct += productList.get(i).getPrice();
     // }

 //for each loop
     //for (Product product :productList){
     //    totalPriceOfProduct += product.getPrice();
     //}

 //while loop
     //Iterator<Product> productIterator = productList.iterator();

     //while (productIterator.hasNext()){
     //    Product product = productIterator.next();
     //    totalPriceOfProduct += product.getPrice();
     //}

 //do while loop

     //Iterator<Product> productIterator = productList.iterator();

     //do {
     //    Product product = productIterator.next();
     //    totalPriceOfProduct += product.getPrice();
     //}while (productIterator.hasNext());

 //stream
     //totalPriceOfProduct = productList.stream().mapToDouble(product -> product.getPrice()).sum();

     //System.out.println("Total price of all products £" + totalPriceOfProduct);

 // for each <£1000 and more than £1000

     //double totalPriceOfCheapProduct =0;
     //double totalPriceOfExpensiveProduct =0;

     //for (Product product : productList){
     //    if(product.getPrice() < 1000) {
     //        totalPriceOfCheapProduct += product.getPrice();
     //    }else{
     //       totalPriceOfExpensiveProduct += product.getPrice();
     //    }
     //}

     //System.out.println("Total price of cheap products £" + totalPriceOfCheapProduct);
     //System.out.println("Total price of expensive products £" + totalPriceOfExpensiveProduct);

     //for each to print out the price of some of the products with a unique message

     //for (Product product : productList){
     // switch (product.getName()){
     //        case ("A thing"):
     //           System.out.println("This is a thing price £" + product.getPrice());
     //           break;
     //        case ("AN EVEN BIGGER THING "):
     //            System.out.println("This is an even bigger thing price £" + product.getPrice());
     //            break;
     //        default:
     //            System.out.println("This is the other price £" + product.getPrice());
     //    }
     //}

 // Hash set
 //    List<Integer> intList = Arrays.asList(1,2,3,4);
 //    Set<Integer> intSet = new HashSet<>(intList);

 //    intSet.stream().forEach(System.out::println);

 //sort list
     //System.out.println(Collections.min(productList));




     // Product product1 = new Product(1,"Pizza","Just Cheese", 1.00);

           //  productList.add(product1);

     public Product getProductById(int id) throws FailedToGetProductException, ProductDoesNotExistException {
         try{
             Product product = productDAO.getProductById(id);

             if(product == null){
                 throw new ProductDoesNotExistException();
             }
             return product;
         }catch (SQLException e){
             System.err.println(e.getMessage());

             throw new FailedToGetProductException();
         }
     }

     public int createProduct(ProductRequest product) throws FailedToCreateProductException, InvalidProductException {
        try {
        String validation = productValidator.isValidProduct(product);

        if (validation !=null){
            throw new InvalidProductException(validation);
        }
             int id = productDAO.createProduct(product);

             if(id == -1){
                 throw new FailedToCreateProductException();
             }
             return id;
         } catch (SQLException e) {
             System.err.println(e.getMessage());

             throw new FailedToCreateProductException();
         }
    }

    public void updateProduct(int id, ProductRequest product) throws FailedToCreateProductException, InvalidProductException, ProductDoesNotExistException {
        try {
            String validation = productValidator.isValidProduct(product);

            if (validation !=null){
                throw new InvalidProductException(validation);
            }

            Product productToUpdate = productDAO.getProductById(id);

            if (productToUpdate == null){
                throw new ProductDoesNotExistException();
            }
            productDAO.updateProduct(id, product);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateProductException();
        }
    }

    public void deleteProduct(int id) throws ProductDoesNotExistException, FailedToDeleteProductException {

        try{
            Product productToDelete = productDAO.getProductById(id);

            if(productToDelete == null){
                throw new ProductDoesNotExistException();
            }
            productDAO.deleteProduct(id);
        }catch (SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToDeleteProductException();
        }
    }



}

