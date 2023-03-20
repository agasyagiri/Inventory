/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

/**
 *
 * @author agasya
 */
public class Product {
    
    private int number;
    private String nama;
    private int qty;
    private double harga;
    private boolean active;

    
    public Product (int number , String nama , int qty , double harga) {
        this.number = number;
        this.nama = nama;
        this.qty = qty;
        this.harga = harga;
        this.active = true;
    }
    
    @Override
    public String toString () {
        String status = active ? "Aktif (true)" : "Dihentikan (false)";
        return "\nNama Produk : " + nama + "\nJumlah Unit : " +  qty + "\nHarga Produk: RP." + harga +"\nNilai Persediaan : RP." + getValue() + "\nStatus Produk : " + status + "\n";
    }
    public int getnumber() {
        return number;
    } 
    public String getnama() {
        return nama;
    }
    public int getqty() {
        return qty;
    }
    public double getharga() {
        return harga;
    }
     public boolean isActive() {
        return active;
    }
     public double getValue() {
        return qty * harga;
    }
     public void setnumber(int number) {
        this.number = number;
    }
    public void setnama(String nama) {
        this.nama = nama;
    }
    public void setqty(int qty) {
        this.qty = qty;
    }
    public void setharga(double harga) {
        this.harga = harga;
    }    
    public void setActive(boolean active) {
        this.active = active;
    }
    public double getInventoryValue(){
        return harga * qty;
    }
    public void addToInventory(int amount) {
        qty += amount;
    }
    public void deductFromInventory(int amount) {
        if (qty >= amount) {
            qty -= amount;
        } else {
            System.out.println("Kuantitas yang tidak mencukupi dalam persediaan.");
        }
    }
}