/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

import java.util.Scanner;

/**
 *
 * @author agasya
 */
public class ProductTester {
    
     public static int getNumProduct(Scanner in){
         int maxSize = -1;
         do {
             try {
                 System.out.println("Masukkan 0 Jika Tidak Ingin Menambahkan Produk,");
                 System.out.println("Masukkan Jumlah Produk Yang Ingin Ditambahkan : ");
                 maxSize = in.nextInt();
                 if (maxSize < 0){
                     System.out.println("Incorrect number entered!");
                 }
             } catch (Exception e){
                 System.out.println("Incorrect type data entered!");
                 in.nextLine();
             }
         } while (maxSize < 0);
         return maxSize;
     }
        
    // public static void addToInventory(Product[] products, Scanner in){
    //     String tempNama;
    //     int tempQty;
    //     double tempHarga;
        
    //     for (int i = 0;i < products.length;i++){
    //         System.out.println("\nBarang nomor "+ (i+1));
    //         System.out.println("Masukkan nama barang : ");
    //         tempNama = in.next();
    //         System.out.println("Masukkan jumlah barang : ");
    //         tempQty = in.nextInt();
    //         System.out.println("Masukkan harga barang : ");
    //         tempHarga = in.nextDouble();
    //         products[i] = new Product(i+1,tempNama,tempQty,tempHarga);
    //     }
    // }
    
