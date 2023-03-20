/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

/**
 *
 * @author agasy
 */
public class CD extends Product {
    private String artis;
    private int numberOfSongs;
    private String label;
    private boolean active;

    public CD(int number,String productName, double harga, int unitsAvailable, String artist, int numberOfSongs, String label) {
        super(number, label, number, harga);
        this.artis = artist;
        this.numberOfSongs = numberOfSongs;
        this.label = label;
        this.active = true;
    }


    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
    public String toString() {
        String status = active ? "Aktif (true)" : "Dihentikan (false)";
        return "Nomor Item : " + this.getnumber()+
                "\nNama : " + this.getnama() +
                "\nArtis : " + this.getArtis()+
                "\nLagu di Album : " + this.getNumberOfSongs()+
                "\nLabel Rekaman : " + this.getLabel()+
                "\nJumlah yang tersedia : " + this.getqty()+
                "\nHarga : " + this.getharga() +
                "\nNilai Persediaan : " + this.getValue()+
                "\nStatus Produk : " + status;
    }
}
