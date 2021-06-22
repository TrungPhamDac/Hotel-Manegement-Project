/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class ChiTietTiec {
    private int matiec;
    private int mamonan;
    private String tenmonan; 
    private int soluong;
    private int dongia;
    private int thanhtien;

    public int getMatiec() {
        return matiec;
    }

    public void setMatiec(int matiec) {
        this.matiec = matiec;
    }

    public int getMamonan() {
        return mamonan;
    }

    public void setMamonan(int mamonan) {
        this.mamonan = mamonan;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThanhtien() {
        setThanhtien();
        return thanhtien;
    }

    public void setThanhtien() {
        this.thanhtien = soluong*dongia;
    }
    
    
}
