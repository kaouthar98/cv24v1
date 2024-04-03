package fr.univrouen.cv24;

import util.Fichier;
import model.TestCV;
import java.awt.PageAttributes.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/testfic")
public class GetController {

    @GetMapping("/resume")
    public String getListCVinXML() {
        return "Envoi de la liste des CV";
    }

    @GetMapping("/cvid")
    public String getCVinXML(@RequestParam(value = "texte") String texte) {
        return "Détail du CV n°" + texte;
    }
    
    @GetMapping("/test")
    public String testMethod(@RequestParam(value = "id") int id, @RequestParam(value = "titre") String titre) {
        return "Test : id = " + id + ", titre = " + titre;
    }
    
    @GetMapping("/xmlcontent")
    public String getXmlContent() {
        Fichier fichier = new Fichier();
        return fichier.loadFileXML();
    }
    
    @RequestMapping(value="/testxml", produces="application/xml")
    public @ResponseBody TestCV getXML() {
        TestCV cv = new TestCV("HAMILTON", "1969/07/21", "Appollo11@nasa.us");
        return cv;
    }


}
