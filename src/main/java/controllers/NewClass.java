/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class NewClass {

    public static void main(String[] args) {
////        Date date = new Date();
////        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////        System.out.println("date = " + date);
////        GregorianCalendar gc = new GregorianCalendar();
////        gc.setTime(date);
////        gc.add(GregorianCalendar.MONTH, 9);
////        System.out.println("date2 = " + sdf.format(gc.getTime()));
////
////        gc.add(GregorianCalendar.DATE, 10);
////        Calendar c = Calendar.getInstance();
////        c.setTime(date);
////
////        System.out.println("date3 = " + sdf.format(gc.getTime());
        List<String> names = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        names.add("melissa");
        names.add("joile");
        names.add("clemence");
        names.add("daniko");
        for (String name : names) {
            sb.append(name + ",");
        }
        System.out.println("index of last , " + sb.lastIndexOf(","));
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",")+1, "");
        System.out.println("sb = " + sb);
    }

}