    public static void addToInventory(Product[] products, Scanner in){
        
    
        int stockChoice = -1;
        for (int i = 0; i < products.length; i++) {
          System.out.println("Product " + (i + 1));
          System.out.println("1: CD\n2: DVD");
          do {
            try {
              System.out.print("Please enter the product type: ");
              stockChoice = in.nextInt();
              if (stockChoice < 0 || stockChoice > 2)
                System.out.println("Incorrect Value entered");
            } catch (Exception e) {
              System.out.println("Incorrect data type entered!");
              in.nextLine();
            }
          } while (stockChoice < 0 || stockChoice > 2);
          switch (stockChoice) {
            case 1 : 
                addCDToInventory(products, in, i);
                break;
            case 2 : 
                addDVDToInventory(products, in, i);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int menuChoice,maxSize;
        maxSize = getNumProduct(in);
        
        
        if (maxSize == 0){
            System.out.println("No Product Required");
        } else {
            Product products[] = new Product[maxSize];
            addToInventory(products,in);
            do {
                menuChoice = getMenuOption(in);
                executeMenuChoice(menuChoice, products, in);
            } while (menuChoice!=0);
        }
    }

    public static void addCDToInventory(Product[] products, Scanner in, int i){
        String tempNama,tempArtist,tempAgeRating;
        int tempQty,tempLenght;
        double tempHarga;
        
            in.nextLine();// clear input buffer
            System.out.println("\n\t Barang Nomer " + (i+1));
            System.out.println("Masukan Nama CD : ");
            tempNama = in.next();
            System.out.println("Masukan Nama Artis : ");
            tempArtist = in.next();
            System.out.println("Masukan Nama Label Rekaman : ");
            tempAgeRating = in.next();
            System.out.println("Masukan Jumlah Lagu : ");
            tempLenght = in.nextInt();
            System.out.println("Masukan Jumlah Barang : ");
            tempQty = in.nextInt();
            System.out.println("Masukan Harga Barang : ");
            tempHarga = in.nextDouble();
            products[i] = new CD ((i+1),tempNama, tempHarga, tempQty, tempArtist, tempLenght, tempAgeRating);
        
    }
    
    public static void addDVDToInventory(Product[] products, Scanner in,int i){
        String tempNama,tempFilmStudio;
        int tempQty,tempLenght,tempAgeRating;
        double tempHarga;
        
        in.nextLine();// clear input buffer
            System.out.println("\n\t Barang Nomer " + (i+1));
            System.out.println("Masukan Nama DVD : ");
            tempNama = in.next();
            System.out.println("Masukan Nama Studio Film : ");
            tempFilmStudio = in.next();
            System.out.println("Masukan Nama Usia : ");
            tempAgeRating = in.nextInt();
            System.out.println("Masukan Jumlah Lagu : ");
            tempLenght = in.nextInt();
            System.out.println("Masukan Jumlah Barang Yang Tersedia : ");
            tempQty = in.nextInt();
            System.out.println("Masukan Harga Barang : ");
            tempHarga = in.nextDouble();
            products[i] = new DVD ((i+1),tempNama, tempQty, tempHarga, tempLenght, tempAgeRating, tempFilmStudio);
    }
    
    public static void executeMenuChoice(int menuChoice, Product[] products, Scanner in){
        switch (menuChoice) {
            case 1:
            System.out.println("1. Lihat Daftar Produk");
            displayInventory(products);break;
            case 2:
            System.out.println("Tambah Persediaan");
            addInventory(products, in);break;
            case 3:
            System.out.println("Kurangi Persediaan");
            deductInventory(products, in);break;
            case 4:
            System.out.println("Hentikan Persediaan");
            discontinueInventory(products, in);break;
            case 5:
            System.out.println("Aktifkan Persediaan");
            activateInventory(products, in);break;
        }
    }
    
    public static void displayInventory(Product[] parameter){
        System.out.println("\n\tDaftar Produk");
        for (int i = 0;i<parameter.length;i++){
            System.out.println(parameter[i].toString());
        }
    }
    
    public static void addInventory(Product[] products, Scanner in){
        int productChoice;
        int updateValue = -1;
        productChoice = getProductNumber(products, in);
        do {
            try {
                System.out.println("Masukkan jumlah barang yang ingin diinput :");
                updateValue = in.nextInt();
                if (updateValue < 0){
                    System.out.println("Incorrect number entered!");
                }
            }catch (Exception e) {
                System.out.println("Incorrect type data entered!");
                in.nextLine();
            }
        } while (updateValue < 0);
        products[productChoice].addToInventory(updateValue);
    }
    
    public static void deductInventory(Product[] products, Scanner in){
        int productChoice,jumlah;
        int updateValue = -1;
        productChoice = getProductNumber(products, in);
        jumlah = products[productChoice].getqty();
        do {
            try {
                System.out.println("Masukkan jumlah barang yang ingin dideduct :");
                updateValue = in.nextInt();
                if (updateValue < 0 || updateValue > jumlah){
                    System.out.println("Incorrect number entered!");
                }
            }catch (Exception e) {
                System.out.println("Incorrect type data entered!");
                in.nextLine();
            }
        } while (updateValue < 0 || updateValue > jumlah);
        products[productChoice].deductFromInventory(updateValue);
    }
    
    public static int getProductNumber(Product[] products, Scanner in){
        int productChoice = -1;
        for (int i = 0;i < products.length;i++) {
            System.out.println((i+1)+". "+products[i].getnama());
        }
        do {
            try {
                System.out.println("Masukkan nomor produk : ");
                productChoice = in.nextInt();
                if (productChoice < 0 || productChoice > products.length) {
                    System.out.println("Incorrect number entered!");
                }
            } catch (Exception e) {
                System.out.println("Incorrect type data entered!");
                in.nextLine();
            }
        } while (productChoice < 0 || productChoice > products.length);
        return productChoice - 1;
    }
    
    public static void discontinueInventory(Product[] products, Scanner in){
        int productChoice;
        productChoice = getProductNumber(products, in);
        products[productChoice].setActive(false);
    }
    public static void activateInventory(Product[] products, Scanner in){
        int productChoice;
        productChoice = getProductNumber(products, in);
        products[productChoice].setActive(true);
    }   


    public static int getMenuOption(Scanner in){
        System.out.println("\tMenu\n1. Lihat Inventaris\n2. Tambah Persediaan\n3. Kurangi Persediaan\n4. Hentikan Produk\n5. Aktifkan Produk\n0. Keluar");
        int pilih = 0;
        do {
            try {
                System.out.println("Masukkan opsi menu: ");
                pilih = in.nextInt();
                if (pilih < 0 || pilih > 5) {
                    System.out.println("Incorrect value entered!");
                }
            } catch (Exception e) {
                System.out.println("Incorrect data type entered!");
                in.nextLine();
            }
        } while (pilih < 0 || pilih > 5);
        return pilih;
    }
}

