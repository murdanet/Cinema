package org.example.MySqlConnection;

import java.util.Scanner;

public class Cinema {
    Scanner sc = new Scanner(System.in);
    int num;
    String titol, data, pais, director;

    public int start(){
        System.out.println("***********Bienvenido a nuestra app de Peliculas ***********");
        System.out.println("*1.- Ver peliculas estrenadas por año");
        System.out.println("*2.- Ver las peliculas de directores ");
        System.out.println("*3.- Insertar peliculas");
        System.out.println("************************************************************");
        num = sc.nextInt();
        return num;
    }

    public String opcion1(){
        System.out.println("Introduzca el estreno de su pelicula en el siguiente formato: 'aaaa-mm-dd' ");
        sc.nextLine();
        return sc.nextLine();
    }

    public String opcion2(){
        System.out.println("Introduzca el segundo año en el mismo formato: 'aaaa-mm-dd' ");
        return sc.nextLine();
    }

    public String nombreDirector(){
        System.out.println("Introduzca el nombre de un Director:");
        sc.nextLine();
        return sc.nextLine();

    }

    public void insertarPelis(){
        System.out.println("Introduzca el nombre de la pelicula");
        sc.nextLine();
        titol = sc.nextLine();
        System.out.println("Introduzca la fecha de estreno de la peli en el siguiente formato: 'aaaa-mm-dd'");
        data = sc.nextLine();
        System.out.println("Introduzca el nombre de Pais de la pelicula");
        pais = sc.nextLine();

    }


    public Scanner getSc() {
        return sc;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
