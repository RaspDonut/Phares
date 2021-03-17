package com.develop.tp2.model;

public class LighthouseModel {
    private String id;
    private String nom;
    private String imgFile;
    private String region;
    private int construction;
    private int hauteur;
    private int nbEclat;
    private int periode;
    private int portee;
    private int automatisation;
    private double lat;
    private double lon;

    public LighthouseModel(String id, String nom, String imgFile, String region, int construction, int hauteur, int nbEclat, int periode, int portee, int automatisation, double lat, double lon) {
        this.id = id;
        this.nom = nom;
        this.imgFile = imgFile;
        this.region = region;
        this.construction = construction;
        this.hauteur = hauteur;
        this.nbEclat = nbEclat;
        this.periode = periode;
        this.portee = portee;
        this.automatisation = automatisation;
        this.lat = lat;
        this.lon = lon;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getImgFile() {
        return imgFile;
    }

    public String getRegion() {
        return region;
    }

    public int getConstruction() {
        return construction;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getNbEclat() {
        return nbEclat;
    }

    public int getPeriode() {
        return periode;
    }

    public int getPortee() {
        return portee;
    }

    public int getAutomatisation() {
        return automatisation;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setConstruction(int construction) {
        this.construction = construction;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setNbEclat(int nbEclat) {
        this.nbEclat = nbEclat;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    public void setAutomatisation(int automatisation) {
        this.automatisation = automatisation;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
