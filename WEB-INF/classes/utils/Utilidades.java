/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Renan
 */
public class Utilidades {
    public static String WeekDay(int d){
        String dayString="";
        switch (d)
        {
            case 2: dayString="Segunda-feira";
                break;
            case 3: dayString="Terça-feira";
                break;
            case 4: dayString="Quarta-feira";
                break;     
            case 5: dayString="Quinta-feira";
                break;
            case 6: dayString="Sexta-feira";
                break;
            case 7: dayString="Sábado";
                break;
            case 1: dayString="Domingo";
                break;
            case 8: dayString="Carona Única";
                break;
        }
        return dayString;
            
        }
    
    public static String tipoCarona(String t){
        String tipo="";
        if("O".equals(t))
        {
            tipo="Oferecimento";
        }
        if("P".equals(t))
        {
            tipo="Procura";
        }
        return tipo;
    }
            
    }
    

