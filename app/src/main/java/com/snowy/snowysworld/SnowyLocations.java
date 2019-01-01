package com.snowy.snowysworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.snowy.snowysworld.Type.GROOMING;
import static com.snowy.snowysworld.Type.HOME;
import static com.snowy.snowysworld.Type.HOME_STAY;
import static com.snowy.snowysworld.Type.HOTEL;
import static com.snowy.snowysworld.Type.ORIGIN;
import static com.snowy.snowysworld.Type.VET;

public class SnowyLocations {
    final List<Location> locations = new ArrayList<>();

    public static List<Location> get() {
        return Arrays.asList(
                new Location("Princess House, Manchester", 53.473253, -2.236760, HOME),
                new Location("31 Millharbour, London", 51.498534, -0.018406, HOME),
                new Location("Stane Grove, Clapham", 51.468655, -0.128210, HOME),
                new Location("Elm Park, Brixton", 51.449272, -0.117284, HOME),
                new Location("Warwick Avenue, Maida Vale", 51.523851, -0.185232, HOME),
                new Location("Hilltop Farm, Swinscoe", 53.030890, -1.802465, ORIGIN),
                new Location("The Barrowdale Hotel", 54.553891, -3.143978, HOTEL),
                new Location("Groes Inn", 53.249421, -3.834811, HOTEL),
                new Location("The Unicorn Apartments", 51.929458, -1.724280, HOTEL),
                new Location("The Crown of Crucis", 51.714537, -1.904194, HOTEL),
                new Location("Beauport Park Hotel", 50.894005, 0.542247, HOTEL),
                new Location("Shirley Greening-Jackson, Worksop", 53.299139, -1.127752, HOME_STAY),
                new Location("Phil & Linna, Worksop", 53.310228, -1.121634, HOME_STAY),
                new Location("Peter & Peter, Salford", 53.486056, -2.260124, HOME_STAY),
                new Location("Mrs Todorova, Brixton", 51.447225, -0.114810, HOME_STAY),
                new Location("Dog sitter, Battersea", 51.472061, -0.166811, HOME_STAY),
                new Location("Gemma Wagtales", 53.540341, -2.200941, HOME_STAY),
                new Location("Millionhairs", 53.408780, -2.255505, GROOMING),
                new Location("Battersea Dogs Home groomer", 51.478392, -0.145010, GROOMING),
                new Location("Sandy's", 53.545120, -2.306999, GROOMING),
                new Location("Allsorts", 53.444907, -2.364175, GROOMING),
                new Location("Acorn Veterinary Surgery", 53.408089, -2.257927, VET),
                new Location("Best Friends Isle of Dogs", 51.495477, -0.007458, VET),
                new Location("David Cuffs Vets, Clapham", 51.454763, -0.139341, VET)
        );
    }
}