/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

/**
 *
 * @author agasya
 */
public class DVD extends Product {
    private int duration;
    private int ageRating;
    private String studio;
    private boolean active;

    public DVD(int number,String nama , int qty , double harga, int duration, int ageRating, String studio) {
        super(number, nama, qty, harga);
        this.duration = duration;
        this.ageRating = ageRating;
        this.studio = studio;
        this.active = true;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public int getAgeRating() {
        return ageRating;
    }
    
    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }
    
    public String getStudio() {
        return studio;
    }
    
    public void setStudio(String studio) {
        this.studio = studio;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
   
    public double InventoryValue(){
        return getharga() * getqty() + getharga() * getqty() * 0.05;
    }
    
    @Override
    public String toString() {
        String status = active ? "Aktif (true)" : "Dihentikan (false)";
        return "Nomor Item : " + this.getnumber() +
                "\nNama : " + this.getnama() +
                "\nDurasi Film : " + this.getDuration() +
                "\nNilai Usia : " + this.getAgeRating() +
                "\nStudio Film : " + this.getStudio() +
                "\nJumlah yang tersedia : " + this.getqty() +
                "\nHarga : " + this.getharga() +
                "\nNilai Persediaan : " + this.getValue() +
                "\nStatus Produk : " + status;
    }
}
