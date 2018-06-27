package hackerrank.algo.sample;

import java.util.Arrays;
import java.util.OptionalInt;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class SampleQuestions {

    static long waitingTimeS(int[] tickets, int p) {
        int t=0;
        while(tickets[p]>0){
            for(int i=0;i<tickets.length;i++){
                if(tickets[i]>0){
                    t+=1;
                    tickets[i] -=1;
                }
                if(p==i && tickets[i]==0)
                    break;
            }
        }
        return t;

    }
    static long waitingTime(int[] tickets, int p) {
        int t=0;
        int pTickets = tickets[p];
        while(pTickets>1){
            t+=tickets.length;
            pTickets-=1;
        }
        for(int i=0;i<p;i++){
            if((tickets[i]-(tickets[p]-1))>0){
                t+=1;
            }
        }

        for(int i=0;i<tickets.length;i++){
            if(i!=p && tickets[i]<tickets[p]-1){
                t=t-(tickets[p]-1-tickets[i]);

            }

        }

        return t+1;



    }
    public static void main(String[] args) throws Exception {
        int[] tickets = {2,
                6,
                3,
                4,
                5};

        System.out.println(waitingTime(tickets,2));
        //System.out.println(getCountries("un",100090));
    }




    static String JSON_DATA = "{\"page\":\"1\",\"per_page\":10,\"total\":10,\"total_pages\":1,\"data\":[{\"name\":\"United States Minor Outlying Islands\",\"nativeName\":\"United States Minor Outlying Islands\",\"topLevelDomain\":[\".us\"],\"alpha2Code\":\"UM\",\"numericCode\":\"581\",\"alpha3Code\":\"UMI\",\"currencies\":[\"USD\"],\"callingCodes\":[\"\"],\"capital\":\"\",\"altSpellings\":[\"UM\"],\"relevance\":\"0\",\"region\":\"Americas\",\"subregion\":\"Northern America\",\"language\":[\"English\"],\"languages\":[\"en\"],\"translations\":{\"de\":\"Kleinere Inselbesitzungen der Vereinigten Staaten\",\"es\":\"Islas Ultramarinas Menores de Estados Unidos\",\"fr\":\"Îles mineures éloignées des États-Unis\",\"it\":\"Isole minori esterne degli Stati Uniti d'America\",\"ja\":\"合衆国領有小離島\",\"nl\":\"Kleine afgelegen eilanden van de Verenigde Staten\",\"hr\":\"Mali udaljeni otoci SAD-a\"},\"population\":300,\"latlng\":[],\"demonym\":\"American\",\"borders\":[],\"timezones\":[\"UTC-11:00\",\"UTC-10:00\",\"UTC+12:00\"]},{\"name\":\"Brunei\",\"nativeName\":\"Negara Brunei Darussalam\",\"topLevelDomain\":[\".bn\"],\"alpha2Code\":\"BN\",\"numericCode\":\"096\",\"alpha3Code\":\"BRN\",\"currencies\":[\"BND\"],\"callingCodes\":[\"673\"],\"capital\":\"Bandar Seri Begawan\",\"altSpellings\":[\"BN\",\"Nation of Brunei\",\" the Abode of Peace\"],\"relevance\":\"0\",\"region\":\"Asia\",\"subregion\":\"South-Eastern Asia\",\"language\":[\"Malay\"],\"languages\":[\"ms\"],\"translations\":{\"fr\":\"Brunei\",\"nl\":\"Brunei\",\"de\":\"Brunei\",\"it\":\"Brunei\",\"ja\":\"ブルネイ・ダルサラーム\",\"es\":\"Brunei\",\"hr\":\"Brunej\"},\"population\":393372,\"latlng\":[4.5,114.66666666],\"demonym\":\"Bruneian\",\"borders\":[\"MYS\"],\"area\":5765,\"timezones\":[\"UTC+08:00\"]},{\"name\":\"Burundi\",\"nativeName\":\"Burundi\",\"topLevelDomain\":[\".bi\"],\"alpha2Code\":\"BI\",\"numericCode\":\"108\",\"alpha3Code\":\"BDI\",\"currencies\":[\"BIF\"],\"callingCodes\":[\"257\"],\"capital\":\"Bujumbura\",\"altSpellings\":[\"BI\",\"Republic of Burundi\",\"Republika y'Uburundi\",\"République du Burundi\"],\"relevance\":\"0\",\"region\":\"Africa\",\"subregion\":\"Eastern Africa\",\"language\":[\"Kirundi\",\"French\"],\"languages\":[\"fr\",\"rn\"],\"translations\":{\"de\":\"Burundi\",\"es\":\"Burundi\",\"fr\":\"Burundi\",\"it\":\"Burundi\",\"ja\":\"ブルンジ\",\"nl\":\"Burundi\",\"hr\":\"Burundi\"},\"population\":9823827,\"latlng\":[-3.5,30],\"demonym\":\"Burundian\",\"borders\":[\"COD\",\"RWA\",\"TZA\"],\"area\":27834,\"gini\":33.3,\"timezones\":[\"UTC+02:00\"]},{\"name\":\"Hungary\",\"nativeName\":\"Magyarország\",\"topLevelDomain\":[\".hu\"],\"alpha2Code\":\"HU\",\"numericCode\":\"348\",\"alpha3Code\":\"HUN\",\"currencies\":[\"HUF\"],\"callingCodes\":[\"36\"],\"capital\":\"Budapest\",\"altSpellings\":[\"HU\"],\"relevance\":\"0\",\"region\":\"Europe\",\"subregion\":\"Eastern Europe\",\"language\":[\"Hungarian\"],\"languages\":[\"hu\"],\"translations\":{\"de\":\"Ungarn\",\"es\":\"Hungría\",\"fr\":\"Hongrie\",\"it\":\"Ungheria\",\"ja\":\"ハンガリー\",\"nl\":\"Hongarije\",\"hr\":\"Mađarska\"},\"population\":9849000,\"latlng\":[47,20],\"demonym\":\"Hungarian\",\"borders\":[\"AUT\",\"HRV\",\"ROU\",\"SRB\",\"SVK\",\"SVN\",\"UKR\"],\"area\":93028,\"gini\":31.2,\"timezones\":[\"UTC+01:00\"]},{\"name\":\"Réunion\",\"nativeName\":\"La Réunion\",\"topLevelDomain\":[\".re\"],\"alpha2Code\":\"RE\",\"numericCode\":\"638\",\"alpha3Code\":\"REU\",\"currencies\":[\"EUR\"],\"callingCodes\":[\"262\"],\"capital\":\"Saint-Denis\",\"altSpellings\":[\"RE\",\"Reunion\"],\"relevance\":\"0\",\"region\":\"Africa\",\"subregion\":\"Eastern Africa\",\"language\":[\"French\"],\"languages\":[\"fr\"],\"translations\":{\"de\":\"Réunion\",\"es\":\"Reunión\",\"fr\":\"Réunion\",\"it\":\"Riunione\",\"ja\":\"レユニオン\",\"nl\":\"Réunion\",\"hr\":\"Réunion\"},\"population\":840974,\"latlng\":[-21.15,55.5],\"demonym\":\"French\",\"borders\":[],\"timezones\":[\"UTC+04:00\"]},{\"name\":\"Tunisia\",\"nativeName\":\"تونس\",\"topLevelDomain\":[\".tn\"],\"alpha2Code\":\"TN\",\"numericCode\":\"788\",\"alpha3Code\":\"TUN\",\"currencies\":[\"TND\"],\"callingCodes\":[\"216\"],\"capital\":\"Tunis\",\"altSpellings\":[\"TN\",\"Republic of Tunisia\",\"al-Jumhūriyyah at-Tūnisiyyah\"],\"relevance\":\"0\",\"region\":\"Africa\",\"subregion\":\"Northern Africa\",\"language\":[\"Arabic\"],\"languages\":[\"ar\"],\"translations\":{\"de\":\"Tunesien\",\"es\":\"Túnez\",\"fr\":\"Tunisie\",\"it\":\"Tunisia\",\"ja\":\"チュニジア\",\"nl\":\"Tunesië\",\"hr\":\"Tunis\"},\"population\":10982754,\"latlng\":[34,9],\"demonym\":\"Tunisian\",\"borders\":[\"DZA\",\"LBY\"],\"area\":163610,\"gini\":41.4,\"timezones\":[\"UTC+01:00\"]},{\"name\":\"United Arab Emirates\",\"nativeName\":\"دولة الإمارات العربية المتحدة\",\"topLevelDomain\":[\".ae\"],\"alpha2Code\":\"AE\",\"numericCode\":\"784\",\"alpha3Code\":\"ARE\",\"currencies\":[\"AED\"],\"callingCodes\":[\"971\"],\"capital\":\"Abu Dhabi\",\"altSpellings\":[\"AE\",\"UAE\"],\"relevance\":\"0\",\"region\":\"Asia\",\"subregion\":\"Western Asia\",\"language\":[\"Arabic\"],\"languages\":[\"ar\"],\"translations\":{\"de\":\"Vereinigte Arabische Emirate\",\"es\":\"Emiratos Árabes Unidos\",\"fr\":\"Émirats arabes unis\",\"it\":\"Emirati Arabi Uniti\",\"ja\":\"アラブ首長国連邦\",\"nl\":\"Verenigde Arabische Emiraten\",\"hr\":\"Ujedinjeni Arapski Emirati\"},\"population\":9157000,\"latlng\":[24,54],\"demonym\":\"Emirati\",\"borders\":[\"OMN\",\"SAU\"],\"area\":83600,\"gini\":null,\"timezones\":[\"UTC+04\"]},{\"name\":\"United Kingdom\",\"nativeName\":\"United Kingdom\",\"topLevelDomain\":[\".uk\"],\"alpha2Code\":\"GB\",\"numericCode\":\"826\",\"alpha3Code\":\"GBR\",\"currencies\":[\"GBP\"],\"callingCodes\":[\"44\"],\"capital\":\"London\",\"altSpellings\":[\"GB\",\"UK\",\"Great Britain\"],\"relevance\":\"2.5\",\"region\":\"Europe\",\"subregion\":\"Northern Europe\",\"language\":[\"English\"],\"languages\":[\"en\"],\"translations\":{\"de\":\"Vereinigtes Königreich\",\"es\":\"Reino Unido\",\"fr\":\"Royaume-Uni\",\"it\":\"Regno Unito\",\"ja\":\"イギリス\",\"nl\":\"Verenigd Koninkrijk\",\"hr\":\"Ujedinjeno Kraljevstvo\"},\"population\":64800000,\"latlng\":[54,-2],\"demonym\":\"British\",\"borders\":[\"IRL\"],\"area\":242900,\"gini\":34,\"timezones\":[\"UTC-08:00\",\"UTC-05:00\",\"UTC-04:00\",\"UTC-03:00\",\"UTC-02:00\",\"UTC\",\"UTC+01:00\",\"UTC+02:00\",\"UTC+06:00\"]},{\"name\":\"United States\",\"nativeName\":\"United States\",\"topLevelDomain\":[\".us\"],\"alpha2Code\":\"US\",\"numericCode\":\"840\",\"alpha3Code\":\"USA\",\"currencies\":[\"USD\",\"USN\",\"USS\"],\"callingCodes\":[\"1\"],\"capital\":\"Washington, D.C.\",\"altSpellings\":[\"US\",\"USA\",\"United States of America\"],\"relevance\":\"3.5\",\"region\":\"Americas\",\"subregion\":\"Northern America\",\"language\":[\"English\"],\"languages\":[\"en\"],\"translations\":{\"de\":\"Vereinigte Staaten von Amerika\",\"es\":\"Estados Unidos\",\"fr\":\"États-Unis\",\"it\":\"Stati Uniti D'America\",\"ja\":\"アメリカ合衆国\",\"nl\":\"Verenigde Staten\",\"hr\":\"Sjedinjene Američke Države\"},\"population\":321645000,\"latlng\":[38,-97],\"demonym\":\"American\",\"borders\":[\"CAN\",\"MEX\"],\"area\":9629091,\"gini\":48,\"timezones\":[\"UTC-12:00\",\"UTC-11:00\",\"UTC-10:00\",\"UTC-09:00\",\"UTC-08:00\",\"UTC-07:00\",\"UTC-06:00\",\"UTC-05:00\",\"UTC-04:00\",\"UTC+10:00\",\"UTC+12:00\"]},{\"name\":\"Wallis and Futuna\",\"nativeName\":\"Wallis et Futuna\",\"topLevelDomain\":[\".wf\"],\"alpha2Code\":\"WF\",\"numericCode\":\"876\",\"alpha3Code\":\"WLF\",\"currencies\":[\"XPF\"],\"callingCodes\":[\"681\"],\"capital\":\"Mata-Utu\",\"altSpellings\":[\"WF\",\"Territory of the Wallis and Futuna Islands\",\"Territoire des îles Wallis et Futuna\"],\"relevance\":\"0.5\",\"region\":\"Oceania\",\"subregion\":\"Polynesia\",\"language\":[\"French\"],\"languages\":[\"fr\"],\"translations\":{\"de\":\"Wallis und Futuna\",\"es\":\"Wallis y Futuna\",\"fr\":\"Wallis-et-Futuna\",\"it\":\"Wallis e Futuna\",\"ja\":\"ウォリス・フツナ\",\"nl\":\"Wallis en Futuna\",\"hr\":\"Wallis i Fortuna\"},\"population\":13135,\"latlng\":[-13.3,-176.2],\"demonym\":\"Wallis and Futuna Islander\",\"borders\":[],\"area\":142,\"timezones\":[\"UTC+12:00\"]}]}";

    static int getCountries(String str, int p) throws Exception {



        JSONParser jsonParser = new JSONParser();
        String resp = query(1,str);
        JSONObject o = (JSONObject)jsonParser.parse(resp);
        long numPages = (Long)o.get("total_pages");
        JSONArray countries = (JSONArray)o.get("data");
        int numCountries= getMatchingCountryCount(countries,p);

        for(int i=2;i<=numPages;i++){
            //query the data
            o = (JSONObject)jsonParser.parse(JSON_DATA);
            countries = (JSONArray)o.get("data");
            numCountries += getMatchingCountryCount(countries,p);


        }

        return numCountries;




    }
    static String query(int page,String str) throws IOException {
        String uri = "https://jsonmock.hackerrank.com/api/countries/search?name="+str+"&page="+page;
        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        //setup http client to call URI
        //handle errors and respond
        //resposnd with json data
        return content.toString();
    }
    static int getMatchingCountryCount(JSONArray countries,int p){
        int count=0;
        for(int i=0;i<countries.size();i++){
            JSONObject country = (JSONObject)countries.get(i);
            try {
                if (((Long) country.get("population")).longValue() >= p) {
                    count++;
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return count;
    }
}
