/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.regex;

/**
 *
 * @author tnikolay
 */
public class RegexTester {
    public static void main(String[] args) {
        
        String testString = "string <script type=\"text/javascript\"> \n$lazy(window.GeckoVideoPlayer, CBSi.lazy.videoPlayer, function(){ loadGeckoVideoPlayer({ parentElement: 'universalVideoid50146202', flashVars:{ autoplay: 'false', adTargetType: 'Page', adPreroll: 'true', contentType: 'id', contentValue: '50146202', playlistDisplay: 'over', interactiveConsole: 'none' } },'blogSmall'); }); </script> string";
        String pattern = "(?s)<script.*/script>";
        System.out.println(testString.replaceAll(pattern, ""));
    }
   
}
