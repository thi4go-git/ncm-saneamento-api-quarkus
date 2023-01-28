package net.ddns.cloudtecnologia.client;

import net.ddns.cloudtecnologia.exception.ErroConexaoCosmosException;
import net.ddns.cloudtecnologia.rest.dto.BlueSoftDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@ApplicationScoped
public class CosmosBlue {

    private static final String TAG_TITULO = "title";
    private static final String CLASS_INFO = "list-unstyled product-header-attributes";
    private static final String REPLACE_EAN = "GTIN/EAN/UPC";
    private static final String REPLACE_NCM = "NCM:";
    //
    private static final String GET = "GET";
    private static final String USER_AGENT = "Mozilla/5.0";
    //
    private static final String CODIFICACAO = "UTF-8";

    public BlueSoftDTO resposta(String code) {

        String URL = "https://cosmos.bluesoft.com.br/produtos/" + code;

        try {
            java.net.URL obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(GET);
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), CODIFICACAO))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return extrairInformacoesa(response.toString().trim());
            }
        } catch (IOException e) {
            throw new ErroConexaoCosmosException();
        }
    }


    private BlueSoftDTO extrairInformacoesa(String response) {
        BlueSoftDTO ncm = new BlueSoftDTO();
        //
        Document doc = Jsoup.parse(response);
        String titulo = doc.getElementsByTag(TAG_TITULO).text();
        String tituloStr[] = titulo.split("[-]", -1);
        ncm.setTitulo(tituloStr[0].trim());
        ncm.setGtinEanUpc(tituloStr[1].replace(REPLACE_EAN, "").trim());
        //
        String info = doc.getElementsByClass(CLASS_INFO).text();
        String infoStr[] = info.split("[-]", -1);
        ncm.setNcm(infoStr[0].replace(REPLACE_NCM, "").trim());
        ncm.setCategoria(infoStr[1].trim());
        ncm.setDescricao(infoStr[2].trim());
        //
        return ncm;
    }

}
