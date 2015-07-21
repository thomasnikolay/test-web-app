/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class RandomList {

    public static void main(String[] args) {
        List<String> input = Arrays.asList(new String[]{
            "022644", "024163", "024553", "024571", "024611", "024619", "024635", "024639",
            "024646", "024761", "422268", "790000", "790001", "790002", "790003", "790004",
            "790005", "790006", "790007", "790008", "790009", "790010", "790011", "790012",
            "790013", "790014", "790015", "790016", "790017", "790018", "790019", "790020",
            "790021", "790022", "790023", "790024", "790025", "790026", "790027", "790028",
            "790029", "790030", "790031", "790032", "790033", "790034", "790035", "790036",
            "790037", "790038", "790039", "790040", "790041", "790042", "790043", "790044",
            "790045", "790046", "790047", "790048", "790049", "790050", "790051", "790052",
            "790053", "790054", "790055", "022381", "022783", "024661", "024693", "421692",
            "423610", "423614", "890000", "890001", "890002", "890003", "890004", "890005",
            "890006", "890007", "890008", "890009", "890010", "890011", "890012", "890013",
            "890014", "025780", "990000", "990001", "990002", "990003", "990004", "990005",
            "990006", "990007", "990008", "990009"
        });
        
        for (int i = 0; i < 100; i++) {
            Collections.sort(input);
            Collections.shuffle(input);            
        }

        StringBuilder sb = new StringBuilder(input.size());
        
        int i = 0;
        for (String store : input) {            
            if(i %15 ==0)sb.append("\n");
            sb.append(store)
                    .append(";");
            i++;
        }
        
        
        
        System.out.println(sb.toString());
    }
}
